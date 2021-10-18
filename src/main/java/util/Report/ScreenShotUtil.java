package util.Report;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import util.Common.BaseClass;

public class ScreenShotUtil extends BaseClass{

	public void ExtentShot(String testStatus) {
		File screenShotLocation = new File(pathUtil.getScreenshotPath(BaseResult.getName()+".png"));
		File screenShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenShot, screenShotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ERU.ExtentScreenShot(testStatus,screenShotLocation.getAbsolutePath());
		logUtil.logC("Screenshot Taken : "+screenShotLocation.getAbsolutePath());

	}
}
