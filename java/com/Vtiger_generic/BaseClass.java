package com.Vtiger_generic;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Pom_Classes.Homepage;
import Pom_Classes.Vtigerloginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  implements IAutoconsts{
	public  WebDriver driver;
	static WebDriver sdriver;

	fileproperty property;
	Vtigerloginpage login;
	Webdriver_utility wu;
	@BeforeSuite
	public void connectToDB() {
		System.out.println("====DB connection done");
	}
	@AfterSuite
	public void closeConnectToDB() {
		System.out.println("====DB connection closed");
	}
	@BeforeClass
	public void launchBrowser() throws Throwable {

		//System.out.println(property.readpropertydata("browser"));
		property=new fileproperty(driver);
		String value=property.readpropertydata("browser");
		if(value.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (value.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		Webdriver_utility wu = new Webdriver_utility(driver);
	
		wu.maximize();
		String url=property.readpropertydata("url");
		driver.get(url);
		sdriver=driver;

	}
	@AfterClass
	public void closeBrowser() throws Throwable {
		
		driver.close();
	}
	@BeforeMethod
	public void logionAppln() throws Throwable {

		login=new Vtigerloginpage(driver);
		login.logintoapp(property.readpropertydata("username"), property.readpropertydata("password"));

	}
	@AfterMethod
	public void logoutAppln() throws Throwable {
		Homepage homepage = new Homepage(driver);
		homepage.getSignoutimage().click();
		homepage.getSignoutbuttonlink().click();
	}





}
