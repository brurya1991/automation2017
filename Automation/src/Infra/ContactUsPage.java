package Infra;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ContactUsPage implements IWebsiteTest{

	public WebDriver driver;
	private String urlContactUsUrl = "http://www.phptravels.net";
	private String contactUsXpath = "/html/body/nav[1]/div/div/div/ul/li[7]/a";
	private String contactUsEmailXpath = "/html/body/div[3]/div/div/div/form/div[1]/div[2]/input[2]";
	private String contactUsNameXpath = "/html/body/div[3]/div/div/div/form/div[1]/div[2]/input[1]";
	
	private String[] contactUsXpathList = {"/html/body/nav[1]/div/div/div/ul/li[7]/a", "/html/body/div[3]/div/div/div/form/div[1]/div[2]/input[2]", "/html/body/div[3]/div/div/div/form/div[1]/div[2]/input[1]"};
	private ArrayList<String[]> contactUsArray = new ArrayList<String[]>();
	
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;		
		contactUsArray.add(contactUsXpathList);
	}
	
	private void tetsContactName(String name) {
		WebElement elementName = ((ChromeDriver) driver).findElementByXPath(contactUsNameXpath);
		elementName.sendKeys(name);
	}
	
	private void testContactEmail(String email) {
		driver.findElement(By.xpath(contactUsEmailXpath));
		WebElement elementEmail = driver.findElement(By.xpath(contactUsEmailXpath));
		elementEmail.sendKeys(email);
	}

	@Override
	public void testSite() {
		driver.get(urlContactUsUrl);
		GeneralTools.sleep();
		GeneralTools.testCurrentPageTilte(driver.getTitle(), "PHPTRAVELS | Travel Technology Partner");
		WebElement elementContact =  driver.findElement(By.xpath(contactUsXpath));
		elementContact.click();
		GeneralTools.sleep();
		GeneralTools.testCurrentPageTilte(driver.getTitle(), "Contact Us");
		tetsContactName("brurya");
		testContactEmail("brurycohn@gmail.com");
	}

	@Override
	public void testNeg() {
		// TODO Auto-generated method stub	
	}
}
