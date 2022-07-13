package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcases_automation {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.name("q")).sendKeys("redmi mobiles",Keys.ENTER);
		//driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		WebElement str=driver.findElement(By.xpath("//div[@class='_1YokD2 _3Mn1Gg']/descendant::div[@class='_4rR01T'][1]"));
		//System.out.println(str);
		String str1=driver.findElement(By.xpath("//div[@class='_1YokD2 _3Mn1Gg']/descendant::div[@class='_30jeq3 _1_WHN1'][1]")).getText();
		//System.out.println(str1);
		String a =str1.replaceAll("₹","");
		//System.out.println(a);
		String c =a.replaceAll(",","");
		System.out.println(c);
		str.click();

		String mainId = driver.getWindowHandle();
		Set<String> allID = driver.getWindowHandles();
		for(String i:allID) {
			if(!i.equals(mainId))  {
				driver.switchTo().window(i);

			}
		}


		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,5000);");
		WebElement ele=driver.findElement(By.xpath("//input[@class='_253qQJ']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//button[text()='+']")).click();
		Thread.sleep(3000);
		//String data = driver.findElement(By.xpath("//div[@class='_3LxTgx']/ancestor::div[@class='_35mLK5']/descendant::div[@class='Ob17DV _3X7Jj1']")).getText();
	    //System.out.println(data);
		String data = driver.findElement(By.xpath("//div[@class='_3LxTgx']/ancestor::div[@class='_35mLK5']/descendant::div[@class='Ob17DV _3X7Jj1']")).getText();
	    System.out.println(data);
	}

}
