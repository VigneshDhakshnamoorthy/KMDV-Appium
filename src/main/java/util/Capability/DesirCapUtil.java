package util.Capability;

import java.net.URL;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import util.Common.BaseClass;
import util.Data.PropertiesUtil;

public class DesirCapUtil extends BaseClass{
	public  DesiredCapabilities PlatformCap,AppiumCap;
	public  PropertiesUtil prop;
	protected AppiumServiceBuilder AppiumBuilder;
	protected static String URLAddress;


	public DesiredCapabilities App(String AppName) throws Exception {
		
		switch (AppName) {
		
		case "Azam":
			setDesireCap("azamTv.properties");
			break;
		
		case "ApkInfo":
			setDesireCap("apkinfo.properties");
			break;
			
		case "Chrome":
			setDesireCap("chrome.properties");
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
	
	public void setDesireCap(String appProperty) throws Exception {
		prop = new PropertiesUtil(appProperty);
		PlatformCap = new DesiredCapabilities();
		Set<Object> allPropertyKeys = prop.getAllPropertyKeys();
		PlatformCap.setCapability("deviceName", emulator);
		for (Object propKey:allPropertyKeys)
		{
		if (propKey.toString().equalsIgnoreCase("app")) {
			PlatformCap.setCapability(propKey.toString(),pathUtil.getAppPath(prop.getAppProperty(propKey.toString())));
		}
		else if(propKey.toString().equalsIgnoreCase("chromedriverExecutable")){
			PlatformCap.setCapability(propKey.toString(),pathUtil.getDriverPath(prop.getAppProperty(propKey.toString())));
		}
		else 
		{
			PlatformCap.setCapability(propKey.toString(),prop.getAppProperty(propKey.toString()));
		}
		}
	}
	
}
