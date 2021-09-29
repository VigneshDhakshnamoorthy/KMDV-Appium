package util.TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import util.Base.BaseClass;

public class Listener  extends BaseClass implements ITestListener {
	 	@Override  
	    public void onTestStart(ITestResult result) {  
	 		BaseResult=result;
	 		ERU.StartExtentTest(result.getName());
	 		logC("\n===============================================\n\nTest Started - "+result.getName());

	    }  
	 	
	    @Override  
	    public void onTestSuccess(ITestResult result) {  
	    	logC("Test Success : "+result.getName());
	    }  
	  
	    @Override  
	    public void onTestFailure(ITestResult result) {  
	    	logC("Test Failure : "+result.getName()+" // "+result.getThrowable());
	    	AppScreenShot("Fail");

	    
	    }  
	  
	    @Override  
	    public void onTestSkipped(ITestResult result) {  
	    	logC("Test Skip : "+result.getName());  
	    }  
	  
	    @Override  
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	        
	    }  
	  
	    @Override  
	    public void onStart(ITestContext context) { 
	    	ERU.StartExtentReport();
	    	logC("\n===============================================\n\nTest Suite Started");
	          
	    }  
	  
	    @Override  
	    public void onFinish(ITestContext context) {  
	    	logC("\n===============================================\n\nTest Suite End"); 
	    	ERU.EndExtentReport();
	    }  
}
