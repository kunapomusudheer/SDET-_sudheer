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
	@FindBy(xpath="//tr[@class='lvtColData']")
	private WebElement selectProject;
	public WebElement getSelectProject() {
		return selectProject;
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
	@FindBy(xpath="//td[@class='tabSelected']")
	private WebElement contactlinkBTN;
	public WebElement getContactlinkBTN() {
		return contactlinkBTN;
	}
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchBox;
	public WebElement getSearchBox() {
		return searchBox;
	}
	@FindBy(xpath="//select[@id='bas_searchfield']")
	private WebElement contactDD;
	public WebElement getContactDD() {
		return contactDD;
	}
	@FindBy(xpath="//input[@name='submit']")
	private WebElement finalSearch;
	public WebElement getFinalSearch() {
		return finalSearch;
	}
	@FindBy(xpath="//input[@name='selected_id']")
	private WebElement Checkbox;
	public WebElement getCheckbox() {
		return Checkbox;
	}
	@FindBy(xpath="//input[@class='crmbutton small delete'][1]")
	private WebElement DeleteContact;
	public WebElement getDeleteContact() {
		return DeleteContact;
	}
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement deleteHeadmsg;
	public WebElement getDeleteHeadmsg() {
		return deleteHeadmsg;
	}
	
}
