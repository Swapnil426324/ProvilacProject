package com.provilac.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer{

	int maxCount = 3;
	int count = 1;
	
	@Override
	public boolean retry(ITestResult result) {
	
		if(count < maxCount) {
			count++;
			return true;
		}
		return false;
	}

}
