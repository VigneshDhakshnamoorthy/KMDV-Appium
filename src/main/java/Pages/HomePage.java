package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import commonUtil.ComUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends ComUtil{

	public HomePage(AppiumDriver<MobileElement> driver){
		this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	

	private By getStartedBtn = By.xpath("//android.widget.TextView[@text='Get Started']");
	private By englishLanguageBtn = By.xpath("//android.widget.TextView[@text='English']");
	private By continueBtn = By.xpath("//android.widget.TextView[@text='Continue']");
	private By loginTab = By.xpath("//android.widget.Button[5]/android.view.ViewGroup");
	private By registerBtn = By.xpath("//android.widget.TextView[@text='Register']");
	private By signInBtn = By.xpath("//android.widget.TextView[@text='Sign in']");

	
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
	
	public void clickloginTab() {
		driver.findElement(loginTab).click();
		log("Clicked Login Button Succesfully");


	}
	
	public void clickregisterBtn() {
		driver.findElement(registerBtn).click();
		log("Clicked Register Button Succesfully");


	}
	
	public void clicksignInBtn() {
		driver.findElement(signInBtn).click();
		log("Clicked Sign In Button Succesfully");


	}
	
	
	
	
	
}
