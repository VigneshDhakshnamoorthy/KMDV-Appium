package util.TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	 	@Override  
	    public void onTestStart(ITestResult result) {  
	        System.out.println("\n===============================================\n\nTest Started - "+result.getName());

	    }  
	 	
	    @Override  
	    public void onTestSuccess(ITestResult result) {  
	        System.out.println("Success test cases : "+result.getName());  
	    }  
	  
	    @Override  
	    public void onTestFailure(ITestResult result) {  
	        System.out.println("Failure test cases : "+result.getName()+" // "+result.getThrowable());  
	    }  
	  
	    @Override  
	    public void onTestSkipped(ITestResult result) {  
	        System.out.println("Skip test cases : "+result.getName());  
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
	        System.out.println("\n===============================================\n\nTest Suite End"); 
	          
	    }  
}
