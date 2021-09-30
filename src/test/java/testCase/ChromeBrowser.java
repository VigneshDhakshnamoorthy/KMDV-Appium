package testCase;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import util.Common.BaseClass;

public class ChromeBrowser extends BaseClass{
	private String appName="Chrome";
	private String browseURL="https://www.amazon.in/";
	private String searchKeyword="iphone";


	@Test(groups= {"chrome.main"})
	public void AmazonProductSearch() throws Exception{
		appOpen(appName);
		actionClass.clearChromeTabs();
		driver.get(browseURL);
		logUtil.logE(browseURL+"\nOpened in "+appName+" Browser Succesfully");

		actionClass.isWebviewEnabled();
		actionClass.SwitchWebview();
		screenShotUtil.ExtentShot("Pass");

		driver.findElementByXPath("//input[@id='nav-search-keywords']").sendKeys(searchKeyword+Keys.ENTER);
		logUtil.logE(searchKeyword+"Searched Succesfully");
		actionClass.SwitchNative();
		
	}
}
