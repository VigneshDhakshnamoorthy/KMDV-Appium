package trial;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.TestNG.RetryAnalyser;

public class trialDemo {

	

	@Test(groups = {"success"}, dataProvider ="dp_name", priority=2)
	public void testtopassTest(String name) {
		System.out.println(name+" - "+ Thread.currentThread().getId());
		Assert.assertTrue(true);    
	}
	
	@Test(retryAnalyzer = RetryAnalyser.class,groups = {"success"}, dataProvider ="dp_name", priority=2)
	public void testtofailTest(String name) {
		System.out.println(name+" - "+ Thread.currentThread().getId());
		Assert.assertTrue(false);   
	}
	
	
	@DataProvider(name = "dp_name")
	public Object[][] dataprofunc(){
		return new Object[][]{
          	{"DP_1"},{"DP_2"}
    	};
		
	}
}
