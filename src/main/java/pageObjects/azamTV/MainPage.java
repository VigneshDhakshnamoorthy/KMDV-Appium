package pageObjects.azamTV;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Common.BaseClass;

public class MainPage extends BaseClass{

	public MainPage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	private By homeTab = By.xpath("//android.widget.Button[1]/android.view.ViewGroup");
	private By livetvTab = By.xpath("//android.widget.Button[2]/android.view.ViewGroup");
	private By moviesTab = By.xpath("//android.widget.Button[3]/android.view.ViewGroup");
	private By sportsTab = By.xpath("//android.widget.Button[4]/android.view.ViewGroup");
	private By loginTab = By.xpath("//android.widget.Button[5]/android.view.ViewGroup");
	private By registerBtn = By.xpath("//android.widget.TextView[@text='Register']");
	private By signInBtn = By.xpath("//android.widget.TextView[@text='Sign in']");
	
	public void clickhomeTab() {
		driver.findElement(homeTab).click();
		logUtil.logE("Clicked Home Tab Button Succesfully");

	}
	
	public void clicklivetvTab() {
		driver.findElement(livetvTab).click();
		logUtil.logE("Clicked Live TV Tab Button Succesfully");

	}
	
	public void clickmoviesTab() {
		driver.findElement(moviesTab).click();
		logUtil.logE("Clicked Movies Tab Button Succesfully");

	}
	
	public void clicksportsTab() {
		driver.findElement(sportsTab).click();
		logUtil.logE("Clicked Sports Tab Button Succesfully");

	}
	
	public void clickloginTab() {
		driver.findElement(loginTab).click();
		logUtil.logE("Clicked Login Tab Button Succesfully");

	}
	
	public void clickregisterBtn() {
		driver.findElement(registerBtn).click();
		logUtil.logE("Clicked Register Button Succesfully");


	}
	
	public void clicksignInBtn() {
		driver.findElement(signInBtn).click();
		logUtil.logE("Clicked SignIn Button Succesfully");


	}
	
	

	
	
}
