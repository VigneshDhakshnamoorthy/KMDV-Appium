package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.MainPage;
import Pages.MoviesTabPage;
import Pages.RegisterTabPage;
import Pages.StartupPage;
import baseUtil.BaseClass;

public class MovieSearch  extends BaseClass{
	
	private String movienumber = "3";

	
	@Test(groups= {"Movies"})
	public void Test_MovieSearch() throws InterruptedException{
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

}
