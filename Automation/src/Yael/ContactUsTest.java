package Yael;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ContactUsTest implements TestInterface{
	

	private final String BASE_URL= "http://www.phptravels.net";	
	private String contactUsUrl =BASE_URL+"/contact-us";
	private String nameXpath="/html/body/div[3]/div/div/div/form/div[1]/div[2]/input[1]";
	private String nameString ="yael";
	private String emailXpath="/html/body/div[3]/div/div/div/form/div[1]/div[2]/input[2]";
	private String emailString ="yr@gmail.com";
	private String subjectXpath="/html/body/div[3]/div/div/div/form/div[1]/div[2]/input[3]";
	private String subjectString ="kishkush subject";
	private String messageXpath="/html/body/div[3]/div/div/div/form/div[1]/div[3]/textarea";
	private String messageString ="kishkush message";
	private String submitButtonXpath="/html/body/div[3]/div/div/div/form/div[2]/input";
	private String resultXpath ="/html/body/div[3]/div/div/div/form/div[1]/div[1]";
	private String contactUsTestOutput ="Message Sent Successfully";
	private String validationBaseMsg ="Request sent to server without typing email";
	WebDriver driver ;
	
	

	
	/**
	 * This function is positiveTest for ContactUs page
	 */
	@Override
	public void positiveTest() throws Exception{
	System.out.println("start contactUs positiveTest");
	driver.get(contactUsUrl);
	getNameElement().sendKeys(nameString);
	getEmailElement().sendKeys(emailString);
	getSubjectElement().sendKeys(subjectString);
	getMessageElement().sendKeys(messageString);
	getSubmitElement().click();	 
	Utils.throwException(getResultFrame().getText().equals(contactUsTestOutput), "correct message appears on dashboard", "wrong message appears on dashboard",false);
	System.out.println("its the title: "+driver.getTitle());

	}
		
	
	private WebElement getNameElement() {
		return driver.findElement(By.xpath(nameXpath));
	}
	
	
	
	private WebElement getEmailElement() {
	return driver.findElement(By.xpath(emailXpath));
	}
	
	
	
	private WebElement getSubjectElement() {
		return driver.findElement(By.xpath(subjectXpath));
	
	}
	
	
	private WebElement getMessageElement() {
		return driver.findElement(By.xpath(messageXpath));}
	
	
	
	
	
	private WebElement getSubmitElement(){
		return driver.findElement(By.xpath(submitButtonXpath));
	
	}
	
	 
	private WebElement getResultFrame(){
		return driver.findElement(By.xpath(resultXpath));
		
		}	
	

	
	public ContactUsTest(WebDriver driver) {
		this.driver = driver;
		
	}


	
	/**
	 * This function is negativeTest for ContactUs page
	 */
	@Override
	public void negativeTest() throws Exception {
		System.out.println("start contactUs negativeTest");
		driver.get(contactUsUrl);
		driver.manage().window().maximize();
		getNameElement().sendKeys(nameString);
		getSubjectElement().sendKeys(subjectString);
		getMessageElement().sendKeys(messageString);
		getSubmitElement().click();	
		Utils.throwException(getResultFrame().isDisplayed(), validationBaseMsg,validationBaseMsg.replace("sent", "isnt sent") ,true);
	

	}
	

	
	}
