package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteOrgAnd_Compare {
	WebDriver driver;
	public DeleteOrgAnd_Compare(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='selected_id']")
	private WebElement Checkbox;
	public WebElement getCheckbox() {
		return Checkbox;
	}
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement DeleteOrg;
	public WebElement getDeleteOrg() {
		return DeleteOrg;
	}
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement DeleteComparHeaderMsg;
	public WebElement getDeleteComparHeaderMsg() {
		return DeleteComparHeaderMsg;
	}
	
	
	}

