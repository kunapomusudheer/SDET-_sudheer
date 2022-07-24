package com.testNG.annotations_Implementation;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.Vtiger_generic.BaseClass;
import com.Vtiger_generic.Fakedata;
import com.Vtiger_generic.Webdriver_utility;
import Pom_Classes.CreateOrgPage;
import Pom_Classes.DeleteOrgAnd_Compare;
import Pom_Classes.Homepage;
import Pom_Classes.OrganizationInfoPage;

public class Testcase4_create_org_delete_Test extends BaseClass{
	@Test
	public void run() throws Throwable {
		Fakedata fake=new Fakedata();
		String orgname=fake.orgname();
		int randomNumber = fake.randomNumber();
		String organizationname = (orgname+randomNumber);
		Webdriver_utility util=new Webdriver_utility(driver);
		Thread.sleep(3000);
		Homepage homepage=new Homepage(driver);
		homepage.getOrglinkbutton().click();
		CreateOrgPage orgpage=new CreateOrgPage(driver);
		orgpage.getCreateorgplusbtn().click();
		orgpage.getOrgname().sendKeys(organizationname);
		OrganizationInfoPage inform=new OrganizationInfoPage(driver);
		inform.getindustryDD().click();
		WebElement ele=inform.getindustryDD();
		util.DropdownbyValue(ele,"Apparel");
		orgpage.getOrgsave().click();
		util.refresh();
		homepage.getOrglinkbutton().click();
		inform.getSearchbox().sendKeys(organizationname);
		inform.getOrganizationDD().click();
		WebElement ordDD=inform.getOrganizationDD();
		util.DropdownbyValue(ordDD,"accountname");
		inform.getfinalsearch().click();
		Thread.sleep(3000);
		DeleteOrgAnd_Compare deleteCB=new DeleteOrgAnd_Compare(driver);
		WebElement checkbox = deleteCB.getCheckbox();
		util.mouseHandle(checkbox);
		Thread.sleep(3000);
		deleteCB.getCheckbox().click();
		deleteCB.getDeleteOrg().click();
		util.alertAccept();
//		boolean compare = deleteCB.getDeleteComparHeaderMsg().isDisplayed();
//		if(compare==true) {
//			System.out.println("test case deleted successfully");
//		}
//		else {
//			System.out.println("organization is not deleted");
//		}
	}

}
