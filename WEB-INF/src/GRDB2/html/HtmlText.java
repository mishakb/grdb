// HtmlText.hava
/****************************************************************
*
* GRDB : HtmlText.java
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
* Purpose: to define an html text.
*
* Revisions:
*
*
*****************************************************************/

package GRDB2.html;

import java.util.Vector;


public class HtmlText implements HtmlComponent
{
    private String sText = "";
    private Vector vFormatTags = new Vector();

    public HtmlText(String sText)
    {
        this.sText = sText;
    }

    public HtmlText(String sText, String sTag)
    {
        this.sText = sText;
        vFormatTags.addElement(sTag);
    }

    public void addFormatTag(String sTag)
    {
        vFormatTags.addElement(sTag);
    }

    public String getHtml()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        for (int iCount = 0; iCount < vFormatTags.size(); iCount++)
        {
            String sTag = "<" + (String)vFormatTags.elementAt(iCount) + ">";
            sbHtmlText.append(sTag);
        }
        sbHtmlText.append(sText);
        for (int iCount = 0; iCount < vFormatTags.size(); iCount++)
        {
            String sTag = "</" + (String)vFormatTags.elementAt(iCount) + ">";
            sbHtmlText.append(sTag);
        }

        return (sbHtmlText.toString());
    }
}
