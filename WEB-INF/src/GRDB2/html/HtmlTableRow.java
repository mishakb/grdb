/****************************************************************
*
* GRDB : HtmlTableRow.java
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
* Purpose: to define a table row.
*
* Revisions:
*
*
*****************************************************************/

package GRDB2.html;

import java.util.Vector;

/**
 * This class represents an html row
 *
 * @version 1.0
 */
public class HtmlTableRow implements HtmlComponent
{
    private Vector vCells = new Vector();
    private Vector vParameters = new Vector();

    public HtmlTableRow ()      {   }

    public void addCell (HtmlTableCell cell)
    {
        vCells.addElement(cell);
    }

    public void addParameter(String sParameter)
    {
        vParameters.addElement(sParameter);
    }

    public String getHtml ()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        sbHtmlText.append("<TR");

        for (int iCount = 0; iCount < vParameters.size(); iCount++)
        {
            sbHtmlText.append(" " + (String)vParameters.elementAt(iCount));
        }
        sbHtmlText.append(">\n");

        for (int iCount = 0; iCount < vCells.size(); iCount++)
        {
            HtmlComponent comp = (HtmlComponent) vCells.elementAt(iCount);
            sbHtmlText.append(comp.getHtml());
        }

        sbHtmlText.append("</TR>\n");

        return (sbHtmlText.toString());

    }
}
