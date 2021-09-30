package util.Common;

import java.util.Set;

import io.appium.java_client.MobileBy;

public class ActionClass extends BaseClass {
	protected String Context_Native = "NATIVE_APP";
	protected String Context_WebView = "WEBVIEW_chrome";

 
	public void isWebviewEnabled() {
		while(true) {
			Set<String> contextHandles = driver.getContextHandles();
			if(contextHandles.contains(Context_WebView)) {
				break;
			}
		}
	}
	
	public void SwitchWebview() {
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
		driver.findElement(MobileBy.AndroidUIAutomator(
	    		"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+ScrollText+"\").instance(0))"));
		logUtil.logE("Scroll to - "+ScrollText+" -  Succesfully");
	}
	
}
