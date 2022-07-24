package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
    WebDriver driver;
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@style='padding-left:5px']")
	private WebElement Morelink;
	public WebElement getMorelink() {
		return Morelink;
	}
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campbutton;
	public WebElement getCampbutton() {
		return campbutton;
	}
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement camplusbtn;
	public WebElement getcamplusbtn() {
		return camplusbtn;
	}
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campname;
	public WebElement getCampname() {
		return campname;
	}
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement campsavename;
	public WebElement getCampsavename() {
		return campsavename;
	}
	
}
