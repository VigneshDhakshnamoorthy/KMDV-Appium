package baseUtil;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.testng.Reporter;

public class BaseClass {

	protected String IPAddress = "127.0.0.1";
	protected int Port = 4723;

	protected String URLAddress = "http://localhost:4723/wd/hub";

	protected DesiredCapabilities AppiumCap,PlatformCap;
	protected AppiumDriverLocalService AppiumService;
	protected AppiumServiceBuilder AppiumBuilder;
	protected static AppiumDriver<MobileElement> driver;

	protected File classPathRoot = new File(System.getProperty("user.dir"));
	protected File resourcesRoot = new File(classPathRoot,"src/test/resources");
	protected String appPackage="com.azamtv.max.media";
	protected String appActivity="com.azamtv.max.media.MainActivity";
	protected String appName="AzamTV.apk";
	protected String runApp;

	protected String emulator = "emulator-5554";
	protected String avdName= "Pixel";

	public DesiredCapabilities platformCapabilities(String platForm, String version) {

		if (platForm == "Android" ) {
			PlatformCap = new DesiredCapabilities();
			PlatformCap.setCapability("platformName", platForm);
			PlatformCap.setCapability("platformVersion", version);
			PlatformCap.setCapability("deviceName", emulator);
			PlatformCap.setCapability("app", getAppPath(appName));
			PlatformCap.setCapability("appPackage", appPackage);
			PlatformCap.setCapability("appActivity", appActivity);
		}

		return PlatformCap;
	}


	@BeforeSuite(alwaysRun=true)
	protected void setup() throws Throwable {
		String StartEmulator= "emulator -avd "+avdName+" -netdelay none -netspeed full";
		Runtime.getRuntime().exec(StartEmulator);

		//Set Capabilities
		AppiumCap = new DesiredCapabilities();
		AppiumCap.setCapability("noReset", "false");

		//Build the Appium service
		AppiumBuilder = new AppiumServiceBuilder();
		AppiumBuilder.withIPAddress(IPAddress);
		AppiumBuilder.usingPort(Port);
		AppiumBuilder.withCapabilities(AppiumCap);
		AppiumBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		AppiumBuilder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

		//Start the server with the builder
		AppiumService = AppiumDriverLocalService.buildService(AppiumBuilder);
		AppiumService.start();


		

	}
	
	@BeforeMethod(alwaysRun=true)
	protected void appOpen() throws MalformedURLException {
		//Initiate the AppiumDriver			
			URL Url = new URL(URLAddress);
			driver = new AppiumDriver<MobileElement>(Url,platformCapabilities("Android", "11.0"));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun=true)
	protected void appClose() throws MalformedURLException {
		//Close the AppiumDriver			
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

	public void log(String LogMessage) {
		Reporter.log(LogMessage);
		System.out.println(LogMessage);
	}		
	
	public String getAppPath(String AppName){
		File app= new File(resourcesRoot,"/APK/"+AppName);
		return app.getAbsolutePath();

	}
	
	public String getExcelPath(String ExcelName){
		File app= new File(resourcesRoot,"/ExcelData/"+ExcelName);
		return app.getAbsolutePath();

	}
	
}

