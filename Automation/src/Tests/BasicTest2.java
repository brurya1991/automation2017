package Tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * 
 * @author קיארה
 *
 */
public class BasicTest2 {

	public final String WEBDRIVER = "webdriver";
	public final String DRIVER = "driver";
	public final String CHROME_DRIVER = WEBDRIVER + ".chrome." + DRIVER; 
	public final String IEDRIVER = WEBDRIVER + ".ie." + DRIVER; 
	public final String FIREFOXDRIVER = WEBDRIVER + ".gecko." + DRIVER; 
	public final String CHROM_DRIVER_PATH = "C:\\chromedriver.exe";
	public final String IE_DRIVER_PATH = "C:\\IEDriverServer.exe";
	public final String FIREFOX_DRIVER_PATH = "C:\\geckodriver.exe";
	public final int CHROME_TEST = 1;
	public final int IE_TEST = 2;
	public final int FIREFOX_TEST = 3;
	public final String PATH_URL = "http://www.google.com";
	public WebDriver driver = null; 

	
	@Test 
	/**
	 * 
	 */
	public void BasicTest () {
		for (int i = 1; i < 5; i++) {
			testAllBrowser(i);
		}
/*		testAllBrowser(1);
		testAllBrowser(2);
		testAllBrowser(3);*/
	}
	
	/**
	 * 
	 * @param testNum int: chrome is 1 num
	 */
	private void testAllBrowser (int testNum) {		
		if (testNum == 1) {
			driver = BasicTestChrome();		
		} else if (testNum == 2) {
			driver = BasicTestIE();
		} else {
			driver = BasicTestFireFox();
		}
		driver.get(PATH_URL);	
	}

	/**
	 * 
	 * @return
	 */
public WebDriver BasicTestChrome () {
	//WebDriver driver; 
	System.setProperty(CHROME_DRIVER, CHROM_DRIVER_PATH);
	driver = new ChromeDriver();
	return driver;
}

public WebDriver BasicTestIE () {
	System.setProperty(IEDRIVER, IE_DRIVER_PATH);
    driver = new InternetExplorerDriver();
	return driver;
}

/**
 * 
 * @return
 */
public WebDriver BasicTestFireFox () {
	System.setProperty(FIREFOXDRIVER,FIREFOX_DRIVER_PATH);
	return new FirefoxDriver();
}
}
