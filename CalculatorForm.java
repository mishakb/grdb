/****************************************************************
*
* GRDB : CalculatorForm.java
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
* Purpose: invoking the calculator.
*
* Revisions:
*
*
*****************************************************************/


package GRDB2;

import GRDB2.html.*;

/**
 */

public class CalculatorForm extends HtmlForm
{
    public CalculatorForm (String sServletAddress)
    {
        // super("CalculatorForm", sServletAddress, "GET");
        super("", sServletAddress, "GET");
	
addHtml("<applet\n ");
addHtml("codebase=\"/~postgres/GRTensorJ2/\"\n");
addHtml(" code=\"GRTensorJClient/GRTensorJClientApplet.class\"");
addHtml(" width=\"201\"");
addHtml(" height=\"31\"");
addHtml(">\n");
addHtml("<param name=\"port\" value=\"4470\">\n");
// addHtml("<param name=\"GRDBServlet\" value="+ param_GRDBServlet + ">\n");
addHtml("</applet><br>\n");
// addHtml("</center>\n");

// addHtml("Spacetimes can be loaded into the Calculator from the Database by clicking on the appropriate \"Load in Calculator\" Button that will appear near spacetimes names <br>");
// addHtml("<center> ");
//        HtmlHiddenInput command =
 //               new HtmlHiddenInput(GRDBProtocol.COMMAND,
  //                                  GRDBProtocol.SEARCH);
   //     addComponent(command);
    }
}
