package Com.Vtiger.Testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports {
	// Path , set theme, title (look and feel )
	ExtentSparkReporter reports;
	// attch reports manual inputs
	ExtentReports reporter;
	//To create entries in reports
	ExtentTest test;
	@Test
	public void createrReport() throws Throwable {
		ExtentSparkReporter reports=new ExtentSparkReporter("../SDET7_SUD/new2.html");
		reports.config().setDocumentTitle("zomato");
		reports.config().setTheme(Theme.STANDARD);
		ExtentReports reporter=new ExtentReports();
		reporter.attachReporter(reports);
		reporter.setSystemInfo("Application version", "2.0.1");
		reporter.setSystemInfo("Browser", "Chrome"); 
		reporter.setSystemInfo("tester", "Sudheer");
		reporter.setSystemInfo("Environment", "QA");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.zomato.com/");
		test=reporter.createTest("zomato123");
        TakesScreenshot sh=(TakesScreenshot)driver;
		File src = sh.getScreenshotAs(OutputType.FILE);
		String path = "../SDET7_SUD/screnshot/abc2.png";
		File dist = new File(path);
		FileUtils.copyFile(src, dist);
		test.addScreenCaptureFromPath(path);
		reporter.flush();
	}

}
