package util.Common;

import java.util.Set;

public class ChromeBase  extends BaseClass{
	
	protected String Context_Native = "NATIVE_APP";
	protected String Context_WebView = "WEBVIEW_chrome";
	
	public void open(String browseURL) {
		driver.get(browseURL);
		logUtil.logE("Opened URL : "+browseURL);
	}
	
	public void clearChromeTabs() {
		String xpath1 = "//*[@resource-id=\"com.android.chrome:id/tab_switcher_button\"]";
		String xpath2 = "//*[@resource-id=\"com.android.chrome:id/menu_button_wrapper\"]";
		String xpath3 = "//*[@content-desc=\"Close all tabs\"]";

		driver.findElementByXPath(xpath1).click();
		driver.findElementByXPath(xpath2).click();
		driver.findElementByXPath(xpath3).click();
	}
	
	public void SwitchWebview() {
		while(true) {
			Set<String> contextHandles = driver.getContextHandles();
			if(contextHandles.contains(Context_WebView)) {
				driver.context(Context_WebView);
				break;
			}
		}
		
		logUtil.logE("Switched to "+Context_WebView+" Succesfully");
	}
	public void SwitchNative() {
		while(true) {
			Set<String> contextHandles = driver.getContextHandles();
			if(contextHandles.contains(Context_Native)) {
				driver.context(Context_Native);
				break;
			}
		}
		
		logUtil.logE("Switched to "+Context_Native+" Succesfully");
	}
	
	

}

