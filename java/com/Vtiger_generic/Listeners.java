package com.Vtiger_generic;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener{

	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	


	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" is started");
		test=reports.createTest(result.getMethod().getMethodName());
	}


	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"is got passed");
		test.log(Status.PASS,result.getMethod().getMethodName()+" got Passed" );	
	}
	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println(" is fail");
		test.log(Status.FAIL,result.getMethod().getMethodName()+" is fail");


		try {
			Webdriver_utility wu = new Webdriver_utility(BaseClass.sdriver);
			wu.takesscreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"is got skipped");
		test.log(Status.SKIP,result.getMethod().getMethodName()+" got Skip");
	}


	@Override
	public void onStart(ITestContext context) {
		reporter = new ExtentSparkReporter(IAutoconsts.extentreportpath);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("VTIGER APP");
		reporter.config().setReportName("CRM Report");

		reports= new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Build", "0.0.0");
		reports.setSystemInfo("Created by", "Sudheer");

	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}


}
