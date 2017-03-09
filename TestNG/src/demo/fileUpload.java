package demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class fileUpload {

	public static void main(String[] args) throws IOException {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://the-internet.herokuapp.com/upload");
	driver.findElement(By.id("file-upload")).click();
	Runtime.getRuntime().exec("FileUpload.exe");
	driver.findElement(By.id("file-submit")).click();
	
	}

}
