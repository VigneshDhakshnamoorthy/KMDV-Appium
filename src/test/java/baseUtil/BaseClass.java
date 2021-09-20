package baseUtil;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseClass {
	
	
		protected String IPAddress = "127.0.0.1";
		protected int Port = 4723;
		
		protected String URLAddress = "http://localhost:4723/wd/hub";

		protected DesiredCapabilities AppiumCap,PlatformCap;
		protected AppiumDriverLocalService AppiumService;
		protected AppiumServiceBuilder AppiumBuilder;
		protected AppiumDriver<MobileElement> driver;
		
		protected File classPathRoot = new File(System.getProperty("user.dir"));
		protected File appRoot = new File(classPathRoot,"src/test/resources/APK");
		protected File app;

		
		protected String emulator = "emulator-5554";
		protected String avdName= "Pixel";
		
		public DesiredCapabilities platformCapabilities(String platForm) {
			
			if (platForm == "Android" ) {
				app = new File(appRoot,"AzamTV.apk");
				PlatformCap = new DesiredCapabilities();
				PlatformCap.setCapability("platformName", "Android");
				PlatformCap.setCapability("platformVersion", "11.0");
				PlatformCap.setCapability("deviceName","emulator-5554" );
				PlatformCap.setCapability("app", app.getAbsolutePath());
				PlatformCap.setCapability("appPackage", "com.azamtv.max.media");
				PlatformCap.setCapability("appActivity", "com.azamtv.max.media.MainActivity");
			}

			return PlatformCap;
		}
		
	
		@BeforeTest(alwaysRun=true)
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
			
			
			//Initiate the AppiumDriver			
			URL Url = new URL(URLAddress);
			driver = new AppiumDriver<MobileElement>(Url,platformCapabilities("Android"));
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		}
		

		
		
		@AfterTest(alwaysRun=true)
		protected void tearDown() throws Throwable {
			driver.quit();
			AppiumService.stop();
			String StopEmulator = "adb -s "+emulator+" emu kill";
			Runtime.getRuntime().exec(StopEmulator);
		}
		
}

