package testCase;

import org.testng.annotations.Test;

import util.Common.BaseClass;

public class ApkInfo extends BaseClass{

	@Test(groups= {"LocalAppium"})
	public void ApkinfoMain(){
		appOpen(AppDir.ApkInfo);
		actionClass.scrollUiText("Photos");
		screenShotUtil.ExtentShot("Pass");
		actionClass.getOrientation();
		actionClass.scrollUiText("YouTube");

	}


}
