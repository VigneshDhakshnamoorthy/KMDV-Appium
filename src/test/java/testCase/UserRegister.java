package testCase;

import org.testng.Assert;
import org.testng.annotations.*;

import Pages.HomePage;
import Pages.RegisterPage;
import Pages.StartupPage;
import baseUtil.BaseClass;

public class UserRegister extends BaseClass{

	@Test(groups= {"Register"})
	public void Test_Registeration() throws InterruptedException{
		
		StartupPage startUpPage = new StartupPage(driver);
		startUpPage.clickGetStarted();
		startUpPage.clickenglishLanguageBtn();
		startUpPage.clickcontinueBtn();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickloginTab();
		homePage.clickregisterBtn();
		
		RegisterPage registerPage = new RegisterPage(driver);
		Assert.assertTrue(registerPage.isPageLoaded());
		registerPage.enterPhonenumber("9600000000");
		registerPage.clickContinue();
		registerPage.enterOTP("000000");
	}

}
