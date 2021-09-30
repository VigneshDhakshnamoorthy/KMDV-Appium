package pageObjects.azamTV;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Common.BaseClass;

public class MoviesTabPage extends BaseClass {
	public MoviesTabPage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
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
