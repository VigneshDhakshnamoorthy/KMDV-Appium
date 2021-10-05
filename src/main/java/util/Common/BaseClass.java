package util.Common;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import util.Capability.AppiumServerUtil;
import util.Capability.DesirCapUtil;
import util.Capability.EmulatorUtil;
import util.Capability.PathUtil;
import util.Data.ExcelUtil;
import util.Data.PropertiesUtil;
import util.Report.ExtentReportUtil;
import util.Report.LogUtil;
import util.Report.ScreenShotUtil;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class BaseClass implements ITestListener{
	
	protected static PropertiesUtil prop;
	protected static EmulatorUtil emuUtil = new EmulatorUtil();
	protected static AppiumServerUtil appiumUtil = new AppiumServerUtil();
	protected static AppiumDriver<MobileElement> driver;
	
	protected static PathUtil pathUtil= new PathUtil();
	protected static DesirCapUtil desireCap = new DesirCapUtil();
	protected static LogUtil logUtil= new LogUtil();
	protected static ExtentReportUtil ERU= new ExtentReportUtil();
	protected static ActionClass actionClass= new ActionClass();
	protected static ScreenShotUtil screenShotUtil= new ScreenShotUtil();
	protected static ExcelUtil xlutil;

	protected static String emulator;
	protected static String avdName;
	protected static ITestResult BaseResult;
	protected String APPName;

	@BeforeSuite(alwaysRun=true)
	protected void setup() throws Throwable {
		emulator = desireCap.emulatorID();
		avdName = desireCap.avdName();
		
		//Start the emulator 
			emuUtil.startEmulator(avdName);

		//Start the server with the builder
			appiumUtil.startServer();
		
		//Start Extent Report
	    	ERU.StartExtentReport();


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
		//Stop Extent Report
    		ERU.EndExtentReport();

		//Stop the AppiumServer			
    		appiumUtil.stopServer();

		// Close the Emulator
			emuUtil.stopEmulator(emulator);
	}

	
	
}
		
	


