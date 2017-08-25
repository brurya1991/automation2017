package Infra;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;

public class ReporterTest {

	private final static String PATH = "D:\\";
	private final static String UTF = "UTF-8";
	private final static String REPORT_NAME = "Report.html";
	private final static String TESTNAME_TEMPLATE = "$testName";
	private final static String DATE_TEMPLATE = "$date";
	private final static String OPTIONAL_TEMPLATE = "$optional";
	private final static String OPTIONAL_TEXT = "Automation basic tests";
	private final static String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	private final static String TIME_FORMAT = "HH:mm:ss:SSS";
	private final static String TEST_STATUS_TEMPLATE = "$testCurrentStatus";
	private final static String STEP_TEMPLATE = "<tr>\n<td>STEP</td>\n<td>DESC</td>\n<td>STATUS</td>\n<td>RESULT</td>\n</tr>\n</table>";
	private final static String REPLACE_STEP = "</table>";
	private static String failurs = "";
	private final static File HTML_TEMPLATE_FILE = new File("C:\\Report Test.html");
	private static ReportStatus finalTestStatus = ReportStatus.PASS;
	private static ArrayList<String> steps = new ArrayList<>();

	public static void createReportFile(String testName) {
		checkFile();
		replaceReportHeader(testName);
		GeneralTools.sleep();
	}

	private static void checkFile() {
		File newHtmlFile = new File(PATH + REPORT_NAME);
		try {
			if (newHtmlFile.exists()) {
				newHtmlFile.createNewFile();
			}
			String htmlString = FileUtils.readFileToString(HTML_TEMPLATE_FILE, UTF);
			FileUtils.writeStringToFile(newHtmlFile, htmlString, UTF);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void replaceReportHeader(String testName) {
		replaceInReport(TESTNAME_TEMPLATE, testName);
		replaceInReport(DATE_TEMPLATE, getTime(DATE_FORMAT));
		replaceInReport(OPTIONAL_TEMPLATE, OPTIONAL_TEXT);
		// TODO replace with current real time status
		replaceInReport(TEST_STATUS_TEMPLATE, "");
	}
	
	private static String getTime(String timeFormat) {
		DateFormat dateFormat = new SimpleDateFormat(timeFormat);
		Date date = new Date();
		return dateFormat.format(date);
	}

	private synchronized static void replaceInReport(String searchText, String replaceText) {
		File newHtmlFile = new File(PATH + REPORT_NAME);
		try {
			String htmlString = FileUtils.readFileToString(newHtmlFile, UTF);
			htmlString = htmlString.replace(searchText, replaceText);
			FileUtils.writeStringToFile(newHtmlFile, htmlString, UTF);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized static void addStepToReportFile(String msg, ReportStatus status) {
		if (status.equals(ReportStatus.FAIL)) {
			finalTestStatus = ReportStatus.FAIL;
			failurs = failurs + "\n" + msg;
		}
		String step = STEP_TEMPLATE;
		String time = getTime(TIME_FORMAT);
		step = step.replaceFirst("STEP", time);
		step = step.replaceFirst("DESC", msg);
		step = step.replaceFirst("STATUS", status.name());
		step = step.replaceFirst("RESULT", status.name());
		replaceInReport(REPLACE_STEP, step);
		steps.add(time);
	}
	
	public static void endTest() {
		if (finalTestStatus.equals(ReportStatus.FAIL)) {
			replaceInReport("$end", "Test failed with failures:" + failurs);
			Assert.fail("Test failed with failures:" + failurs);
		} else {
			replaceInReport("$end", "Test passed without failures");
		}
	}
}
