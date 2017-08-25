package Yael;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminTest implements TestInterface  {
	
	private final String BASE_URL= "http://www.phptravels.net";	
	private String adminUrl =BASE_URL+"/admin";	
	 private String emailXpath= "/html/body/div[2]/div[2]/form[1]/div[1]/input[1]";
	 private String	passwordXpath="/html/body/div[2]/div[2]/form[1]/div[1]/input[2]";
	 private String	loginButtonXpath="/html/body/div[2]/div[2]/form[1]/button";
	 private String	dropDownXpath="/html/body/div[2]/header/nav/div[3]/ul[2]/li[2]/a";
	 private String	logoutXpath="/html/body/div[2]/header/nav/div[3]/ul[2]/li[2]/ul/li[2]/a";
	 private String	email="admin@phptravels.com";
	 private String	password= "demoadmin";
	 private WebDriver driver;
	 private String adminLoginPageTitle = "Administator Login";
	 private String dashboardPageTitle = "Dashboard";

private WebElement getEmailElement() {
	return  driver.findElement(By.xpath(emailXpath));
}


private WebElement getPasswordElement() {
	return  driver.findElement(By.xpath(passwordXpath));}

private WebElement getDropDownElement() {
	return  driver.findElement(By.xpath(dropDownXpath));}


private WebElement getLogoutElement() {
	return  driver.findElement(By.xpath(logoutXpath));}

private WebElement getLoginButtonElement() {
	return  driver.findElement(By.xpath(loginButtonXpath));}


/**
 * This function is positiveTest for Admin page
 */
@Override
public void positiveTest()throws Exception {
	System.out.println("start admin positiveTest");
	driver.get(adminUrl);
	getEmailElement().sendKeys(email);;	
	getPasswordElement().sendKeys(password);
	getLoginButtonElement().click();
	Thread.sleep(5000);
	Utils.compareTitle(driver.getTitle(), dashboardPageTitle,false);
	Thread.sleep(5000);
    getDropDownElement().click();
    getLogoutElement().click();
 
	
	

}


public AdminTest(WebDriver driver) {
	this.driver = driver;
}



/**
 * This function is negativeTest for Admin page
 */
@Override
public void negativeTest() throws Exception {
	System.out.println("start admin negativeTest");
	Thread.sleep(5000);
	driver.get(adminUrl);
	Thread.sleep(5000);
	getEmailElement().sendKeys(email+"yyty");	
	getPasswordElement().sendKeys(password+"gfg");
	getLoginButtonElement().click();
	Thread.sleep(5000);
	Utils.compareTitle(driver.getTitle(), adminLoginPageTitle,false);

}



	
}






