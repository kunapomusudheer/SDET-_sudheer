package practice;



import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Future_date {

	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date);
		//Wed Jun 22 13:32:43 IST 2022
		//0     1  2   3       4    5
		String currentdate = date.toString();
		String[] Str = currentdate.split(" ");
		String day=Str[0];
		String month=Str[1];
		String date1=Str[2];
		String year=Str[5];
		String todaydate=(day+" "+month+" "+date1+" "+year);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
	    driver.findElement(By.xpath("//div[@aria-label='"+todaydate+"']")).click();
		
		

	}

}

