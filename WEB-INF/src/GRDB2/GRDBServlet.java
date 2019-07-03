/****************************************************************
 *
 * GRDB : GRDBServlet.java
 *
 *
 * Note: GRDB1 is the development and test area.
 *       GRDB2 is the operational and running package.
 *
 *
 * (C) 1999-2003 Mustapha Ishak and Kayll Lake
 *
 *
 * File Created By: Mustapha Ishak
 *           Date : May, 1999
 *
 *
 * Purpose: The main GRDB Servlet that Operates All the database.
 *
 * Revisions:
 *
 *
 *****************************************************************/

package GRDB2;

import java.io.*;
import java.util.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import GRDB2.*;
import GRDB2.html.HtmlPage;
import GRTensorJClient.ClientAPI;
import GRTensorJClient.GRTensorJClientWindow;

public class GRDBServlet extends HttpServlet {
    private Connection connection;
    private Statement statement;
    public static ClientAPI ivjClientInterface = null;
    public static GRTensorJClientWindow ivjClientWindow = null;
    public static boolean CalculatorOn = false ;
    public static String USER_KEY = "GRDBServlet.user";
    public static String FIELD_USER = "username";
    public static String FIELD_PASSWORD = "password";
    private GRTensorJClientWindow theGRTensorJClientWindow = null;

    public void init (ServletConfig config) throws ServletException {
        super.init(config);

        String GrdbDriver = "org.postgresql.Driver";
        String GrdbUrl = "jdbc:postgresql:grdbi";
        String GrdbUsr = "postgres";
        String GrdbPassword = "postgres";

        try {
            Class.forName (GrdbDriver);
            // System.out.println("database driver loadded !");
        }
        catch (ClassNotFoundException DriverError) {
            String ErrorMessage = "Error: Driver: "+DriverError.toString();
            // System.out.println(ErrorMessage);
            throw new UnavailableException(this, ErrorMessage);
        }

        try {
            connection = DriverManager.getConnection(GrdbUrl,GrdbUsr,GrdbPassword);
            statement = connection.createStatement();
        }
        catch (SQLException SqlE) {
            String ErrorMessage = "Error: Database Connection problem";
            // System.out.println(ErrorMessage);
            DisplaySqlError(SqlE);
            throw new UnavailableException(this, ErrorMessage);
        }
    }

    public void destroy () {
        try {
            statement.close();
            connection.close();
        }
        catch (SQLException SqlE) {
            String ErrorMessage = "Error: Database closing problem";
            // System.out.println(ErrorMessage);
            DisplaySqlError(SqlE);
        }
        super.destroy();
    }

    private void DisplaySqlError (SQLException SqlE) {
        while (SqlE != null) {
            // System.out.println("SQL State  : " + SqlE.getSQLState ());
            // System.out.println("Message    : " + SqlE.getMessage ());
            // System.out.println("Error Code : " + SqlE.getErrorCode ());
            SqlE = SqlE.getNextException ();
        }
    }

    public static String SetAppletWindowPointers(GRTensorJClient.ClientAPI clientInterface, GRTensorJClientWindow clientWindow) {
        ivjClientInterface = clientInterface;
        ivjClientWindow = clientWindow;
        CalculatorOn = true;
        return "Link made with GR-Database";
    }

    synchronized protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ServletAddress = request.getServletPath();
        String QueryString = request.getQueryString();
        // System.out.println("Inside doGet GRDBServlet");
        // System.out.println("QueryString = " + QueryString);
        // initial Home page display

        if (QueryString == null) {
            response.setContentType("text/html");
            ServletOutputStream out = response.getOutputStream();
            GRDBHomePage HomePage = new GRDBHomePage(ServletAddress);
            out.print(HomePage.getHtml()); // a revoir, setter debut, fin de la page
        }
        else {
            // take the user commands
            // initial command -----------------------------------------------------------
            // why this step ??? A hidden Java Script from MetricDetailPage
            String Command =request.getParameter(GRDBProtocol.COMMAND);

            if (Command == null) {
                response.setContentType("text/html");
                ServletOutputStream out = response.getOutputStream();
                GRDBHomePage HomePage = new GRDBHomePage(ServletAddress);
                out.print(HomePage.getHtml()); // a revoir, setter debut, fin de la page
            }
            else {
                if (Command.equals(GRDBProtocol.LIST_ALL)) {
                    response.setContentType("text/html");
                    ServletOutputStream out = response.getOutputStream();
                    // Set the response header to force the browser to
                    // load the HTML page from the server instead of
                    // from a cache
                    // // response.setHeader("Expires", "Tues, 01 Jan 1980 00:00:00 GMT");

                    // Get the URI of this request
                    String uri = request.getRequestURI();

                    // Get the current user. If one does not exist, create
                    // a form to gather the user and password
                    HttpSession session = request.getSession(true);
                    String user = (String) session.getValue(USER_KEY);

                    if (user == null) {
                        // No user - create the form to prompt the user
                        login(out, uri);
                        return;
                    }

                    String SqlCommand = "SELECT * FROM metrics";
                    HtmlPage ResultsPage = StaticGRDBSearchHandling(SqlCommand, ServletAddress);
                    out.print(ResultsPage.getHtml()); // a revoir, setter debut, fin de la page
                }
                else if (Command.equals(GRDBProtocol.SEARCH)) {
                    response.setContentType("text/html");
                    ServletOutputStream out = response.getOutputStream();
                    String SearchParameter = request.getParameter("SearchParameter");
                    String SearchText = request.getParameter("SearchText");
                    if (SearchText.length() >= 3) {
                        String SqlWhereClause = null;
                        // All this part can be changed !!!
                        if (SearchParameter.equals("Keyword")) {
                            SqlWhereClause = "SELECT * FROM metrics  WHERE (metricname  Like '%" + SearchText + "%' OR  metricinfo Like '%" + SearchText + "%')";
                        }
                        else if (SearchParameter.equals("kshm")) {
                            SqlWhereClause = "SELECT * FROM metrics  WHERE (kshm_reference  Like '%" + SearchText + "%')";
                        }

                        String SqlCommand = SqlWhereClause;
                        // System.out.println(SqlCommand);
                        HtmlPage ResultsPage = StaticGRDBSearchHandling(SqlCommand, ServletAddress);
                        out.print(ResultsPage.getHtml());
                    }
                    else {
                        String ErrorMessage = "Please enter a search text of at least 3 characters!";
                        MessagePage message = new MessagePage(ServletAddress, "Invalid Search Text.", ErrorMessage + "<BR>");
                        out.print(message.getHtml());
                    }
                }
                else if (Command.equals(GRDBProtocol.GET) || Command.equals(GRDBProtocol.MODIFY)) {
                    response.setContentType("text/html");
                    ServletOutputStream out = response.getOutputStream();

                    String metricid = request.getParameter("metricid");
                    String SqlCommand = "SELECT * FROM metrics WHERE metricid = " + metricid;

                    try {
                        ResultSet Result = statement.executeQuery(SqlCommand);

                        if (Result.next()) {
                            MetricRecord record = new MetricRecord();

                            record.setmetricid(Result.getInt("metricid"));
                            record.setmetricname(Result.getString("metricname"));

                            if (Result.getString("metricinfo") != null) {
                                record.setmetricinfo(Result.getString("metricinfo"));
                            }
                            if (Result.getString("metricreference") != null) {
                                record.setmetricreference(Result.getString("metricreference"));
                            }
                            if (Result.getInt("metricdimension") != 0) {
                                record.setmetricdimension(Result.getInt("metricdimension"));
                            }
                            if (Result.getString("metricinputtype") != null) {
                                record.setmetricinputtype(Result.getString("metricinputtype"));
                            }
                            if (Result.getString("x1_") != null) {
                                record.setx1_(Result.getString("x1_"));
                            }
                            if (Result.getString("x2_") != null) {
                                record.setx2_(Result.getString("x2_"));
                            }
                            if (Result.getString("x3_") != null) {
                                record.setx3_(Result.getString("x3_"));
                            }
                            if (Result.getString("x4_") != null) {
                                record.setx4_(Result.getString("x4_"));
                            }
                            if (Result.getString("sig_") != null) {
                                record.setsig_(Result.getString("sig_"));
                            }
                            if (Result.getString("complex_") != null) {
                                record.setcomplex_(Result.getString("complex_"));
                            }
                            if (Result.getString("metriclineelement") != null) {
                                record.setmetriclineelement(Result.getString("metriclineelement"));
                            }
                            if (Result.getString("g11_") != null) {
                                record.setg11_(Result.getString("g11_"));
                            }
                            if (Result.getString("g12_") != null) {
                                record.setg12_(Result.getString("g12_"));
                            }
                            if (Result.getString("g13_") != null) {
                                record.setg13_(Result.getString("g13_"));
                            }
                            if (Result.getString("g14_") != null) {
                                record.setg14_(Result.getString("g14_"));
                            }
                            if (Result.getString("g21_") != null) {
                                record.setg21_(Result.getString("g21_"));
                            }
                            if (Result.getString("g22_") != null) {
                                record.setg22_(Result.getString("g22_"));
                            }
                            if (Result.getString("g23_") != null) {
                                record.setg23_(Result.getString("g23_"));
                            }
                            if (Result.getString("g24_") != null) {
                                record.setg24_(Result.getString("g24_"));
                            }
                            if (Result.getString("g31_") != null) {
                                record.setg31_(Result.getString("g31_"));
                            }
                            if (Result.getString("g32_") != null) {
                                record.setg32_(Result.getString("g32_"));
                            }
                            if (Result.getString("g33_") != null) {
                                record.setg33_(Result.getString("g33_"));
                            }
                            if (Result.getString("g34_") != null) {
                                record.setg34_(Result.getString("g34_"));
                            }
                            if (Result.getString("g41_") != null) {
                                record.setg41_(Result.getString("g41_"));
                            }
                            if (Result.getString("g42_") != null) {
                                record.setg42_(Result.getString("g42_"));
                            }
                            if (Result.getString("g43_") != null) {
                                record.setg43_(Result.getString("g43_"));
                            }
                            if (Result.getString("g44_") != null) {
                                record.setg44_(Result.getString("g44_"));
                            }
                            if (Result.getString("metrictype") != null) {
                                record.setmetrictype(Result.getString("metrictype"));
                            }
                            if (Result.getString("metricconstraints") != null) {
                                record.setmetricconstraints(Result.getString("metricconstraints"));
                            }
                            if (Result.getString("b11_") != null) {
                                record.setb11_(Result.getString("b11_"));
                            }
                            if (Result.getString("b12_") != null) {
                                record.setb12_(Result.getString("b12_"));
                            }
                            if (Result.getString("b13_") != null) {
                                record.setb13_(Result.getString("b13_"));
                            }
                            if (Result.getString("b14_") != null) {
                                record.setb14_(Result.getString("b14_"));
                            }
                            if (Result.getString("b21_") != null) {
                                record.setb21_(Result.getString("b21_"));
                            }
                            if (Result.getString("b22_") != null) {
                                record.setb22_(Result.getString("b22_"));
                            }
                            if (Result.getString("b23_") != null) {
                                record.setb23_(Result.getString("b23_"));
                            }
                            if (Result.getString("b24_") != null) {
                                record.setb24_(Result.getString("b24_"));
                            }
                            if (Result.getString("b31_") != null) {
                                record.setb31_(Result.getString("b31_"));
                            }
                            if (Result.getString("b32_") != null) {
                                record.setb32_(Result.getString("b32_"));
                            }
                            if (Result.getString("b33_") != null) {
                                record.setb33_(Result.getString("b33_"));
                            }
                            if (Result.getString("b34_") != null) {
                                record.setb34_(Result.getString("b34_"));
                            }
                            if (Result.getString("b41_") != null) {
                                record.setb41_(Result.getString("b41_"));
                            }
                            if (Result.getString("b42_") != null) {
                                record.setb42_(Result.getString("b42_"));
                            }
                            if (Result.getString("b43_") != null) {
                                record.setb43_(Result.getString("b43_"));
                            }
                            if (Result.getString("b44_") != null) {
                                record.setb44_(Result.getString("b44_"));
                            }
                            if (Result.getString("bd11_") != null) {
                                record.setbd11_(Result.getString("bd11_"));
                            }
                            if (Result.getString("bd12_") != null) {
                                record.setbd12_(Result.getString("bd12_"));
                            }
                            if (Result.getString("bd13_") != null) {
                                record.setbd13_(Result.getString("bd13_"));
                            }
                            if (Result.getString("bd14_") != null) {
                                record.setbd14_(Result.getString("bd14_"));
                            }
                            if (Result.getString("bd21_") != null) {
                                record.setbd21_(Result.getString("bd21_"));
                            }
                            if (Result.getString("bd22_") != null) {
                                record.setbd22_(Result.getString("bd22_"));
                            }
                            if (Result.getString("bd23_") != null) {
                                record.setbd23_(Result.getString("bd23_"));
                            }
                            if (Result.getString("bd24_") != null) {
                                record.setbd24_(Result.getString("bd24_"));
                            }
                            if (Result.getString("bd31_") != null) {
                                record.setbd31_(Result.getString("bd31_"));
                            }
                            if (Result.getString("bd32_") != null) {
                                record.setbd32_(Result.getString("bd32_"));
                            }
                            if (Result.getString("bd33_") != null) {
                                record.setbd33_(Result.getString("bd33_"));
                            }
                            if (Result.getString("bd34_") != null) {
                                record.setbd34_(Result.getString("bd34_"));
                            }
                            if (Result.getString("bd41_") != null) {
                                record.setbd41_(Result.getString("bd41_"));
                            }
                            if (Result.getString("bd42_") != null) {
                                record.setbd42_(Result.getString("bd42_"));
                            }
                            if (Result.getString("bd43_") != null) {
                                record.setbd43_(Result.getString("bd43_"));
                            }
                            if (Result.getString("bd44_") != null) {
                                record.setbd44_(Result.getString("bd44_"));
                            }
                            if (Result.getString("tetradtype") != null) {
                                record.settetradtype(Result.getString("tetradtype"));
                            }
                            if (Result.getString("eta11_") != null) {
                                record.seteta11_(Result.getString("eta11_"));
                            }
                            if (Result.getString("eta12_") != null) {
                                record.seteta12_(Result.getString("eta12_"));
                            }
                            if (Result.getString("eta13_") != null) {
                                record.seteta13_(Result.getString("eta13_"));
                            }
                            if (Result.getString("eta14_") != null) {
                                record.seteta14_(Result.getString("eta14_"));
                            }
                            if (Result.getString("eta21_") != null) {
                                record.seteta21_(Result.getString("eta21_"));
                            }
                            if (Result.getString("eta22_") != null) {
                                record.seteta22_(Result.getString("eta22_"));
                            }
                            if (Result.getString("eta23_") != null) {
                                record.seteta23_(Result.getString("eta23_"));
                            }
                            if (Result.getString("eta24_") != null) {
                                record.seteta24_(Result.getString("eta24_"));
                            }
                            if (Result.getString("eta31_") != null) {
                                record.seteta31_(Result.getString("eta31_"));
                            }
                            if (Result.getString("eta32_") != null) {
                                record.seteta32_(Result.getString("eta32_"));
                            }
                            if (Result.getString("eta33_") != null) {
                                record.seteta33_(Result.getString("eta33_"));
                            }
                            if (Result.getString("eta34_") != null) {
                                record.seteta34_(Result.getString("eta34_"));
                            }
                            if (Result.getString("eta41_") != null) {
                                record.seteta41_(Result.getString("eta41_"));
                            }
                            if (Result.getString("eta42_") != null) {
                                record.seteta42_(Result.getString("eta42_"));
                            }
                            if (Result.getString("eta43_") != null) {
                                record.seteta43_(Result.getString("eta43_"));
                            }
                            if (Result.getString("eta44_") != null) {
                                record.seteta44_(Result.getString("eta44_"));
                            }
                            if (Result.getString("basemetrictype") != null) {
                                record.setbasemetrictype(Result.getString("basemetrictype"));
                            }
                            if (Result.getString("energymomentumtype") != null) {
                                record.setenergymomentumtype(Result.getString("energymomentumtype"));
                            }
                            if (Result.getString("killingvector1_") != null) {
                                record.setkillingvector1_(Result.getString("killingvector1_"));
                            }
                            if (Result.getString("killingvector2_") != null) {
                                record.setkillingvector2_(Result.getString("killingvector2_"));
                            }
                            if (Result.getString("killingvector3_") != null) {
                                record.setkillingvector3_(Result.getString("killingvector3_"));
                            }
                            if (Result.getString("killingvector4_") != null) {
                                record.setkillingvector4_(Result.getString("killingvector4_"));
                            }
                            if (Result.getString("petrovtype") != null) {
                                record.setpetrovtype(Result.getString("petrovtype"));
                            }
                            if (Result.getString("petrovreport") != null) {
                                record.setpetrovreport(Result.getString("petrovreport"));
                            }
                            if (Result.getString("segretype") != null) {
                                record.setsegretype(Result.getString("segretype"));
                            }
                            if (Result.getString("lambdatype") != null) {
                                record.setlambdatype(Result.getString("lambdatype"));
                            }
                            if (Result.getString("isotropytype") != null) {
                                record.setisotropytype(Result.getString("isotropytype"));
                            }
                            if (Result.getString("isotropyinfo") != null) {
                                record.setisotropyinfo(Result.getString("isotropyinfo"));
                            }
                            if (Result.getString("isometrytype") != null) {
                                record.setisometrytype(Result.getString("isometrytype"));
                            }
                            if (Result.getString("kshm_reference") != null) {
                                record.setkshm_reference(Result.getString("kshm_reference"));
                            }
                            if (Result.getString("skea_reference") != null) {
                                record.setskea_reference(Result.getString("skea_reference"));
                            }
                            if (Result.getString("hawking_ellis_reference") != null) {
                                record.sethawking_ellis_reference(Result.getString("hawking_ellis_reference"));
                            }
                            if (Result.getString("metriclineelementhtml") != null) {
                                record.setmetriclineelementhtml(Result.getString("metriclineelementhtml"));
                            }

                            int DisplayFullRecord;

                            if (Command.equals(GRDBProtocol.GET)) {
                                DisplayFullRecord = 0;
                                MetricDetailPage detailPage = new MetricDetailPage(ServletAddress, record,DisplayFullRecord);
                                out.print(detailPage.getHtml());
                            }
                            else if (Command.equals(GRDBProtocol.MODIFY)) {
                                // Set the response header to force the browser to
                                // load the HTML page from the server instead of
                                // from a cache
                                // response.setHeader("Expires", "Tues, 01 Jan 1980 00:00:00 GMT");

                                // Get the URI of this request
                                String uri = request.getRequestURI();

                                // Get the current user. If one does not exist, create
                                // a form to gather the user and password
                                HttpSession session = request.getSession(true);
                                String user = (String) session.getValue(USER_KEY);

                                if (user == null) {
                                    // No user - create the form to prompt the user
                                    login(out, uri);
                                    return;
                                }
                                MetricModifyPage ModifyPage = new MetricModifyPage(ServletAddress,record);
                                out.print(ModifyPage.getHtml());
                            }
                        }
                        else {
                            String ErrorMessage = "Error: record not found";
                            MessagePage message = new MessagePage(ServletAddress, "Error", ErrorMessage);
                            out.print(message.getHtml());
                        }
                        Result.close();
                        //  } catch (SQLException SqlE)
                    }
                    catch (Exception SqlE) {
                        String ErrorMessage = "Error: in get from database ";
                        MessagePage message = new MessagePage(ServletAddress, "Error", ErrorMessage + "<BR>Error: " + SqlE.toString());
                        out.print(message.getHtml());
                        // DisplaySqlError(SqlE);
                    }
                }
                else if (Command.equals(GRDBProtocol.PRIVATE)) {
                    response.setContentType("text/html");
                    ServletOutputStream out = response.getOutputStream();
                    // Set the response header to force the browser to
                    // load the HTML page from the server instead of
                    // from a cache
                    // response.setHeader("Expires", "Tues, 01 Jan 1980 00:00:00 GMT");

                    // Get the URI of this request
                    String uri = request.getRequestURI();

                    // Get the current user. If one does not exist, create
                    // a form to gather the user and password
                    HttpSession session = request.getSession(true);
                    String user = (String)session.getValue(USER_KEY);

                    if (user == null) {
                        // No user - create the form to prompt the user
                        login(out, uri);
                        return;
                    }

                    PrivateInput privatepage = new PrivateInput(ServletAddress);
                    out.print(privatepage.getHtml());
                }
                else if (Command.equals(GRDBProtocol.NEW)) {
                    // Enter a new metric
                    response.setContentType("text/html");
                    ServletOutputStream out = response.getOutputStream();
                    // Set the response header to force the browser to
                    // load the HTML page from the server instead of
                    // from a cache
                    // response.setHeader("Expires", "Tues, 01 Jan 1980 00:00:00 GMT");

                    // Get the URI of this request
                    String uri = request.getRequestURI();

                    // Get the current user. If one does not exist, create
                    // a form to gather the user and password
                    HttpSession session = request.getSession(true);
                    String user = (String) session.getValue(USER_KEY);

                    if (user == null) {
                        // No user - create the form to prompt the user
                        login(out, uri);
                        return;
                    }
                    MetricModifyPage newMetric = new MetricModifyPage(ServletAddress, null);
                    out.print(newMetric.getHtml());
                }
            }
        }
    }

    synchronized protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ServletAddress = request.getServletPath();
        // look for command parameter
        String Command = request.getParameter(GRDBProtocol.COMMAND);

        if (Command == null) {
            response.setContentType("text/html");
            ServletOutputStream out = response.getOutputStream();
            GRDBHomePage HomePage = new GRDBHomePage(ServletAddress);
            out.print(HomePage.getHtml());
        }
        else {
            // handle command parameter
            if (Command.equals(GRDBProtocol.SAVE)) {
                response.setContentType("text/html");
                ServletOutputStream out = response.getOutputStream();

                String metricid = request.getParameter("metricid");
                String metricname = request.getParameter("metricname");
                String metricinfo = request.getParameter("metricinfo");
                String metricreference = request.getParameter("metricreference");
                String metricdimension = request.getParameter("metricdimension");
                String metricinputtype = request.getParameter("metricinputtype");
                String x1_ = request.getParameter("x1_");
                String x2_ = request.getParameter("x2_");
                String x3_ = request.getParameter("x3_");
                String x4_ = request.getParameter("x4_");
                String sig_ = request.getParameter("sig_");
                String complex_ = request.getParameter("complex_");
                String metriclineelement = request.getParameter("metriclineelement");
                String g11_ = request.getParameter("g11_");
                String g12_ = request.getParameter("g12_");
                String g13_ = request.getParameter("g13_");
                String g14_ = request.getParameter("g14_");
                String g21_ = request.getParameter("g21_");
                String g22_ = request.getParameter("g22_");
                String g23_ = request.getParameter("g23_");
                String g24_ = request.getParameter("g24_");
                String g31_ = request.getParameter("g31_");
                String g32_ = request.getParameter("g32_");
                String g33_ = request.getParameter("g33_");
                String g34_ = request.getParameter("g34_");
                String g41_ = request.getParameter("g41_");
                String g42_ = request.getParameter("g42_");
                String g43_ = request.getParameter("g43_");
                String g44_ = request.getParameter("g44_");
                String metrictype = request.getParameter("metrictype");
                String metricconstraints = request.getParameter("metricconstraints");
                String b11_ = request.getParameter("b11_");
                String b12_ = request.getParameter("b12_");
                String b13_ = request.getParameter("b13_");
                String b14_ = request.getParameter("b14_");
                String b21_ = request.getParameter("b21_");
                String b22_ = request.getParameter("b22_");
                String b23_ = request.getParameter("b23_");
                String b24_ = request.getParameter("b24_");
                String b31_ = request.getParameter("b31_");
                String b32_ = request.getParameter("b32_");
                String b33_ = request.getParameter("b33_");
                String b34_ = request.getParameter("b34_");
                String b41_ = request.getParameter("b41_");
                String b42_ = request.getParameter("b42_");
                String b43_ = request.getParameter("b43_");
                String b44_ = request.getParameter("b44_");
                String bd11_ = request.getParameter("bd11_");
                String bd12_ = request.getParameter("bd12_");
                String bd13_ = request.getParameter("bd13_");
                String bd14_ = request.getParameter("bd14_");
                String bd21_ = request.getParameter("bd21_");
                String bd22_ = request.getParameter("bd22_");
                String bd23_ = request.getParameter("bd23_");
                String bd24_ = request.getParameter("bd24_");
                String bd31_ = request.getParameter("bd31_");
                String bd32_ = request.getParameter("bd32_");
                String bd33_ = request.getParameter("bd33_");
                String bd34_ = request.getParameter("bd34_");
                String bd41_ = request.getParameter("bd41_");
                String bd42_ = request.getParameter("bd42_");
                String bd43_ = request.getParameter("bd43_");
                String bd44_ = request.getParameter("bd44_");
                String tetradtype = request.getParameter("tetradtype");
                String eta11_ = request.getParameter("eta11_");
                String eta12_ = request.getParameter("eta12_");
                String eta13_ = request.getParameter("eta13_");
                String eta14_ = request.getParameter("eta14_");
                String eta21_ = request.getParameter("eta21_");
                String eta22_ = request.getParameter("eta22_");
                String eta23_ = request.getParameter("eta23_");
                String eta24_ = request.getParameter("eta24_");
                String eta31_ = request.getParameter("eta31_");
                String eta32_ = request.getParameter("eta32_");
                String eta33_ = request.getParameter("eta33_");
                String eta34_ = request.getParameter("eta34_");
                String eta41_ = request.getParameter("eta41_");
                String eta42_ = request.getParameter("eta42_");
                String eta43_ = request.getParameter("eta43_");
                String eta44_ = request.getParameter("eta44_");
                String basemetrictype = request.getParameter("basemetrictype");
                String energymomentumtype = request.getParameter("energymomentumtype");
                String killingvector1_ = request.getParameter("killingvector1_");
                String killingvector2_ = request.getParameter("killingvector2_");
                String killingvector3_ = request.getParameter("killingvector3_");
                String killingvector4_ = request.getParameter("killingvector4_");
                String petrovtype = request.getParameter("petrovtype");
                String petrovreport = request.getParameter("petrovreport");
                String segretype = request.getParameter("segretype");
                String lambdatype = request.getParameter("lambdatype");
                String isotropytype = request.getParameter("isotropytype");
                String isotropyinfo = request.getParameter("isotropyinfo");
                String isometrytype = request.getParameter("isometrytype");
                String kshm_reference = request.getParameter("kshm_reference");
                String skea_reference = request.getParameter("skea_reference");
                String hawking_ellis_reference = request.getParameter("hawking_ellis_reference");
                String metriclineelementhtml = request.getParameter("metriclineelementhtml");

                if (metricname.equals("") || metricdimension.equals("")) {
                    String ErrorMessage = "The following fields should not be empty :" + " MetricName, dimension (just as an example)";
                    MessagePage message = new MessagePage(ServletAddress, "Error", ErrorMessage);
                    out.print(message.getHtml());
                    return;
                }

                // HERE INSERT ENTRY CHECKING
                try {
                    int imetricdimension = Integer.parseInt(metricdimension);
                }
                catch (NumberFormatException nfe) {
                    String ErrorMessage = "Dimension must be an integer. " + "Click back to correct the error.";
                    MessagePage message = new MessagePage(ServletAddress, "Error", ErrorMessage);
                    out.print(message.getHtml());
                    return;
                }

                String SqlCommand = null;
                metricid = metricid.trim();
                if (metricid.equals("0") || metricid.equals("")) {
                    String sQuery = "SELECT MAX(metricid) AS " + "Max_MetricId FROM metrics";
                    String snewmetricid = "1";
                    try {
                        ResultSet Result = statement.executeQuery(sQuery);
                        if (Result.next()) {
                            snewmetricid = "" + (Result.getInt("Max_MetricId") + 1);
                        }
                    }
                    catch (SQLException SqlE) {
                        String ErrorMessage = "A database error has occurred." + " Could not get new MetricId";
                        MessagePage message = new MessagePage(ServletAddress, "Error", ErrorMessage + "<BR>Error: " + SqlE.toString());
                        out.print(message.getHtml());
                        DisplaySqlError(SqlE);
                    }
                    // new record
                    // the structure in this INSERT should be exactly like the grdbstructure file
                    SqlCommand = "INSERT INTO Metrics VALUES (" +
                        snewmetricid + ", '" +
                        metricname + "','" +
                        metricinfo + "','" +
                        metricreference + "'," +
                        metricdimension + ",'" +
                        metricinputtype + "','" +
                        x1_ + "','" +
                        x2_ + "','" +
                        x3_ + "','" +
                        x4_ + "','" +
                        sig_ + "','" +
                        complex_ + "','" +
                        metriclineelement + "','" +
                        g11_ + "','" +
                        g12_ + "','" +
                        g13_ + "','" +
                        g14_ + "','" +
                        g21_ + "','" +
                        g22_ + "','" +
                        g23_ + "','" +
                        g24_ + "','" +
                        g31_ + "','" +
                        g32_ + "','" +
                        g33_ + "','" +
                        g34_ + "','" +
                        g41_ + "','" +
                        g42_ + "','" +
                        g43_ + "','" +
                        g44_ + "','" +
                        metrictype + "','" +
                        metricconstraints + "','" +
                        b11_ + "','" +
                        b12_ + "','" +
                        b13_ + "','" +
                        b14_ + "','" +
                        b21_ + "','" +
                        b22_ + "','" +
                        b23_ + "','" +
                        b24_ + "','" +
                        b31_ + "','" +
                        b32_ + "','" +
                        b33_ + "','" +
                        b34_ + "','" +
                        b41_ + "','" +
                        b42_ + "','" +
                        b43_ + "','" +
                        b44_ + "','" +
                        bd11_ + "','" +
                        bd12_ + "','" +
                        bd13_ + "','" +
                        bd14_ + "','" +
                        bd21_ + "','" +
                        bd22_ + "','" +
                        bd23_ + "','" +
                        bd24_ + "','" +
                        bd31_ + "','" +
                        bd32_ + "','" +
                        bd33_ + "','" +
                        bd34_ + "','" +
                        bd41_ + "','" +
                        bd42_ + "','" +
                        bd43_ + "','" +
                        bd44_ + "','" +
                        tetradtype + "','" +
                        eta11_ + "','" +
                        eta12_ + "','" +
                        eta13_ + "','" +
                        eta14_ + "','" +
                        eta21_ + "','" +
                        eta22_ + "','" +
                        eta23_ + "','" +
                        eta24_ + "','" +
                        eta31_ + "','" +
                        eta32_ + "','" +
                        eta33_ + "','" +
                        eta34_ + "','" +
                        eta41_ + "','" +
                        eta42_ + "','" +
                        eta43_ + "','" +
                        eta44_ + "','" +
                        basemetrictype + "','" +
                        energymomentumtype + "','" +
                        killingvector1_ + "','" +
                        killingvector2_ + "','" +
                        killingvector3_ + "','" +
                        killingvector4_ + "','" +
                        petrovtype + "','" +
                        petrovreport + "','" +
                        segretype + "','" +
                        lambdatype + "','" +
                        isotropytype + "','" +
                        isotropyinfo + "','" +
                        isometrytype + "','" +
                        kshm_reference + "','" +
                        skea_reference + "','" +
                        hawking_ellis_reference + "','" +
                        metriclineelementhtml + "')";
                }
                else {
                    // existing record
                    SqlCommand = "UPDATE metrics SET metricname='" + metricname +
                        "',metricinfo='" + metricinfo +
                        "',metricreference='" + metricreference +
                        "', metricdimension=" + metricdimension +
                        " ,metricinputtype='" + metricinputtype +
                        "',x1_='" + x1_ +
                        "',x2_='" + x2_ +
                        "',x3_='" + x3_ +
                        "',x4_='" + x4_ +
                        "',sig_='" + sig_ +
                        "',complex_='" + complex_ +
                        "',metriclineelement='" + metriclineelement +
                        "',g11_='"+g11_ +
                        "',g12_='"+g12_ +
                        "',g13_='"+g13_ +
                        "',g14_='"+g14_ +
                        "',g21_='"+g21_ +
                        "',g22_='"+g22_ +
                        "',g23_='"+g23_ +
                        "',g24_='"+g24_ +
                        "',g31_='"+g31_ +
                        "',g32_='"+g32_ +
                        "',g33_='"+g33_ +
                        "',g34_='"+g34_ +
                        "',g41_='"+g41_ +
                        "',g42_='"+g42_ +
                        "',g43_='"+g43_ +
                        "',g44_='"+g44_ +
                        "',metrictype='"+ metrictype +
                        "',metricconstraints='"+ metricconstraints +
                        "',b11_='"+b11_ +
                        "',b12_='"+b12_ +
                        "',b13_='"+b13_ +
                        "',b14_='"+b14_ +
                        "',b21_='"+b21_ +
                        "',b22_='"+b22_ +
                        "',b23_='"+b23_ +
                        "',b24_='"+b24_ +
                        "',b31_='"+b31_ +
                        "',b32_='"+b32_ +
                        "',b33_='"+b33_ +
                        "',b34_='"+b34_ +
                        "',b41_='"+b41_ +
                        "',b42_='"+b42_ +
                        "',b43_='"+b43_ +
                        "',b44_='"+b44_ +
                        "',bd11_='"+bd11_ +
                        "',bd12_='"+bd12_ +
                        "',bd13_='"+bd13_ +
                        "',bd14_='"+bd14_ +
                        "',bd21_='"+bd21_ +
                        "',bd22_='"+bd22_ +
                        "',bd23_='"+bd23_ +
                        "',bd24_='"+bd24_ +
                        "',bd31_='"+bd31_ +
                        "',bd32_='"+bd32_ +
                        "',bd33_='"+bd33_ +
                        "',bd34_='"+bd34_ +
                        "',bd41_='"+bd41_ +
                        "',bd42_='"+bd42_ +
                        "',bd43_='"+bd43_ +
                        "',bd44_='"+bd44_ +
                        "',tetradtype='" + tetradtype +
                        "',eta11_='" + eta11_ +
                        "',eta12_='" + eta12_ +
                        "',eta13_='" + eta13_ +
                        "',eta14_='" + eta14_ +
                        "',eta21_='" + eta21_ +
                        "',eta22_='" + eta22_ +
                        "',eta23_='" + eta23_ +
                        "',eta24_='" + eta24_ +
                        "',eta31_='" + eta31_ +
                        "',eta32_='" + eta32_ +
                        "',eta33_='" + eta33_ +
                        "',eta34_='" + eta34_ +
                        "',eta41_='" + eta41_ +
                        "',eta42_='" + eta42_ +
                        "',eta43_='" + eta43_ +
                        "',eta44_='" + eta44_ +
                        "',basemetrictype='" + basemetrictype +
                        "',energymomentumtype='" + energymomentumtype +
                        "',killingvector1_='" + killingvector1_ +
                        "',killingvector2_='" + killingvector2_ +
                        "',killingvector3_='" + killingvector3_ +
                        "',killingvector4_='" + killingvector4_ +
                        "',petrovtype='" + petrovtype +
                        "',petrovreport='" + petrovreport +
                        "',segretype='" + segretype +
                        "',lambdatype='" + lambdatype +
                        "',isotropytype='" + isotropytype +
                        "',isotropyinfo='" + isotropyinfo +
                        "',isometrytype='" + isometrytype +
                        "',kshm_reference='" + kshm_reference +
                        "',skea_reference='" + skea_reference +
                        "',hawking_ellis_reference='" + hawking_ellis_reference +
                        "',metriclineelementhtml='" + metriclineelementhtml +
                        "'  WHERE metricid=" + metricid;
                }
                try {
                    int iStatus = statement.executeUpdate(SqlCommand);
                    MessagePage message = new MessagePage(ServletAddress, "Success", "Successfully saved the Record.");
                    out.print(message.getHtml());
                }
                catch (SQLException SqlE) {
                    String ErrorMessage = "A database error has occurred.";
                    MessagePage message = new MessagePage(ServletAddress, "Error", ErrorMessage + "<BR>Error: " + SqlE.toString());
                    out.print(message.getHtml());
                    DisplaySqlError(SqlE);
                }
            }
            // Validate password  -------------------------------------------
            else if (Command.equals(GRDBProtocol.VALIDATE)) {
                response.setContentType("text/html");
                ServletOutputStream out = response.getOutputStream();
                String MetricName = request.getParameter("MetricToLoad");

                // If the user is not yet logged in, validate
                HttpSession session = request.getSession(true);
                String user = (String)session.getValue(USER_KEY);

                if (user == null) {
                    String username = request.getParameter(FIELD_USER);
                    String password = request.getParameter(FIELD_PASSWORD);

                    if (!validUser(username, password)) {
                        out.println("<html>");
                        out.println("<title>Invalid User </title>");
                        out.println("<body bgcolor=\"b5d8ff\"><center><h2>Invalid User! </h2><br>");
                        //out.println("<body><center><h2>Invalid User! "+username+" "+password +"</h2><br>");
                        out.println("Press the 'Back' button to try again");
                        out.println("</center></body></html>");
                        out.flush();
                        return;
                    }

                    // We've got a valid user now, store the username in
                    // the session
                    session.putValue(USER_KEY, username);
                }
                // The current user has been validated.
                // Redirect to our main site
                // response.sendRedirect("http://130.15.26.66/servlet/GRDB2.GRDBServlet");
                response.sendRedirect("https://grdatabase.utdallas.edu/home");
            }

            // Load  Metric into ListOfMetrics  -------------------------------------------
            // I can here personalize the lists !
            else if (Command.equals(GRDBProtocol.ADDTOMETRICSLIST)) {
                response.setContentType("text/html");
                ServletOutputStream out = response.getOutputStream();
                String metricName = request.getParameter("MetricToLoad");
                String names = "";
                Cookie clientCookies[] = request.getCookies();

                try {
                    if (clientCookies != null) {
                        for (int i = 0; i < clientCookies.length; i++) {
                            if (clientCookies[i].getName().equals("Metric-Names")) {
                                names = clientCookies[i].getValue();
                            }
                        }
                    }
                    if (names.equals("")) {
                        names = names + metricName;
                    }
                    else {
                        names = names + "-" + metricName;
                    }
                    Cookie newMetricNamesList = new Cookie("Metric-Names", names);
                    newMetricNamesList.setMaxAge(-1);
                    response.addCookie(newMetricNamesList);
                    ConfirmMarking message = new ConfirmMarking(ServletAddress, "Success", "Record <b>" + metricName + " </b>marked! Please launch calculator from home page or mark other records.", "If the calculator is already launched, please just use the <b>Load/Select</b> option Calculator menu.");
                    out.print(message.getHtml());
                }
                catch (Exception E) {
                    String errorMessage = "Record not loaded in Calculator";
                    MessagePage message = new MessagePage(ServletAddress, "Error", errorMessage + "<BR>"+E);
                    out.print(message.getHtml());
                }
            }
            // Load  Metric from List to Calculator -------------------------------------------------
            else if (Command.equals(GRDBProtocol.TRANSFERMETRICSNAMES)) {
                Vector ListOfMetricsNames = null;
                Cookie metricCookies[] = request.getCookies();

                if (metricCookies != null) {
                    for (int i = 0; i < metricCookies.length; i++) {
                        if (metricCookies[i].getName().equals("Metric-Names")) {
                            ListOfMetricsNames = new Vector(Arrays.asList(metricCookies[i].getValue().split("-")));
                            metricCookies[i].setValue("");
                            metricCookies[i].setPath("/");
                            metricCookies[i].setMaxAge(0);
                            response.addCookie(metricCookies[i]);
                        }
                    }
                }
                try {
                    //   this will be used in the future for the applet to send results to
                    //   the servlet and the database !!!
                    // response.setContentType("text/html");
                    // ServletOutputStream out = response.getOutputStream();
                    //  ObjectInputStream ois = new ObjectInputStream(request.getInputStream());
                    //    String  SignalFromApplet  = (String) ois.readObject();
                    //ConfirmMarking message =new ConfirmMarking(ServletAddress, "in Transfert metrics",SignalFromApplet,"");
                    //out.print(message.getHtml());
                    response.setContentType("application/octet-stream");
                    ObjectOutputStream oos = new ObjectOutputStream(response.getOutputStream());
                    oos.writeObject(ListOfMetricsNames);
                    oos.flush();
                    oos.close();
                    // for (int x=0 ; x < ListOfMetricsNames.size(); x++) {
                    // System.out.println("metric " + x + " : "
                    // + (String) ListOfMetricsNames.elementAt(x)); }
                }
                catch (Exception e) {
                    // System.out.println(e.getMessage());
                }
            }
            // Delete a metric from database ----------------------------------------------
            else if (Command.equals(GRDBProtocol.DELETE)) {
                response.setContentType("text/html");
                ServletOutputStream out = response.getOutputStream();
                String smetricid = request.getParameter("metricid");
                String SqlCommand = "DELETE FROM metrics WHERE metricid=" + smetricid;

                try {
                    int iStatus = statement.executeUpdate(SqlCommand);
                    MessagePage message = new MessagePage(ServletAddress, "Success", "Successfully deleted the Record.");
                    out.print(message.getHtml());
                }
                catch (SQLException SqlE) {
                    String ErrorMessage = "A database error has occurred.";
                    MessagePage message = new MessagePage(ServletAddress, "Error", ErrorMessage + "<BR>Error: " + SqlE.toString());
                    out.print(message.getHtml());
                    DisplaySqlError(SqlE);
                }
            }
        }
    }

    private HtmlPage StaticGRDBSearchHandling(String SqlCommand, String ServletAddress) throws ServletException {
        try {
            // THIS part should be enhanced and modified !!!!
            // FOR EXAMPLE the "metricid" can be replaced by 1, 2, ..etc form more efficiency
            // may be other  tricks are possible
            // the results from the Sql Query, one record after the other
            ResultSet Result = statement.executeQuery(SqlCommand);
            Vector vRecords = new Vector();

            while (Result.next()) {
                //taking data from result and putting it in the vector of metrics
                MetricRecord record = new MetricRecord();
                record.setmetricid(Result.getInt("metricid"));
                record.setmetricname(Result.getString("metricname"));
                record.setmetricinfo(Result.getString("metricinfo"));
                record.setmetricreference(Result.getString("metricreference"));
                record.setmetricdimension(Result.getInt("metricdimension"));
                record.setmetricinputtype(Result.getString("metricinputtype"));
                record.setx1_(Result.getString("x1_"));
                record.setx2_(Result.getString("x2_"));
                record.setx3_(Result.getString("x3_"));
                record.setx4_(Result.getString("x4_"));
                record.setsig_(Result.getString("sig_"));
                record.setcomplex_(Result.getString("complex_"));
                record.setmetriclineelement(Result.getString("metriclineelement"));
                record.setg11_(Result.getString("g11_"));
                record.setg12_(Result.getString("g12_"));
                record.setg13_(Result.getString("g13_"));
                record.setg14_(Result.getString("g14_"));
                record.setg21_(Result.getString("g21_"));
                record.setg22_(Result.getString("g22_"));
                record.setg23_(Result.getString("g23_"));
                record.setg24_(Result.getString("g24_"));
                record.setg31_(Result.getString("g31_"));
                record.setg32_(Result.getString("g32_"));
                record.setg33_(Result.getString("g33_"));
                record.setg34_(Result.getString("g34_"));
                record.setg41_(Result.getString("g41_"));
                record.setg42_(Result.getString("g42_"));
                record.setg43_(Result.getString("g43_"));
                record.setg44_(Result.getString("g44_"));
                record.setmetrictype(Result.getString("metrictype"));
                record.setmetricconstraints(Result.getString("metricconstraints"));
                record.setb11_(Result.getString("b11_"));
                record.setb12_(Result.getString("b12_"));
                record.setb13_(Result.getString("b13_"));
                record.setb14_(Result.getString("b14_"));
                record.setb21_(Result.getString("b21_"));
                record.setb22_(Result.getString("b22_"));
                record.setb23_(Result.getString("b23_"));
                record.setb24_(Result.getString("b24_"));
                record.setb31_(Result.getString("b31_"));
                record.setb32_(Result.getString("b32_"));
                record.setb33_(Result.getString("b33_"));
                record.setb34_(Result.getString("b34_"));
                record.setb41_(Result.getString("b41_"));
                record.setb42_(Result.getString("b42_"));
                record.setb43_(Result.getString("b43_"));
                record.setb44_(Result.getString("b44_"));
                record.setbd11_(Result.getString("bd11_"));
                record.setbd12_(Result.getString("bd12_"));
                record.setbd13_(Result.getString("bd13_"));
                record.setbd14_(Result.getString("bd14_"));
                record.setbd21_(Result.getString("bd21_"));
                record.setbd22_(Result.getString("bd22_"));
                record.setbd23_(Result.getString("bd23_"));
                record.setbd24_(Result.getString("bd24_"));
                record.setbd31_(Result.getString("bd31_"));
                record.setbd32_(Result.getString("bd32_"));
                record.setbd33_(Result.getString("bd33_"));
                record.setbd34_(Result.getString("bd34_"));
                record.setbd41_(Result.getString("bd41_"));
                record.setbd42_(Result.getString("bd42_"));
                record.setbd43_(Result.getString("bd43_"));
                record.setbd44_(Result.getString("bd44_"));
                record.settetradtype(Result.getString("tetradtype"));
                record.seteta11_(Result.getString("eta11_"));
                record.seteta12_(Result.getString("eta12_"));
                record.seteta13_(Result.getString("eta13_"));
                record.seteta14_(Result.getString("eta14_"));
                record.seteta21_(Result.getString("eta21_"));
                record.seteta22_(Result.getString("eta22_"));
                record.seteta23_(Result.getString("eta23_"));
                record.seteta24_(Result.getString("eta24_"));
                record.seteta31_(Result.getString("eta31_"));
                record.seteta32_(Result.getString("eta32_"));
                record.seteta33_(Result.getString("eta33_"));
                record.seteta34_(Result.getString("eta34_"));
                record.seteta41_(Result.getString("eta41_"));
                record.seteta42_(Result.getString("eta42_"));
                record.seteta43_(Result.getString("eta43_"));
                record.seteta44_(Result.getString("eta44_"));
                record.setbasemetrictype(Result.getString("basemetrictype"));
                record.setenergymomentumtype(Result.getString("energymomentumtype"));
                record.setkillingvector1_(Result.getString("killingvector1_"));
                record.setkillingvector2_(Result.getString("killingvector2_"));
                record.setkillingvector3_(Result.getString("killingvector3_"));
                record.setkillingvector4_(Result.getString("killingvector4_"));
                record.setpetrovtype(Result.getString("petrovtype"));
                record.setpetrovreport(Result.getString("petrovreport"));
                record.setsegretype(Result.getString("segretype"));
                record.setlambdatype(Result.getString("lambdatype"));
                record.setisotropytype(Result.getString("isotropytype"));
                record.setisotropyinfo(Result.getString("isotropyinfo"));
                record.setisometrytype(Result.getString("isometrytype"));
                record.setkshm_reference(Result.getString("kshm_reference"));
                record.setskea_reference(Result.getString("skea_reference"));
                record.sethawking_ellis_reference(Result.getString("hawking_ellis_reference"));
                record.setmetriclineelementhtml(Result.getString("metriclineelementhtml"));

                // adding the record to the vector
                vRecords.addElement(record);
            }

            MetricRecord records[] = null;
            if (vRecords.size() > 0) {
                records = new MetricRecord[vRecords.size()];
                for (int iCount = 0; iCount < records.length; iCount++) {
                    records[iCount] = (MetricRecord)vRecords.elementAt(iCount);
                }
            }
            //   GRDBServlet GRDBTest = (GRDBServlet) getServletConfig().getServletContext().getServlet("GRDBServlet") ;
            //   System.out.println(GRDBTest.toto+ " le nouveau !!!");
            SearchResultsPage ResultsPage = new SearchResultsPage(ServletAddress, records, "all names");
            // System.out.println(" after SearchResults Call in GRDBServlet");
            Result.close();
            return(ResultsPage);
        }
        catch (SQLException SqlE) {
            String ErrorMessage = "Error: in database search";
            MessagePage message = new MessagePage(ServletAddress, "Error", ErrorMessage + "<BR>Error: " + SqlE.toString());
            DisplaySqlError(SqlE);
            return (message);
        }
    }

    /**
     * Formats the login page
     * @param out The output stream to write the response to
     * @param uri The requesting URI
     */
    protected void login(ServletOutputStream out, String uri) throws java.io.IOException {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>grdb Private Input Login Page</title>");
        out.println("<body bgcolor=\"bidaff\">");
        out.println("<center><h2>grdb Private Input Login Page</h2>");
        out.println("<center><h2>Welcome! Please login</h2>");
        out.println("<br><form method=POST action=\"" + uri + "\">");
        out.println("<input type=\"hidden\" name=\"Command\" value=\"Validate\">");
        out.println("<table>");
        out.println("<tr><td>User ID:</td>");
        out.println("<td><input type=\"text\" name=\"" + FIELD_USER + "\" size=30></td></tr>");
        out.println("<tr><td>Password:</td>");
        out.println("<td><input type=\"password\" name=\"" + FIELD_PASSWORD + "\" size=14></td></tr>");
        out.println("</table><br>");
        out.println("<input type=\"submit\" value=\"Login\"><br><br>\n");
        out.println("<A href=\"#\" onClick=\"history.back();return false\"><b> Back to Previous Page </b></a>\n");
        out.println("</form></center></body></html>");
    }

    /**
     * Validates the username and password
     * @param username The user name
     * @param password The user password
     * @return true if the username/password is valid
     */
    protected boolean validUser(String username, String password) {
        boolean valid = false;
        // Perform a simple check to make sure the user is valid.
        if ((username != null) && (username.length() > 0)) {
            if ((username.equals("admin") && (password.equals("R_abcd=R_cdab")))) {
                valid = true;
            }
        }
        return valid;
    }

    public String getServletInfo() {
        return "Database servlet";
    }
}
