package util.Capability;

import org.openqa.selenium.remote.DesiredCapabilities;

import util.Base.BaseClass;

public class DesiredCapabilityUtil{
	public  DesiredCapabilities PlatformCap;
	public  PropertiesUtil prop;

	public DesiredCapabilities desireCapability(String AppName) throws Exception {
		BaseClass bs = new BaseClass();
		
		switch (AppName) {
		
		case "Azam":
			prop = new PropertiesUtil("azamTv.properties");
			PlatformCap = new DesiredCapabilities();
			PlatformCap.setCapability("platformName", prop.getAppProperty("platformName"));
			PlatformCap.setCapability("platformVersion", prop.getAppProperty("platformVersion"));
			PlatformCap.setCapability("deviceName", bs.emulator);
			PlatformCap.setCapability("app", bs.getAppPath("AzamTV.apk"));
			PlatformCap.setCapability("appPackage", prop.getAppProperty("appPackage"));
			PlatformCap.setCapability("appActivity", prop.getAppProperty("appActivity"));
			PlatformCap.setCapability("noReset", prop.getAppProperty("noReset"));
			break;
		
		case "ApkInfo":
			prop = new PropertiesUtil("apkinfo.properties");
			PlatformCap = new DesiredCapabilities();
			PlatformCap.setCapability("platformName", prop.getAppProperty("platformName"));
			PlatformCap.setCapability("platformVersion", prop.getAppProperty("platformVersion"));
			PlatformCap.setCapability("deviceName", bs.emulator);
			PlatformCap.setCapability("app", bs.getAppPath("APKinfo.apk"));
			PlatformCap.setCapability("appPackage", prop.getAppProperty("appPackage"));
			PlatformCap.setCapability("appActivity", prop.getAppProperty("appActivity"));
			PlatformCap.setCapability("noReset", prop.getAppProperty("noReset"));
			break;
			
		case "Chrome":
			prop = new PropertiesUtil("chrome.properties");
			PlatformCap = new DesiredCapabilities();
			PlatformCap.setCapability("platformName", prop.getAppProperty("platformName"));
			PlatformCap.setCapability("platformVersion", prop.getAppProperty("platformVersion"));
			PlatformCap.setCapability("deviceName", bs.emulator);
			PlatformCap.setCapability("appPackage", prop.getAppProperty("appPackage"));
			PlatformCap.setCapability("appActivity", prop.getAppProperty("appActivity"));
			PlatformCap.setCapability("chromedriverExecutable",bs.getDriverPath("chromedriver.exe"));
			PlatformCap.setCapability("noReset", prop.getAppProperty("noReset"));
			break;
		
		default:
			throw new Exception("Provide Proper App Name");
			
		}

		return PlatformCap;
	}
	
	
}
