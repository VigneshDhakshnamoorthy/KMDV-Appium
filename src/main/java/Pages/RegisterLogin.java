package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class RegisterLogin {
	private AppiumDriver<MobileElement> driver;

	public RegisterLogin(AppiumDriver<MobileElement> driver){
		this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		
	}
	
	private By registerBtn = By.xpath("//android.view.ViewGroup[3]/android.widget.TextView");

	public void clickregisterBtn() {
		driver.findElement(registerBtn).click();

	}
}
