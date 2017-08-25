package Tests;

import org.testng.annotations.Test;

import Infra.InfraReporter;
import Infra.ReportStatus;

/**
 * 
 * @author Brurya
 *
 */
public class TestTheReport {
	
	public InfraReporter report = new InfraReporter("Test the report");

	@Test
	public void testTravelSite() {
		for (int i = 0; i < 100; i++) {
			report.runStepAndReport("step number "+ i, ReportStatus.INFO);
		}
		report.runStepAndReport("step number 101", ReportStatus.FAIL);
		report.endTest();
	}
}
