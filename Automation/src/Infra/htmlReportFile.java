package Infra;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class htmlReportFile {

	//HTML report general parameters
	File htmlTemplateFile = new File("C:\\Report Test.html");
	File newHtmlFile;
	String testName;
	
	//Step parameters
	String stepTemplate = "<tr>\n<td>STEP</td>\n<td>DESC</td>\n<td>STATUS</td>\n<td>RESULT</td>\n</tr>\n</table>";
	String replaceStep = "</table>";
	String step;

	public htmlReportFile(String testName) {
		this.testName = testName;
		createTestReport();
		replaceReportHeader();
	}

	private void createTestReport() {
		newHtmlFile = new File("D:\\Report" + testName.replace(" ", "") + ".html");
		try {
			if (!newHtmlFile.exists()) {
				newHtmlFile.createNewFile();
			}
			String htmlString = FileUtils.readFileToString(htmlTemplateFile, "UTF-8");
			FileUtils.writeStringToFile(newHtmlFile, htmlString, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void replaceReportHeader() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		replaceInReport("$testName", testName);
		replaceInReport("$date", dateFormat.format(date));
		replaceInReport("$optional", "Automation basic tests");
		//TODO replace with current real time status
		replaceInReport("$testCurrentStatus", "");
	}
	
	private void replaceInReport(String searchText, String replaceText) {
		try {
		String htmlString = FileUtils.readFileToString(newHtmlFile, "UTF-8");
		htmlString = htmlString.replace(searchText, replaceText);
		FileUtils.writeStringToFile(newHtmlFile, htmlString, "UTF-8");	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addStepToReportFile(int stepNum, String msg, ReportStatus status) {
		step = stepTemplate;
		step = step.replaceFirst("STEP", ""+stepNum);
		step = step.replaceFirst("DESC", msg);
		step = step.replaceFirst("STATUS", status.name());
		step = step.replaceFirst("RESULT", status.name());
		replaceInReport(replaceStep, step);
	}
	
	public void addEndResultToReport(String result) {
		replaceInReport("$end", result);
	}
}
