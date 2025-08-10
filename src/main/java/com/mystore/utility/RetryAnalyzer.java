package com.mystore.utility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	 private int retryCount = 0;
	    private static final int maxRetryCount = 2; // Retry failed test 2 more times

	    @Override
	    public boolean retry(ITestResult result) {
	        if (retryCount < maxRetryCount) {
	            retryCount++;
	            return true; // Retry the test
	        }
	        return false; // Don't retry anymore
	    }

}
