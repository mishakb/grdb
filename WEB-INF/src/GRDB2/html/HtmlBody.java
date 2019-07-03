// HtmlBody.hava
package GRDB2.html;

/**
 * This class represents the body in an html page
 *
 */
public class HtmlBody extends HtmlContainer
{
    public String getHtml()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        sbHtmlText.append("<BODY bgcolor=\"b5d8ff\">\n");
        sbHtmlText.append(super.getHtml());
        sbHtmlText.append("</BODY>\n");

        return (sbHtmlText.toString());
    }
}
