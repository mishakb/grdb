/****************************************************************
*
* GRDB : HtmlPage.java
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
* Purpose: to define an html page.
*
* Revisions:
*
*
*****************************************************************/


package GRDB2.html;


public class HtmlPage implements HtmlComponent
{
    private HtmlHead head;
    private HtmlBody body;

    public HtmlPage()
    {
        head = new HtmlHead();
        body = new HtmlBody();
    }

    public HtmlPage(HtmlHead head, HtmlBody body)
    {
        this.head = head;
        this.body = body;
    }

    protected void setHead (HtmlHead head)
    {
        this.head = head;
    }

    protected void setBody (HtmlBody body)
    {
        this.body = body;
    }

    public String getHtml()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        sbHtmlText.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\"\n");
        sbHtmlText.append("\"http://www.w3.org/TR/REC-html40/loose.dtd\">\n");
	sbHtmlText.append("<HTML>\n");
        sbHtmlText.append(head.getHtml());
        sbHtmlText.append(body.getHtml());
        sbHtmlText.append("</HTML>\n");

        return (sbHtmlText.toString());
    }
}
