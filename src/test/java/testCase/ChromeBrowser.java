package testCase;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import util.Base.BaseClass;

public class ChromeBrowser extends BaseClass{
	private String appName="Chrome";
	private String browseURL="https://www.amazon.in/";
	private String searchKeyword="iphone";


	@Test(groups= {"chrome.main"})
	public void AmazonProductSearch() throws Exception{
		appOpen(appName);
		clearChromeTabs();
		driver.get(browseURL);
		log(browseURL+"\nOpened in "+appName+" Browser Succesfully");

		isWebviewEnabled();
		SwitchWebview();
		AppScreenShot();

		driver.findElementByXPath("//input[@id='nav-search-keywords']").sendKeys(searchKeyword+Keys.ENTER);
		log(searchKeyword+"Searched Succesfully");
		SwitchNative();

		
		
	}
}
