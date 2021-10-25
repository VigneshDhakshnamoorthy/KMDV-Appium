package pageObjects.azamTV;

import org.openqa.selenium.By;
import util.Common.BaseClass;

public class MoviesTabPage extends BaseClass {
	
	private By pageLoad = By.xpath("//android.widget.TextView[@text='MOVIES']");
	
			
	public boolean isPageLoaded() {
		boolean IsPageLoaded = driver.findElement(pageLoad).getText().toString().equals("MOVIES");
		if (IsPageLoaded ) {
			logUtil.logE("Loaded Movies Tab Succesfully");
		}else {
			logUtil.logE("Error : Movies Tab Not Loaded");

		}
		return IsPageLoaded;

	}
	
	public void clickAnymovies(String movienum) {
		By bongoMovies = By.xpath("(//android.view.ViewGroup["+movienum+"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView)[2]");
		driver.findElement(bongoMovies).click();
		logUtil.logE("Clicked Bongo Movies number - "+movienum+" Succesfully");

	}
}
