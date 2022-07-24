package Com.Vtiger.Testcases;

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
import com.github.javafaker.Name;

import Pom_Classes.CreateCampaignPage;
import Pom_Classes.Vtigerloginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase5_create_camp_deleteCamp_Test {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		Fakedata fakedata=new Fakedata();
		String campName = fakedata.campName();
		int rNumber = fakedata.randomNumber();
		fileproperty prop=new fileproperty(driver);
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
		driver.get(u);
		//driver.manage().window().maximize();
		Webdriver_utility util=new Webdriver_utility(driver);
		util.maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		util.pageloadtimeout();
		//		driver.findElement(By.name("user_name")).sendKeys(un,Keys.TAB,pwd);
		//		driver.findElement(By.id("submitButton")).click();
		Vtigerloginpage login=new Vtigerloginpage(driver);
		login.getUsername().sendKeys(un);
		login.getPassword().sendKeys(pwd);
		login.getLoginbutton().click();
		Thread.sleep(3000);
		CreateCampaignPage createcampaign=new CreateCampaignPage(driver);
		createcampaign.getMorelink().click();
		//driver.findElement(By.xpath("//img[@style='padding-left:5px']")).click();
		//driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		createcampaign.getCampbutton().click();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		createcampaign.getcamplusbtn().click();
		//driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campName+ rNumber);
		createcampaign.getCampname().sendKeys(campName+ rNumber);
		//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		createcampaign.getCampsavename().click();
		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(campName+rNumber);
		driver.findElement(By.xpath("//select[@name='search_field']")).click();
		WebElement clist = driver.findElement(By.xpath("//select[@name='search_field']"));
		//Select s=new Select(clist);
		//s.selectByValue("campaignname");
		util.DropdownbyValue(clist,"campaignname" );
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		WebElement drop = driver.findElement(By.xpath("//input[@name='selected_id']"));

		//Actions act=new Actions(driver);
		//act.moveToElement(drop);
		util.mouseHandle(drop);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		Alert alt=driver.switchTo().alert();
		alt.accept();
		driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']")).click();
		Thread.sleep(4000);
		WebElement ele2=driver.findElement(By.xpath("//a[text()='Sign Out']"));
		//Actions act1=new Actions(driver);
		//act1.moveToElement(ele1);
		//ele1.click();
		util.mouseHandle(ele2);


	}

}
