package testNG_parameters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Vtiger_generic.Webdriver_utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotation_1 extends Annotation {
	WebDriver driver;
	@Parameters("USERNAME")
	@Test
	public void test1(String username) {
		System.out.println(username);
		System.out.println("testcase1 passed");
	}
	@Parameters("browser")
	@Test
	public void launchBrowser(String Browser) {
		if (Browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		}
	}
	@Test
	public void test2() {
		System.out.println("testcase2 passed");
	}
}
