package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import commonUtil.ComUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainPage extends ComUtil{

	public MainPage(AppiumDriver<MobileElement> driver){
		this.driver = driver;
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
		log("Clicked Home Tab Button Succesfully");

	}
	
	public void clicklivetvTab() {
		driver.findElement(livetvTab).click();
		log("Clicked Live TV Tab Button Succesfully");

	}
	
	public void clickmoviesTab() {
		driver.findElement(moviesTab).click();
		log("Clicked Movies Tab Button Succesfully");

	}
	
	public void clicksportsTab() {
		driver.findElement(sportsTab).click();
		log("Clicked Sports Tab Button Succesfully");

	}
	
	public void clickloginTab() {
		driver.findElement(loginTab).click();
		log("Clicked Login Tab Button Succesfully");

	}
	
	public void clickregisterBtn() {
		driver.findElement(registerBtn).click();
		log("Clicked Register Button Succesfully");


	}
	
	public void clicksignInBtn() {
		driver.findElement(signInBtn).click();
		log("Clicked SignIn Button Succesfully");


	}
	
	

	
	
}
