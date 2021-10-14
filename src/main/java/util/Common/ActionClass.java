package util.Common;

import java.util.Set;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public class ActionClass extends BaseClass {
	protected String Context_Native = "NATIVE_APP";
	protected String Context_WebView = "WEBVIEW_chrome";

	public void WaitSec(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void WaitMilliSec(int MilliSec) {
		try {
			Thread.sleep(MilliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void isWebviewEnabled() {
		while(true) {
			Set<String> contextHandles = driver.getContextHandles();
			if(contextHandles.contains(Context_WebView)) {
				break;
			}
		}
	}
	
	public void WaitElement(By by, int Seconds) {
		for (int i =1; i<=Seconds*1000 ; i++) {
			if (driver.findElement(by).isDisplayed()){
				break;
			}else {
				WaitMilliSec(1);
			}
		}
	}
	public void WaitUnlimit(By by) {
		while(true) {
			if(driver.findElement(by).isDisplayed()) {
				break;
			}
		}
	}
	public void ClickElement(By by) {
		WaitElement(by,10);
		driver.findElement(by).click();
	}
	
	public void TypeinElement(By by, String Value) {
		WaitElement(by,10);
		driver.findElement(by).sendKeys(Value);
	}
	
	public void SwitchWebview() {
		isWebviewEnabled();
		driver.context(Context_WebView);
		logUtil.logE("Switched to "+Context_WebView+" Succesfully");


	}
	public void SwitchNative() {
		driver.context(Context_Native);
		logUtil.logE("Switched to "+Context_Native+" Succesfully");


	}
	public void clearChromeTabs() {
		String xpath1 = "//*[@resource-id=\"com.android.chrome:id/tab_switcher_button\"]";
		String xpath2 = "//*[@resource-id=\"com.android.chrome:id/menu_button_wrapper\"]";
		String xpath3 = "//*[@content-desc=\"Close all tabs\"]";

		driver.findElementByXPath(xpath1).click();
		driver.findElementByXPath(xpath2).click();
		driver.findElementByXPath(xpath3).click();
	}

	public void scrollUiText(String ScrollText) {
		String ScrollCommand = "new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView("                      
				+ "new UiSelector().textContains(\""+ScrollText+"\"));";
		By androidUIAutomator = MobileBy.AndroidUIAutomator(ScrollCommand);
		driver.findElement(androidUIAutomator);
		driver.findElement(By.xpath("//*[contains(@text, '"+ScrollText+"')]"));
		logUtil.logE("Scroll to - "+ScrollText+" -  Succesfully");
	}

}
