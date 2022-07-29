package com.Vtiger_generic;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends BaseClass implements ITestListener {
	public static WebDriver driver;
	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"passed!");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+"failed");
		test.log(Status.FAIL, result.getThrowable());
		Webdriver_utility wu = new Webdriver_utility(driver);
		String methodname = result.getMethod().getMethodName(); 
		try {
			wu.screenshot(IAutoconstants.screenshotpath+methodname+Fakedata.randomNumber()+".png");
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	test.log(Status.SKIP, result.getMethod().getMethodName()+"Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void onStart(ITestContext context) {
		driver=BaseClass.driver;
		reporter = new ExtentSparkReporter(IAutoconstants.extentreportpath);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("VTIGER APPLICATION");
		reporter.config().setReportName("CRM Report");
		
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Build", "1.109");
		reports.setSystemInfo("Created by", "Sudheer");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}


	
	

}
