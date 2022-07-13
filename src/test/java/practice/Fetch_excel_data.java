package practice;

import com.Vtiger_generic.Data_fetch_Excel;

public class Fetch_excel_data {
public static void main(String[] args) throws Throwable {
	Data_fetch_Excel s=new Data_fetch_Excel();
	String m = s.dataFetch("sheet1", 4, 2);
	System.out.println(m);
}
}
