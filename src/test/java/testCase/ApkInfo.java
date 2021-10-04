package testCase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.Common.BaseClass;

@Listeners(util.TestNG.Listener.class)
public class ApkInfo extends BaseClass{
	private String appName="ApkInfo";

	@Test(groups= {"ApkInfo.main"})
	public void ApkinfoMain() throws Exception{
		appOpen(appName);
		actionClass.scrollUiText("Duo");
		screenShotUtil.ExtentShot("Pass");
		actionClass.scrollUiText("YouTube");
	}


}
