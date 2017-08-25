package Infra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTools {
	
	public WebDriver driver;
	public IWebsiteTest test;
	
	public WebDriver getDriver() {
		return driver;
	}

	public BrowserEnum getBrowserType() {
		return browserType;
	}

	private BrowserEnum browserType;
	
	public BrowserTools(BrowserEnum browserType) {
		this.browserType = browserType;
		System.setProperty(browserType.getKey(), browserType.getPath());
		getWebDriverByType();
	}
	
	private void getWebDriverByType() {
		switch (browserType) {
		case CHROME:
			this.driver = new ChromeDriver();
			break;
		case IE:
			this.driver = new InternetExplorerDriver();
			break;
		case FIREFOX:
			this.driver = new FirefoxDriver();
			break;
		default:
			this.driver = null;
		}
	}
	
	public void closeBrowser() {
		System.out.println("Close");
		GeneralTools.sleep();
		getDriver().close();
	}
	
	public void runTestOnPage(int testPage)  {
		if (testPage == 2) {
			test = new AdminPage(getDriver());
		} else {
			test = new ContactUsPage(driver);
		}
		test.testSite();
	}
	
	public void runTests() throws Exception {
		test.testSite();
		test.testNeg();
	}
}
