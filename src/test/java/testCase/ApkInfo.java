package testCase;

import org.testng.annotations.Test;

import util.Common.BaseClass;

public class ApkInfo extends BaseClass{
	private String appName="ApkInfo";

	@Test(groups= {"ApkInfo.main"})
	public void ApkinfoMain() throws Exception{
		appOpen(appName);
		actionClass.scrollUiText("Duo");
		actionClass.scrollUiText("YouTube");
		screenShotUtil.ExtentShot("Pass");
	}


}
