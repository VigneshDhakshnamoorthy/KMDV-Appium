package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class HomePage {
	private AppiumDriver<MobileElement> driver;

	public HomePage(AppiumDriver<MobileElement> driver){
		this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		
	}
	

	private By getStartedBtn = By.xpath("//android.widget.TextView[@text='Get Started']");
	private By continueBtn = By.xpath("//android.widget.TextView[@text='Endelea']");
	private By loginRegisterTab = By.xpath("//android.widget.Button[5]/android.view.ViewGroup");
	
	public void clickGetStarted() {
		driver.findElement(getStartedBtn).click();
		
	}
	
	public void clickcontinueBtn() {
		driver.findElement(continueBtn).click();

	}
	
	public void clickloginRegisterTab() {
		driver.findElement(loginRegisterTab).click();

	}
	
	
	
	
	
	
}
