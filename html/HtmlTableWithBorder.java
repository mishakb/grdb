/****************************************************************
*
* GRDB : HtmlTableWithBorder.java
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
* Purpose: to define an html table with a border.
*
* Revisions:
*
*
*****************************************************************/

package GRDB2.html;

import java.util.Vector;

public class HtmlTableWithBorder implements HtmlComponent
{
    private Vector vRows = new Vector();
    private Vector vParameters = new Vector();

    public HtmlTableWithBorder ()      {   }

    public void addRow (HtmlTableRow row)
    {
        vRows.addElement(row);
    }

    public void addParameter(String sParameter)
    {
        vParameters.addElement(sParameter);
    }

    public String getHtml ()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        sbHtmlText.append("\n<TABLE BORDER");

        for (int iCount = 0; iCount < vParameters.size(); iCount++)
        {
            sbHtmlText.append(" " + (String)vParameters.elementAt(iCount));
        }
        sbHtmlText.append(">\n");

        for (int iCount = 0; iCount < vRows.size(); iCount++)
        {
            HtmlComponent comp = (HtmlComponent) vRows.elementAt(iCount);
            sbHtmlText.append(comp.getHtml() + "\n");
        }

        sbHtmlText.append("</TABLE>\n");

        return (sbHtmlText.toString());

    }
}
