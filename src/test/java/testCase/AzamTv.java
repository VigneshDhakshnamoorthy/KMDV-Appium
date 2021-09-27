package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.azamTV.MainPage;
import pageObjects.azamTV.MoviesTabPage;
import pageObjects.azamTV.RegisterTabPage;
import pageObjects.azamTV.StartupPage;
import util.Base.BaseClass;

public class AzamTv  extends BaseClass{
	
	private String appName="Azam";
	
	private String movienumber = "3";
	
	private String phonenumber = "9600000000";
	private String otpnumber = "000000";

	
	@Test(groups= {"Azam.Movies"})
	public void AzamTV_MovieSearch() throws Exception{
		appOpen(appName);
		StartupPage startUpPage = new StartupPage(driver);
		startUpPage.clickGetStarted();
		startUpPage.clickenglishLanguageBtn();
		startUpPage.clickcontinueBtn();
		
		MainPage mainPage = new MainPage(driver);
		mainPage.clickmoviesTab();
		
		MoviesTabPage moviesTabPage = new MoviesTabPage(driver);
		Assert.assertTrue(moviesTabPage.isPageLoaded());
		moviesTabPage.clickAnymovies(movienumber);
		
		mainPage.clickregisterBtn();
		RegisterTabPage registerTabPage = new RegisterTabPage(driver);
		Assert.assertTrue(registerTabPage.isPageLoaded());
		
	}

	@Test(groups= {"Azam.Register"})
	public void AzamTV_Registeration() throws Exception{
		appOpen(appName);
		StartupPage startUpPage = new StartupPage(driver);
		startUpPage.clickGetStarted();
		startUpPage.clickenglishLanguageBtn();
		startUpPage.clickcontinueBtn();
		
		MainPage mainPage = new MainPage(driver);
		mainPage.clickloginTab();
		mainPage.clickregisterBtn();
		
		RegisterTabPage registerTabPage = new RegisterTabPage(driver);
		Assert.assertTrue(registerTabPage.isPageLoaded());
		registerTabPage.enterPhonenumber(phonenumber);
		registerTabPage.clickContinue();
		registerTabPage.enterOTP(otpnumber);
	}

}
