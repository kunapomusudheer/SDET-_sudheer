package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation_ComparePrice {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.name("q")).sendKeys("redmi note10 pro(dark night,128 GB)(6GB RAM)mobile",Keys.ENTER);
		String str=driver.findElement(By.xpath("//div[@class='_4rR01T'][1]/../following-sibling::div/div/div/div[1]")).getText();
		//System.out.println(str);
		String dat = str.replaceFirst("₹", "");
		String firstprice=dat.replaceFirst(",", "");
		System.out.println(firstprice);
		int flipkart=Integer.parseInt(firstprice);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		 driver.switchTo().newWindow(WindowType.TAB);
		 driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		
		WebElement ele=driver.findElement(By.id("twotabsearchtextbox"));
		Actions act=new Actions(driver);
		   act.moveToElement(ele).build().perform();
		   ele.sendKeys("redmi note10 pro(dark night,128 GB)(6GB RAM)mobile",Keys.ENTER);
		String data=driver.findElement(By.xpath("//span[text()='Redmi Note 10 Pro (Dark Night, 6GB RAM, 128GB Storage) -120hz Super Amoled Display|64MPwith 5mp Super Tele-Macro | 33W Charger Included']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']")).getText();
		//System.out.println(data);
		String secondprice=data.replaceFirst(",", "");
		System.out.println(secondprice);
		int amazon=Integer.parseInt(secondprice);
		String mainId = driver.getWindowHandle();
		Set<String> allID = driver.getWindowHandles();
		for(String i:allID) {
			if(!i.equals(mainId))  {
				driver.switchTo().window(i);

			}
		}
		driver.close();
         if(flipkart>amazon) {
      System.out.println("The cheapest price is"+flipkart);
	}
         else if (flipkart<amazon) {
        	 System.out.println("The cheapest price is"+amazon);
		}
        
         else {
			System.out.println("both prices are same");
		}
}
}