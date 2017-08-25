
package Yael;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitDriver {

	public WebDriver driver;
	/**
	 * this function build the driver according to the browser type param
	 * @param browser
	 */
	public InitDriver(BrowsersEnum browser) {
		System.out.println("build "+browser+" driver for init");
		switch (browser){
		case CHROM:
			this.driver = returnChromDriver();
			break;
		case FF:
			this.driver = returnFFDriver();
			break;
		case IE:
			this.driver =returnIEDriver();
			break;}


}
	
	
	private WebDriver returnFFDriver() {
		System.setProperty(BrowsersEnum.FF.getKey(),BrowsersEnum.FF.getPathValue());
		System.out.println("Start to init FF driver");
		return new FirefoxDriver();
}
	
	private  WebDriver returnChromDriver() {
		System.setProperty(BrowsersEnum.CHROM.getKey(),BrowsersEnum.CHROM.getPathValue());
		System.out.println("Start to init chrom driver");
		return new ChromeDriver();	
		
	}
	private  WebDriver returnIEDriver() {
		System.setProperty(BrowsersEnum.IE.getKey(),BrowsersEnum.IE.getPathValue());
		System.out.println("Start to init IE driver");
		return new InternetExplorerDriver();
}
	
	public void closeTest()throws Exception {
		Thread.sleep(5000);
		System.out.println("close the test");
		driver.close();
	}
	
}


