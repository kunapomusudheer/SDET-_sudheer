package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchbox;
	public WebElement getSearchbox() {
		return searchbox;
	}
	@FindBy(name="search_field")
	private WebElement OrganizationDD;
	public WebElement getOrganizationDD() {
		return OrganizationDD;
	}
	@FindBy(name="submit")
	private WebElement finalsearch;
	public WebElement getfinalsearch() {
		return finalsearch;
	}


}
