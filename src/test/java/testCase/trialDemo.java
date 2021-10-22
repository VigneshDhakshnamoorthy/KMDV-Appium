package testCase;


import org.testng.annotations.Test;

import util.Common.BaseClass;


public class trialDemo  extends BaseClass{
	private String appName="Azam";

	@Test(groups= {"LocalAppium"})
	public void AppiumSessions() {
		// Create Sessions
			appOpen(appName);
	


	}
}