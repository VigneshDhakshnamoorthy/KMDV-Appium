package testCase;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SauceLabsAzamTV {
	
	public static AppiumDriver<MobileElement> driver;
	private By getStartedBtn = By.xpath("//android.widget.TextView[@text='Get Started']");
	private By englishLanguageBtn = By.xpath("//android.widget.TextView[@text='English']");
	private By continueBtn = By.xpath("//android.widget.TextView[@text='Continue']");
	private By loginTab = By.xpath("//android.widget.Button[5]/android.view.ViewGroup");
	private By registerBtn = By.xpath("//android.widget.TextView[@text='Register']");
	private By phonenumberBox = By.xpath("//android.widget.EditText");
	private By registerContinueButton = By.xpath("//android.widget.TextView[@text='Continue']");
	private By ISDCodeButton = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]");
	private By ISDCodeSearch = By.xpath("//android.widget.EditText");


@Test(enabled=false)
public void sauceLabTest() throws IOException, InterruptedException {
	String userName = System.getenv("SAUCE_USERNAME");
	final String accessKey = System.getenv("SAUCE_ACCESS_KEY");
	URL url = new URL("https://"+userName+":"+accessKey+"@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	
	MutableCapabilities caps = new MutableCapabilities();
	MutableCapabilities sauceOptions = new MutableCapabilities();
	sauceOptions.setCapability("appiumVersion", "1.20.2");
	caps.setCapability("sauce:options", sauceOptions);
	caps.setCapability("platformName", "Android");
	caps.setCapability("app", "storage:filename=AzamTV.apk");
	caps.setCapability("appium:deviceName", "Google Pixel 3a GoogleAPI Emulator");
	caps.setCapability("appium:platformVersion", "10.0");
	caps.setCapability("appPackage", "com.azamtv.max.media");
	caps.setCapability("appActivity", "com.azamtv.max.media.MainActivity");

	
	
	driver = new AppiumDriver<MobileElement>(url,caps);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	

	driver.findElement(getStartedBtn).click();
	System.out.println("Clicked Get Started Button Succesfully");
	driver.findElement(englishLanguageBtn).click();
	System.out.println("Clicked English Language Button Succesfully");
	driver.findElement(continueBtn).click();
	System.out.println("Clicked Continue Button Succesfully");

	
	driver.findElement(loginTab).click();
	System.out.println("Clicked Login Tab Button Succesfully");

	driver.findElement(registerBtn).click();
	System.out.println("Clicked Register Button Succesfully");
	
	driver.findElement(ISDCodeButton).click();
	System.out.println("Clicked ISDCode Button Succesfully");

	String ISDCode = "+91";

	driver.findElement(ISDCodeSearch).sendKeys(ISDCode);
	System.out.println("Entered ISDCodeSearch - "+ISDCode+" - Succesfully");
	
	By CountryButton = By.xpath("//android.widget.TextView[@text='"+ISDCode+"']");
	driver.findElement(CountryButton).click();

	Thread.sleep(5000);
	String phonenumber = "9600000000";

	driver.findElement(phonenumberBox).click();
	driver.findElement(phonenumberBox).sendKeys(phonenumber);
	System.out.println("Entered New Register Number - "+phonenumber+" - Succesfully");
	
	driver.findElement(registerContinueButton).click();
	System.out.println("Clicked Continue Button Succesfully");
	
	String otpnumber = "000000";

	char[] ch = otpnumber.toCharArray();
	for (int i =1 ; i<=ch.length;i++)
	{
	By otpBox = By.xpath("//android.view.ViewGroup["+i+"]/android.widget.EditText");
	String otp = String.valueOf(ch[i-1]);
	driver.findElement(otpBox).click();
	driver.findElement(otpBox).sendKeys(otp);
	}
	System.out.println("Entered OTP - "+otpnumber+" -  Succesfully");

}


}

