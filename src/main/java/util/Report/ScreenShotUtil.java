package util.Report;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import util.Common.BaseClass;

public class ScreenShotUtil extends BaseClass{
	private static String screenshotType= "png";
	private File screenShot,screenShotLocation;
	
	public void ExtentShot(String testStatus) {
		screenShotLocation = new File(pathUtil.getScreenshotPath(BaseResult.getName()+"."+screenshotType));
		screenShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, screenShotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logUtil.logC("Screenshot Taken : "+screenShotLocation.getAbsolutePath());
		ERU.ExtentScreenShot(testStatus,screenShotLocation.getAbsolutePath());

	}
}
