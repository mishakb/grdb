/*
 * @(#)ServletLogin.java
 *
 * Copyright (c) 1998 Karl Moss. All Rights Reserved.
 *
 * You may study, use, modify, and distribute this software for any
 * purpose provided that this copyright notice appears in all copies.
 *
 * This software is provided WITHOUT WARRANTY either expressed or
 * implied.
 *
 * @author  Karl Moss
 * @version 1.0
 * @date    31Jan99
 *
 */

package GRDB2;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * <p>This servlet creates an HTML form to gather a username and
 * password, validates the user, then allows the user to access
 * other pages.
 */
public class ServletLogin extends HttpServlet
{
  public static String USER_KEY = "ServletLogin.user";
  public static String FIELD_USER = "username";
  public static String FIELD_PASSWORD = "toto";
  
  /**
    * <p>Performs the HTTP GET operation
    *
    * @param req The request from the client
    * @param resp The response from the servlet
    */
  public void doGet(HttpServletRequest req,
                    HttpServletResponse resp)
    throws ServletException, java.io.IOException
    {
      // Set the content type of the response
      resp.setContentType("text/html");

      // Get the PrintWriter to write the response
      java.io.PrintWriter out = resp.getWriter();

      // Set the response header to force the browser to
      // load the HTML page from the server instead of
      // from a cache
      resp.setHeader("Expires", "Tues, 01 Jan 1980 00:00:00 GMT");

      // Get the URI of this request
      String uri = req.getRequestURI();
      
      // Get the current user. If one does not exist, create
      // a form to gather the user and password
      HttpSession session = req.getSession(true);
      String user = (String) session.getValue(USER_KEY);

      if (user == null) {

        // No user - create the form to prompt the user
        login(out, uri);
        return;
      }
      
      // Print a standard header
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Wecome</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<center><h2>Welcome to our site!</h2>");
      out.println("<br>");
      out.println("More cool stuff coming soon...");
      out.println("</center>");
      
      // Wrap up
      out.println("</body>");
      out.println("</html>");
      out.flush();
    }

  /**
    * <p>Performs the HTTP POST operation
    *
    * @param req The request from the client
    * @param resp The response from the servlet
    */
  public void doPost(HttpServletRequest req,
                    HttpServletResponse resp)
    throws ServletException, java.io.IOException
    {
      // Set the content type of the response
      resp.setContentType("text/html");

      // Get the PrintWriter to write the response
      java.io.PrintWriter out = resp.getWriter();
      
      // If the user is not yet logged in, validate
      HttpSession session = req.getSession(true);
      String user = (String) session.getValue(USER_KEY);

      if (user == null) {
        String username = req.getParameter(FIELD_USER);
        String password = req.getParameter(FIELD_PASSWORD);

          out.println("<html>");
          out.println("<title>Invalid User "+username+" "+"password"+ " </title>");
          out.println("<body><center><h2>Invalid User!</h2><br>");
          out.println("Press the 'Back' button to try again");
          out.println("</center></body></html>");
          out.flush();
        if (!validUser(username, password)) {
          out.println("<html>");
          out.println("<title>Invalid User "+username+" "+"password"+ " </title>");
          out.println("<body><center><h2>Invalid User!</h2><br>");
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
      resp.sendRedirect("http://130.15.26.66" + req.getRequestURI());
    }
  
  /**
    * Formats the login page
    * @param out The output stream to write the response to
    * @param uri The requesting URI
    */
  protected void login(java.io.PrintWriter out, String uri)
    throws java.io.IOException
    {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Login</title>");
      out.println("<center><h2>Welcome! Please login</h2>");
      out.println("<br><form method=POST action=\"" +
                  uri + "\">");
      out.println("<table>");
      out.println("<tr><td>User ID:</td>");
      out.println("<td><input type=text name=" +
                  FIELD_USER + " size=30></td></tr>");
      out.println("<tr><td>Password:</td>");
      out.println("<td><input type=text name=" +
                  FIELD_PASSWORD + " size=10></td></tr>");
      out.println("</table><br>");
      out.println("<input type=submit value=\"Login\">");
      out.println("</form></center></body></html>");
    }

  /**
    * Validates the username and password
    * @param username The user name
    * @param password The user password
    * @return true if the username/password is valid
    */
  protected boolean validUser(String username, String password)
    {
      boolean valid = false;

      // Perform a simple check to make sure the user is valid.
      if ((username != null) && (username.length() > 0)) {
        valid = username.equals(password);
      }
      
      return valid;
    }
  
  /**
    * <p>Initialize the servlet. This is called once when the
    * servlet is loaded. It is guaranteed to complete before any
    * requests are made to the servlet
    *
    * @param cfg Servlet configuration information
    */
  public void init(ServletConfig cfg)
    throws ServletException
    {
      super.init(cfg);
    }

  /**
    * <p>Destroy the servlet. This is called once when the servlet
    * is unloaded.
    */
  public void destroy()
    {
      super.destroy();
    }

}

