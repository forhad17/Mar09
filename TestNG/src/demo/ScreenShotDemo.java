package demo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenShotDemo {
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser(){
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
	}
	@Test
	public void bookTicket() throws IOException{
	try{	
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		WebElement passengers = driver.findElement(By.name("passCount"));
		Select drpdownpass = new Select(passengers);
		drpdownpass.selectByIndex(1);
		Select drpdownFrom = new Select(driver.findElement(By.name("fromPort")));
		drpdownFrom.selectByIndex(2);
		Select drpMonth= new Select(driver.findElement(By.name("fromMonth")));
		drpMonth.selectByVisibleText("February");
		Select drpDate= new Select(driver.findElement(By.name("fromDay")));
		drpDate.selectByValue("26");
		Select drpArriving = new Select(driver.findElement(By.name("toMonth")));
		drpArriving.selectByValue("6");
		driver.findElement(By.cssSelector("input[value='Business']"));
		driver.findElement(By.name("findFlights")).click();
		driver.findElement(By.xpath("(//input[contains(@value, 'Blue')])[2]")).click();
		driver.findElement(By.xpath("(//input[contains(@value, 'Pangea')])[2]")).click();
		driver.findElement(By.name("reserveFlights")).click();
		driver.findElement(By.name("passFirst0")).sendKeys("Forhad");
		driver.findElement(By.name("passLas0")).sendKeys("Ali");
		driver.findElement(By.name("creditnumber")).sendKeys("43424534");
		driver.findElement(By.name("buyFlights")).click();
	}
	catch (Exception e){
		getScreenshot();
	}
	}
	private void getScreenshot() throws IOException {
		File ss= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File ("C:\\JAVA PRACTICE\\SeleniumSS.jpg "));
	}
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
}
