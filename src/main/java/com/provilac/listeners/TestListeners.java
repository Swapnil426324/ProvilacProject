package com.provilac.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.provilac.base.BaseClass;
import com.provilac.utilities.MyExtentReport;
import com.provilac.utilities.MyScreenshotUtils;


public class TestListeners extends BaseClass implements ITestListener{
	
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test case execution started "+result.getName());
		test = reports.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test case is pass "+result.getName());
		test.log(Status.PASS, "test case pass "+result.getName());
		test.log(Status.PASS, "Reason: " + "Pass Test");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test case failed "+result.getName());
		test.log(Status.FAIL, "test case failed "+result.getName());
		test.log(Status.FAIL, "Reason: " + result.getThrowable());
		String screenshotPath = MyScreenshotUtils.getScreenshot(result.getName());
		test.addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test case skipped "+result.getName());
		test.log(Status.SKIP, "test case failed "+result.getName());
		test.log(Status.SKIP, "Reason: " + result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test case suite started ");
		reports=MyExtentReport.getExtentReport(context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test case suite execution finish ");
		reports.flush();
	}
	

}
