package com.w2a.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.w2a.base.Page;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.MonitoringMail;
import com.w2a.utilities.TestConfig;
import com.w2a.utilities.Utilities;

public class CustomListeners extends Page implements ITestListener, ISuiteListener {

	public String messageBody;

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ISuite suite) {
		
		if (extent != null) {

			extent.flush();
		}
		/*
		 * System.out.println("In Finish"); MonitoringMail mail = new MonitoringMail();
		 * System.out.println("In Finish2");
		 * 
		 * try {
		 * 
		 * messageBody = "http://" + InetAddress.getLocalHost().getHostAddress() +
		 * ":8080/job/DataDrivenLiveProject/Extent_20Reports/"; } catch (Exception e) {
		 * // TODO Auto-generated catch block System.out.println("in catch 1");
		 * 
		 * e.printStackTrace(); }
		 * 
		 * try { System.out.println("In Finish4");
		 * 
		 * mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,
		 * TestConfig.subject, messageBody); } catch (AddressException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (Exception e) { //
		 * TODO Auto-generated catch block System.out.println("In catch 2");
		 * 
		 * e.printStackTrace(); }
		 * 
		 */ }

	static Date d = new Date();
	public static String test = new SimpleDateFormat("yyyy-MMM-dd-kk-mm").format(d);
	public static String fileName = "Extent_" + test + ".html";
	private static ExtentReports extent = ExtentManager
			.createInstance(System.getProperty("user.dir") + "\\reports\\" + fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName());
		testReport.set(test);

		// runmodes - Y
		if (!Utilities.isTestRunnable(result.getName(), excel)) {

			throw new SkipException("Skipping the test " + result.getName().toUpperCase() + " as the Run mode is NO");
		}

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);

	}

	public void onTestFailure(ITestResult result) {

		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
						+ " \n");

		try {

			Utilities.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(Utilities.screenshotName).build());
		} catch (IOException e) {

		}

		String failureLogg = "TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}

}
