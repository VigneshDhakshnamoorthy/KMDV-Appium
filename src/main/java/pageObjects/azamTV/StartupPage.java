package pageObjects.azamTV;

import org.openqa.selenium.By;
import util.Common.BaseClass;

public class StartupPage  extends BaseClass{
	
	private By getStartedBtn = By.xpath("//android.widget.TextView[@text='Get Started']");
	private By englishLanguageBtn = By.xpath("//android.widget.TextView[@text='English']");
	private By continueBtn = By.xpath("//android.widget.TextView[@text='Continue']");
	
	public void clickGetStarted() {
		driver.findElement(getStartedBtn).click();
		logUtil.logE("Clicked Get Started Button Succesfully");
		
		
	}
	
	public void clickenglishLanguageBtn() {
		driver.findElement(englishLanguageBtn).click();
		logUtil.logE("Clicked English Language Button Succesfully");

		
	}
	
	public void clickcontinueBtn() {
		driver.findElement(continueBtn).click();
		logUtil.logE("Clicked Continue Button Succesfully");


	}
	
}
