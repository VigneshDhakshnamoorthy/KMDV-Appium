package testCase;

import org.testng.annotations.Test;

import util.Common.BaseClass;

public class ApkInfo extends BaseClass{
	private String appName="ApkInfo";

	@Test(groups= {"LocalAppium"})
	public void ApkinfoMain(){
		appOpen(appName);
		actionClass.scrollUiText("Photos");
		screenShotUtil.ExtentShot("Pass");
		actionClass.getOrientation();
		actionClass.scrollUiText("YouTube");

	}


}
