/****************************************************************
*
* GRDB : PrivateInput.java
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
* Purpose: to perform the reserved "add a new metric" operation.
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
public class PrivateInput extends HtmlPage
{
    public PrivateInput (String sServletAddress)
    {
        HtmlHead head = new HtmlHead();
        HtmlBody body = new HtmlBody();

        HtmlText title = new HtmlText("grdb Private Input Page", "H2");
        body.addComponent(title);

        HtmlText message = new HtmlText("Internal Input and Maintenance Operations:", "P");
        body.addComponent(message);

        // create anchors/links


        String sNewMetricLink = sServletAddress + "?" +
                              GRDBProtocol.COMMAND + "=" +
                              GRDBProtocol.NEW;
        HtmlAnchor  aNewMetric = new HtmlAnchor("",
                               new HtmlText("Add a New Metric"),
                               sNewMetricLink);

            body.addComponent(aNewMetric);
            body.addHtml("<BR>");
            body.addHtml("<BR>");


        // create anchors/links
        HtmlAnchor  aHome = new HtmlAnchor("",
                            new HtmlText("Database Home Page"),
                            sServletAddress);

        body.addComponent(aHome);
        body.addHtml("<BR>");
        body.addHtml("<BR>");

        HtmlText sGoBack = new HtmlText("<A href=\"#\" onClick=\"history.back();return false\"><b> Back to Previous Page </b></a>");
        body.addComponent(sGoBack);

        body.addHtml("<HR SIZE=2>");

        setHead(head);
        setBody(body);
    }
}
