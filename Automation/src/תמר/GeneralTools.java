package Infra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralTools {
	public static void throwFailure(Boolean condition,String passMsg, String failMsg) throws Exception{
		if (condition){
			System.out.println(passMsg);
		}else{
			System.out.println(failMsg);
			throw new Exception(failMsg);
		}	
	}
	
	public static void sleep(){
		try{
			Thread.sleep(5000);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void testCurrnetPageTitle(String currentTitle,String expectedTitle)throws Exception{
		GeneralTools.throwFailure(currentTitle.equals(expectedTitle), 
				"Title is: " + currentTitle + " As Expected.", 
				"Title is: "+ currentTitle + ". Expected title: " + expectedTitle);
	}
	
	public static void testCurrnetPageTitleNeg(String currentTitle,String unexpectedTitle)throws Exception{
		GeneralTools.throwFailure(!currentTitle.equals(unexpectedTitle), 
				"Title is: " + currentTitle + " As Expected.", 
				"Title is: "+ currentTitle + ". unExpected title: " + unexpectedTitle);
	}
	
	public static void checkElementExistence(WebElement element)throws Exception{
		GeneralTools.throwFailure(element.isDisplayed(), "element is displayed, as expected", "element is not displayed");
	}
	
	public static void checkElementExistenceNeg(WebElement element)throws Exception{
		GeneralTools.throwFailure(!element.isDisplayed(), "element is not displayed, as expected", "element is displayed");
	}
	
	public static WebElement getElement(WebDriver driver,String name){
		return driver.findElement(By.xpath(name));
	}
	
	public static void webElementSendKeys(WebDriver driver, String element, String strText){
		getElement(driver,element).sendKeys(strText);
	}

}
