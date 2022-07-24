package com.testNG.annotations_Implementation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Vtiger_generic.BaseClass;
import com.Vtiger_generic.Webdriver_utility;
import com.Vtiger_generic.fileproperty;

import Pom_Classes.CreateOrgPage;
import Pom_Classes.Homepage;
import Pom_Classes.OrganizationInfoPage;
import Pom_Classes.Vtigerloginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase1_Select_particular_rowTest extends BaseClass{
	@Test
	public void main1() throws Throwable  {

		Webdriver_utility util=new Webdriver_utility(driver);
		Vtigerloginpage login=new Vtigerloginpage(driver);
		Homepage homepage=new Homepage(driver);
		homepage.getOrglinkbutton().click();
		OrganizationInfoPage organizationInfoPage=new OrganizationInfoPage(driver);
		List<WebElement> tablecount =organizationInfoPage.getAllorgTableData();
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
		List<WebElement> alldata = organizationInfoPage.getThirdRowData();

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
		List<WebElement> alldatas = organizationInfoPage.getThirdRowData();

		for (int j = 3; j <alldatas.size(); j++) {
			//String orgname=	driver.findElement(By.xpath("//table[@class='lvt small']//tr["+j+"]/td[3]")).getText();
			String orgname = organizationInfoPage.getOrgNameColumn().getText();

			if(orgname.equals("sudheer")) {
				organizationInfoPage.getAllCheckboxesOforg().click();
			}



		}
		//String lastrow = driver.findElement(By.xpath("//table[@class='lvt small']//tr[last()]")).getText();
		String lastrow = organizationInfoPage.getLastRowOfOrgtable().getText();
		System.out.println(lastrow);
		//String lastrow_lastcolumn = driver.findElement(By.xpath("//table[@class='lvt small']//tr[last()]//td[last()]")).getText();
		String lastrow_lastcolumn =organizationInfoPage.getlastRowLastColumnOfOrgtable().getText();
		System.out.println(lastrow_lastcolumn);

	}
} 