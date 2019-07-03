/****************************************************************
 *
 * GRDB : ConfirmMarking.java
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
 * Purpose: to display messages.
 *
 * Revisions:
 *
 *
 *****************************************************************/

package GRDB2;

import GRDB2.html.*;

/**
 * This class represents an Html Page used to display
 * a status or error message
 */
public class ConfirmMarking extends HtmlPage {
    public ConfirmMarking (String sServletAddress, String sTitle, String sMessage, String sMessage2) {
        HtmlHead head = new HtmlHead(sTitle);
        HtmlBody body = new HtmlBody();

        HtmlText title = new HtmlText(sTitle, "H2");
        body.addComponent(title);

        HtmlText message = new HtmlText(sMessage, "P");
        body.addComponent(message);

        HtmlText message2 = new HtmlText(sMessage2, "P");
        body.addComponent(message2);

        // create anchors/links
        // HtmlAnchor  aHome = new HtmlAnchor("", new HtmlText("<b>Database Home Page</b>"), sServletAddress);
        // body.addComponent(aHome);
        // body.addHtml("<BR>");
        // body.addHtml("<BR>");

        HtmlText sGoBack2 = new HtmlText("<A href=\"#\" onClick=\"history.go(-2);return false\"><b>Home Page / Search Results</b></a>");
        body.addComponent(sGoBack2);

        body.addHtml("<BR>");
        body.addHtml("<BR>");

        HtmlText sGoBack = new HtmlText("<A href=\"#\" onClick=\"history.back();return false\"><b> Back to Previous Page </b></a>");
        body.addComponent(sGoBack);

        body.addHtml("<HR SIZE=2>");

        setHead(head);
        setBody(body);
    }
}
