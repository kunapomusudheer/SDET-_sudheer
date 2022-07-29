package AllTestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Vtiger_generic.BaseClass;
import com.Vtiger_generic.Fakedata;
import com.Vtiger_generic.Webdriver_utility;

import Pom_Classes.CampaignInfoPage;
import Pom_Classes.CreateCampaignPage;
import Pom_Classes.DeleteOrgAnd_Compare;
import Pom_Classes.Homepage;

public class TC_05_create_camp_deleteCamp_Test extends BaseClass {
	@Test(groups= {"Smoke","Regression"})
	public void example() throws Throwable {
		Fakedata fakedata=new Fakedata();
		String campName = fakedata.campName();
		int rNumber = fakedata.randomNumber();
		Webdriver_utility util=new Webdriver_utility(driver);
		Thread.sleep(3000);
		CreateCampaignPage cCamp=new CreateCampaignPage(driver);
		cCamp.getMorelink().click();
		cCamp.getCampbutton().click();
		cCamp.getcamplusbtn().click();
		cCamp.getCampname().sendKeys(campName+ rNumber);
		cCamp.getCampsavename().click();
		Thread.sleep(5000);
		WebElement verify = cCamp.getGetCreatedCampaign();
		String ele1 = verify.getText();
		if(ele1.equals(campName+ rNumber)) {
			System.out.println("new Campaign created");
		}
		else {
			System.out.println("new Campaign not  created");
		}
		Thread.sleep(2000);
		Homepage homepage=new Homepage(driver);
		homepage.getCampaignlink().click();
		CampaignInfoPage campaignInfoPage=new CampaignInfoPage(driver);
		campaignInfoPage.getSearchBoxlink().sendKeys(campName+rNumber);
		campaignInfoPage.getCampDD().click();
		WebElement clist = campaignInfoPage.getCampDD();
		util.DropdownbyValue(clist,"campaignname" );
		campaignInfoPage.getFinalsearch().click();
		WebElement drop = campaignInfoPage.getCheckbox();
		util.mouseHandle(drop);
		Thread.sleep(2000);
		campaignInfoPage.getCheckbox().click();
		campaignInfoPage.getCampDelete().click();
		util.alertAccept();
		DeleteOrgAnd_Compare deleteCB=new DeleteOrgAnd_Compare(driver);
		Thread.sleep(3000);
		WebElement str = deleteCB.getDeleteComparHeaderMsg();
		if(str.isDisplayed()) {
			System.out.println("Campaign deleted successfully");
		}
		else {
			System.out.println("Campaign not deleted successfully");

		}
	}

}


