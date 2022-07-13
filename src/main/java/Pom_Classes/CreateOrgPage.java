package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	WebDriver driver;
	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgplusbtn;
	public WebElement getCreateorgplusbtn() {
		return createorgplusbtn;
	}
	@FindBy(name="accountname")
	private WebElement orgname;
	public WebElement getOrgname() {
		return orgname;
	}
   @FindBy(xpath="//input[@class='crmbutton small save']")
   private WebElement orgsave;
public WebElement getOrgsave() {
	return orgsave;
}
}
