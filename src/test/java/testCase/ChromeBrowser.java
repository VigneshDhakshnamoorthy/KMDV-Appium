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

		driver.get(browseURL);
		log(browseURL+"Opened in"+appName+" Succesfully");

		isWebviewEnabled();
		driver.context(Context_WebView);
		log("Switched to "+Context_WebView+" Succesfully");

		driver.findElementByXPath("//input[@id='nav-search-keywords']").sendKeys(searchKeyword+Keys.ENTER);
		log(searchKeyword+"Searched Succesfully");
		driver.context(Context_Native);
		log("Switched to "+Context_Native+" Succesfully");

		
		
	}
}
