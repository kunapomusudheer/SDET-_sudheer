package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vtigerloginpage {
	WebDriver driver;
	public Vtigerloginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private  WebElement username;
	public WebElement getUsername() {
		return username;
	}
	@ FindBy(xpath="//input[@name='user_password']")
	private WebElement password;
	public WebElement getPassword() {
		return password;
	}
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	public void logintoapp(String userName,String passWord)
	{
		username.sendKeys(userName);
		password.sendKeys(passWord);
		loginbutton.click();
	}

}
