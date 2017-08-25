package Infra;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Reporter;

public class GeneralTools {
	
	public static String[] regex(String text, String pattern, int groups) {
		String[] results = new String[groups];   
		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);
		// Now create matcher object.
		Matcher m = r.matcher(text);
		if (m.find()) {
			for (int i = 0; i < groups; i++) {
				results[i] = m.group(i);
				System.out.println("Found value: " + m.group(i));
			}
		}else {
			System.out.println("NO MATCH");
		}
		return results;
	}
	
	//rename: throwFailure:
	public static void reportPassOrFail(Boolean condition, String passMsg, String failMsg) {
		if (condition) {
			ReporterTest.addStepToReportFile(passMsg, ReportStatus.PASS);
			Reporter.log("PASS: " + passMsg);
		} else {
			ReporterTest.addStepToReportFile(failMsg, ReportStatus.FAIL);
			//Assert.fail("FAIL: " + failMsg);
		}
	}
	
	public static void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	
	public static void testCurrentPageTilte(String currentTitle, String expectedTitle) {
		String passMsg = "Title is: " + currentTitle + " as expected";
		Boolean condition = currentTitle.equals(expectedTitle);
		String failMsg = "page is not correct: " + currentTitle + " it should be: " +expectedTitle;
		reportPassOrFail(condition, passMsg, failMsg);
	}
}
