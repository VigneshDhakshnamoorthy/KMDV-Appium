package util.Report;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import util.Common.BaseClass;

public class ScreenShotUtil extends BaseClass{

	public void ExtentShot(String testStatus) {
		((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String DateTime = new java.util.Date().toString().replace(":", "-");
		String Time = DateTime.substring(11, DateTime.length() - 9);

		File screenShotLocation = new File(pathUtil.getScreenshotPath(BaseResult.getName()+" "+Time+".png"));
		try {
			File screenShot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenShot, screenShotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ERU.ExtentScreenShot(testStatus,screenShotLocation.getAbsolutePath());
		logUtil.logC("Screenshot Taken : "+screenShotLocation.getAbsolutePath());

	}
	
}
