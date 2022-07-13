package practice;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Firefox {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		LoggingPreferences pref=new LoggingPreferences();
		pref.enable(LogType.PERFORMANCE, Level.ALL);
		ChromeOptions opt=new ChromeOptions();
		

	}

}
