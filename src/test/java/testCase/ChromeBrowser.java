package testCase;

import org.testng.annotations.Test;

import pageObjects.chromeBrowser.AmazonPage;
import util.Common.BaseClass;

public class ChromeBrowser extends BaseClass{

	@Test(groups= {"LocalAppium"})
	public void AmazonProductSearch() throws Exception{
		appOpen(AppDir.Chrome);

		AmazonPage amazonPage = new AmazonPage();
		
		amazonPage.enterSearchBox()
				.clickHamburgerMenu()
				.clickMenuMobiles();
		
		screenShotUtil.ExtentShot("Pass");
		chromeBase.SwitchNative();
		
	}
}
