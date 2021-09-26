package testCase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class ChromeBrowser  extends BaseClass{
	private String appName="Chrome";

	@Test(groups= {"chrome.main"})
	public void chromeMain() throws Exception{
		appOpen(appName);
		driver.get("https://www.amazon.in/");

		Thread.sleep(10000);
	}
}
