package Infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage implements IWebsiteTest{
	private String mainXpath = "/html/body/div[2]/div[2]/form[1]";
	private String adminNameXpath  = mainXpath + "/div[1]/input[1]";
	private String adminPasswordXpath  = mainXpath + "/div[1]/input[2]";
	private String loginXpath = mainXpath + "/button";
	private String adminName  = "admin@phptravels.com";
	private String adminPass  = "demoadmin";
	private String url = "http://www.phptravels.net/admin";
	private WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;		
	}
	
	private WebElement getElementAdminName() {
		return driver.findElement(By.xpath(adminNameXpath));
	}

	private WebElement getElementAdminPass() {
		return driver.findElement(By.xpath(adminPasswordXpath));
	}
	private WebElement getElementLogin() {
		return driver.findElement(By.xpath(loginXpath));
	}
	
	private void setAdminName() {
		getElementAdminName().sendKeys(adminName);
	}
	
	private void setAdminPass() {
		getElementAdminPass().sendKeys(adminPass);
	}

	@Override
	public void testSite() {
		driver.get(url);
		setAdminName();
		setAdminPass();
		GeneralTools.testCurrentPageTilte(driver.getTitle(),"Administator Login");
		getElementLogin().click();
		GeneralTools.sleep();
		GeneralTools.testCurrentPageTilte(driver.getTitle(),"Dashboard");
	}

	@Override
	public void testNeg() {
		// TODO Auto-generated method stub
	}
}
