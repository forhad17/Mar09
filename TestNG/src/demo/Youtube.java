package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Youtube {

	public static void main(String[] args) throws FindFailed {
		Screen s = new Screen();
		Pattern pause = new Pattern("C:\\PRACTICE\\TestNG\\SikuliImage\\pause.PNG");
		Pattern play = new Pattern("C:\\PRACTICE\\TestNG\\SikuliImage\\play.PNG");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/watch?v=82p-DYgGFjI");
		
		s.click(pause);
		s.click(play);
		

	}

}
