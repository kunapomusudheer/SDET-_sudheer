package Com.Vtiger.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger_generic.Fakedata;
import com.Vtiger_generic.Webdriver_utility;
import com.Vtiger_generic.fileproperty;

import Pom_Classes.ContactInformation;
import Pom_Classes.Homepage;
import Pom_Classes.Vtigerloginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase3_create_Compare_org_Test {
	public static void main(String[] args) throws Throwable {
		Fakedata fakedata=new Fakedata();
		String firstname = fakedata.firstName();
		String lastname = fakedata.lastName();
		WebDriver driver=null;
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
		Webdriver_utility util=new Webdriver_utility(driver);
		util.maximize();
		driver.get(u);
		util.pageloadtimeout();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//		driver.findElement(By.name("user_name")).sendKeys(un,Keys.TAB,pwd);
		//		driver.findElement(By.id("submitButton")).click();
		Vtigerloginpage login=new Vtigerloginpage(driver);
		login.getUsername().sendKeys(un);
		login.getPassword().sendKeys(pwd);
		login.getLoginbutton().click();
		Thread.sleep(3000);
		Homepage homepage=new Homepage(driver);
		homepage.getClickonContact().click();
		homepage.getClickonContact().click();
		homepage.getContactplusbutton().click();
		//		driver.findElement(By.xpath("//td[@class='tabUnSelected'][4]")).click();
		//		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		//	driver.findElement(By.xpath("//select[@name='salutationtype']")).click();
		ContactInformation contactinf=new ContactInformation(driver);
		contactinf.getFirstname();


		WebElement list = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		//Select s=new Select(list);
		//s.selectByValue("Mr.");
		util.DropdownbyValue(list,"Mr.");
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		String mainid = driver.getWindowHandle();
		//		Set<String> Allid = driver.getWindowHandles();
		//		for(String i:Allid) {
		//			if(!mainid.equals(i))  {
		//				driver.switchTo().window(i);
		//			}
		//		}
		util.switchchildWindow();
		Thread.sleep(2000);
		WebElement org=driver.findElement(By.xpath("//input[@name='search_text']"));
		org.sendKeys("project36");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='project36']")).click();
		driver.switchTo().window(mainid);
		Thread.sleep(3000);
		//util.switchtoMainWindow();
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		WebElement s1 = driver.findElement(By.xpath("//span[@class='genHeaderSmall']"));
		String compare = s1.getText();

		if(compare.contains(firstname)) {
			System.out.println("organization is added and verified");
		}
		//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//		WebElement ele1=driver.findElement(By.xpath("//a[text()='Sign Out']"));
		//Actions act=new Actions(driver);
		//act.moveToElement(ele1);
		//ele1.click();
		//util.mouseHandle(ele1);
		homepage.getSignoutimage().click();
		homepage.getSignoutbuttonlink().click();
	}



}

