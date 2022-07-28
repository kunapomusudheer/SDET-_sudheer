package AllTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Vtiger_generic.BaseClass;

import Pom_Classes.Homepage;
import Pom_Classes.OrganizationInfoPage;

public class TC_01_Select_particular_rowTest extends BaseClass{
	
	@Test
	public void main1() throws Throwable  {
		Homepage homepage=new Homepage(driver);
		homepage.getOrglinkbutton().click();
		OrganizationInfoPage organizationInfoPage=new OrganizationInfoPage(driver);
		List<WebElement> tablecount =organizationInfoPage.getAllorgTableData();
		int i = tablecount.size();
		System.out.println(i);
		List<WebElement> alldata = organizationInfoPage.getThirdRowData();
		for (WebElement one:alldata)
		{
			System.out.println(one.getText());
		}
		List<WebElement> alldatas = organizationInfoPage.getThirdRowData();
		for (int j = 3; j <alldatas.size(); j++) {
			String orgname = organizationInfoPage.getOrgNameColumn().getText();
			if(orgname.equals("sudheer")) {
				organizationInfoPage.getAllCheckboxesOforg().click();
			}
		}
		String lastrow = organizationInfoPage.getLastRowOfOrgtable().getText();
		System.out.println(lastrow);
		String lastrow_lastcolumn =organizationInfoPage.getlastRowLastColumnOfOrgtable().getText();
		System.out.println(lastrow_lastcolumn);
		Thread.sleep(3000);
		
	}
} 