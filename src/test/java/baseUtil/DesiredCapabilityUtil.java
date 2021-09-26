package baseUtil;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DesiredCapabilityUtil{
	public static DesiredCapabilities PlatformCap;
	public static PropertiesUtil prop;

	public DesiredCapabilities desireCapability(String AppName) throws Exception {
		BaseClass bs = new BaseClass();
		
		switch (AppName) {
		
		case "Azam":
			prop = new PropertiesUtil("azamTv.properties");
			PlatformCap = new DesiredCapabilities();
			PlatformCap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getAppProperty("platformName"));
			PlatformCap.setCapability(MobileCapabilityType.VERSION, prop.getAppProperty("platformVersion"));
			PlatformCap.setCapability(MobileCapabilityType.DEVICE_NAME, bs.emulator);
			PlatformCap.setCapability(MobileCapabilityType.APP, bs.getAppPath("AzamTV.apk"));
			PlatformCap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getAppProperty("appPackage"));
			PlatformCap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getAppProperty("appActivity"));
			break;
		
		case "ApkInfo":
			prop = new PropertiesUtil("apkinfo.properties");
			PlatformCap = new DesiredCapabilities();
			PlatformCap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getAppProperty("platformName"));
			PlatformCap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getAppProperty("platformVersion"));
			PlatformCap.setCapability(MobileCapabilityType.DEVICE_NAME, bs.emulator);
			PlatformCap.setCapability(MobileCapabilityType.APP, bs.getAppPath("APKinfo.apk"));
			PlatformCap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getAppProperty("appPackage"));
			PlatformCap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getAppProperty("appActivity"));
			break;
			
		case "Chrome":
			prop = new PropertiesUtil("chrome.properties");
			PlatformCap = new DesiredCapabilities();
			PlatformCap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getAppProperty("platformName"));
			PlatformCap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getAppProperty("platformVersion"));
			PlatformCap.setCapability(MobileCapabilityType.DEVICE_NAME, bs.emulator);
			PlatformCap.setCapability(MobileCapabilityType.NO_RESET, "true");
			PlatformCap.setCapability(MobileCapabilityType.FULL_RESET, "false");
			PlatformCap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getAppProperty("appPackage"));
			PlatformCap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getAppProperty("appActivity"));
			break;
		
		default:
			throw new Exception("Provide Proper App Name");
			
		}

		return PlatformCap;
	}
	
	
}
