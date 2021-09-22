package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import commonUtil.ComUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterPage  extends ComUtil{

	public RegisterPage(AppiumDriver<MobileElement> driver){
		this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	private By pageLoad = By.xpath("//android.widget.TextView[@text='Your phone number']");
	
	public boolean IsPageLoaded() {
		boolean IsPageLoaded = driver.findElement(pageLoad).getText().toString().equals("Your phone number");
		if (IsPageLoaded ) {
			log("Loaded Register Page Succesfully");
		}else {
			log("Error : Register Page Not Loaded");

		}
		return IsPageLoaded;

	}

}
