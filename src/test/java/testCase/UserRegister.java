package testCase;

import org.testng.annotations.*;

import Pages.HomePage;
import Pages.RegisterLogin;
import baseUtil.BaseClass;

public class UserRegister extends BaseClass{


	@Test
	public void HomePageTest1() throws InterruptedException{
		HomePage homePage = new HomePage(driver);
		homePage.clickGetStarted();
		homePage.clickcontinueBtn();
		homePage.clickloginRegisterTab();
		
		RegisterLogin registerLogin= new RegisterLogin(driver);
		registerLogin.clickregisterBtn();
	}

}
