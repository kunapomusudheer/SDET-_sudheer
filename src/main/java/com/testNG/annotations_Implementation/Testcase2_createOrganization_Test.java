package com.testNG.annotations_Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger_generic.BaseClass;
import com.Vtiger_generic.Fakedata;
import com.Vtiger_generic.Webdriver_utility;
import com.Vtiger_generic.fileproperty;

import Pom_Classes.CreateOrgPage;
import Pom_Classes.DeleteOrgAnd_Compare;
import Pom_Classes.Homepage;
import Pom_Classes.OrganizationInfoPage;
import Pom_Classes.Vtigerloginpage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.Vtiger_generic.Listeners.class)
public class Testcase2_createOrganization_Test extends BaseClass {
	
	@Test
	public void createOrg() throws Throwable {

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



