package pageObjects.chromeBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.Common.BaseClass;

public class AmazonPage  extends BaseClass{
	
	private By searchBox = By.xpath("//input[@id='nav-search-keywords']");
	private By hamburgerMenu = By.xpath("//a[@id='nav-hamburger-menu']");
	private By menuMobiles = By.xpath("//li/a[text()='Mobiles']");
	private By filterByInternalMemory = By.xpath("//*[text()='Filter by internal memory']");
	private By brandsRelatedToYourSearch = By.xpath("//*[text()='Brands related to your search']");
	private By nextPageButton = By.xpath("//a[contains(text(),'Next')]");

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
	public void clicknextPageButton() {
		chromeBase.jseScrolltoEle(nextPageButton);
		driver.findElement(nextPageButton).click();
		logUtil.logE("Next Page Button - Clicked Succesfully");

	}
	public void scrollto_FilterByInternalMemory() {
		chromeBase.jseScrolltoEle(filterByInternalMemory);
		logUtil.logE("Scroll To - Filter By Internal Memory Succesfully");

	}
	
	public void scrollto_BrandsRelatedToYourSearch() {
		chromeBase.jseScrolltoEle(brandsRelatedToYourSearch);
		logUtil.logE("Scroll To - Brands Related To Your Search Succesfully");

	}

}
