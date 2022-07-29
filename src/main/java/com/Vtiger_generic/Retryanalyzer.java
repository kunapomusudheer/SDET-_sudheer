package com.Vtiger_generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryanalyzer implements IRetryAnalyzer{
	int count = 3;
	int retryanalyser = 0;
	@Override
	public boolean retry(ITestResult result) {
		if(retryanalyser<count) {
			retryanalyser++;
			return true;
		}
		return false;
	}

}

