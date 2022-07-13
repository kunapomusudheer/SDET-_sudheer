package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Svg_Hashtag {

	public static void main(String[] args) throws Throwable {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\eclipse-workspace\\Selenium\\src\\Browser_jar\\chromedriver.exe");
	       ChromeDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
		    driver.get("https://www.flipkart.com/");
		    Thread.sleep(300);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone11");
			driver.findElement(By.xpath("//*[name()='svg' and @xmlns='http://www.w3.org/2000/svg']")).click();
	}

}
