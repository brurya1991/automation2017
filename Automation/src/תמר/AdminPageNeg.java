package Infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AdminPageNeg implements IWebsiteTest{
	private String email = "/html/body/div[2]/div[2]/form[1]/div[1]/input[1]";
	private String adminPassword = "/html/body/div[2]/div[2]/form[1]/div[1]/input[2]";
	private String login = "/html/body/div[2]/div[2]/form[1]/button";
	private String adminName = "admin@phptravels.com";
	private String adminPass = "demoadm";
	private String url = "http://www.phptravels.net/admin";
	private WebDriver driver;
	
	
	public AdminPageNeg(WebDriver driver)throws Exception{
		this.driver = driver;
	}
	
	/*private WebElement getElementAdminName(){
		return driver.findElement(By.xpath(adminNameXpath));
	}
	
	private WebElement getElementAdminPass(){
		return driver.findElement(By.xpath(adminPasswordXpath));
	}
	
	private WebElement getElementLogin(){
		return driver.findElement(By.xpath(loginXpath));
	}
	
	private void setAdminName(){
		getElementAdminName().sendKeys(adminName);
	}
	
	private void setAdminPass(){
		getElementAdminPass().sendKeys(adminPass);
	}*/
	
	@Override
	public void testSite()throws Exception{
		driver.get(url);
		GeneralTools.webElementSendKeys(driver,email,adminName);
		GeneralTools.webElementSendKeys(driver,adminPassword,adminPass);
		GeneralTools.testCurrnetPageTitle(driver.getTitle(),"Administator Login");
		GeneralTools.getElement(driver,login).click();
		GeneralTools.sleep();
		GeneralTools.testCurrnetPageTitleNeg(driver.getTitle(), "Dashboard");
		
	}
}
