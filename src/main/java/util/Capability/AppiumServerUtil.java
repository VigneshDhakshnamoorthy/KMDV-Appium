package util.Capability;

import java.io.IOException;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import util.Common.BaseClass;
import util.Data.PropertiesUtil;

public class AppiumServerUtil  extends BaseClass{
	protected AppiumServiceBuilder AppiumBuilder;
	protected static AppiumDriverLocalService AppiumService;

	public void startServer() {
		try {
			prop = new PropertiesUtil("appiumserver.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}


		//Build the Appium service
		AppiumBuilder = new AppiumServiceBuilder();
		AppiumBuilder.withIPAddress(prop.getAppProperty("IPAddress"));
		AppiumBuilder.usingPort(Integer.parseInt(prop.getAppProperty("Port")));
		AppiumBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		AppiumBuilder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		AppiumService = AppiumDriverLocalService.buildService(AppiumBuilder);
		AppiumService.start();
	}
	
	public void stopServer() {
		AppiumService.stop();
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
