package util.TestNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	int count = 0;
	int retrylim = 3;
			
	@Override
	public boolean retry(ITestResult result) {
		
		while (count < retrylim) {
			count++;
			System.out.println("Retry "+count+" "+result.getName());
			return true;
		}
		
		return false;
	}
}
