package pageObjects.chromeBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.Common.BaseClass;

public class AmazonPage  extends BaseClass{
	
	public AmazonPage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	private By searchBox = By.xpath("//input[@id='nav-search-keywords']");
	
	public void enterSearchBox(String searchKeyword) {
		driver.findElement(searchBox).sendKeys(searchKeyword+Keys.ENTER);
		logUtil.logE(searchKeyword+" - Searched Succesfully");

	}

}
