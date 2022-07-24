package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	WebDriver driver;
	public CampaignInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchBoxlink;
	public WebElement getSearchBoxlink() {
		return searchBoxlink;
	}
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement campDD;
	public WebElement getCampDD() {
		return campDD;
	}
	@FindBy(xpath="//input[@name='submit']")
	private WebElement finalsearch;
	public WebElement getFinalsearch() {
		return finalsearch;
	}
	@FindBy(xpath="//input[@name='selected_id']")
	private WebElement checkbox;
	public WebElement getCheckbox() {
		return checkbox;
	}
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement campDelete;
	public WebElement getCampDelete() {
		return campDelete;
	}

}
