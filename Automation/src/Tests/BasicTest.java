package Tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasicTest {
 	
	@Test 	
	public void testMain ()  {
		BasicTest3();
		BasicTest1();
		BasicTest2();
	}
	
private void BasicTest1 ()  {
	WebDriver driver; 
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://www.google.com");	
}
	
private void BasicTest2 ()  {
	WebDriver driver; 
	System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
	driver = new InternetExplorerDriver();
	driver.get("http://www.google.com");	
}

 	
private void BasicTest3 ()  {
	WebDriver driver; 
	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("http://www.google.com");	
}
}
