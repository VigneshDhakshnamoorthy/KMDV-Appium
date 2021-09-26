package testCase;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class ApkInfo extends BaseClass{
	private String appName="ApkInfo";

	@Test(groups= {"ApkInfo.main"})
	public void ApkinfoMain() throws Exception{
		appOpen(appName);
		
	}
}
