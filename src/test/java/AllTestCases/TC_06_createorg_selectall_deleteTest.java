package AllTestCases;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.Vtiger_generic.BaseClass;
import com.Vtiger_generic.Fakedata;
import com.Vtiger_generic.Webdriver_utility;
import Pom_Classes.CreateOrgPage;
import Pom_Classes.DeleteOrgAnd_Compare;
import Pom_Classes.Homepage;
import Pom_Classes.OrganizationInfoPage;

public class TC_06_createorg_selectall_deleteTest extends BaseClass{
	@Test(groups= {"Smoke","Regression"})
	public void exampl() throws Throwable {
		Fakedata fakedata=new Fakedata();
		String orgname = fakedata.orgname();
		int rnumber = fakedata.randomNumber();
		String OrganizationName = (orgname+rnumber);
		Webdriver_utility util=new Webdriver_utility(driver);
		Homepage homepage=new Homepage(driver);
		homepage.getOrglinkbutton().click();
		CreateOrgPage orgpage=new CreateOrgPage(driver);
		orgpage.getCreateorgplusbtn().click();
		orgpage.getOrgname().sendKeys(OrganizationName);
		OrganizationInfoPage inform=new OrganizationInfoPage(driver);
		inform.getindustryDD().click();
		WebElement dropdown=inform.getindustryDD();
		inform.getTypeDD().click();
		WebElement dropdown1=inform.getTypeDD();
		Thread.sleep(4000);
		inform.getRatingDD().click();
		WebElement dropdown2=inform.getRatingDD();
		util.DropdownbyValue(dropdown, "Apparel");
		util.DropdownbyValue(dropdown1, "Analyst");
		Thread.sleep(3000);
		util.DropdownbyValue(dropdown2, "Acquired");
		orgpage.getOrgsave().click(); 
		Thread.sleep(3000);
		WebElement ele = orgpage.getCreatedOrgMsg();
		String ele1 = ele.getText();
		if(ele1.equals(OrganizationName)) {
			System.out.println("test pass");
		}
		else {
			System.out.println("test fail");
		}
		util.refresh();
		homepage.getOrglinkbutton().click();
		inform.getSearchbox().sendKeys(OrganizationName);
		inform.getOrganizationDD().click();
		WebElement ordDD=inform.getOrganizationDD();
		util.DropdownbyValue(ordDD,"accountname");
		inform.getfinalsearch().click();
		Thread.sleep(3000);
		DeleteOrgAnd_Compare deleteCB=new DeleteOrgAnd_Compare(driver);
		WebElement checkbox = deleteCB.getCheckbox();
		util.mouseHandle(checkbox);
		Thread.sleep(3000);
		deleteCB.getCheckbox();
		deleteCB.getDeleteOrg().click();
		util.alertAccept();
		Thread.sleep(5000);
		//WebElement str = driver.findElement(By.xpath("//span[@class='genHeaderSmall']"));
		WebElement str = deleteCB.getDeleteComparHeaderMsg();
		if(str.isDisplayed()) {
			System.out.println("test case deleted successfully");
		}
		else {
			System.out.println("test case not deleted successfully");
		}
		

	}
}








