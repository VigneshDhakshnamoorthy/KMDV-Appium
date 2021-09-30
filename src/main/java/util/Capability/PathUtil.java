package util.Capability;

import java.io.File;

import util.Common.BaseClass;

public class PathUtil extends BaseClass {
	public File classPathRoot = new File(System.getProperty("user.dir"));
	public File resourcesRoot = new File(classPathRoot,"src/test/resources");
	public File screenShotRoot = new File(classPathRoot,"/Report-ScreenShot/ScreenShots/");
	
	public String getAppPath(String AppName){
		File app= new File(resourcesRoot,"/APK/"+AppName);
		return app.getAbsolutePath();

	}
	
	public String getPropertyPath(String PropertyName){
		File property= new File(resourcesRoot,"/Properties/"+PropertyName);
		return property.getAbsolutePath();

	}
	
	public String getExcelPath(String ExcelName){
		File excel= new File(resourcesRoot,"/ExcelData/"+ExcelName);
		return excel.getAbsolutePath();

	}
	

	public String getDriverPath(String browser){
		File browserdriver= new File(resourcesRoot,"/WebDriver/"+browser);
		return browserdriver.getAbsolutePath();

	}
	
}
