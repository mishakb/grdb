/****************************************************************
 *
 * GRDB : MetricDetailPage.java
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
 * Purpose: To maintain and update the details of a GRDB record.
 *
 * Revisions:
 *
 *
 *****************************************************************/

package GRDB2;

import GRDB2.html.*;
import java.lang.String;
import java.lang.Integer;

public class MetricDetailPage extends HtmlPage {
    public MetricDetailPage (String sServletAddress, MetricRecord record, int DisplayFullRecord) {
        super();

        HtmlHead head = null;
        head = new HtmlHead("Metric Detail for Metric Name: ");

        StringBuffer sJavascript = new StringBuffer();
        sJavascript.append("<SCRIPT language=JavaScript>\n");
        sJavascript.append("<!-- hide from non-javascript browsers\n");
        sJavascript.append("function doSubmit (sAction)\n");
        sJavascript.append("{\n");
        sJavascript.append("document.forms.MetricDetail.Command.value" + "= sAction;\n");
        sJavascript.append("document.forms.MetricDetail.submit();\n");
        sJavascript.append("}\n");
        sJavascript.append("// end hiding from old browsers -->\n");
        sJavascript.append("</SCRIPT>\n");
        head.addHtml(sJavascript.toString());

        // Body
        HtmlBody body = new HtmlBody();
        HtmlText title = null;
        title = new HtmlText("Record Details for : " + record.getmetricname(), "H2");
        title.addFormatTag("CENTER");
        body.addComponent(title);

        // create anchors/links
        // HtmlAnchor  aHome = new HtmlAnchor("", new HtmlText("Database Home Page"), sServletAddress);
        // body.addComponent(aHome);
        // body.addHtml("\n<BR>\n");

        HtmlText sGoBack = new HtmlText("<A href=\"#\" onClick=\"history.back();return false\"><b> Back to Previous Page </b></a>");
        body.addComponent(sGoBack);

        // body.addHtml("<HR SIZE=2>");

        HtmlText LoadInCalculator = new HtmlText("<FORM ACTION=\"/home\" METHOD=\"POST\"> <INPUT TYPE=\"submit\" NAME=\"LoadButton\" VALUE=\"Mark To Load in Calculator\">  <INPUT TYPE=\"hidden\" NAME=\"Command\" VALUE=\"AddToMetricsList\" > <INPUT TYPE=\"hidden\" NAME=\"MetricToLoad\" VALUE=\"" + record.getmetricname().trim() + "\" >  </FORM>\n" );
        body.addComponent(LoadInCalculator);

        if (record.getmetriclineelementhtml().trim().length() != 0) {
            HtmlText LineElementHtml = new HtmlText("<BR> <table bgcolor=\"#ffffc0\"> <td> <b> ds<sup><tt>2</tt></sup> = </b></td><td> " + record.getmetriclineelementhtml() + "</td></table><BR>\n");
            body.addComponent(LineElementHtml);
        }

        // Create form here
        HtmlForm form = new HtmlForm("MetricDetail", sServletAddress, "GET");

        // text fields/hidden fields
        HtmlHiddenInput Hmetricid = null;
        HtmlHiddenInput command = new HtmlHiddenInput("Command", "");

        // add buttons
        HtmlInputButton modify = new HtmlInputButton("Modify","Modify Record (password required)");
        modify.addParameter("onClick=doSubmit(\"" + GRDBProtocol.MODIFY + "\")");
        HtmlInputButton getfull = new HtmlInputButton("DisplayFullRecord", "Display Full Record");
        getfull.addParameter("onClick=doSubmit(\"" + GRDBProtocol.GETFULL + "\")");
        HtmlInputButton getpart = new HtmlInputButton("DisplayRecord", "Display Record");
        getpart.addParameter("onClick=doSubmit(\"" + GRDBProtocol.GET + "\")");
        form.addComponent(modify);
        form.addComponent(getpart);
        form.addComponent(getfull);

        Hmetricid = new HtmlHiddenInput("metricid", "" + record.getmetricid());
        form.addComponent(command);
        form.addComponent(Hmetricid);

        HtmlTable table = new HtmlTable();
        HtmlTableRow rows[] = new HtmlTableRow[96];

        for (int iCount = 0; iCount < rows.length; iCount++) {
            rows[iCount] = new HtmlTableRow();
            table.addRow(rows[iCount]);
        }

        if (DisplayFullRecord == 0) {
            int rowNum = 0;
            if (record.getmetricname().trim().length() != 0) {
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Name :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetricname().trim())));
            }
            if (record.getmetricinfo().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Information :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetricinfo().trim())));
            }
            if (record.getmetricreference().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric References :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetricreference().trim())));
            }
            if (Integer.toString(record.getmetricdimension()).trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Dimension :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(Integer.toString(record.getmetricdimension()).trim())));
            }
            if (record.getx1_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Coordinate x1_ :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getx1_().trim())));
            }
            if (record.getx2_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Coordinate  x2_ :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getx2_().trim())));
            }
            if (record.getx3_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Coordinate  x3_ :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getx3_().trim())));
            }
            if (record.getx4_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Coordinate  x4_ :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getx4_().trim())));
            }
            if (record.getsig_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Signature :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getsig_().trim())));
            }
            if (record.getcomplex_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Complex :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getcomplex_().trim())));
            }
            if (record.getmetriclineelement().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Line Element :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetriclineelement().trim())));
            }
            if (record.getg11_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g11_ :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg11_().trim())));
            }
            if (record.getg12_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g12_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg12_().trim())));
            }
            if (record.getg13_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g13_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg13_().trim())));
            }
            if (record.getg14_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g14_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg14_().trim())));
            }
            if (record.getg21_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g21_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg21_().trim())));
            }
            if (record.getg22_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g22_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg22_().trim())));
            }
            if (record.getg23_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g23_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg23_().trim())));
            }
            if (record.getg24_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g24_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg24_().trim())));
            }
            if (record.getg31_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g31_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg31_().trim())));
            }
            if (record.getg32_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g32_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg32_().trim())));
            }
            if (record.getg33_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g33_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg33_().trim())));
            }
            if (record.getg34_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g34_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg34_().trim())));
            }
            if (record.getg41_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g41_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg41_().trim())));
            }
            if (record.getg42_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g42_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg42_().trim())));
            }
            if (record.getg43_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g43_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg43_().trim())));
            }
            if (record.getg44_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g44_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg44_().trim())));
            }
            if (record.getb11_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b11_ :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg11_().trim())));
            }
            if (record.getb12_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b12_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb12_().trim())));
            }
            if (record.getb13_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b13_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb13_().trim())));
            }
            if (record.getb14_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b14_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb14_().trim())));
            }
            if (record.getb21_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b21_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb21_().trim())));
            }
            if (record.getb22_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b22_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb22_().trim())));
            }
            if (record.getb23_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b23_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb23_().trim())));
            }
            if (record.getb24_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b24_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb24_().trim())));
            }
            if (record.getb31_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b31_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb31_().trim())));
            }
            if (record.getb32_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b32_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb32_().trim())));
            }
            if (record.getb33_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b33_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb33_().trim())));
            }
            if (record.getb34_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b34_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb34_().trim())));
            }
            if (record.getb41_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b41_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb41_().trim())));
            }
            if (record.getb42_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b42_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb42_().trim())));
            }
            if (record.getb43_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b43_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb43_().trim())));
            }
            if (record.getb44_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b44_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb44_().trim())));
            }
            if (record.getbd11_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd11_ :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd11_().trim())));
            }
            if (record.getbd12_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd12_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd12_().trim())));
            }
            if (record.getbd13_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd13_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd13_().trim())));
            }
            if (record.getbd14_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd14_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd14_().trim())));
            }
            if (record.getbd21_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd21_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd21_().trim())));
            }
            if (record.getbd22_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd22_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd22_().trim())));
            }
            if (record.getbd23_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd23_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd23_().trim())));
            }
            if (record.getbd24_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd24_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd24_().trim())));
            }
            if (record.getbd31_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd31_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd31_().trim())));
            }
            if (record.getbd32_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd32_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd32_().trim())));
            }
            if (record.getbd33_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd33_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd33_().trim())));
            }
            if (record.getbd34_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd34_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd34_().trim())));
            }
            if (record.getbd41_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd41_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd41_().trim())));
            }
            if (record.getbd42_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd42_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd42_().trim())));
            }
            if (record.getbd43_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd43_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd43_().trim())));
            }
            if (record.getbd44_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  gd44_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd44_().trim())));
            }
            if (record.getmetrictype().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Type :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetrictype().trim())));
            }
            if (record.getmetricconstraints().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Constraints :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetricconstraints().trim())));
            }
            if (record.gettetradtype().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("tetradtype   :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.gettetradtype().trim())));
            }
            if (record.geteta11_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta11_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta11_().trim())));
            }
            if (record.geteta12_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta12_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta12_().trim())));
            }
            if (record.geteta13_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta13_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta13_().trim())));
            }
            if (record.geteta14_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta14_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta14_().trim())));
            }
            if (record.geteta21_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta21_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta21_().trim())));
            }
            if (record.geteta22_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta22_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta22_().trim())));
            }
            if (record.geteta23_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta23_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta23_().trim())));
            }
            if (record.geteta24_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta24_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta24_().trim())));
            }
            if (record.geteta31_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta31_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta31_().trim())));
            }
            if (record.geteta32_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(" eta32_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta32_().trim())));
            }
            if (record.geteta33_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta34_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta34_().trim())));
            }
            if (record.geteta34_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta41_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta41_().trim())));
            }
            if (record.geteta41_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta42_    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta42_().trim())));
            }
            if (record.geteta42_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta43_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta43_().trim())));
            }
            if (record.geteta43_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta44_  :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta44_().trim())));
            }
            if (record.geteta44_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Basis Metric Type :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbasemetrictype().trim())));
            }
            if (record.getenergymomentumtype().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Energy Momentum Tensor Type :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getenergymomentumtype().trim())));
            }
            if (record.getkillingvector1_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Killing Vector k1_ :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getkillingvector1_().trim())));
            }
            if (record.getkillingvector2_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(" Killing Vector k2_ :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getkillingvector2_().trim())));
            }
            if (record.getkillingvector3_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(" Killing Vector k3_ :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getkillingvector3_().trim())));
            }
            if (record.getkillingvector4_().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(" Killing Vector k4_ :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getkillingvector4_().trim())));
            }
            if (record.getpetrovtype().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Petrov Type :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getpetrovtype().trim())));
            }
            if (record.getpetrovreport().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Petrov Report :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getpetrovreport().trim())));
            }
            if (record.getsegretype().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Segre Type :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getsegretype().trim())));
            }
            if (record.getlambdatype().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Lambda Type :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getlambdatype().trim())));
            }
            if (record.getisotropytype().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Isotropy Type :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getisotropytype().trim())));
            }
            if (record.getisotropyinfo().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Isotropy Information    :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getisotropyinfo().trim())));
            }
            if (record.getisotropytype().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Isometry Type :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getisometrytype().trim())));
            }
            if (record.getkshm_reference().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Kramer et al. reference :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getkshm_reference().trim())));
            }
            // if (record.getskea_reference().trim().length() != 0) {
            //     rowNum++;
            //     rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Archive reference       :")));
            //     rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getskea_reference().trim())));
            // }
            if (record.gethawking_ellis_reference().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Hawking&Ellis reference :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.gethawking_ellis_reference().trim())));
            }
            if (record.getmetricinputtype().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Input Type :")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetricinputtype().trim())));
            }
            if (record.getmetriclineelementhtml().trim().length() != 0) {
                rowNum++;
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Line Element(HTML):")));
                rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetriclineelementhtml().trim())));
            }

        }
        else {
            int rowNum=0;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Name :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetricname().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Information :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetricinfo().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric References :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetricreference().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Dimension :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(Integer.toString(record.getmetricdimension()).trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Coordinate x1_ :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getx1_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Coordinate  x2_ :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getx2_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Coordinate  x3_ :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getx3_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Coordinate  x4_ :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getx4_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Signature    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getsig_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Complex      :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getcomplex_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Line Element :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetriclineelement().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g11_ :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg11_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g12_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg12_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g13_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg13_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g14_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg14_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g21_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg21_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g22_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg22_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g23_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg23_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g24_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg24_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g31_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg31_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g32_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg32_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g33_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg33_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g34_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg34_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g41_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg41_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g42_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg42_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g43_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg43_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Component g44_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getg44_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b11_ :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb11_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b12_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb12_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b13_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb13_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b14_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb14_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b21_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb21_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b22_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb22_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b23_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb23_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b24_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb24_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b31_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb31_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b32_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb32_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b33_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb33_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b34_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb34_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b41_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb41_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b42_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb42_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b43_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb43_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Covariant basis  b44_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getb44_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd11_ :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd11_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd12_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd12_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd13_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd13_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd14_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd14_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd21_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd21_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd22_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd22_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd23_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd23_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd24_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd24_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd31_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd31_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd32_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd32_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd33_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd33_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd34_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd34_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd41_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd41_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd42_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd42_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd43_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd43_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Contravariant basis  bd44_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbd44_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Type              :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetrictype().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Constraints       :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetricconstraints().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("tetradtype   :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.gettetradtype().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta11_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta11_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta12_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta12_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta13_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta13_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta14_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta14_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta21_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta21_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta22_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta22_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta23_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta23_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta24_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta24_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta31_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta31_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(" eta32_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta32_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta34_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta34_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta41_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta41_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta42_    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta42_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta43_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta43_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("eta44_  :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.geteta44_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Base Metric Type :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getbasemetrictype().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Energy Momentum Tensor Type :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getenergymomentumtype().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Killing Vector k1_ :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getkillingvector1_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(" Killing Vector k2_ :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getkillingvector2_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(" Killing Vector k3_ :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getkillingvector3_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(" Killing Vector k4_ :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getkillingvector4_().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Petrov Type :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getpetrovtype().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Petrov Report :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getpetrovreport().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Segre Type :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getsegretype().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Lambda Type :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getlambdatype().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Isotropy Type :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getisotropytype().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Isotropy Information    :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getisotropyinfo().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Isometry Type :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getisometrytype().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Kramer et al. reference :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getkshm_reference().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Archive reference       :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getskea_reference().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Hawking&Ellis reference :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.gethawking_ellis_reference().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Input Type :")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetricinputtype().trim())));
            rowNum++;
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText("Metric Line Element (HTML):")));
            rows[rowNum].addCell(new HtmlTableCell(new HtmlText(record.getmetriclineelementhtml().trim())));
        }
        form.addComponent(table);

        // add buttons
        // form.addComponent(getpart);
        // form.addComponent(getfull);
        form.addComponent(modify);
        body.addComponent(form);

        setHead(head);
        setBody(body);
    }
}
