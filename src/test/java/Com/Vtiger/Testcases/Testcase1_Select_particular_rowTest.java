package Com.Vtiger.Testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger_generic.Webdriver_utility;
import com.Vtiger_generic.fileproperty;

import Pom_Classes.Vtigerloginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase1_Select_particular_rowTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
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
		util.maximize();
		driver.get(u);
//		driver.findElement(By.name("user_name")).sendKeys(un,Keys.TAB,pwd);
//		driver.findElement(By.id("submitButton")).click();
		Vtigerloginpage login=new Vtigerloginpage(driver);
		login.getUsername();
		login.getPassword();
		login.getLoginbutton();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		List<WebElement> tablecount = driver.findElements(By.xpath("//table[@class='lvt small']//tr"));
		int i = tablecount.size();
		System.out.println(i);
		//List<WebElement> tablecount1 = driver.findElements(By.xpath("//table[@class='lvt small']//tr//td"));
		//  int j = tablecount1.size();
		//  System.out.println(j);

		//   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//   driver.findElement(By.name("accountname")).sendKeys("project"+data);
		//   driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		//   Thread.sleep(5000);
		//  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//  WebElement ele=driver.findElement(By.xpath("//a[text()='Sign Out']"));
		//   Actions act=new Actions(driver);
		//  act.moveToElement(ele);
		//   ele.click();
		List<WebElement> alldata = driver.findElements(By.xpath("//table[@class='lvt small']//tr/td[3]"));

		for (WebElement one:alldata)
		{
			System.out.println(one.getText());


		}

		//  List<WebElement> alldatas = driver.findElements(By.xpath("//table[@class='lvt small']//tr/td[1]"));
		//  int y = alldatas.size();
		//  for (WebElement one:alldatas)
		//  {
		//	  one.click();
		//	 
		//	
		//}
		List<WebElement> alldatas = driver.findElements(By.xpath("//table[@class='lvt small']//tr/td[3]"));
		for (int j = 3; j <alldatas.size(); j++) {
			String orgname=	driver.findElement(By.xpath("//table[@class='lvt small']//tr["+j+"]/td[3]")).getText();
			if(orgname.equals("sudheer")) {
				driver.findElement(By.xpath("//table[@class='lvt small']//tr["+j+"]/td[1]")).click();
			}



		}
		String lastrow = driver.findElement(By.xpath("//table[@class='lvt small']//tr[last()]")).getText();
		System.out.println(lastrow);
		String lastrow_lastcolumn = driver.findElement(By.xpath("//table[@class='lvt small']//tr[last()]//td[last()]")).getText();
		System.out.println(lastrow_lastcolumn);

	}
} 