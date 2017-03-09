package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleTestAnnotation {
	WebDriver driver;
	@BeforeTest
	public void openBrowser(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	@Test(priority=0)
	public void verifyTitle(){
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test(priority=1)
	public void verifyText(){
	String expectedText = "See photos and updates";
	String actualText = driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div[1]/div[1]/div[2]/span[1]")).getText();
	Assert.assertEquals(actualText, expectedText);
	}
	@Test(enabled=false)
	public void verifyText1(){
		String expectedText = "Sign Up";
		String actualText = driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div[2]/h2")).getText();
		Assert.assertEquals(actualText, expectedText);
	}
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
	
}
