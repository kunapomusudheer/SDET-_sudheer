package AllTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Vtiger_generic.BaseClass;
import com.Vtiger_generic.Fakedata;
import com.Vtiger_generic.Webdriver_utility;

import Pom_Classes.CreateOrgPage;
import Pom_Classes.Homepage;
import Pom_Classes.OrganizationInfoPage;

public class TC_02_createOrganization_Test extends BaseClass {

	@Test(groups="Smoke")
	public void createOrg() throws Throwable {
		Fakedata fake=new Fakedata();
		String orgname=fake.orgname();
		//int randomNumber = fake.randomNumber();
		int randomNumber = Fakedata.randomNumber();

		String organizationname = (orgname+randomNumber);
		Webdriver_utility util=new Webdriver_utility(driver);
		Thread.sleep(3000);
		Homepage homepage=new Homepage(driver);
		homepage.getOrglinkbutton().click();
		CreateOrgPage orgpage=new CreateOrgPage(driver);
		orgpage.getCreateorgplusbtn().click();
		orgpage.getOrgname().sendKeys(organizationname );
		OrganizationInfoPage inform=new OrganizationInfoPage(driver);
		inform.getindustryDD().click();
		WebElement ele=inform.getindustryDD();
		util.DropdownbyValue(ele,"Apparel");
		orgpage.getOrgsave().click();
		util.refresh();
		homepage.getOrglinkbutton().click();
		OrganizationInfoPage orginfo=new OrganizationInfoPage(driver);
		Thread.sleep(4000);
		orginfo.getSearchbox().sendKeys(organizationname);
		orginfo.getOrganizationDD().click();
		WebElement ordDD=driver.findElement(By.name("search_field"));
		util.DropdownbyValue(ordDD,"accountname");
		Thread.sleep(5000);
		orginfo.getfinalsearch().click();

	}
}



