package testCase;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.azamTV.MainPage;
import pageObjects.azamTV.MoviesTabPage;
import pageObjects.azamTV.RegisterTabPage;
import pageObjects.azamTV.StartupPage;
import util.Common.BaseClass;
import util.Data.ExcelUtil;

@Listeners(util.TestNG.Listener.class)
public class AzamTv  extends BaseClass{
	
	private String appName="Azam";

	@Test(groups= {"Azam.Movies"})
	public void AzamTV_MovieSearch() throws Exception{
		appOpen(appName);
		xlutil = new ExcelUtil(pathUtil.getExcelPath("AzamExcelData.xlsx"));
		String movienumber = xlutil.getCellDataByValue("Sheet1", "movienumber", "value");

		StartupPage startUpPage = new StartupPage(driver);
		startUpPage.clickGetStarted();
		startUpPage.clickenglishLanguageBtn();
		startUpPage.clickcontinueBtn();
		
		MainPage mainPage = new MainPage(driver);
		mainPage.clickmoviesTab();
		
		MoviesTabPage moviesTabPage = new MoviesTabPage(driver);
		Assert.assertTrue(moviesTabPage.isPageLoaded());
		screenShotUtil.ExtentShot("Pass");
		moviesTabPage.clickAnymovies(movienumber);
		
		mainPage.clickregisterBtn();
		RegisterTabPage registerTabPage = new RegisterTabPage(driver);
		Assert.assertTrue(registerTabPage.isPageLoaded());
		
	}

	@Test(groups= {"Azam.Register"})
	public void AzamTV_Registeration() throws Exception{
		appOpen(appName);
		String phonenumber = xlutil.getCellDataByValue("Sheet1", "phonenumber", "value");;
		String otpnumber = xlutil.getCellDataByValue("Sheet1", "otpnumber", "value");;

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
