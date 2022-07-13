package Com.Vtiger.Testcases;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Vtiger_generic.Fakedata;
import com.Vtiger_generic.Webdriver_utility;
import com.Vtiger_generic.fileproperty;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase4_create_org_delete_Test {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		Fakedata fakedata=new Fakedata();
		String orgname = fakedata.orgname();
		int rnumber = fakedata.randomNumber();

		fileproperty prop=new fileproperty();
		String Browser = prop.readpropertydata("browser");
		String u = prop.readpropertydata("url");
		String un = prop.readpropertydata("username");
		String pwd = prop.readpropertydata("password");
		if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Webdriver_utility util=new Webdriver_utility(driver);
		driver.get(u);
		util.maximize();
		util.pageloadtimeout();
		driver.findElement(By.name("user_name")).sendKeys(un,Keys.TAB,pwd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname+rnumber);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys( orgname+rnumber) ;
		driver.findElement(By.id("bas_searchfield")).click();
		Thread.sleep(3000);
		WebElement list = driver.findElement(By.id("bas_searchfield"));
		//Select s=new Select(list);
		//s.selectByValue("accountname");
		util.DropdownbyValue(list, "accountname");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		WebElement checkbox = driver.findElement(By.xpath("//input[@name='selected_id']"));
		//Actions act=new Actions(driver);
		//act.moveToElement(checkbox);
		util.mouseHandle(checkbox);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		//Alert alt=driver.switchTo().alert();
		//alt.accept();
		util.alertAccept();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(2000);
		WebElement ele1=driver.findElement(By.xpath("//a[text()='Sign Out']"));
		//Actions act1=new Actions(driver);
		//act1.moveToElement(ele1);
		//ele1.click();
		util.mouseHandle(ele1);


	}

}
