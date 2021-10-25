package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.azamTV.MainPage;
import pageObjects.azamTV.MoviesTabPage;
import pageObjects.azamTV.RegisterTabPage;
import pageObjects.azamTV.StartupPage;
import util.Common.BaseClass;
import util.Data.ExcelUtil;

public class AzamTv  extends BaseClass{
	
	private String appName="Azam";

	@Test(groups= {"LocalAppium"})
	public void AzamTV_MovieSearch() {
		appOpen(appName);
		xlutil = new ExcelUtil(pathUtil.getExcelPath("AzamExcelData.xlsx"));
		String movienumber = xlutil.getCellDataByValue("Sheet1", "movienumber", "value");

		StartupPage startUpPage = new StartupPage();
		startUpPage.clickGetStarted();
		startUpPage.clickenglishLanguageBtn();
		startUpPage.clickcontinueBtn();
		
		MainPage mainPage = new MainPage();
		mainPage.clickmoviesTab();
		
		MoviesTabPage moviesTabPage = new MoviesTabPage();
		Assert.assertTrue(moviesTabPage.isPageLoaded());
		screenShotUtil.ExtentShot("Pass");
		moviesTabPage.clickAnymovies(movienumber);
		
		mainPage.clickregisterBtn();
		RegisterTabPage registerTabPage = new RegisterTabPage();
		Assert.assertTrue(registerTabPage.isPageLoaded());
		actionClass.getLocation();
	}

	@Test(groups= {"LocalAppium"})
	public void AzamTV_Registeration() {
		appOpen(appName);
		xlutil = new ExcelUtil(pathUtil.getExcelPath("AzamExcelData.xlsx"));
		String phonenumber = xlutil.getCellDataByValue("Sheet1", "phonenumber", "value");
		String otpnumber = xlutil.getCellDataByValue("Sheet1", "otpnumber", "value");

		StartupPage startUpPage = new StartupPage();
		startUpPage.clickGetStarted();
		startUpPage.clickenglishLanguageBtn();
		startUpPage.clickcontinueBtn();
		
		MainPage mainPage = new MainPage();
		mainPage.clickloginTab();
		mainPage.clickregisterBtn();
		
		RegisterTabPage registerTabPage = new RegisterTabPage();
		Assert.assertTrue(registerTabPage.isPageLoaded());
		screenShotUtil.ExtentShot("Pass");
		registerTabPage.enterPhonenumber(phonenumber);
		registerTabPage.clickContinue();
		registerTabPage.enterOTP(otpnumber);
	}

}
