package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Organizations'][1]")
	WebElement orglinkbutton;
	public WebElement getOrglinkbutton() {
		return orglinkbutton;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimage;
	public WebElement getSignoutimage() {
		return signoutimage;
	}
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbuttonlink;
	public WebElement getSignoutbuttonlink() {
		return signoutbuttonlink;
	}
	@FindBy(xpath="//a[text()='Contacts']")//td[@class='tabSelected']
	private WebElement clickonContact;
	public WebElement getClickonContact() {
		return clickonContact;
	}
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement contactplusbutton;
	public WebElement getContactplusbutton() {
		return contactplusbutton;
	}
	@FindBy(xpath="//td[@class='tabSelected']")
	private WebElement Campaignlink;
	public WebElement getCampaignlink() {
		return Campaignlink;
	}
	
}

