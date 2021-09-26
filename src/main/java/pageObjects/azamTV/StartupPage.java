package pageObjects.azamTV;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import commonUtil.ComUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StartupPage  extends ComUtil{
	public StartupPage(AppiumDriver<MobileElement> driver){
		this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	private By getStartedBtn = By.xpath("//android.widget.TextView[@text='Get Started']");
	private By englishLanguageBtn = By.xpath("//android.widget.TextView[@text='English']");
	private By continueBtn = By.xpath("//android.widget.TextView[@text='Continue']");
	
	public void clickGetStarted() {
		driver.findElement(getStartedBtn).click();
		log("Clicked Get Started Button Succesfully");
		
		
	}
	
	public void clickenglishLanguageBtn() {
		driver.findElement(englishLanguageBtn).click();
		log("Clicked English Language Button Succesfully");

		
	}
	
	public void clickcontinueBtn() {
		driver.findElement(continueBtn).click();
		log("Clicked Continue Button Succesfully");


	}
	
}
