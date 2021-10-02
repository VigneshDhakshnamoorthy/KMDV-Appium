package util.Capability;

import java.io.File;

import util.Common.BaseClass;

public class PathUtil extends BaseClass {
	public File classPathRoot = new File(System.getProperty("user.dir"));
	public File resourcesRoot = new File(classPathRoot,"src/test/resources");
	public File RLCroot = new File(classPathRoot,"Report-Log-ScreenShot");

	public String getAppPath(String AppName){
		File app= new File(resourcesRoot,"APK/"+AppName);
		return app.getAbsolutePath();

	}
	
	public String getPropertyPath(String PropertyName){
		File property= new File(resourcesRoot,"Properties/"+PropertyName);
		return property.getAbsolutePath();

	}
	
	public String getExcelPath(String ExcelName){
		File excel= new File(resourcesRoot,"TestData/"+ExcelName);
		return excel.getAbsolutePath();

	}
	

	public String getDriverPath(String browser){
		File browserdriver= new File(resourcesRoot,"WebDriver/"+browser);
		return browserdriver.getAbsolutePath();

	}
	
	public String getExtentReportPath(String reportName) {
		File extentReport= new File(RLCroot,"ExtentReport/"+reportName);
		return extentReport.getAbsolutePath();

	}
	
	public String getScreenshotPath(String imageName) {
		File screenShot= new File(RLCroot,"ScreenShots/"+imageName);
		return screenShot.getAbsolutePath();

	}
	
	public String getLoggerPath(String logName) {
		File screenShot= new File(RLCroot,"Logs/"+logName);
		return screenShot.getAbsolutePath();

	}
	
}
