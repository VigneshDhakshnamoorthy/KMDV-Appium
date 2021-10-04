package testCase;

import org.testng.ITestListener;
import org.testng.ITestResult;

import util.Common.BaseClass;

public class trialDemo extends BaseClass implements ITestListener{

	private static String methName() {
		return new Throwable()
                .getStackTrace()[0]
                .getMethodName();
	}
	
	public static void newMeth () {
		System.out.println(methName());
	}
	public static void oldMeth (ITestResult result) {
		System.out.println(result.getName());
	}
public static void main(String[] args) throws Throwable {
	newMeth();
}
}
