package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Icc_table {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		driver.findElement(By.xpath("//a[@class='mobile-banner__close js-mobile-banner-close']")).click();
		List<WebElement> s = driver.findElements(By.xpath("//table//tr/td"));	
		for (WebElement a : s) {
			System.out.println(a.getText());
		}
		System.out.println("*****************************************");

		String lastrow = driver.findElement(By.xpath("//table//tr[@class='table-body'][last()]")).getText();
		System.out.println(lastrow);
		List<WebElement> pcolumn = driver.findElements(By.xpath("//table//tr[*]/td[3]"));
		for (WebElement b : pcolumn) {
			System.out.println(b.getText());

		}
		System.out.println("*****************************************");
		List<WebElement> prow = driver.findElements(By.xpath("//table//tr[*]/td[2]"));
		for (int i = 2; i < prow.size(); i++) {
			//String prows=driver.findElement(By.xpath("//table//tr/td["+i+"]")).getText();
			String s1=prow.get(i).getText();
			System.out.println(s1);
			if(prow.get(i).getText().equals("Pakistan")) {
				System.out.println(prow.get(i).getText());

			}

		}
	}
}