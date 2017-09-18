package Infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ContactUsPageNeg implements IWebsiteTest{
	private String nameXpath = "/html/body/div[3]/div/div/div/form/div[1]/div[2]/input[1]";
	private String emailXpath = "/html/body/div[3]/div/div/div/form/div[1]/div[2]/input[2]";
	private String subjectXpath = "/html/body/div[3]/div/div/div/form/div[1]/div[2]/input[3]";
	private String messageXpath = "/html/body/div[3]/div/div/div/form/div[1]/div[3]/textarea";
	private String submitXpath = "/html/body/div[3]/div/div/div/form/div[2]/input";
	private String submitMsgXpath = "/html/body/div[3]/div/div/div/form/div[1]/div[1]";
	private String name = "Tamar";
	private String email = "meyer";
	private String subject = "Hi";
	private String message = "bla bla bla";
	private String url = "http://www.phptravels.net/contact-us";
	private WebDriver driver;
	
	public ContactUsPageNeg(WebDriver driver)throws Exception{
		this.driver = driver;
	}
	
	/*private WebElement getElementName(){
		return driver.findElement(By.xpath(nameXpath));
	}
	
	private WebElement getElementEmail(){
		return driver.findElement(By.xpath(emaildXpath));
	}
	
	private WebElement getElementSubject(){
		return driver.findElement(By.xpath(subjectXpath));
	}
	
	private WebElement getElementMessage(){
		return driver.findElement(By.xpath(messageXpath));
	}
	
	private WebElement getElementSubmit(){
		return driver.findElement(By.xpath(submitXpath));
	}
	
	private WebElement getElementSubmitMsg(){
		return driver.findElement(By.xpath(submitMsgXpath));
	}
	
	private void setName(){
		getElementName().sendKeys(name);
	}
	
	private void setEmail(){
		getElementEmail().sendKeys(email);
	}
	
	private void setSubject(){
		getElementSubject().sendKeys(subject);
	}
	
	private void setMessage(){
		getElementMessage().sendKeys(message);
	}*/
	
	@Override
	public void testSite()throws Exception{
		driver.get(url);
		GeneralTools.webElementSendKeys(driver,nameXpath,name);
		GeneralTools.webElementSendKeys(driver,emailXpath,email);
		GeneralTools.webElementSendKeys(driver,subjectXpath,subject);
		GeneralTools.webElementSendKeys(driver,messageXpath,message);
		GeneralTools.testCurrnetPageTitle(driver.getTitle(),"Contact Us");
		GeneralTools.getElement(driver,submitXpath).click();
		GeneralTools.sleep();
		GeneralTools.checkElementExistenceNeg(GeneralTools.getElement(driver,submitMsgXpath));
		
	}
}


