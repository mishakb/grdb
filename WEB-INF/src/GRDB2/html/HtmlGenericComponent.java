
/****************************************************************
*
* GRDB : HtmlGenericComponent.java
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
* Purpose: to define a generic html component.
*
* Revisions:
*
*
*****************************************************************/

package GRDB2.html;

public class HtmlGenericComponent implements HtmlComponent
{
    String sHtml;

    public HtmlGenericComponent(String sHtml)
    {
        this.sHtml = sHtml;
    }

    public String getHtml()
    {
        return (sHtml);
    }
}
