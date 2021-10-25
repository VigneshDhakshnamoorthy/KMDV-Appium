package pageObjects.azamTV;

import org.openqa.selenium.By;
import util.Common.BaseClass;

public class RegisterTabPage  extends BaseClass{

	private By pageLoad = By.xpath("//android.widget.TextView[@text='Your phone number']");
	private By phonenumberBox = By.xpath("//android.widget.EditText");
	private By registerContinueButton = By.xpath("//android.widget.TextView[@text='Continue']");
	private By ISDCodeButton = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]");
	private By ISDCodeSearch = By.xpath("//android.widget.EditText");

	public boolean isPageLoaded() {
		boolean IsPageLoaded = driver.findElement(pageLoad).getText().toString().equals("Your phone number");
		if (IsPageLoaded ) {
			logUtil.logE("Loaded Register Page Succesfully");
		}else {
			logUtil.logE("Error : Register Page Not Loaded");

		}
		return IsPageLoaded;

	}
	public void clickISDCodeButton() {
		driver.findElement(ISDCodeButton).click();
		logUtil.logE("Clicked ISDCode Button Succesfully");

	}
	public void enterISDCode(String ISDCode) {
		driver.findElement(ISDCodeSearch).sendKeys(ISDCode);
		actionClass.WaitSec(1);
		logUtil.logE("Entered ISDCode - "+ISDCode+" - Succesfully");
		By CountryButton = By.xpath("//android.widget.TextView[@text='"+ISDCode+"']");
		driver.findElement(CountryButton).click();
		actionClass.WaitSec(3);


	}
	
	public void enterPhonenumber(String phnum) {
		driver.findElement(phonenumberBox).click();
		driver.findElement(phonenumberBox).sendKeys(phnum);
		logUtil.logE("Entered New Register Number - "+phnum+" - Succesfully");

	}
	
	public void clickContinue() {
		driver.findElement(registerContinueButton).click();
		logUtil.logE("Clicked Continue Button Succesfully");

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
		logUtil.logE("Entered OTP - "+OTP+" -  Succesfully");

	}

}
