// HtmlAnchor
/****************************************************************
*
* GRDB : HtmlAnchor.java
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
* Purpose: to define html Anchors and hypertext.
*
* Revisions:
*
*
*****************************************************************/

package GRDB2.html;

public class HtmlAnchor implements HtmlComponent
{
    private HtmlComponent anchorSubject = new HtmlText("");
    private String        sName = "";
    private String        sLink = "";

    public HtmlAnchor ()    {   }

    public HtmlAnchor (String sName, HtmlComponent subject, String sLink)
    {
        this.sName = sName;
        this.anchorSubject = subject;
        this.sLink = sLink;
    }

    public void setName (String sName)
    {
        this.sName = sName;
    }

    public void setAnchorSubject (HtmlComponent subject)
    {
        this.anchorSubject = subject;
    }

    public void setAnchorSubject (String sSubject)
    {
        this.anchorSubject = new HtmlText(sSubject);
    }

    public void setLink (String sLink)
    {
        this.sLink = sLink;
    }

    public String getHtml()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        sbHtmlText.append("<A");
        if (!sName.equals(""))
            sbHtmlText.append(" NAME=\"" + sName + "\"");

        if (!sLink.equals(""))
            sbHtmlText.append(" HREF=\"" + sLink +"\"");

        sbHtmlText.append(">");
        sbHtmlText.append(anchorSubject.getHtml());
        sbHtmlText.append("</A>");

        return (sbHtmlText.toString());
    }

}
