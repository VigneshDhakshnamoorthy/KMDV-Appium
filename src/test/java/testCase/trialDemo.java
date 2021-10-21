package testCase;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.appiumSessions.SessionCommands;
import pageObjects.azamTV.MainPage;
import pageObjects.azamTV.StartupPage;
import util.Common.BaseClass;


public class trialDemo  extends BaseClass{
	private String appName="Azam";

	@Test(groups= {"LocalAppium"})
	public void AppiumSessions() {
		// Create Sessions
			appOpen(appName);
			SessionCommands Ses = new SessionCommands(driver);
			StartupPage startUpPage = new StartupPage(driver);
			startUpPage.clickGetStarted();
			startUpPage.clickenglishLanguageBtn();
			startUpPage.clickcontinueBtn();
			MainPage mainPage = new MainPage(driver);
			mainPage.clickmoviesTab();
			
		// Get Session Capabilities
			Assert.assertTrue(Ses.getSessionDetails());

		// Get Page Source
			Assert.assertTrue(Ses.getPageSource());


	}
}