package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicPrice {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("washingmachines");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[text()='Samsung']")).click();
		driver.findElement(By.xpath("//span[text()='Samsung 6.5 kg Fully-Automatic Top Loading Washing Machine (WA65A4002VS/TL, Imperial Silver, Diamond Drum)']")).click();
		String mainId=driver.getWindowHandle();
        Set<String>allID=driver.getWindowHandles();
       for(String i:allID) {
        	if(!i.equals(mainId)) {
        		driver.switchTo().window(i);
        	}
        }
       String data= driver.findElement(By.xpath("//span[@id='productTitle']/ancestor::div[@id='centerCol']//span[@class='a-price-whole']")).getText();
	   System.out.println(data);
	}

}
