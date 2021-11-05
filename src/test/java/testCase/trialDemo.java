package testCase;


import org.testng.annotations.Test;


public class trialDemo{
	@Test()
	public void test() {
		String time = new java.util.Date().toString().replace(":", "-");
		String substring = time.substring(11, time.length() - 9);
		System.out.println(time);
		System.out.println(substring);


	}
	
	
}