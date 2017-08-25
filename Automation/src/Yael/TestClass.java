package Yael;
import org.junit.Test;

public class TestClass {
	
	
	InitDriver chromTest = new InitDriver(BrowsersEnum.CHROM);
	ContactUsTest testContact= new ContactUsTest(chromTest.driver);
	AdminTest testAdmin = new AdminTest(chromTest.driver);
	
	/**
	 * This function run all tests
	 * @throws Exception
	 */
	@Test
	 public void runTheTests()throws Exception {
		testContact.positiveTest();
		 testContact.negativeTest();
		 testAdmin.positiveTest();
	     testAdmin.negativeTest();
	     chromTest.closeTest();
			 
}
}