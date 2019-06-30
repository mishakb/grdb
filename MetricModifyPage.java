/****************************************************************
*
* GRDB : MetricModifyPage.java
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
* Purpose: To update a GRDB metric record.
*
* Revisions:
*
*
*****************************************************************/


package GRDB2;

import GRDB2.html.*;

/**
 */
public class MetricModifyPage extends HtmlPage
{
    public MetricModifyPage (String sServletAddress, MetricRecord record)
    {
        super();

        HtmlHead head = null;
        if (record != null)
            head = new HtmlHead("Metric Modification Page, for Metric Name: " +
                                                    record.getmetricname());
        else
            head = new HtmlHead("New Metric");

        StringBuffer sJavascript = new StringBuffer();
        sJavascript.append("<SCRIPT language=JavaScript>\n");
        sJavascript.append("<!-- hide from non-javascript browsers\n");
        sJavascript.append("function doSubmit (sAction)\n");
        sJavascript.append("{\n");
        sJavascript.append("document.forms.MetricModify.Command.value" +
                                                        "= sAction;\n");
        sJavascript.append("document.forms.MetricModify.submit();\n");
        sJavascript.append("}\n");
        sJavascript.append("// end hiding from old browsers -->\n");
        sJavascript.append("</SCRIPT>\n");

        head.addHtml(sJavascript.toString());

        // Body
        HtmlBody body = new HtmlBody();
        HtmlText title = null;

        if (record != null)
            title = new HtmlText("Spacetimes Active Online Database : Modifications Page", "H2");
        else
            title = new HtmlText("Spacetimes Active Online Database : New Metric Page", "H2");

        title.addFormatTag("CENTER");
        body.addComponent(title);
        body.addHtml("<HR SIZE=3>");


        // create anchors/links
        HtmlAnchor  aHome = new HtmlAnchor("",
                            new HtmlText("Database Home Page"),
                            sServletAddress);

        body.addComponent(aHome);
        body.addHtml("<BR>");

        HtmlText sGoBack = new HtmlText("<A href=\"#\" onClick=\"history.back();return false\"><b> Back to Previous Page </b></a>");
        body.addComponent(sGoBack);

        body.addHtml("<HR SIZE=3>");

        // Create form here
        HtmlForm form = new HtmlForm("MetricModify", sServletAddress, "POST");

        // text fields/hidden fields

        		HtmlHiddenInput Hmetricid = null;

			HtmlTextInput Hmetricname = null ;
			HtmlTextInput Hmetricinfo= null ;
			HtmlTextInput Hmetricreference = null ;
			HtmlTextInput Hmetricdimension = null ;
			HtmlTextInput Hmetricinputtype = null ;
			HtmlTextInput Hx1_ = null ;
			HtmlTextInput Hx2_ = null ;
			HtmlTextInput Hx3_ = null ;
			HtmlTextInput Hx4_ = null ;
			HtmlTextInput Hmetriclineelement = null ;
			HtmlTextInput Hsig_ = null ;
			HtmlTextInput Hcomplex_ = null ;

			HtmlTextInput Hg11_	= null ;
			HtmlTextInput Hg12_	= null ;
			HtmlTextInput Hg13_	= null ;
			HtmlTextInput Hg14_	= null ;
			HtmlTextInput Hg21_	= null ;
			HtmlTextInput Hg22_	= null ;
			HtmlTextInput Hg23_	= null ;
			HtmlTextInput Hg24_	= null ;
			HtmlTextInput Hg31_	= null ;
			HtmlTextInput Hg32_	= null ;
			HtmlTextInput Hg33_	= null ;
			HtmlTextInput Hg34_	= null ;
			HtmlTextInput Hg41_	= null ;
			HtmlTextInput Hg42_	= null ;
			HtmlTextInput Hg43_	= null ;
			HtmlTextInput Hg44_	= null ;

			HtmlTextInput Hb11_	= null ;
			HtmlTextInput Hb12_	= null ;
			HtmlTextInput Hb13_	= null ;
			HtmlTextInput Hb14_	= null ;
			HtmlTextInput Hb21_	= null ;
			HtmlTextInput Hb22_	= null ;
			HtmlTextInput Hb23_	= null ;
			HtmlTextInput Hb24_	= null ;
			HtmlTextInput Hb31_	= null ;
			HtmlTextInput Hb32_	= null ;
			HtmlTextInput Hb33_	= null ;
			HtmlTextInput Hb34_	= null ;
			HtmlTextInput Hb41_	= null ;
			HtmlTextInput Hb42_	= null ;
			HtmlTextInput Hb43_	= null ;
			HtmlTextInput Hb44_	= null ;

			HtmlTextInput Hbd11_	= null ;
			HtmlTextInput Hbd12_	= null ;
			HtmlTextInput Hbd13_	= null ;
			HtmlTextInput Hbd14_	= null ;
			HtmlTextInput Hbd21_	= null ;
			HtmlTextInput Hbd22_	= null ;
			HtmlTextInput Hbd23_	= null ;
			HtmlTextInput Hbd24_	= null ;
			HtmlTextInput Hbd31_	= null ;
			HtmlTextInput Hbd32_	= null ;
			HtmlTextInput Hbd33_	= null ;
			HtmlTextInput Hbd34_	= null ;
			HtmlTextInput Hbd41_	= null ;
			HtmlTextInput Hbd42_	= null ;
			HtmlTextInput Hbd43_	= null ;
			HtmlTextInput Hbd44_	= null ;

			HtmlTextInput Hmetrictype = null ;
			HtmlTextInput Hmetricconstraints = null ;

			HtmlTextInput Htetradtype	 = null ;

			HtmlTextInput Heta11_		= null ;
			HtmlTextInput Heta12_		= null ;
			HtmlTextInput Heta13_		= null ;
			HtmlTextInput Heta14_		= null ;
			HtmlTextInput Heta21_		= null ;
			HtmlTextInput Heta22_		= null ;
			HtmlTextInput Heta23_		= null ;
			HtmlTextInput Heta24_		= null ;
			HtmlTextInput Heta31_		= null ;
			HtmlTextInput Heta32_		= null ;
			HtmlTextInput Heta33_		= null ;
			HtmlTextInput Heta34_		= null ;
			HtmlTextInput Heta41_		= null ;
			HtmlTextInput Heta42_		= null ;
			HtmlTextInput Heta43_		= null ;
			HtmlTextInput Heta44_		= null ;

			HtmlTextInput Hbasemetrictype = null ;

			HtmlTextInput Henergymomentumtype = null ;

			HtmlTextInput Hkillingvector1_ = null ;
			HtmlTextInput Hkillingvector2_ = null ;
			HtmlTextInput Hkillingvector3_	= null ;
			HtmlTextInput Hkillingvector4_	= null ;

			HtmlTextInput Hpetrovtype 	= null ;
			HtmlTextInput Hpetrovreport 	= null ;

			HtmlTextInput Hsegretype 	= null ;

			HtmlTextInput Hlambdatype 	= null ;

			HtmlTextInput Hisotropytype 	= null ;
			HtmlTextInput Hisotropyinfo 	= null ;

			HtmlTextInput Hisometrytype 	= null ;

			HtmlTextInput Hkshm_reference 	= null ;
			HtmlTextInput Hskea_reference 	= null ;
			HtmlTextInput Hhawking_ellis_reference 	= null ;

			HtmlTextInput Hmetriclineelementhtml = null ;

        HtmlHiddenInput command = new HtmlHiddenInput("Command", "");


        // add buttons
        HtmlInputButton save = new HtmlInputButton("Save", "Save");
        save.addParameter("onClick=doSubmit(\"" +
                            GRDBProtocol.SAVE + "\")");
        HtmlInputButton delete = new HtmlInputButton("Delete", "Delete");
        delete.addParameter("onClick=doSubmit(\"" +
                            GRDBProtocol.DELETE + "\")");

        if (record == null)
        {
            form.addComponent(save);
        }
        else
        {
            form.addComponent(save);
            form.addComponent(delete);
        }


        if (record == null)
        {
	String InputSize = "50" ;
        Hmetricid = new HtmlHiddenInput("metricid", "");

	Hmetricname = new HtmlTextInput("metricname","",InputSize);
	Hmetricinfo = new HtmlTextInput("metricinfo","",InputSize);
	Hmetricreference = new HtmlTextInput("metricreference","",InputSize);
	Hmetricdimension = new HtmlTextInput("metricdimension","",InputSize);
	Hmetricinputtype = new HtmlTextInput("metricinputtype","",InputSize);
	Hx1_ = new HtmlTextInput("x1_","",InputSize);
	Hx2_ = new HtmlTextInput("x2_","",InputSize);
	Hx3_ = new HtmlTextInput("x3_","",InputSize);
	Hx4_ = new HtmlTextInput("x4_","",InputSize);

	Hmetriclineelement = new HtmlTextInput("metriclineelement","",InputSize);
	Hsig_ = new HtmlTextInput("sig_","",InputSize);
	Hcomplex_ = new HtmlTextInput("complex_","",InputSize);

	Hg11_	= new HtmlTextInput("g11_","",InputSize);
	Hg12_	= new HtmlTextInput("g12_","",InputSize);
	Hg13_	= new HtmlTextInput("g13_","",InputSize);
	Hg14_	= new HtmlTextInput("g14_","",InputSize);
	Hg21_	= new HtmlTextInput("g21_","",InputSize);
	Hg22_	= new HtmlTextInput("g22_","",InputSize);
	Hg23_	= new HtmlTextInput("g23_","",InputSize);
	Hg24_	= new HtmlTextInput("g24_","",InputSize);
	Hg31_	= new HtmlTextInput("g31_","",InputSize);
	Hg32_	= new HtmlTextInput("g32_","",InputSize);
	Hg33_	= new HtmlTextInput("g33_","",InputSize);
	Hg34_	= new HtmlTextInput("g34_","",InputSize);
	Hg41_	= new HtmlTextInput("g41_","",InputSize);
	Hg42_	= new HtmlTextInput("g42_","",InputSize);
	Hg43_	= new HtmlTextInput("g43_","",InputSize);
	Hg44_	= new HtmlTextInput("g44_","",InputSize);

	Hb11_	= new HtmlTextInput("b11_","",InputSize);
	Hb12_	= new HtmlTextInput("b12_","",InputSize);
	Hb13_	= new HtmlTextInput("b13_","",InputSize);
	Hb14_	= new HtmlTextInput("b14_","",InputSize);
	Hb21_	= new HtmlTextInput("b21_","",InputSize);
	Hb22_	= new HtmlTextInput("b22_","",InputSize);
	Hb23_	= new HtmlTextInput("b23_","",InputSize);
	Hb24_	= new HtmlTextInput("b24_","",InputSize);
	Hb31_	= new HtmlTextInput("b31_","",InputSize);
	Hb32_	= new HtmlTextInput("b32_","",InputSize);
	Hb33_	= new HtmlTextInput("b33_","",InputSize);
	Hb34_	= new HtmlTextInput("b34_","",InputSize);
	Hb41_	= new HtmlTextInput("b41_","",InputSize);
	Hb42_	= new HtmlTextInput("b42_","",InputSize);
	Hb43_	= new HtmlTextInput("b43_","",InputSize);
	Hb44_	= new HtmlTextInput("b44_","",InputSize);

	Hbd11_	= new HtmlTextInput("bd11_","",InputSize);
	Hbd12_	= new HtmlTextInput("bd12_","",InputSize);
	Hbd13_	= new HtmlTextInput("bd13_","",InputSize);
	Hbd14_	= new HtmlTextInput("bd14_","",InputSize);
	Hbd21_	= new HtmlTextInput("bd21_","",InputSize);
	Hbd22_	= new HtmlTextInput("bd22_","",InputSize);
	Hbd23_	= new HtmlTextInput("bd23_","",InputSize);
	Hbd24_	= new HtmlTextInput("bd24_","",InputSize);
	Hbd31_	= new HtmlTextInput("bd31_","",InputSize);
	Hbd32_	= new HtmlTextInput("bd32_","",InputSize);
	Hbd33_	= new HtmlTextInput("bd33_","",InputSize);
	Hbd34_	= new HtmlTextInput("bd34_","",InputSize);
	Hbd41_	= new HtmlTextInput("bd41_","",InputSize);
	Hbd42_	= new HtmlTextInput("bd42_","",InputSize);
	Hbd43_	= new HtmlTextInput("bd43_","",InputSize);
	Hbd44_	= new HtmlTextInput("bd44_","",InputSize);

	Hmetrictype = new HtmlTextInput("metrictype","",InputSize);

	Hmetricconstraints = new HtmlTextInput("metricconstraints","",InputSize);

	Htetradtype	 = new HtmlTextInput("tetradtype","",InputSize);

	Heta11_		= new HtmlTextInput("eta11_","",InputSize);
	Heta12_		= new HtmlTextInput("eta12_","",InputSize);
	Heta13_		= new HtmlTextInput("eta13_","",InputSize);
	Heta14_		= new HtmlTextInput("eta14_","",InputSize);
	Heta21_		= new HtmlTextInput("eta21_","",InputSize);
	Heta22_		= new HtmlTextInput("eta22_","",InputSize);
	Heta23_		= new HtmlTextInput("eta23_","",InputSize);
	Heta24_		= new HtmlTextInput("eta24_","",InputSize);
	Heta31_		= new HtmlTextInput("eta31_","",InputSize);
	Heta32_		= new HtmlTextInput("eta32_","",InputSize);
	Heta33_		= new HtmlTextInput("eta33_","",InputSize);
	Heta34_		= new HtmlTextInput("eta34_","",InputSize);
	Heta41_		= new HtmlTextInput("eta41_","",InputSize);
	Heta42_		= new HtmlTextInput("eta42_","",InputSize);
	Heta43_		= new HtmlTextInput("eta43_","",InputSize);
	Heta44_		= new HtmlTextInput("eta44_","",InputSize);

	Hbasemetrictype = new HtmlTextInput("basemetrictype","",InputSize);

	Henergymomentumtype = new HtmlTextInput("energymomentumtype","",InputSize);

	Hkillingvector1_ 	= new HtmlTextInput("killingvector1_","",InputSize);
	Hkillingvector2_ 	= new HtmlTextInput("killingvector2_","",InputSize);
	Hkillingvector3_ 	= new HtmlTextInput("killingvector3_","",InputSize);
	Hkillingvector4_ 	= new HtmlTextInput("killingvector4_","",InputSize);

	Hpetrovtype 	= new HtmlTextInput("petrovtype","",InputSize);
	Hpetrovreport 	= new HtmlTextInput("petrovreport","",InputSize);

	Hsegretype 	= new HtmlTextInput("segretype","",InputSize);

	Hlambdatype 	= new HtmlTextInput("lambdatype","",InputSize); 

	Hisotropytype 	= new HtmlTextInput("isotropytype","",InputSize);
	Hisotropyinfo 	= new HtmlTextInput("isotropyinfo","",InputSize);

	Hisometrytype 	= new HtmlTextInput("isometrytype","",InputSize);

	Hkshm_reference	= new HtmlTextInput("kshm_reference","",InputSize);
	Hskea_reference	= new HtmlTextInput("skea_reference","",InputSize);
	Hhawking_ellis_reference	= new HtmlTextInput("hawking_ellis_reference","",InputSize);

	Hmetriclineelementhtml = new HtmlTextInput("metriclineelementhtml","",InputSize);

        }
        else
        {

	String InputSize = "50" ;
        Hmetricid = new HtmlHiddenInput("metricid","" + record.getmetricid());
	Hmetricname = new HtmlTextInput("metricname","" + record.getmetricname(),InputSize);
	Hmetricinfo = new HtmlTextInput("metricinfo","" + record.getmetricinfo(),InputSize);
	Hmetricreference = new HtmlTextInput("metricreference","" + record.getmetricreference(),InputSize);
	Hmetricdimension = new HtmlTextInput("metricdimension","" + record.getmetricdimension(),InputSize);
	Hmetricinputtype = new HtmlTextInput("metricinputtype","" + record.getmetricinputtype(),InputSize);
	Hx1_ = new HtmlTextInput("x1_","" + record.getx1_(),InputSize);
	Hx2_ = new HtmlTextInput("x2_","" + record.getx2_(),InputSize);
	Hx3_ = new HtmlTextInput("x3_","" + record.getx3_(),InputSize);
	Hx4_ = new HtmlTextInput("x4_","" + record.getx4_(),InputSize);

	Hmetriclineelement = new HtmlTextInput("metriclineelement","" + record.getmetriclineelement(),InputSize);
	Hsig_ = new HtmlTextInput("sig_","" + record.getsig_(),InputSize);
	Hcomplex_ = new HtmlTextInput("complex_","" + record.getcomplex_(),InputSize);

	Hg11_	= new HtmlTextInput("g11_","" + record.getg11_(),InputSize);
	Hg12_	= new HtmlTextInput("g12_","" + record.getg12_(),InputSize);
	Hg13_	= new HtmlTextInput("g13_","" + record.getg13_(),InputSize);
	Hg14_	= new HtmlTextInput("g14_","" + record.getg14_(),InputSize);
	Hg21_	= new HtmlTextInput("g21_","" + record.getg21_(),InputSize);
	Hg22_	= new HtmlTextInput("g22_","" + record.getg22_(),InputSize);
	Hg23_	= new HtmlTextInput("g23_","" + record.getg23_(),InputSize);
	Hg24_	= new HtmlTextInput("g24_","" + record.getg24_(),InputSize);
	Hg31_	= new HtmlTextInput("g31_","" + record.getg31_(),InputSize);
	Hg32_	= new HtmlTextInput("g32_","" + record.getg32_(),InputSize);
	Hg33_	= new HtmlTextInput("g33_","" + record.getg33_(),InputSize);
	Hg34_	= new HtmlTextInput("g34_","" + record.getg34_(),InputSize);
	Hg41_	= new HtmlTextInput("g41_","" + record.getg41_(),InputSize);
	Hg42_	= new HtmlTextInput("g42_","" + record.getg42_(),InputSize);
	Hg43_	= new HtmlTextInput("g43_","" + record.getg43_(),InputSize);
	Hg44_	= new HtmlTextInput("g44_","" + record.getg44_(),InputSize);

	Hb11_	= new HtmlTextInput("b11_","" + record.getb11_(),InputSize);
	Hb12_	= new HtmlTextInput("b12_","" + record.getb12_(),InputSize);
	Hb13_	= new HtmlTextInput("b13_","" + record.getb13_(),InputSize);
	Hb14_	= new HtmlTextInput("b14_","" + record.getb14_(),InputSize);
	Hb21_	= new HtmlTextInput("b21_","" + record.getb21_(),InputSize);
	Hb22_	= new HtmlTextInput("b22_","" + record.getb22_(),InputSize);
	Hb23_	= new HtmlTextInput("b23_","" + record.getb23_(),InputSize);
	Hb24_	= new HtmlTextInput("b24_","" + record.getb24_(),InputSize);
	Hb31_	= new HtmlTextInput("b31_","" + record.getb31_(),InputSize);
	Hb32_	= new HtmlTextInput("b32_","" + record.getb32_(),InputSize);
	Hb33_	= new HtmlTextInput("b33_","" + record.getb33_(),InputSize);
	Hb34_	= new HtmlTextInput("b34_","" + record.getb34_(),InputSize);
	Hb41_	= new HtmlTextInput("b41_","" + record.getb41_(),InputSize);
	Hb42_	= new HtmlTextInput("b42_","" + record.getb42_(),InputSize);
	Hb43_	= new HtmlTextInput("b43_","" + record.getb43_(),InputSize);
	Hb44_	= new HtmlTextInput("b44_","" + record.getb44_(),InputSize);

	Hbd11_	= new HtmlTextInput("bd11_","" + record.getbd11_(),InputSize);
	Hbd12_	= new HtmlTextInput("bd12_","" + record.getbd12_(),InputSize);
	Hbd13_	= new HtmlTextInput("bd13_","" + record.getbd13_(),InputSize);
	Hbd14_	= new HtmlTextInput("bd14_","" + record.getbd14_(),InputSize);
	Hbd21_	= new HtmlTextInput("bd21_","" + record.getbd21_(),InputSize);
	Hbd22_	= new HtmlTextInput("bd22_","" + record.getbd22_(),InputSize);
	Hbd23_	= new HtmlTextInput("bd23_","" + record.getbd23_(),InputSize);
	Hbd24_	= new HtmlTextInput("bd24_","" + record.getbd24_(),InputSize);
	Hbd31_	= new HtmlTextInput("bd31_","" + record.getbd31_(),InputSize);
	Hbd32_	= new HtmlTextInput("bd32_","" + record.getbd32_(),InputSize);
	Hbd33_	= new HtmlTextInput("bd33_","" + record.getbd33_(),InputSize);
	Hbd34_	= new HtmlTextInput("bd34_","" + record.getbd34_(),InputSize);
	Hbd41_	= new HtmlTextInput("bd41_","" + record.getbd41_(),InputSize);
	Hbd42_	= new HtmlTextInput("bd42_","" + record.getbd42_(),InputSize);
	Hbd43_	= new HtmlTextInput("bd43_","" + record.getbd43_(),InputSize);
	Hbd44_	= new HtmlTextInput("bd44_","" + record.getbd44_(),InputSize);


	Hmetrictype = new HtmlTextInput("metrictype","" + record.getmetrictype(),InputSize);

	Hmetricconstraints = new HtmlTextInput("metricconstraints","" + record.getmetricconstraints(),InputSize);

	Htetradtype	 = new HtmlTextInput("tetradtype","" + record.gettetradtype(),InputSize);

	Heta11_		= new HtmlTextInput("eta11_","" + record.geteta11_(),InputSize);
	Heta12_		= new HtmlTextInput("eta12_","" + record.geteta12_(),InputSize);
	Heta13_		= new HtmlTextInput("eta13_","" + record.geteta13_(),InputSize);
	Heta14_		= new HtmlTextInput("eta14_","" + record.geteta14_(),InputSize);
	Heta21_		= new HtmlTextInput("eta21_","" + record.geteta21_(),InputSize);
	Heta22_		= new HtmlTextInput("eta22_","" + record.geteta22_(),InputSize);
	Heta23_		= new HtmlTextInput("eta23_","" + record.geteta23_(),InputSize);
	Heta24_		= new HtmlTextInput("eta24_","" + record.geteta24_(),InputSize);
	Heta31_		= new HtmlTextInput("eta31_","" + record.geteta31_(),InputSize);
	Heta32_		= new HtmlTextInput("eta32_","" + record.geteta32_(),InputSize);
	Heta33_		= new HtmlTextInput("eta33_","" + record.geteta33_(),InputSize);
	Heta34_		= new HtmlTextInput("eta34_","" + record.geteta34_(),InputSize);
	Heta41_		= new HtmlTextInput("eta41_","" + record.geteta41_(),InputSize);
	Heta42_		= new HtmlTextInput("eta42_","" + record.geteta42_(),InputSize);
	Heta43_		= new HtmlTextInput("eta43_","" + record.geteta43_(),InputSize);
	Heta44_		= new HtmlTextInput("eta44_","" + record.geteta44_(),InputSize);

	Hbasemetrictype = new HtmlTextInput("basemetrictype","" + record.getbasemetrictype(),InputSize);

	Henergymomentumtype = new HtmlTextInput("energymomentumtype","" + record.getenergymomentumtype(),InputSize);

	Hkillingvector1_ 	= new HtmlTextInput("killingvector1_","" + record.getkillingvector1_(),InputSize);
	Hkillingvector2_ 	= new HtmlTextInput("killingvector2_","" + record.getkillingvector2_(),InputSize);
	Hkillingvector3_ 	= new HtmlTextInput("killingvector3_","" + record.getkillingvector3_(),InputSize);
	Hkillingvector4_ 	= new HtmlTextInput("killingvector4_","" + record.getkillingvector4_(),InputSize);

	Hpetrovtype 	= new HtmlTextInput("petrovtype","" + record.getpetrovtype(),InputSize);
	Hpetrovreport 	= new HtmlTextInput("petrovreport","" + record.getpetrovreport(),InputSize);

	Hsegretype 	= new HtmlTextInput("segretype","" + record.getsegretype(),InputSize);

	Hlambdatype 	= new HtmlTextInput("lambdatype","" + record.getlambdatype(),InputSize);

	Hisotropytype 	= new HtmlTextInput("isotropytype","" + record.getisotropytype(),InputSize);
	Hisotropyinfo 	= new HtmlTextInput("isotropyinfo","" + record.getisotropyinfo(),InputSize);

	Hisometrytype 	= new HtmlTextInput("isometrytype","" + record.getisometrytype(),InputSize);

	Hkshm_reference 	= new HtmlTextInput("kshm_reference","" + record.getkshm_reference(),InputSize);
	Hskea_reference 	= new HtmlTextInput("skea_reference","" + record.getskea_reference(),InputSize);
	Hhawking_ellis_reference 	= new HtmlTextInput("hawking_ellis_reference","" + record.gethawking_ellis_reference(),InputSize);

	Hmetriclineelementhtml = new HtmlTextInput("metriclineelementhtml","" + record.getmetriclineelementhtml(),InputSize);

        }

        form.addComponent(command);
        form.addComponent(Hmetricid);

        HtmlTable table = new HtmlTable();
        HtmlTableRow rows[] = new HtmlTableRow[95];

        for (int iCount = 0; iCount < rows.length; iCount++)
        {
            rows[iCount] = new HtmlTableRow();
            table.addRow(rows[iCount]);
        }

	int rowNum = 0 ;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Name :")));
	rows[rowNum].addCell(new HtmlTableCell(Hmetricname ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Information :")));
	rows[rowNum].addCell(new HtmlTableCell(Hmetricinfo));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric References :")));
	rows[rowNum].addCell(new HtmlTableCell(Hmetricreference ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Dimension :")));
	rows[rowNum].addCell(new HtmlTableCell(Hmetricdimension ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Coordinate x1_ :")));
	rows[rowNum].addCell(new HtmlTableCell(Hx1_ ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Coordinate  x2_ :")));
	rows[rowNum].addCell(new HtmlTableCell(Hx2_ ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Coordinate  x3_ :")));
	rows[rowNum].addCell(new HtmlTableCell(Hx3_ ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Coordinate  x4_ :")));
	rows[rowNum].addCell(new HtmlTableCell(Hx4_ ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Signature    :")));
	rows[rowNum].addCell(new HtmlTableCell(Hsig_ ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Complex      :")));
	rows[rowNum].addCell(new HtmlTableCell(Hcomplex_ ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Line Element :")));
	rows[rowNum].addCell(new HtmlTableCell(Hmetriclineelement ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g11_ :")));
	rows[rowNum].addCell(new HtmlTableCell(Hg11_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g12_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg12_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g13_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg13_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g14_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg14_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g21_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg21_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g22_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg22_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g23_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg23_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g24_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg24_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g31_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg31_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g32_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg32_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g33_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg33_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g34_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg34_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g41_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg41_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g42_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg42_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g43_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg43_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g44_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hg44_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Type :")));
	rows[rowNum].addCell(new HtmlTableCell(Hmetrictype ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Constraints :")));
	rows[rowNum].addCell(new HtmlTableCell(Hmetricconstraints ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b11_ :")));
	rows[rowNum].addCell(new HtmlTableCell(Hb11_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b12_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb12_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b13_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb12_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b14_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb14_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b21_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb21_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b22_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb22_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b23_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb23_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b24_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb24_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b31_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb31_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b32_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb32_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b33_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb33_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b34_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb34_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b41_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb41_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b42_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb42_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b43_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb43_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b44_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hb44_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new  HtmlText("Contravariant basis  bd11_ :")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd11_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd12_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd12_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd13_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd12_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd14_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd14_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd21_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd21_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd22_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd22_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd23_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd23_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd24_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd24_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd31_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd31_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd32_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd32_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd33_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd33_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd34_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd34_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd41_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd41_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd42_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd42_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd43_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd43_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd44_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Hbd44_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("tetradtype	 :")));
	rows[rowNum].addCell(new HtmlTableCell(Htetradtype	 ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta11_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta11_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta12_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta12_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta13_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta13_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta14_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta14_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta21_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta21_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta22_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta22_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta23_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta23_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta24_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta24_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta31_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta31_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText(" eta32_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta32_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta34_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta34_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta41_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta41_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta42_		:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta42_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta43_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta43_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta44_	:")));
	rows[rowNum].addCell(new HtmlTableCell(Heta44_		));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Base Metric Type :")));
	rows[rowNum].addCell(new HtmlTableCell(Hbasemetrictype ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Energy Momentum Tensor Type :")));
	rows[rowNum].addCell(new HtmlTableCell(Henergymomentumtype ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Killing Vector k1_ :")));
	rows[rowNum].addCell(new HtmlTableCell(Hkillingvector1_ ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText(" Killing Vector k2_ :")));
	rows[rowNum].addCell(new HtmlTableCell(Hkillingvector2_ ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText(" Killing Vector k3_ :")));
	rows[rowNum].addCell(new HtmlTableCell(Hkillingvector3_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText(" Killing Vector k4_ :")));
	rows[rowNum].addCell(new HtmlTableCell(Hkillingvector4_	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Petrov Type :")));
	rows[rowNum].addCell(new HtmlTableCell(Hpetrovtype 	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Petrov Report :")));
	rows[rowNum].addCell(new HtmlTableCell(Hpetrovreport ));	

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Segre Type :")));
	rows[rowNum].addCell(new HtmlTableCell(Hsegretype 	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Lambda Type :")));
	rows[rowNum].addCell(new HtmlTableCell(Hlambdatype 	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Isotropy Type :")));
	rows[rowNum].addCell(new HtmlTableCell(Hisotropytype 	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Isotropy Information 	 :")));
	rows[rowNum].addCell(new HtmlTableCell(Hisotropyinfo ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Isometry Type :")));
	rows[rowNum].addCell(new HtmlTableCell(Hisometrytype ));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Kramer et al. reference :")));
	rows[rowNum].addCell(new HtmlTableCell(Hkshm_reference 	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Skea Database reference :")));
	rows[rowNum].addCell(new HtmlTableCell(Hskea_reference 	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Hawking&Ellis reference :")));
	rows[rowNum].addCell(new HtmlTableCell(Hhawking_ellis_reference 	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Input Type :")));
	rows[rowNum].addCell(new HtmlTableCell(Hmetricinputtype 	));

	rowNum++;
	rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Line Element (HTML):")));
	rows[rowNum].addCell(new HtmlTableCell(Hmetriclineelementhtml ));

        form.addComponent(table);

        // add buttons

        if (record == null)
        {
            form.addComponent(save);
        }
        else
        {
            form.addComponent(save);
            form.addComponent(delete);
        }

        body.addComponent(form);

        setHead(head);
        setBody(body);
    }
}


