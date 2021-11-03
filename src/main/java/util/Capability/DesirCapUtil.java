package util.Capability;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;

import util.Common.BaseClass;
import util.Data.PropertiesUtil;

public class DesirCapUtil extends BaseClass{
	private  DesiredCapabilities PlatformCap;
	private  String URLAddress;


	public DesiredCapabilities App(AppDir aPPName) {
		
		switch (aPPName) {
		
		case Azam:
			setDesireCap("azamTv.properties");
			break;
		
		case ApkInfo:
			setDesireCap("apkinfo.properties");
			break;
			
		case Chrome:
			setDesireCap("chrome.properties");
			break;
		
		default:
			logUtil.logC("Provide Proper App Name");
			
		}

		return PlatformCap;
	}
	
	
	public URL Url() {
		prop = new PropertiesUtil("appiumserver.properties");
		URLAddress = prop.getValue("URLAddress");
		URL Url = null;
		try {
			Url = new URL(URLAddress);
		} catch (MalformedURLException e) {
		}
		return Url;
	}
	
	
	public void setDesireCap(String appProperty) {
		prop = new PropertiesUtil(appProperty);
		PlatformCap = new DesiredCapabilities();
		Set<Object> allPropertyKeys = prop.getKeys();
		PlatformCap.setCapability("deviceName", emulator);
		for (Object propKey:allPropertyKeys)
		{
		if (propKey.toString().equalsIgnoreCase("app")) {
			PlatformCap.setCapability(propKey.toString(),pathUtil.getAppPath(prop.getValue(propKey.toString())));
		}
		else if(propKey.toString().equalsIgnoreCase("chromedriverExecutable")){
			PlatformCap.setCapability(propKey.toString(),pathUtil.getDriverPath(prop.getValue(propKey.toString())));
		}
		else 
		{
			PlatformCap.setCapability(propKey.toString(),prop.getValue(propKey.toString()));
		}
		}
	}
}
