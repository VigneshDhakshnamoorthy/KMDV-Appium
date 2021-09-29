package util.Capability;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import util.Base.BaseClass;

public class DesiredCapabilityUtil extends BaseClass{
	public  DesiredCapabilities PlatformCap,AppiumCap;
	public  PropertiesUtil prop;
	protected AppiumServiceBuilder AppiumBuilder;
	protected static String URLAddress;


	public DesiredCapabilities App(String AppName) throws Exception {
		
		switch (AppName) {
		
		case "Azam":
			prop = new PropertiesUtil("azamTv.properties");
			PlatformCap = new DesiredCapabilities();
			PlatformCap.setCapability("platformName", prop.getAppProperty("platformName"));
			PlatformCap.setCapability("platformVersion", prop.getAppProperty("platformVersion"));
			PlatformCap.setCapability("deviceName", emulator);
			PlatformCap.setCapability("app", getAppPath("AzamTV.apk"));
			PlatformCap.setCapability("appPackage", prop.getAppProperty("appPackage"));
			PlatformCap.setCapability("appActivity", prop.getAppProperty("appActivity"));
			PlatformCap.setCapability("noReset", prop.getAppProperty("noReset"));
			break;
		
		case "ApkInfo":
			prop = new PropertiesUtil("apkinfo.properties");
			PlatformCap = new DesiredCapabilities();
			PlatformCap.setCapability("platformName", prop.getAppProperty("platformName"));
			PlatformCap.setCapability("platformVersion", prop.getAppProperty("platformVersion"));
			PlatformCap.setCapability("deviceName", emulator);
			PlatformCap.setCapability("app", getAppPath("APKinfo.apk"));
			PlatformCap.setCapability("appPackage", prop.getAppProperty("appPackage"));
			PlatformCap.setCapability("appActivity", prop.getAppProperty("appActivity"));
			PlatformCap.setCapability("noReset", prop.getAppProperty("noReset"));
			break;
			
		case "Chrome":
			prop = new PropertiesUtil("chrome.properties");
			PlatformCap = new DesiredCapabilities();
			PlatformCap.setCapability("platformName", prop.getAppProperty("platformName"));
			PlatformCap.setCapability("platformVersion", prop.getAppProperty("platformVersion"));
			PlatformCap.setCapability("deviceName", emulator);
			PlatformCap.setCapability("appPackage", prop.getAppProperty("appPackage"));
			PlatformCap.setCapability("appActivity", prop.getAppProperty("appActivity"));
			PlatformCap.setCapability("chromedriverExecutable",getDriverPath("chromedriver.exe"));
			PlatformCap.setCapability("noReset", prop.getAppProperty("noReset"));
			break;
		
		default:
			throw new Exception("Provide Proper App Name");
			
		}

		return PlatformCap;
	}
	
	public AppiumServiceBuilder Appium() throws Exception {
		prop = new PropertiesUtil("appiumserver.properties");

		//Set Capabilities
		AppiumCap = new DesiredCapabilities();
		AppiumCap.setCapability("noReset", prop.getAppProperty("noReset"));

		//Build the Appium service
		AppiumBuilder = new AppiumServiceBuilder();
		AppiumBuilder.withIPAddress(prop.getAppProperty("IPAddress"));
		AppiumBuilder.usingPort(Integer.parseInt(prop.getAppProperty("Port")));
		AppiumBuilder.withCapabilities(AppiumCap);
		AppiumBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		AppiumBuilder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		
		return AppiumBuilder;
		
	}
	
	public URL Url() throws Exception {
		prop = new PropertiesUtil("appiumserver.properties");
		URLAddress = prop.getAppProperty("URLAddress");
		URL Url = new URL(URLAddress);
		return Url;

	}
	
	public String emulatorID() throws Exception {
		prop = new PropertiesUtil("appiumserver.properties");
		return prop.getAppProperty("emulator");
		
	}
	
	public String avdName() throws Exception {
		prop = new PropertiesUtil("appiumserver.properties");
		return prop.getAppProperty("avdName");
		
	}
	
}
