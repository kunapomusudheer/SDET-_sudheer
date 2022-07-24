package testNG_Group_exe;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation {
	@BeforeSuite(groups = {"smoke","regression"})
	public void beforeSuite() {
		System.out.println("before suite");
	}
	@AfterSuite(groups = {"smoke","regression"})
	public void afterSuite() {
		System.out.println("after suite");
	}
	@BeforeTest(groups = {"smoke","regression"})
	public void beforeTest() {
		System.out.println("before Test");
	}
	@AfterTest(groups = {"smoke","regression"})
	public void afterTest() {
		System.out.println("after test");
	}
	@BeforeClass(groups = {"smoke","regression"})
	public void beforeClass() {
		System.out.println("before Class");
	}
	@AfterClass(groups = {"smoke","regression"})
	public void afterClass() {
		System.out.println("after class");
	}
	@BeforeMethod(groups = {"smoke","regression"})
	public void beforeMethod() {
		System.out.println("before method");
	}
	@AfterMethod(groups = {"smoke","regression"})
	public void afterMethod() {
		System.out.println("after Method");
	}
	
}
