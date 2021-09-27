package util.TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	 	@Override  
	    public void onTestStart(ITestResult result) {  
	        System.out.println("Test Started - "+result.getName());

	    }  
	 	
	    @Override  
	    public void onTestSuccess(ITestResult result) {  
	        System.out.println("Success of test cases and its details are : "+result.getName());  
	    }  
	  
	    @Override  
	    public void onTestFailure(ITestResult result) {  
	        System.out.println("Failure of test cases and its details are : "+result.getName()+" // "+result.getThrowable());  
	    }  
	  
	    @Override  
	    public void onTestSkipped(ITestResult result) {  
	        System.out.println("Skip of test cases and its details are : "+result.getName());  
	    }  
	  
	    @Override  
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	        
	    }  
	  
	    @Override  
	    public void onStart(ITestContext context) {  
	        System.out.println("Test Suite Started");
	          
	    }  
	  
	    @Override  
	    public void onFinish(ITestContext context) {  
	        System.out.println("Test Suite End"); 
	          
	    }  
}
