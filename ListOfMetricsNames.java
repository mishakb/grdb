/****************************************************************
*
* GRDB : ListOfMetricsNames.java
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
* Purpose: For the exchange of Metric Names.
*
* Revisions:
*
*
*****************************************************************/



package GRDB2;

import java.io.* ;

public class ListOfMetricsNames implements Serializable {

private String lom = new String("");

public ListOfMetricsNames() {

}

public void setListOfMetricsNames(String value) {

if (value != null) {

lom = value ;

}
}

public String getListOfMetricsNames() {

return lom ;

}

}
