package baseUtil;

import java.io.File;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
	protected static RemoteWebDriver webdriver;

	protected static File classPathRoot = new File(System.getProperty("user.dir"));
	protected static File resourcesRoot = new File(classPathRoot,"src/test/resources");
	protected String appPackage="com.azamtv.max.media";
	public static PropertiesUtil prop;
	
	protected String emulator = "emulator-5554";
	protected String avdName= "Pixel";
	
	public DesiredCapabilityUtil desiredCap;

	public DesiredCapabilities appCapability(String AppName) throws Exception {

		DesiredCapabilityUtil desiredCapabilityUtil = new DesiredCapabilityUtil();
		return desiredCapabilityUtil.desireCapability(AppName);

	}


	@BeforeSuite(alwaysRun=true)
	protected void setup() throws Throwable {
		String StartEmulator= "emulator -avd "+avdName+" -netdelay none -netspeed full";
		Runtime.getRuntime().exec(StartEmulator);

		//Set Capabilities
		AppiumCap = new DesiredCapabilities();
		AppiumCap.setCapability("noReset", "true");

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
	
	public void appOpen(String appName) throws Exception {
		//Initiate the AppiumDriver			
			URL Url = new URL(URLAddress);
			driver = new AppiumDriver<MobileElement>(Url,appCapability(appName));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod(alwaysRun=true)
	protected void appClose(){
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
	public void clearChromeTabs() {
		String xpath1 = "//*[@resource-id=\"com.android.chrome:id/tab_switcher_button\"]";
		String xpath2 = "//*[@resource-id=\"com.android.chrome:id/menu_button_wrapper\"]";
		String xpath3 = "//*[@content-desc=\"Close all tabs\"]";
		
		driver.findElementByXPath(xpath1).click();
		driver.findElementByXPath(xpath2).click();
		driver.findElementByXPath(xpath3).click();
	}
	
	
}
		
	


