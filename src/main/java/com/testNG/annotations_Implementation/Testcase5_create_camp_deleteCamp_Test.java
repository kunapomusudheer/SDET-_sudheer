package com.testNG.annotations_Implementation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Vtiger_generic.BaseClass;
import com.Vtiger_generic.Fakedata;
import com.Vtiger_generic.Webdriver_utility;
import com.Vtiger_generic.fileproperty;

import Pom_Classes.CampaignInfoPage;
import Pom_Classes.CreateCampaignPage;
import Pom_Classes.Homepage;
import Pom_Classes.Vtigerloginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase5_create_camp_deleteCamp_Test extends BaseClass {
	@Test
	public void example() throws Throwable {
		Fakedata fakedata=new Fakedata();
		String campName = fakedata.campName();
		int rNumber = fakedata.randomNumber();
		fileproperty prop=new fileproperty(driver);
		Webdriver_utility util=new Webdriver_utility(driver);
		Thread.sleep(3000);
		CreateCampaignPage cCamp=new CreateCampaignPage(driver);
		cCamp.getMorelink().click();
		cCamp.getCampbutton().click();
		cCamp.getcamplusbtn().click();
		cCamp.getCampname().sendKeys(campName+ rNumber);
		cCamp.getCampsavename().click();
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
//		boolean str = driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).isDisplayed();
//		if(str==true) {
//			System.out.println("test case deleted successfully");
//		}
	}
}


