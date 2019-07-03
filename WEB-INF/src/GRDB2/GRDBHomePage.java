/****************************************************************
 *
 * GRDB : GRDBHomePage.java
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
 * Purpose: to display GRDB homepage.
 *
 * Revisions:
 *
 *
 *****************************************************************/


package GRDB2;

import GRDB2.html.*;

public class GRDBHomePage extends HtmlPage {
    String ServletAddress;

    public GRDBHomePage (String ServletAddress) {
        super();
        this.ServletAddress = ServletAddress;

        HtmlHead head = new HtmlHead("GRDB Spacetimes Home Page");

        //-----------------------------------------------------------------------------
        // Body
        //-----------------------------------------------------------------------------
        HtmlBody body = new HtmlBody();
        body.addComponent(new HtmlText("<CENTER>\n"));

        HtmlText HeaderGRDB = new HtmlText("<TABLE BORDER=\"0\" CELLPADDING=\"0\">\n<TR ALIGN=\"CENTER\"><TD>\n<a href=\"http://www.queensu.ca\">\n<img src=\"/~postgres/qlogo.gif\" border=\"0\" alt=\"Queen's Coat of Arms\"></a></TD>\n<TD>&nbsp;&nbsp;</TD><TD><font size=\"+3\"><b>Interactive Geometric Database</b></font><br>\n<font size=\"+1\"> Including Exact Solutions of Einstein's Field Equations </font><br></TD></TR></TABLE>\n");
        body.addComponent(HeaderGRDB);

        HtmlText VersionAuthors = new HtmlText("<TABLE BORDER=\"0\" CELLPADDING=\"0\"><TR ALIGN=\"CENTER\">\n<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</TD><TD>\n<font size=\"+1\">Version 1.0</font>\n<br>Initial development by <br>\n<a href=\"http://www.astro.queensu.ca/~ishak\">Mustapha Ishak </a> and<a href=\"http://www.astro.queensu.ca/~lake\"> Kayll Lake </a></TD></TR></TABLE>");
        body.addComponent(VersionAuthors);

        HtmlText FutureUsage = new HtmlText(" ");
        String Spaces = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;";

        // create anchors/links
        HtmlAnchor aClear = new HtmlAnchor("", new HtmlText("<b>Clear Results</b>\n"), ServletAddress);

        String sListAllMetricsLink = ServletAddress + "?" + GRDBProtocol.COMMAND + "=" + GRDBProtocol.LIST_ALL;
        HtmlAnchor aListAllMetrics = new HtmlAnchor("", new HtmlText("<b>List All</b>\n"), sListAllMetricsLink);

        String sPrivateInputLink = ServletAddress + "?" + GRDBProtocol.COMMAND + "=" + GRDBProtocol.PRIVATE;
        HtmlAnchor aPrivateInput = new HtmlAnchor("", new HtmlText("<b>Private Input</b>\n"), sPrivateInputLink);

        String sAbout = "/~postgres/aboutgrdb.html";
        HtmlAnchor aAbout = new HtmlAnchor("", new HtmlText("<b>Information</b>\n"), sAbout);

        String sHow = "/~postgres/howgrdb.html";
        HtmlAnchor aHow = new HtmlAnchor("", new HtmlText("<b>Help</b>"), sHow);

        String sPublicInput = "/~postgres/publicinput.html";
        HtmlAnchor aPublicInput = new HtmlAnchor("", new HtmlText("<b>Public Input</b>\n"), sPublicInput);

        String sBuild = "/~postgres/build.html";
        HtmlAnchor aBuild = new HtmlAnchor("", new HtmlText("<b>Database</b>\n"), sBuild);

        //----------------------------------------------------------------------------
        // add operations and help items to Menu Here
        //----------------------------------------------------------------------------
        HtmlTableSpecial PublicOperations = new HtmlTableSpecial();
        HtmlTableRow PublicOperRows[] = new HtmlTableRow[1];
        HtmlTableCell Publiccells[] = new HtmlTableCell[7];

        PublicOperRows[0] = new HtmlTableRow();

        Publiccells[0] = new HtmlTableCell(new HtmlText("<b>Public </b>"));
        Publiccells[1] = new HtmlTableCell(aAbout);
        Publiccells[2] = new HtmlTableCell(aHow);
        Publiccells[3] = new HtmlTableCell(aClear);
        Publiccells[4] = new HtmlTableCell(aPublicInput);
        Publiccells[5] = new HtmlTableCell(FutureUsage);
        Publiccells[6] = new HtmlTableCell(FutureUsage);

        PublicOperRows[0].addParameter("ALIGN=\"CENTER\"");
        PublicOperRows[0].addCell(Publiccells[0]);
        PublicOperRows[0].addCell(Publiccells[1]);
        PublicOperRows[0].addCell(Publiccells[2]);
        PublicOperRows[0].addCell(Publiccells[3]);
        PublicOperRows[0].addCell(Publiccells[4]);
        PublicOperRows[0].addCell(Publiccells[5]);
        PublicOperRows[0].addCell(Publiccells[6]);
        PublicOperations.addRow(PublicOperRows[0]);

        HtmlTableSpecial PrivateOperations = new HtmlTableSpecial();
        HtmlTableRow PrivateOperRows[] = new HtmlTableRow[1];
        HtmlTableCell Privatecells[] = new HtmlTableCell[7];

        PrivateOperRows[0] = new HtmlTableRow();

        Privatecells[0] = new HtmlTableCell(new HtmlText("<b>Private </b>"));
        Privatecells[1] = new HtmlTableCell(aBuild);
        Privatecells[2] = new HtmlTableCell(aListAllMetrics);
        Privatecells[3] = new HtmlTableCell(aPrivateInput);
        Privatecells[4] = new HtmlTableCell(FutureUsage);
        Privatecells[5] = new HtmlTableCell(FutureUsage);
        Privatecells[6] = new HtmlTableCell(FutureUsage);

        PrivateOperRows[0].addParameter("ALIGN=\"CENTER\"");
        PrivateOperRows[0].addCell(Privatecells[0]);
        PrivateOperRows[0].addCell(Privatecells[1]);
        PrivateOperRows[0].addCell(Privatecells[2]);
        PrivateOperRows[0].addCell(Privatecells[3]);
        PrivateOperRows[0].addCell(Privatecells[4]);
        PrivateOperRows[0].addCell(Privatecells[5]);
        PrivateOperRows[0].addCell(Privatecells[6]);
        PrivateOperations.addRow(PrivateOperRows[0]);

        // body.addHtml("<CENTER>");
        body.addComponent(PublicOperations);
        body.addComponent(PrivateOperations);

        //----------------------------------------------------------------------------
        //  Search Form Here
        //----------------------------------------------------------------------------
        MetricsSearchForm  searchForm = new MetricsSearchForm(ServletAddress);
        body.addComponent(searchForm);
        body.addHtml("<HR SIZE=2 WIDTH=300>");

        //----------------------------------------------------------------------------
        // Calculator GRTensorJ Applet
        //----------------------------------------------------------------------------
        CalculatorForm  Calcform = new CalculatorForm(ServletAddress);
        body.addComponent(Calcform);
        // body.addHtml("</CENTER>");

        //----------------------------------------------------------------------------
        //  Petrov Form Here
        //----------------------------------------------------------------------------
        // PetrovSearchForm  petrovForm = new PetrovSearchForm(ServletAddress);
        // body.addComponent(petrovForm);
        // body.addHtml("<HR SIZE=2 WIDTH=300>");
        body.addHtml("</CENTER>");
        body.addHtml("<HR SIZE=2 WIDTH=300>");

        setHead(head);
        setBody(body);
    }
}
