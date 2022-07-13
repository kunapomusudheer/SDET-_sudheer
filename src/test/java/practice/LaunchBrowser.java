package practice;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
		WebDriver driver=WebDriverManager.chromedriver().create();
		driver.get("https://www.flipkart.com/");

	}

}
