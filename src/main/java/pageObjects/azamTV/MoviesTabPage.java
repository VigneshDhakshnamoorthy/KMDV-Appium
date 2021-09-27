package pageObjects.azamTV;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Common.ComUtil;

public class MoviesTabPage extends ComUtil {
	public MoviesTabPage(AppiumDriver<MobileElement> driver){
		this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
	private By pageLoad = By.xpath("//android.widget.TextView[@text='MOVIES']");
	
			
	public boolean isPageLoaded() {
		boolean IsPageLoaded = driver.findElement(pageLoad).getText().toString().equals("MOVIES");
		if (IsPageLoaded ) {
			log("Loaded Movies Tab Succesfully");
		}else {
			log("Error : Movies Tab Not Loaded");

		}
		return IsPageLoaded;

	}
	
	public void clickAnymovies(String movienum) {
		By bongoMovies = By.xpath("(//android.view.ViewGroup["+movienum+"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView)[2]");
		driver.findElement(bongoMovies).click();
		log("Clicked Bongo Movies number - "+movienum+" Succesfully");

	}
}
