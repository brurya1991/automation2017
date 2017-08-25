package Tests;



import org.testng.annotations.Test;

import Infra.BrowserEnum;
import Infra.BrowserTools;

/**
 * 
 * @author Brurya
 *
 */
public class TestWebsites {
	
	public BrowserTools testChrome = new BrowserTools(BrowserEnum.CHROME);

	@Test
	public void testTravelSite() {
		testChrome.runTestOnPage(1);
		testChrome.runTestOnPage(2);
		testChrome.closeBrowser();
	}
}
