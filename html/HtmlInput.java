/****************************************************************
*
* GRDB : HtmlInput.java
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
* Purpose: to define an html input field to be add to a form.
*
* Revisions:
*
*
*****************************************************************/


package GRDB2.html;

import java.util.Vector;

/**
 * This class represents an html input field, this type of component
 * should only be added to an html form
 *
 * @version 1.0
 */
public class HtmlInput implements HtmlComponent
{
    private String sType = "";
    private String sName = "";
    private String sValue = "";
    private Vector vParameters = new Vector();

    public HtmlInput (String sType, String sName, String sValue)
    {
        this.sType = sType;
        this.sName = sName;
        this.sValue = sValue;
    }

    public void addParameter(String sParameter)
    {
        vParameters.addElement(sParameter);
    }

    protected String getParameterString()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        sbHtmlText.append("INPUT TYPE=\"" + sType + "\"");
        if (!sName.equals(""))
            sbHtmlText.append(" NAME=\"" + sName + "\"");

        if (!sValue.equals(""))
            sbHtmlText.append(" VALUE=\"" + sValue + "\"");

        for (int iCount = 0; iCount < vParameters.size(); iCount++)
        {
            sbHtmlText.append(" " + (String)vParameters.elementAt(iCount));
        }

        return (sbHtmlText.toString());
    }

    public String getHtml()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        sbHtmlText.append("<" + getParameterString() + ">\n");

        return (sbHtmlText.toString());
    }
}
