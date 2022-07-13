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

}
