package util.Common;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

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
		
		logUtil.logE("Switched to WEBVIEW Succesfully");
	}
	
	public void SwitchNative() {
		while(true) {
			Set<String> contextHandles = driver.getContextHandles();
			if(contextHandles.contains(Context_Native)) {
				driver.context(Context_Native);
				break;
			}
		}
		
		logUtil.logE("Switched to NATIVE Succesfully");
	}
	public void jseClickEle(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if(actionClass.WaitForElement(by,60)) {
            js.executeScript("arguments[0].click();", driver.findElement(by));
		}else {
			logUtil.logE("Element Not Found :  "+by);
		}
	}
	
	public boolean jseWaitPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean bool=false;
        while(bool==false) {
            bool = js.executeScript("return document.readyState").equals("complete");
        }
        return bool;
	}
	
	public void jseScrolltoEle(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if(actionClass.WaitForElement(by,60)) {
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(by));
		}else {
			logUtil.logE("Element Not Found :  "+by);
		}
	}
	
	public void jseScrollbyDim(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        logUtil.logE("Scroll By X : "+x+" | Y : "+y);
        
	}
	
	

}

