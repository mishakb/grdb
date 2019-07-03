/****************************************************************
*
* GRDB : HtmlHead.java
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
* Purpose: to define an html page header.
*
* Revisions:
*
*
*****************************************************************/

package GRDB2.html;

/**
 * This class represents the header in an html page
 *
 * @version 1.0
 */
public class HtmlHead extends HtmlContainer
{
    private String sTitle = "";

    public HtmlHead()   {   }

    public HtmlHead(String sTitle)
    {
        this.sTitle = sTitle;
    }

    public void setTitle(String sTitle)
    {
        this.sTitle = sTitle;
    }

    public String getHtml()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        sbHtmlText.append("<HEAD>\n");
        sbHtmlText.append("<TITLE>");
        sbHtmlText.append(sTitle);
        sbHtmlText.append("</TITLE>");
        sbHtmlText.append(super.getHtml());
        sbHtmlText.append("</HEAD>\n");

        return (sbHtmlText.toString());
    }
}
