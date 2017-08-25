package Infra;
import java.util.ArrayList;
import org.testng.Assert;

public class InfraReporter {

	private ArrayList<String> steps = new ArrayList<>();
	private String failurs = "";
	private int stepNum = 1;
	private ReportStatus finalTestStatus = ReportStatus.PASS;
	private String testName;
	
	public String getTestName() {
		return testName;
	}

	private htmlReportFile reportHtmlFile;

	public InfraReporter(String testName) {
		this.testName = testName;
		reportHtmlFile = new htmlReportFile(testName);
	}

	public void runStepAndReport(String msg, ReportStatus status) {
		steps.add("Num. " + stepNum);
		reportHtmlFile.addStepToReportFile(stepNum, msg, status);
		stepNum++;
		if (status.equals(ReportStatus.FAIL)) {
			finalTestStatus = ReportStatus.FAIL;
			failurs = failurs + "\nstep " + stepNum + ": " + msg;
		}
	}

	public void endTest() {
		if (finalTestStatus.equals(ReportStatus.FAIL)) {
			reportHtmlFile.addEndResultToReport(testName + " failed with failures:" + failurs);
			Assert.fail(testName + " failed with failures:" + failurs);
		}
	}
}
