package pageObjects.chromeBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.Common.BaseClass;

public class AmazonPage  extends BaseClass{
	
	private By searchBox = By.xpath("//input[@id='nav-search-keywords']");
	private By hamburgerMenu = By.xpath("//a[@id='nav-hamburger-menu']");
	private By menuMobiles = By.xpath("//li/a[text()='Mobiles']");

	public void enterSearchBox(String searchKeyword) {
		driver.findElement(searchBox).sendKeys(searchKeyword+Keys.ENTER);
		logUtil.logE(searchKeyword+" - Searched Succesfully");

	}
	
	public void clickHamburgerMenu() {
		driver.findElement(hamburgerMenu).click();
		logUtil.logE("Hamburger Menu - Clicked Succesfully");

	}
	
	public void clickMenuMobiles() {
		driver.findElement(menuMobiles).click();
		logUtil.logE("Menu Mobiles - Clicked Succesfully");

	}

}
