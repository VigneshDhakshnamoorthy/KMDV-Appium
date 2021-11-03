package testCase;


import org.testng.annotations.Test;


public class trialDemo{
	public enum ScrollDirection {
	    UP, DOWN, LEFT, RIGHT
	}
	@Test(groups= {"LocalAppium"})
	public void test() {
		// Create Sessions
		System.out.println(ScrollDirection.UP);
	}
	
	
}