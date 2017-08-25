package Tests;

import org.testng.annotations.Test;

import Infra.GeneralTools;
import Infra.ReporterTest;
import Infra.SimpleThread;

public class TwoThreadsTest {
	
	@Test
	public void test() {
		ReporterTest.createReportFile(this.getClass().getName());
		SimpleThread testChromeThread, testFirefoxThread;
		testChromeThread = new SimpleThread("thread one");
		testFirefoxThread = new SimpleThread("thread two");
		testChromeThread.start();
		testFirefoxThread.start();
		while (testChromeThread.isAlive() || testFirefoxThread.isAlive()) {
			GeneralTools.sleep();
		}
		ReporterTest.endTest();
	}
}
