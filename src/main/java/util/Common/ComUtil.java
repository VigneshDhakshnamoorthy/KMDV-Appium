package util.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.File;

import org.testng.Reporter;

public class ComUtil {
	protected File classPathRoot = new File(System.getProperty("user.dir"));
	protected File resourcesRoot = new File(classPathRoot,"src/test/resources");
	protected AppiumDriver<MobileElement> driver;
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
