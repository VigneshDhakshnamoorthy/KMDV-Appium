package testCase;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class ChromeBrowser extends BaseClass{
	private String appName="Chrome";

	@Test(groups= {"chrome.main"})
	public void chromeMain() throws Exception{
		appOpen(appName);

		driver.get("https://www.amazon.in/");
		isWebviewEnabled();
		driver.context(Context_WebView);
		driver.findElementByXPath("//input[@id='nav-search-keywords']").sendKeys("iphone"+Keys.ENTER);
		driver.context(Context_Native);
		clearChromeTabs();
		
	}
}
