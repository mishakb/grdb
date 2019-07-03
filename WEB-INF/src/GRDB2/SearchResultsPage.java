/****************************************************************
 *
 * GRDB : SearchResultsPage.java
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
 * Purpose: to display the results of a GRDB search request.
 *
 * Revisions:
 *
 *
 *****************************************************************/

package GRDB2;

import GRDB2.html.*;
import java.lang.Integer;

public class SearchResultsPage extends HtmlPage {
    public SearchResultsPage (String sServletAddress, MetricRecord records[], String sSearchText) {
        super();

        HtmlHead head = new HtmlHead("Search results for: " + sSearchText);

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
        HtmlAnchor aClear = new HtmlAnchor("", new HtmlText("<b>Clear Results</b>\n"), sServletAddress);

        String sListAllMetricsLink = sServletAddress + "?" + GRDBProtocol.COMMAND + "=" + GRDBProtocol.LIST_ALL;
        HtmlAnchor aListAllMetrics = new HtmlAnchor("", new HtmlText("<b>List All</b>\n"), sListAllMetricsLink);

        String sPrivateInputLink = sServletAddress + "?" + GRDBProtocol.COMMAND + "=" + GRDBProtocol.PRIVATE;
        HtmlAnchor aPrivateInput = new HtmlAnchor("", new HtmlText("<b>Private Input</b>\n"), sPrivateInputLink);

        String sAbout = "/~postgres/aboutgrdb.html";
        //String sAbout = "/~postgres/aboutgrdb.html";
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
        MetricsSearchForm  searchForm = new MetricsSearchForm(sServletAddress);
        body.addComponent(searchForm);
        body.addHtml("<HR SIZE=2 WIDTH=300>\n");

        //----------------------------------------------------------------------------
        // Calculator GRTensorJ Applet
        //----------------------------------------------------------------------------
        CalculatorForm  Calcform = new CalculatorForm(sServletAddress);
        body.addComponent(Calcform);
        body.addHtml("</CENTER>");
        body.addHtml("<HR SIZE=2 WIDTH=300>\n");

        //----------------------------------------------------------------------------
        //  Petrov Form Here
        //----------------------------------------------------------------------------
        // PetrovSearchForm  petrovForm = new PetrovSearchForm(sServletAddress);
        // body.addComponent(petrovForm);
        // body.addHtml("<HR SIZE=2 WIDTH=300>\n");

        //----------------------------------------------------------------------------
        //  Results Display Area
        //----------------------------------------------------------------------------
        HtmlText subtitle1 = new HtmlText("Search Results From Database");
        body.addComponent(new HtmlText("<CENTER>\n"));
        subtitle1.addFormatTag("B");
        body.addComponent(subtitle1);

        if (records == null || records.length == 0) {
            HtmlText nomatches = new HtmlText("Sorry, no matches were found.");
            nomatches.addFormatTag("B");
            nomatches.addFormatTag("P");
            body.addComponent(nomatches);
        }
        else {
            HtmlTableWithBorder results = new HtmlTableWithBorder();
            HtmlTableRow rows[] = new HtmlTableRow[records.length + 1];

            rows[0] = new HtmlTableRow();
            rows[0].addCell(new HtmlTableCell(new HtmlText("&nbsp;&nbsp;&nbsp;"),true));
            rows[0].addCell(new HtmlTableCell(new HtmlText("Name"),true));
            rows[0].addCell(new HtmlTableCell(new HtmlText("Description"),true));
            results.addRow(rows[0]);

            for (int iCount = 0; iCount < records.length; iCount++) {
                String sQueryString = "?" + GRDBProtocol.COMMAND + "=" + GRDBProtocol.GET + "&metricid=" + records[iCount].getmetricid();
                HtmlAnchor anchor = new HtmlAnchor("", new HtmlText(records[iCount].getmetricname()), sServletAddress + sQueryString);

                rows[iCount + 1] = new HtmlTableRow();
                rows[iCount + 1].addCell(new HtmlTableCell(new HtmlText("&nbsp;"+Integer.toString(iCount+1)   )));
                rows[iCount + 1].addCell(new HtmlTableCell(anchor));
                rows[iCount + 1].addCell(new HtmlTableCell(new HtmlText("<BR>"+records[iCount].getmetricinfo()+"<BR>")));
                results.addRow(rows[iCount + 1]);
            }

            body.addComponent(results);
            body.addHtml("</CENTER>");
        }
        setHead(head);
        setBody(body);
    }
}

// String sOverview = "This page will let you search for a metric " +
//     "by the name or a sub-string of the name " +
//     "You can also add a new metric, update or "+
//     "delete a metric (restricted), " +
//     " or list all metric currently " +
//     " in the database.";
// HtmlText overview = new HtmlText(sOverview, "P");
// body.addComponent(overview);
// body.addHtml("<HR SIZE=3 WIDTH=300>");
