package ListenersTest.java;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(Listnerimplements.class)
public class Annotation1 {
	public static WebDriver driver;
	@Test
	public void flipkart() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://flipkart.com/");
	}
	@Test
	public void amazon() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url1 = driver.getCurrentUrl();
		Assert.assertEquals(url1, "https://www.amazon.in/");
	}

}
