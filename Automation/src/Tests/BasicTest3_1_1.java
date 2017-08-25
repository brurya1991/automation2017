package Tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Infra.BrowserEnum;

/**
 * 
 * @author קיארה
 *
 */
public class BasicTest3_1_1 {

	public final String PATH_URL = "http://www.google.com";
	public WebDriver driver = null; 

	
	@Test 
	/**
	 * 
	 */
	public void BasicTest () {
		for (int i = 0; i <= BrowserEnum.values().length; i++) {
			testAllBrowser(BrowserEnum.values()[i]);
		}
	}
	
	/**
	 * 
	 * @param testNum int: chrome is 1 num, 
	 */
	private void testAllBrowser (BrowserEnum browser) {
		System.setProperty(browser.getKey(), browser.getPath());
		switch (browser) {
		case CHROME:
			this.driver = new ChromeDriver();
			break;
		case FIREFOX:
			this.driver = new FirefoxDriver();
			break;
		case IE:
			this.driver = new InternetExplorerDriver();
			break;
		default:
			this.driver = new FirefoxDriver();
			break;
		}
		driver.get(PATH_URL);	
	}
}
