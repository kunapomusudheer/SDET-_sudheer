package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {
	WebDriver driver;
	public ContactInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="salutationtype")
	private WebElement firstname;
	public WebElement getFirstname() {
		return firstname;
	}
	@FindBy(name="firstname")
	private WebElement fname;
	public WebElement getfname() {
		return fname;
	}
	@FindBy(name="lastname")
	private WebElement lname;
	public WebElement getlname() {
		return lname;
	}
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement contactplusbtn;
	public WebElement getcontactplusbtn() {
		return contactplusbtn;
	}
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchOrginNewwindow;
	public WebElement getsearchOrginNewwindow() {
		return searchOrginNewwindow;
	}
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchNewwindowbtn;
	public WebElement getsearchNewwindowbtn() {
		return searchNewwindowbtn;
	}
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement contactsavebtn;
	public WebElement getcontactsavebtn() {
		return contactsavebtn;
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement compareCreatedContact;
	public WebElement getcompareCreatedContact() {
		return compareCreatedContact;
	}
}
