package testCase;

import org.testng.annotations.Test;

import pageObjects.chromeBrowser.AmazonPage;
import util.Common.BaseClass;

public class ChromeBrowser extends BaseClass{
	private String appName="Chrome";


	@Test(groups= {"LocalAppium"})
	public void AmazonProductSearch() throws Exception{
		appOpen(appName);

		AmazonPage amazonPage = new AmazonPage();
		amazonPage.enterSearchBox();
		amazonPage.clickHamburgerMenu();
		amazonPage.clickMenuMobiles();
		screenShotUtil.ExtentShot("Pass");
		chromeBase.SwitchNative();
		
	}
}
