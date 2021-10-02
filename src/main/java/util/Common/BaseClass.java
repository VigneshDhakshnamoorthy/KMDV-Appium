package util.Common;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import util.Capability.DesirCapUtil;
import util.Capability.EmulatorUtil;
import util.Capability.PathUtil;
import util.Data.LogUtil;
import util.Report.ExtentReportUtil;
import util.Report.ScreenShotUtil;

import org.testng.ITestResult;

public class BaseClass {
	
	protected static EmulatorUtil emuUtil = new EmulatorUtil();
	protected static AppiumDriverLocalService AppiumService;
	protected static AppiumDriver<MobileElement> driver;
	protected static PathUtil pathUtil= new PathUtil();
	protected static DesirCapUtil desireCap = new DesirCapUtil();
	protected static ExtentReportUtil ERU= new ExtentReportUtil();
	protected static ScreenShotUtil screenShotUtil= new ScreenShotUtil();
	protected static LogUtil logUtil= new LogUtil();

	protected static ActionClass actionClass= new ActionClass();

	protected static String emulator;
	protected static String avdName;
	protected String APPName;
	protected static ITestResult BaseResult;

	@BeforeSuite(alwaysRun=true)
	protected void setup() throws Throwable {
		emulator = desireCap.emulatorID();
		avdName = desireCap.avdName();
		
		//Start the emulator 
		
		emuUtil.startEmulator(avdName);

		//Start the server with the builder
			AppiumService = AppiumDriverLocalService.buildService(desireCap.Appium());
			AppiumService.start();

	}
	
	public void appOpen(String appName) throws Exception {
		APPName = appName;
		//Initiate the AppiumDriver			
			driver = new AppiumDriver<MobileElement>(desireCap.Url(),desireCap.App(appName));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			logUtil.logE(APPName+" - Aplication is Opening");
	}
	
	
	@AfterMethod(alwaysRun=true)
	protected void appClose(){
		//Close the AppiumDriver	
			logUtil.logE(APPName+" - Aplication is Closing");
			driver.quit();
			
	}
	

	@AfterSuite(alwaysRun=true)
	protected void tearDown() throws Throwable {
		
		//Stop the AppiumServer			
			AppiumService.stop();

		// Close the Emulator
			emuUtil.stopEmulator(emulator);
	}

	
}
		
	


