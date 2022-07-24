package Com.Vtiger.Testcases;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.Vtiger_generic.Fakedata;
import com.Vtiger_generic.Webdriver_utility;
import com.Vtiger_generic.fileproperty;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase6_createorg_selectall_deleteTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		Fakedata fakedata=new Fakedata();
		String orgname = fakedata.orgname();
		int rnumber = fakedata.randomNumber();
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
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		util.pageloadtimeout();
		driver.findElement(By.name("user_name")).sendKeys(un,Keys.TAB,pwd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname+rnumber);
		WebElement dropdown=driver.findElement(By.xpath("//select[@name='industry']"));
		WebElement dropdown1=driver.findElement(By.xpath("//select[@name='accounttype']"));
		Thread.sleep(4000);
		WebElement dropdown2=driver.findElement(By.xpath("//select[@name='rating']"));
		//Select dd=new Select(dropdown);
		//dd.selectByValue("Apparel");
		util.DropdownbyValue(dropdown, "Apparel");
		//Select dd1=new Select(dropdown1);
		//dd1.selectByValue("Analyst");
		util.DropdownbyValue(dropdown1, "Analyst");
		//Select dd2=new Select(dropdown2);
		//dd2.selectByValue("Acquired");
		Thread.sleep(3000);
		util.DropdownbyValue(dropdown2, "Acquired");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String ele=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		Thread.sleep(3000);
		if(ele.equals(orgname+rnumber)) {
			System.out.println("test pass");
		}
		else {
			System.out.println("test fail");
		}
		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname+rnumber);
		WebElement selecting=driver.findElement(By.xpath("//select[@id='bas_searchfield']"));
		util.DropdownbyValue(selecting, "accountname");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		Thread.sleep(5000);
		WebElement ele1=driver.findElement(By.xpath("//input[@name='selected_id']"));
		util.mouseHandle(ele1);
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		util.alertAccept();
		boolean str = driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).isDisplayed();
		if(str==true) {
			System.out.println("test case deleted successfully");
		}
		List<WebElement> element = driver.findElements(By.xpath("//table[@class='lvt small']//tr/td"));
		for (WebElement i : element) {
			System.out.println(i.getText());
		}
	}
}








