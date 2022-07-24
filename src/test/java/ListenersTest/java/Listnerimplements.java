package ListenersTest.java;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;



public class Listnerimplements implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("on testcase");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("tc passeed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("tc failed");
		TakesScreenshot sh = (TakesScreenshot)Annotation1.driver;
		File src = sh.getScreenshotAs(OutputType.FILE);
		String pathofscreenshot="../SDET7_SUD/screenshot/"+result.getMethod().getMethodName()+".png";
		File dest = new File(pathofscreenshot);
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("tc skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("TestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("TestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("on start");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on finish At last");
	}


}
