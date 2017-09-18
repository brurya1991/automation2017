package Tests;

import org.junit.Test;

import Infra.BrowserEnum;
import Infra.BrowserTools;
//import Infra.TestPageEnum;

public class TestWebSites {
	public BrowserTools testChrome = new BrowserTools(BrowserEnum.CHROME);
	
	@Test
	public void testTravelSite()throws Exception{
		testChrome.runTestOnPage(1);
		testChrome.runTestOnPage(2);
		testChrome.closeBrowser();
		testChrome = new BrowserTools(BrowserEnum.CHROME);
		testChrome.runTestOnPage(3);
		testChrome.runTestOnPage(4);
		testChrome.closeBrowser();
		
	}
}
