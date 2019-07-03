/****************************************************************
 *
 * GRDB : MetricsSearchForm.java
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
 * Purpose: interface to enter the search request elements.
 *
 * Revisions:
 *
 *
 *****************************************************************/

package GRDB2;

import GRDB2.html.*;

public class MetricsSearchForm extends HtmlForm {
    public MetricsSearchForm (String sServletAddress) {
        super("", sServletAddress, "GET");
        // super("MetricsSearchForm", sServletAddress, "GET");

        // create table
        HtmlTable table = new HtmlTable();
        HtmlTableRow rows[] = new HtmlTableRow[2];
        HtmlTableCell cells[][] = new HtmlTableCell[2][2];

        rows[0] = new HtmlTableRow();
        rows[1] = new HtmlTableRow();

        HtmlTextInput searchText = new HtmlTextInput("SearchText", "", "35");

        HtmlSubmitButton submit = new HtmlSubmitButton("SearchButton", "  Click to Search Database   ");
        HtmlRadioButton searchKSHM = new HtmlRadioButton("SearchParameter", "kshm", "Search by <a href=\"/~postgres/kshms.html\">KSHMS</a> (e.g. (13.24) p158)\n", false);

        HtmlRadioButton searchKeyword = new HtmlRadioButton("SearchParameter", "Keyword", "Search by <a href=\"/~postgres/keyword.html\">Keyword</a> (e.g. Kruskal)\n", true);

        HtmlHiddenInput command = new HtmlHiddenInput(GRDBProtocol.COMMAND, GRDBProtocol.SEARCH);

        cells[0][0] = new HtmlTableCell(searchText);
        cells[0][1] = new HtmlTableCell(submit);
        cells[1][0] = new HtmlTableCell(searchKeyword);
        cells[1][1] = new HtmlTableCell(searchKSHM);

        rows[0].addCell(cells[0][0]);
        rows[0].addCell(cells[0][1]);
        rows[1].addCell(cells[1][0]);
        rows[1].addCell(cells[1][1]);

        table.addRow(rows[0]);
        table.addRow(rows[1]);

        addHtml("<CENTER>");
        addComponent(table);
        addComponent(new HtmlText("More search parameters in development\n"));
        addHtml("</CENTER>");
        addComponent(command);
    }
}
