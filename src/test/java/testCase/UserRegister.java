package testCase;

import org.testng.Assert;
import org.testng.annotations.*;

import Pages.HomePage;
import Pages.RegisterPage;
import baseUtil.BaseClass;

public class UserRegister extends BaseClass{

	@Test
	public void Test_Registeration() throws InterruptedException{
		HomePage homePage = new HomePage(driver);
		homePage.clickGetStarted();
		homePage.clickenglishLanguageBtn();
		homePage.clickcontinueBtn();
		homePage.clickloginTab();
		homePage.clickregisterBtn();
		RegisterPage registerPage = new RegisterPage(driver);
		Assert.assertTrue(registerPage.IsPageLoaded());
		
		
	}

}
