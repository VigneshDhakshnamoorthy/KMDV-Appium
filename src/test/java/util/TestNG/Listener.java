package util.TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import util.Base.BaseClass;

public class Listener  extends BaseClass implements ITestListener {
	 	@Override  
	    public void onTestStart(ITestResult result) {  
	 		BaseResult=result;
	 		log("\n===============================================\n\nTest Started - "+result.getName());

	    }  
	 	
	    @Override  
	    public void onTestSuccess(ITestResult result) {  
	    	log("Success test cases : "+result.getName());  
	    }  
	  
	    @Override  
	    public void onTestFailure(ITestResult result) {  
	    	log("Failure test cases : "+result.getName()+" // "+result.getThrowable()); 
	    
	    }  
	  
	    @Override  
	    public void onTestSkipped(ITestResult result) {  
	    	log("Skip test cases : "+result.getName());  
	    }  
	  
	    @Override  
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	        
	    }  
	  
	    @Override  
	    public void onStart(ITestContext context) {  
	    	log("\n===============================================\n\nTest Suite Started");
	          
	    }  
	  
	    @Override  
	    public void onFinish(ITestContext context) {  
	    	log("\n===============================================\n\nTest Suite End"); 
	          
	    }  
}
