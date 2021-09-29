package pageObjects.azamTV;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Base.BaseClass;

public class RegisterTabPage  extends BaseClass{

	public RegisterTabPage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	private By pageLoad = By.xpath("//android.widget.TextView[@text='Your phone number']");
	private By phonenumberBox = By.xpath("//android.widget.EditText");
	private By registerContinueButton = By.xpath("//android.widget.TextView[@text='Continue']");


	public boolean isPageLoaded() {
		boolean IsPageLoaded = driver.findElement(pageLoad).getText().toString().equals("Your phone number");
		if (IsPageLoaded ) {
			log("Loaded Register Page Succesfully");
		}else {
			log("Error : Register Page Not Loaded");

		}
		return IsPageLoaded;

	}
	
	public void enterPhonenumber(String phnum) {
		driver.findElement(phonenumberBox).click();
		driver.findElement(phonenumberBox).sendKeys(phnum);
		log("Entered New Register Number - "+phnum+" - Succesfully");

	}
	
	public void clickContinue() {
		driver.findElement(registerContinueButton).click();
		log("Clicked Continue Button Succesfully");

	}
	
	public void enterOTP(String OTP) {
		char[] ch = OTP.toCharArray();
		for (int i =1 ; i<=ch.length;i++)
		{
		By otpBox = By.xpath("//android.view.ViewGroup["+i+"]/android.widget.EditText");
		String otp = String.valueOf(ch[i-1]);
		driver.findElement(otpBox).click();
		driver.findElement(otpBox).sendKeys(otp);
		}
		log("Entered OTP - "+OTP+" -  Succesfully");

	}

}
