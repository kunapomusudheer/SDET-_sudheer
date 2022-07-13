package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles under 20000");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[text()='Samsung']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Samsung Galaxy M32 (Black, 4GB RAM, 64GB | FHD+ sAMOLED 90Hz Display | 6000mAh Battery | 64MP Quad Camera']")).click();
		String mainId=driver.getWindowHandle();
		Set<String>allID=driver.getWindowHandles();
		for(String i:allID) {
			if(!i.equals(mainId))  {
				driver.switchTo().window(i);
			}
		}
		driver.findElement(By.xpath("")).getText();
		//String data=driver.findElement(By.xpath("//span[normalize-space()='Samsung Galaxy M33 5G (Emerald Brown, 8GB, 128GB Storage) | Travel Adapter to be Purchased Separately']/ancestor::div[@id='centerCol']//span[@class='a-price a-text-price a-size-medium apexPriceToPay']")).getText();
		//System.out.println(data);


	}
}

