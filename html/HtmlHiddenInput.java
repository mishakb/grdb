/****************************************************************
*
* GRDB : HtmlHiddenInput.java
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
* Purpose: to define an html hidden input.
*
* Revisions:
*
*
*****************************************************************/


package GRDB2.html;

public class HtmlHiddenInput extends HtmlInput
{
    public HtmlHiddenInput (String sName, String sValue)
    {
        super("hidden", sName, sValue);
    }
}
