/****************************************************************
 *
 * GRDB : MessagePage.java
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
 * Purpose: to display messages as web pages.
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
 *
 * @version 1.0
 */
public class MessagePage extends HtmlPage {
    public MessagePage (String sServletAddress, String sTitle, String sMessage) {
        HtmlHead head = new HtmlHead(sTitle);
        HtmlBody body = new HtmlBody();

        HtmlText title = new HtmlText(sTitle, "H2");
        body.addComponent(title);

        HtmlText message = new HtmlText(sMessage, "P");
        body.addComponent(message);

        // create anchors/links
        HtmlText sGoBack = new HtmlText("<A href=\"#\" onClick=\"history.back();return false\"><b> Back to Previous Page </b></a>");
        body.addComponent(sGoBack);
        body.addHtml("<BR>");

        // create anchors/links
        HtmlAnchor aHome = new HtmlAnchor("", new HtmlText("Database Home Page"), sServletAddress);
        body.addComponent(aHome);

        body.addHtml("<HR SIZE=2>");

        setHead(head);
        setBody(body);
    }
}
