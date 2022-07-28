package com.Vtiger_generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer_1 implements IRetryAnalyzer{
	int count=0;
	int retrycount=2;
	@Override
	public boolean retry(ITestResult result) {
		if (count<retrycount) {
			count++;
			return true;
		}
		return false;
	}

}
