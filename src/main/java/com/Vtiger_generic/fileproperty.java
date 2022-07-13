package com.Vtiger_generic;

import java.io.FileInputStream;
import java.util.Properties;

public class fileproperty {
	
	
   public String readpropertydata(String key) throws Exception 
   {
	   FileInputStream fis=new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\SDET7_SUD\\src\\main\\java\\com\\Vtiger_generic\\prop.PROPERTIES");
	   Properties prop= new Properties();
	   prop.load(fis);
	   String value=prop.getProperty(key);
	   return value;
   }

}

