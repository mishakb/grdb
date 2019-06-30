/****************************************************************
*
* GRDB : HtmlForm.java
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
* Purpose: to define an html form.
*
* Revisions:
*
*
*****************************************************************/

package GRDB2.html;

public class HtmlForm extends HtmlContainer
{
    private String sName = "";
    private String sAction = "";
    private String sMethod = "";

    public HtmlForm ()      {   }

    public HtmlForm (String sName, String sAction, String sMethod)
    {
        this.sName = sName;
        this.sAction = sAction;
        this.sMethod = sMethod;
    }

    public void setName (String sName)
    {
        this.sName = sName;
    }

    public void setAction (String sAction)
    {
        this.sAction = sAction;
    }

    public void setMethod (String sMethod)
    {
        this.sMethod = sMethod;
    }

    public String getHtml ()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        sbHtmlText.append("\n<FORM");
        if (!sName.equals(""))
            sbHtmlText.append(" NAME=\"" + sName + "\"");

        if (!sAction.equals(""))
            sbHtmlText.append(" ACTION=\"" + sAction + "\"");

        if (!sMethod.equals(""))
            sbHtmlText.append(" METHOD=\"" + sMethod + "\"");

        sbHtmlText.append(">\n");
        sbHtmlText.append(super.getHtml());
        sbHtmlText.append("</FORM>\n");

        return (sbHtmlText.toString());

    }
}
