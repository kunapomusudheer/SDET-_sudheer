package DataProvider;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider_MMT {
	@Test(dataProvider = "getValue")
	public void test1(String src,String dest) throws InterruptedException, EncryptedDocumentException, IOException {
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/flights/?cmp=SEM|D|DF|G|Brand|B_M_Makemytrip_Search_Exact|Brand_MMT_Exact|Responsive|544716039990&s_kwcid=AL!1631!3!544716039990!e!!g!!mmt&ef_id=EAIaIQobChMIuaShtOn3-AIVi3wrCh1VTw5pEAAYASAAEgJUdPD_BwE:G:s&gclid=EAIaIQobChMIuaShtOn3-AIVi3wrCh1VTw5pEAAYASAAEgJUdPD_BwE");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		String src1="HYD";
		String dest1="GOI";
		driver.findElement(By.xpath("//label[@for='fromCity']")).sendKeys(src1);
		driver.findElement(By.xpath("//div[text()='HYD']")).click();
		driver.findElement(By.xpath("//label[@for='toCity']")).sendKeys(dest1);
		driver.findElement(By.xpath("//div[text()='GOI']")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		driver.findElement(By.xpath("//p[text()='22']")).click();

	}
	@DataProvider
	public Object[][] getValue() 
	{
		Object [][] arr = new Object [5][2];

		arr [0][0]="DEL";
		arr [0] [1]="HYD";

		arr [1][0]="BOM";
		arr [1][1]="MAA";

		arr [2][0]="GOI";
		arr [2][1]="NYC";

		arr [3][0]="BOM";
		arr [3][1]="HYD";

		arr [4][0]="DEL";
		arr [4][1]="PNQ";

		return arr;
	}
}





