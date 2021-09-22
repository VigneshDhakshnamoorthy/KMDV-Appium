package commonUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ComUtil {

	protected AppiumDriver<MobileElement> driver;
	
	public void log(String LogMessage) {
		System.out.println(LogMessage);
	}

}
