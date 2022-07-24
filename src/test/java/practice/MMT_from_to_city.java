package practice;



import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT_from_to_city {
	public static void main(String[] args) throws Throwable {
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/flights/?cmp=SEM|D|DF|G|Brand|B_M_Makemytrip_Search_Exact|Brand_MMT_Exact|Responsive|544716039990&s_kwcid=AL!1631!3!544716039990!e!!g!!mmt&ef_id=EAIaIQobChMIuaShtOn3-AIVi3wrCh1VTw5pEAAYASAAEgJUdPD_BwE:G:s&gclid=EAIaIQobChMIuaShtOn3-AIVi3wrCh1VTw5pEAAYASAAEgJUdPD_BwE");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		String src="HYD";
		String dest="GOI";
		driver.findElement(By.xpath("//label[@for='fromCity']")).sendKeys(src);
		driver.findElement(By.xpath("//div[text()='HYD']")).click();
		driver.findElement(By.xpath("//label[@for='toCity']")).sendKeys(dest);
		driver.findElement(By.xpath("//div[text()='GOI']")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		driver.findElement(By.xpath("//p[text()='22']")).click();

	}
}