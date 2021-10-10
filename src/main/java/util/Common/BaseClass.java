package util.Common;


import org.testng.annotations.*;
import org.testng.ITestResult;

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


public class BaseClass{
	protected static InitiationClass init;
	protected static PropertiesUtil prop;
	protected static EmulatorUtil emuUtil;
	protected static AppiumServerUtil appiumUtil;
	protected static AppiumDriver<MobileElement> driver;
	
	protected static PathUtil pathUtil;
	protected static DesirCapUtil desireCap;
	protected static LogUtil logUtil;
	protected static ExtentReportUtil ERU;
	protected static ActionClass actionClass;
	protected static ExcelUtil xlutil;
	protected static ScreenShotUtil screenShotUtil;

	protected static String emulator;
	protected static String avdName;
	protected static ITestResult BaseResult;
	protected static String APPName;

	@BeforeSuite(alwaysRun=true)
	protected void setup() {
		//Initiate necessary classes
		init = new InitiationClass();
		init.InitiateClasses();
		
		//Start the emulator 
		emuUtil.startEmulator(avdName);

		//Start the server with the builder
		appiumUtil.startServer();
		
		//Start Extent Report
	    ERU.StartExtentReport();


	}
	
	public void appOpen(String appName) {
		//Initiate the AppiumDriver	
		APPName = appName;
		init.InitiateAppiumDriver(APPName);
	}
	
	
	@AfterMethod(alwaysRun=true)
	protected void appClose(){
		//Close the AppiumDriver	
		logUtil.logE(APPName+" - Aplication is Closing");
		driver.quit();
	}
	

	@AfterSuite(alwaysRun=true)
	protected void tearDown() {
		//Stop Extent Report
    	ERU.EndExtentReport();

		//Stop the AppiumServer			
    	appiumUtil.stopServer();

		// Close the Emulator
		emuUtil.stopEmulator(emulator);
	}

	
	
}
		
	


