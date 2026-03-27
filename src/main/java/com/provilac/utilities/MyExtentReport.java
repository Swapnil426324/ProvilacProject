package com.provilac.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentReport {

	public static ExtentReports getExtentReport(String reportName) {
		String path = System.getProperty("user.dir")+"/target/"+reportName+".html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Testing");
		sparkReporter.config().setReportName("Sinaty Test Cases");
		
		ExtentReports reports = new ExtentReports();
		reports.setSystemInfo("Tester Name", "Swapnil");
		reports.setSystemInfo("Enviorment", "QA");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Operating System", "Windows");
		
		reports.attachReporter(sparkReporter);
		
		return reports;
	}
}
