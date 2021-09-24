package testCase;

import org.testng.annotations.Test;

import Pages.StartupPage;
import baseUtil.BaseClass;

public class MovieSearch  extends BaseClass{
	
	@Test(groups= {"Movies"})
	public void Test_MovieSearch() throws InterruptedException{
		StartupPage startUpPage = new StartupPage(driver);
		startUpPage.clickGetStarted();
		startUpPage.clickenglishLanguageBtn();
		startUpPage.clickcontinueBtn();
	}

}
