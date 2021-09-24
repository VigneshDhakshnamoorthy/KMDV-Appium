package testCase;

import org.testng.Assert;
import org.testng.annotations.*;

import Pages.MainPage;
import Pages.RegisterTabPage;
import Pages.StartupPage;
import baseUtil.BaseClass;

public class UserRegister extends BaseClass{
	
	private String phonenumber = "9600000000";
	private String otpnumber = "000000";


	@Test(groups= {"Register"})
	public void Test_Registeration() throws InterruptedException{
		
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
