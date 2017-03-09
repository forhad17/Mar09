package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Internationalization {
WebDriver driver;

@BeforeTest
public void openBrowser(){
	FirefoxProfile profile= new FirefoxProfile();
	profile.setPreference("intl.accept_languages", "fr");
	driver = new FirefoxDriver(profile);
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
}
	@Test
	public void testApp(){
	driver.findElement(By.id("email")).sendKeys("user@gmail.com");
	}
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
}



