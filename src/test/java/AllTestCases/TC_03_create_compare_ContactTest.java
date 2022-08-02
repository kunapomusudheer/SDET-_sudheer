package AllTestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Vtiger_generic.BaseClass;
import com.Vtiger_generic.Fakedata;
import com.Vtiger_generic.Webdriver_utility;

import Pom_Classes.ContactInformation;
import Pom_Classes.Homepage;

public class TC_03_create_compare_ContactTest extends BaseClass {
	@Test(groups="Regression")
	public void abcd() throws Throwable {

		Fakedata fakedata=new Fakedata();
		String firstname = fakedata.firstName();
		String lastname = fakedata.lastName();
		Webdriver_utility util=new Webdriver_utility(driver);
		util.pageloadtimeout();
		Thread.sleep(3000);
		Homepage homepage=new Homepage(driver);
		homepage.getClickonContact().click();
		homepage.getContactplusbutton().click();
		ContactInformation contactinf=new ContactInformation(driver);
		contactinf.getFirstname();
		WebElement list = contactinf.getFirstname();
		util.DropdownbyValue(list,"Mr.");
		contactinf.getfname().sendKeys(firstname);
		contactinf.getlname().sendKeys(lastname);
		contactinf.getcontactplusbtn().click();
		String mainid = driver.getWindowHandle();
		util.switchchildWindow();
		Thread.sleep(2000);
		contactinf.getsearchOrginNewwindow().sendKeys("project36");
		contactinf.getsearchNewwindowbtn().click();
		Thread.sleep(2000);
		driver.switchTo().window(mainid);
		//util.switchtoMainWindow();
		Thread.sleep(3000);
		contactinf.getcontactsavebtn().click();
		WebElement s1=contactinf.getcompareCreatedContact();
		String compare = s1.getText();
		if(compare.contains(firstname)) {
			System.out.println("organization is added and verified");
		}
		else {
			System.out.println("organization is not added and verified");

		}
	}

}

