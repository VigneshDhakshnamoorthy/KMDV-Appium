package util.Base;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import util.Capability.DesiredCapabilityUtil;

import org.testng.ITestResult;
import org.testng.Reporter;

public class BaseClass {
	protected static File classPathRoot = new File(System.getProperty("user.dir"));
	protected static File resourcesRoot = new File(classPathRoot,"src/test/resources");
	protected static File screenShotRoot = new File(classPathRoot,"/ScreenShot/");

	protected AppiumDriverLocalService AppiumService;
	protected static AppiumDriver<MobileElement> driver;
	private static DesiredCapabilityUtil desireCap;

	protected static String emulator;
	protected static String avdName;
	protected String APPName;


	@BeforeSuite(alwaysRun=true)
	protected void setup() throws Throwable {
		desireCap= new DesiredCapabilityUtil();
		emulator = desireCap.emulatorID();
		avdName = desireCap.avdName();
		String StartEmulator= "emulator -avd "+avdName+" -netdelay none -netspeed full";
		Runtime.getRuntime().exec(StartEmulator);

		//Start the server with the builder
		AppiumService = AppiumDriverLocalService.buildService(desireCap.Appium());
		AppiumService.start();

	}
	
	public void appOpen(String appName) throws Exception {
		APPName = appName;
		//Initiate the AppiumDriver			
			driver = new AppiumDriver<MobileElement>(desireCap.Url(),desireCap.App(appName));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			log(APPName+" - Aplication is Opening");
	}
	
	
	@AfterMethod(alwaysRun=true)
	protected void appClose(){
		//Close the AppiumDriver	
		log(APPName+" - Aplication is Closing");
		driver.quit();
			
	}
	

	@AfterSuite(alwaysRun=true)
	protected void tearDown() throws Throwable {
		
		//Stop the AppiumServer			
		AppiumService.stop();

		// Close the Emulator
		String StopEmulator = "adb -s "+emulator+" emu kill";
		Runtime.getRuntime().exec(StopEmulator);
	}

	public static void log(String LogMessage) {
		Reporter.log(LogMessage);
		System.out.println(LogMessage);
	}		
	
	public String getAppPath(String AppName){
		File app= new File(resourcesRoot,"/APK/"+AppName);
		return app.getAbsolutePath();

	}
	
	public static String getPropertyPath(String PropertyName){
		File property= new File(resourcesRoot,"/Properties/"+PropertyName);
		return property.getAbsolutePath();

	}
	
	public String getExcelPath(String ExcelName){
		File excel= new File(resourcesRoot,"/ExcelData/"+ExcelName);
		return excel.getAbsolutePath();

	}
	
	protected String Context_Native = "NATIVE_APP";
	protected String Context_WebView = "WEBVIEW_chrome";

 
	public String getDriverPath(String browser){
		File browserdriver= new File(resourcesRoot,"/WebDriver/"+browser);
		return browserdriver.getAbsolutePath();

	}
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
		log("Switched to "+Context_WebView+" Succesfully");


	}
	public void SwitchNative() {
		driver.context(Context_Native);
		log("Switched to "+Context_Native+" Succesfully");


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
		log("Scroll to - "+ScrollText+" -  Succesfully");
	}
	
	protected static ITestResult BaseResult;
	public void AppScreenShot() {
		File screenShotLocation= new File(screenShotRoot,BaseResult.getName()+".jpg");
		File screenShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, screenShotLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log("Screenshot Taken : "+screenShotLocation.getAbsolutePath());
	}
	
}
		
	


