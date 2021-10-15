package util.Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import util.Capability.AppiumServerUtil;
import util.Capability.DesirCapUtil;
import util.Capability.EmulatorUtil;
import util.Capability.PathUtil;
import util.Report.ExtentReportUtil;
import util.Report.LogUtil;
import util.Report.ScreenShotUtil;

public class InitiationClass extends BaseClass  {

	public void InitiateClasses() {
		emuUtil = new EmulatorUtil();
		appiumUtil = new AppiumServerUtil();
		pathUtil= new PathUtil();
		desireCap = new DesirCapUtil();
		logUtil= new LogUtil();
		ERU= new ExtentReportUtil();
		actionClass= new ActionClass();
		screenShotUtil= new ScreenShotUtil();
		js = (JavascriptExecutor) driver;
		
		try {
			emulator = desireCap.emulatorID();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			avdName = desireCap.avdName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void InitiateAppiumDriver(String appName) {
		driver = new AppiumDriver<MobileElement>(desireCap.Url(),desireCap.App(appName));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		logUtil.logE(appName+" - Aplication is Opening");
	}
	
	public void QuitDriver() {
		logUtil.logE(APPName+" - Aplication is Closing");
		driver.quit();
	}
}
