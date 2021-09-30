package util.Data;


import org.testng.Reporter;

import util.Common.BaseClass;

public class LogUtil extends BaseClass {
	
	public void logE(String LogMessage) {
		Reporter.log(LogMessage);
		ERU.ExtentPass(LogMessage);
		System.out.println(LogMessage);
	}		
	
	public void logC(String LogMessage) {
		Reporter.log(LogMessage);
		System.out.println(LogMessage);
	}	
}
