/****************************************************************
*
* GRDB : HtmlTableCell.java
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
* Purpose: to define an html table.
*
* Revisions:
*
*
*****************************************************************/

package GRDB2.html;

import java.util.Vector;

public class HtmlTableCell implements HtmlComponent
{
    private Vector  vParameters = new Vector();
    private boolean bIsHeader = false;
    private HtmlComponent comp;

    public HtmlTableCell (HtmlComponent comp)
    {
        this.comp = comp;
    }

    public HtmlTableCell (HtmlComponent comp, boolean bIsHeader)
    {
        this.comp = comp;
        this.bIsHeader = bIsHeader;
    }

    public void addParameter(String sParameter)
    {
        vParameters.addElement(sParameter);
    }

    public String getHtml ()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        if (bIsHeader)
            sbHtmlText.append("<TH");
        else
            sbHtmlText.append("<TD");

        for (int iCount = 0; iCount < vParameters.size(); iCount++)
        {
            sbHtmlText.append(" " + (String)vParameters.elementAt(iCount));
        }
        sbHtmlText.append(">");
        sbHtmlText.append(comp.getHtml());

        if (bIsHeader)
            sbHtmlText.append("</TH>");
        else
            sbHtmlText.append("</TD>");

        return (sbHtmlText.toString());

    }
}
