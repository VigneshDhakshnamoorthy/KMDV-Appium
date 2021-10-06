package util.TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import util.Common.BaseClass;

public class Listener extends BaseClass  implements ITestListener{
	 	@Override  
	    public void onTestStart(ITestResult result) {  
	 		BaseResult=result;
	 		ERU.StartExtentTest(result.getName());
	 		logUtil.startLogging(result.getName());
	 		logUtil.logInfo("Test Started - "+result.getName());
	 		logUtil.logC("\n===============================================\n\nTest Started - "+result.getName());

	    }  
	 	
	    @Override  
	    public void onTestSuccess(ITestResult result) {  
	    	logUtil.logInfo("Test Success : "+result.getName());
	    	logUtil.logC("Test Success : "+result.getName());
	    }  
	  
	    @Override  
	    public void onTestFailure(ITestResult result) {  
	    	logUtil.logWarn("Test Failure : "+result.getName()+" // "+result.getThrowable());
	    	logUtil.logC("Test Failure : "+result.getName()+" // "+result.getThrowable());
	    	screenShotUtil.ExtentShot("Fail");
	    	ERU.Etest.fail(result.getThrowable());

	    ;
	    }  
	  
	    @Override  
	    public void onTestSkipped(ITestResult result) {  
	    	logUtil.logWarn("Test Skip : "+result.getName());  
	    	logUtil.logC("Test Skip : "+result.getName());  
	    }  
	  
	    @Override  
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	        
	    }  
	  
	    @Override  
	    public void onStart(ITestContext context) { 
	    	logUtil.logC("\n===============================================\n\nTest Suite Started");
	          
	    }  
	  
	    @Override  
	    public void onFinish(ITestContext context) { 
	    	logUtil.logC("\n===============================================\n\nTest Suite Completed"); 
	    }  
}
