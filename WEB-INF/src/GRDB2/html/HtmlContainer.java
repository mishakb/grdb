/****************************************************************
*
* GRDB : HtmlContainer.java
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
* Purpose: to define an html container.
*
* Revisions:
*
*
*****************************************************************/

package GRDB2.html;

import java.util.Vector;
import java.util.Enumeration;

/**
 * This class is used to contain other html components
 *
 * @version 1.0
 */
public class HtmlContainer implements HtmlComponent
{
    private Vector htmlComponents = new Vector();

    public void addComponent(HtmlComponent htmlComponent)
    {
        htmlComponents.addElement(htmlComponent);
    }

    public void addHtml(String sHtml)
    {
        this.addComponent(new HtmlGenericComponent(sHtml));
    }

    public String getHtml()
    {
        StringBuffer sbHtmlText = new StringBuffer();
        for (int iCount = 0; iCount < htmlComponents.size(); iCount++)
        {
            HtmlComponent comp =
                    (HtmlComponent) htmlComponents.elementAt(iCount);
            sbHtmlText.append(comp.getHtml());
        }

        return (sbHtmlText.toString());
    }
}
