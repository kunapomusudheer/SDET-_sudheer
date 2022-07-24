package Com.Vtiger.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.Vtiger_generic.Fakedata;
import com.Vtiger_generic.Webdriver_utility;
import com.Vtiger_generic.fileproperty;

import Pom_Classes.CreateOrgPage;
import Pom_Classes.Homepage;
import Pom_Classes.OrganizationInfoPage;
import Pom_Classes.Vtigerloginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase2_createOrganization_Test {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		Fakedata fake=new Fakedata();
		String orgname=fake.orgname();
		int randomNumber = fake.randomNumber();
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
		//driver.manage().window().maximize();
		Webdriver_utility util=new Webdriver_utility(driver);
		util.maximize();
		driver.get(u);
		util.pageloadtimeout();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get(u);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//		driver.findElement(By.name("user_name")).sendKeys(un,Keys.TAB,pwd);
		//		driver.findElement(By.id("submitButton")).click();
		//		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		Vtigerloginpage login=new Vtigerloginpage(driver);
		login.getUsername().sendKeys(un);
		login.getPassword().sendKeys(pwd);
		login.getLoginbutton().click();
		Thread.sleep(3000);
		Homepage homepage=new Homepage(driver);
		homepage.getOrglinkbutton().click();
		CreateOrgPage orgpage=new CreateOrgPage(driver);
		orgpage.getCreateorgplusbtn().click();
		orgpage.getOrgname().sendKeys(orgname+randomNumber);
		//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//		driver.findElement(By.name("accountname")).sendKeys("Testyantra1"+randomNumber);
		driver.findElement(By.xpath("//select[@name='industry']")).click();
		WebElement ele=driver.findElement(By.xpath("//span[@class='genHeaderSmall']"));
		// Select s=new Select(ele);
		// s.selectByValue("Apparel");
		util.DropdownbyValue(ele,"Apparel");
		orgpage.getOrgsave().click();
		//		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		util.refresh();
		homepage.getOrglinkbutton().click();
		OrganizationInfoPage orginfo=new OrganizationInfoPage(driver);
		Thread.sleep(4000);
		orginfo.getSearchbox().sendKeys(orgname+randomNumber);
		orginfo.getOrganizationDD().click();
		WebElement ordDD=driver.findElement(By.name("search_field"));
		util.DropdownbyValue(ordDD,"accountname");
		orginfo.getfinalsearch().click();

		WebElement s1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String compare = s1.getText();
		if(compare.contains(orgname+randomNumber)) 
		{
			System.out.println("organization is added and verified");
		}
		else {
			System.out.println("organization not added and not verified");
		}
		//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//		WebElement ele1=driver.findElement(By.xpath("//a[text()='Sign Out']"));
		homepage.getSignoutimage().click();
		homepage.getSignoutbuttonlink().click();
		// Actions act=new Actions(driver);
		//act.moveToElement(ele1);
		//util.mouseHandle(ele1);


	}

}

