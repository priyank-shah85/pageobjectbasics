package com.w2a.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

		htmlReporter.loadConfig(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\w2a\\extentconfig\\ReportsConfig.xml");

		/*
		 * htmlReporter.config().setTheme(Theme.STANDARD);
		 * htmlReporter.config().setDocumentTitle(fileName);
		 * htmlReporter.config().setEncoding("utf-8");
		 * htmlReporter.config().setReportName(fileName);
		 */

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Priyank Shah");
		extent.setSystemInfo("Organization", "Apttus");
		extent.setSystemInfo("Build no", "POM-0001");

		return extent;
	}

}