/****************************************************************
*
* GRDB : HtmlRadioButton.java
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
* Purpose: to define an html radio button.
*
* Revisions:
*
*
*****************************************************************/


package GRDB2.html;


public class HtmlRadioButton extends HtmlInput
{
    private HtmlText label;
    private boolean  bChecked = false;

    public HtmlRadioButton (String sName, String sValue,
                            String sLabel, boolean bChecked)
    {
        super("radio", sName, sValue);
        this.label = new HtmlText(sLabel);
        this.bChecked = bChecked;
    }

    public HtmlRadioButton (String sName, String sValue,
                            HtmlText label, boolean bChecked)
    {
        super("radio", sName, sValue);
        this.label = label;
        this.bChecked = bChecked;
    }

    public String getHtml()
    {
        StringBuffer sbHtmlText = new StringBuffer();

        sbHtmlText.append("<" + getParameterString());
        if (bChecked)
            sbHtmlText.append(" CHECKED");

        sbHtmlText.append(">\n");
        sbHtmlText.append(label.getHtml());

        return (sbHtmlText.toString());
    }

}
