package Infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Infra.GeneralTools;


public class AdminPage implements IWebsiteTest{
	//private String adminNameXpath = "/html/body/div[2]/div[2]/form[1]/div[1]/input[1]";
	private String email = "/html/body/div[2]/div[2]/form[1]/div[1]/input[1]";
	private String adminPassword = "/html/body/div[2]/div[2]/form[1]/div[1]/input[2]";
	private String login = "/html/body/div[2]/div[2]/form[1]/button";
	private String adminName = "admin@phptravels.com";
	private String adminPass = "demoadmin";
	private String url = "http://www.phptravels.net/admin";
	private WebDriver driver;
	
	public AdminPage(WebDriver driver)throws Exception{
		this.driver = driver;
	}
	
	

	@Override
	public void testSite()throws Exception{
		driver.get(url);
		GeneralTools.webElementSendKeys(driver,email,adminName);
		GeneralTools.webElementSendKeys(driver,adminPassword,adminPass);
		GeneralTools.testCurrnetPageTitle(driver.getTitle(),"Administator Login");
		GeneralTools.getElement(driver,login).click();
		GeneralTools.sleep();
		GeneralTools.testCurrnetPageTitle(driver.getTitle(), "Dashboard");
		
	}
}
