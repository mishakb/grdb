/****************************************************************
*
* GRDB : HtmlTextForm.java
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
* Purpose: to define an html Input text to be add to an html form.
*
* Revisions:
*
*
*****************************************************************/


package GRDB2.html;

public class HtmlTextInput extends HtmlInput
{
    private String localSize = "";
    private String localValue = "";

    public HtmlTextInput (String sName, String sValue)
    {
        super("text", sName, sValue);
        this.localValue = sValue;
    }

    public HtmlTextInput (String sName, String sValue, String sSize)
    {
        this(sName, sValue);
        this.localSize = sSize;
    }

    public String getHtml()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        sbHtmlText.append("<" + getParameterString());

          if (localSize.equals("")) 
            localSize = java.lang.String.valueOf(localValue.length()+10);



            sbHtmlText.append(" SIZE=" + localSize + " ALIGN=LEFT"); 

        sbHtmlText.append(">\n");

        return (sbHtmlText.toString());
    }
}
