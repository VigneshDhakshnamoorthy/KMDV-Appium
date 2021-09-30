package util.TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import util.Common.BaseClass;

public class Listener extends BaseClass implements ITestListener {
	 	@Override  
	    public void onTestStart(ITestResult result) {  
	 		BaseResult=result;
	 		ERU.StartExtentTest(result.getName());
	 		logUtil.logC("\n===============================================\n\nTest Started - "+result.getName());

	    }  
	 	
	    @Override  
	    public void onTestSuccess(ITestResult result) {  
	    	logUtil.logC("Test Success : "+result.getName());
	    }  
	  
	    @Override  
	    public void onTestFailure(ITestResult result) {  
	    	logUtil.logC("Test Failure : "+result.getName()+" // "+result.getThrowable());
	    	screenShotUtil.ExtentShot("Fail");
	    	ERU.Etest.fail(result.getThrowable());

	    ;
	    }  
	  
	    @Override  
	    public void onTestSkipped(ITestResult result) {  
	    	logUtil.logC("Test Skip : "+result.getName());  
	    }  
	  
	    @Override  
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	        
	    }  
	  
	    @Override  
	    public void onStart(ITestContext context) { 
	    	ERU.StartExtentReport();
	    	logUtil.logC("\n===============================================\n\nTest Suite Started");
	          
	    }  
	  
	    @Override  
	    public void onFinish(ITestContext context) {  
	    	logUtil.logC("\n===============================================\n\nTest Suite End"); 
	    	ERU.EndExtentReport();
	    }  
}
