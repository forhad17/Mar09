package demo;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CBT {
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	
	//Added a comment message in this line
	public void openBrowser(String browser){
		if (browser.equals("Firefox")){
		driver = new FirefoxDriver();	
		}
		else if (browser.equals("Chrome")){
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if (browser.equals("Internet Explorer")){
			System.setProperty("webDriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if (browser.equals("Edge")){
			System.setProperty("WebDriver.edge.driver", "MicrosoftDriver.exe");
			driver = new EdgeDriver();
		}
		
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
