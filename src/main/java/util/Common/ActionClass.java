package util.Common;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

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
	
	public boolean WaitElement(By by, int Seconds) {
		for (int i =1; i<=Seconds*1000 ; i++) {
			if (driver.findElement(by).isDisplayed()){
				return true;
			}else {
				WaitMilliSec(1);
			}
		}
		return false;
	}
	public void WaitUnlimit(By by) {
		while(true) {
			if(driver.findElement(by).isDisplayed()) {
				break;
			}
		}
	}
	public void ClickElement(By by) {
		if(WaitElement(by,60)) {
			driver.findElement(by).click();
		}else {
			logUtil.logE("Element Not Found :  "+by);
		}
	}
	
	public void TypeinElement(By by, String Value) {
		if(WaitElement(by,60)) {
			driver.findElement(by).sendKeys(Value);
		}else {
			logUtil.logE("Element Not Found :  "+by);
		}
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
	
	public void SwipeTo(By by) {
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		scrollObject.put("element", ((RemoteWebElement) driver.findElement(by)).getId());
		js.executeScript("mobile: scroll", scrollObject);
	}

}
