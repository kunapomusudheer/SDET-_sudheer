package com.Vtiger_generic;

public interface IAutoconstants {
	String currentdirectory=System.getProperty("user.dir");
	
	String propertyfilepth=currentdirectory+"/TestData/prop.PROPERTIES";
	String excelpath=currentdirectory+"/TestData/Book1.xlsx";
	String screenshotpath=currentdirectory+"/screenshot/";
	String extentreportpath=currentdirectory+"/Reports/vtiger"+Fakedata.randomNumber()+".html";
	
}
