package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyTitleGrid {
WebDriver driver;
	
	@BeforeTest
	public void openBrowser() throws MalformedURLException{
		String hubUrl = "192.168.1.199"; // need to fix the ip adress.
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setPlatform(Platform.WIN10);
		cap.setBrowserName("firefox");
		driver = new RemoteWebDriver (new URL(hubUrl), cap);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}
	@Test
	public void titleVerification(){
		String expectedTitle = ("Facebook - Log In or Sign Up");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}

}
