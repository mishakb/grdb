/****************************************************************
*
* GRDB : PetrovSearchForm.java
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
* Purpose: to monitor the petrov type verification for a GRDB spacetime.
*
* Revisions:
*
*
*****************************************************************/

package GRDB2;

import GRDB2.html.*;


public class PetrovSearchForm extends HtmlForm
{
    public PetrovSearchForm (String sServletAddress)
    {
        super("PetrovSearchForm", sServletAddress, "GET");

        addHtml("<CENTER>\n");
        addHtml("Select Petrov Type : ");
	addHtml("<SELECT NAME=\"PetrovType\">\n");
	addHtml("<OPTION selected> I\n");
	addHtml("<OPTION> II\n");
	addHtml("<OPTION> III\n");
	addHtml("<OPTION> D\n");
	addHtml("<OPTION> N\n");
	addHtml("<OPTION> O\n");
	addHtml("</SELECT>\n");
	addHtml("<input TYPE=\"submit\" NAME='PetrovButton' VALUE=\" List from Database \">\n");

        HtmlHiddenInput command =
                new HtmlHiddenInput(GRDBProtocol.COMMAND,
                                    GRDBProtocol.LIST_P);

        addHtml("</CENTER>");
        addComponent(command);
    }
}
