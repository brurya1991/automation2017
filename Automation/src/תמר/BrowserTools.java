package Infra;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTools {
	public WebDriver driver;
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public BrowserEnum getBrowserType(){
		return browserType;
	}
	
	private BrowserEnum browserType;
	
	public BrowserTools(BrowserEnum browserType){
		this.browserType = browserType;
		System.setProperty(browserType.getKey(), browserType.getPath());
		getWebDriverByType();
		
	}
	
	private void getWebDriverByType(){
		switch (browserType){
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
			this.driver = null;
		}
	}
	
	public void closeBrowser(){
		System.out.println("Close");
		GeneralTools.sleep();
		getDriver().close();
	}
	
	public void runTestOnPage(int testPage)throws Exception{
		//System.out.print(TestPageEnum.values()[testPage]);
		//public class a;
		switch (testPage){
		case 1:
			(new AdminPage(getDriver())).testSite();
			break;
		case 2:
			(new ContactUsPage(getDriver())).testSite();
			break;
		case 3:
			(new AdminPageNeg(getDriver())).testSite();
			break;
		case 4:
			(new ContactUsPageNeg(getDriver())).testSite();
			break;
		}
	}
}
