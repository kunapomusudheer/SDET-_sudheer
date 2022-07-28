package com.Vtiger_generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fileproperty {
	public fileproperty(WebDriver driver) {
		
	}
	public String readpropertydata(String key) throws Exception 
	
	{
		FileInputStream fis=new FileInputStream(IAutoconsts.propertyfilepth);
		Properties prop= new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
	}
	
	
	public void openBrowser1(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("../SDET7_SUD/src/main/java/com/Vtiger_generic/prop.PROPERTIES");
		
	}
}

