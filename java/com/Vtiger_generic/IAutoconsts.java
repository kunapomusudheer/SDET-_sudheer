package com.Vtiger_generic;

public interface IAutoconsts {
	
	String currentdirectory=System.getProperty("user.dir");
	String propertyfilepth="../SDET7_SUD/TestData/prop.PROPERTIES";
	String excelpath=currentdirectory+"/TestData/Book1.xlsx";
	String screenshotpath="../SDET7_SUD/screenshot/";
	String extentreportpath=currentdirectory+"/ExtentReport/Vtiger"+Fakedata.number+".html";
}
