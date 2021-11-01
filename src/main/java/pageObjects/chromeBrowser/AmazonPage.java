package pageObjects.chromeBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.Common.BaseClass;
import util.Data.ExcelUtil;

public class AmazonPage  extends BaseClass{
	public AmazonPage() {
		xlutil = new ExcelUtil(pathUtil.getExcelPath("ChromeExcelData.xlsx"));
		String browseURL=xlutil.getCellDataByValue("Sheet1", "browseURL", "value");
		chromeBase.clearChromeTabs();
		chromeBase.open(browseURL);
		chromeBase.SwitchWebview();
	}
	private By searchBox = By.xpath("//input[@id='nav-search-keywords']");
	private By hamburgerMenu = By.xpath("//a[@id='nav-hamburger-menu']");
	private By menuMobiles = By.xpath("//li/a[text()='Mobiles']");
	private By filterByInternalMemory = By.xpath("//*[text()='Filter by internal memory']");
	private By brandsRelatedToYourSearch = By.xpath("//*[text()='Brands related to your search']");
	private By nextPageButton = By.xpath("//a[contains(text(),'Next')]");

	public void enterSearchBox(String searchKeyword) {
		actionClass.TypeinElement(searchBox,searchKeyword+Keys.ENTER);
		logUtil.logE(searchKeyword+" - Searched Succesfully");

	}
	public void enterSearchBox() {
		String searchKeyword=xlutil.getCellDataByValue("Sheet1", "searchKeyword", "value");
		actionClass.TypeinElement(searchBox,searchKeyword+Keys.ENTER);
		logUtil.logE(searchKeyword+" - Searched Succesfully");

	}
	
	public void clickHamburgerMenu() {
		actionClass.ClickElement(hamburgerMenu);
		logUtil.logE("Hamburger Menu - Clicked Succesfully");

	}
	
	public void clickMenuMobiles() {
		actionClass.ClickElement(menuMobiles);
		logUtil.logE("Menu Mobiles - Clicked Succesfully");

	}
	public void clicknextPageButton() {
		chromeBase.jseScrolltoXY(nextPageButton);
		actionClass.ClickElement(nextPageButton);
		logUtil.logE("Next Page Button - Clicked Succesfully");

	}
	public void scrollto_FilterByInternalMemory() {
		chromeBase.jseScrolltoXY(filterByInternalMemory);
		logUtil.logE("Scroll To - Filter By Internal Memory Succesfully");

	}
	
	public void scrollto_BrandsRelatedToYourSearch() {
		chromeBase.jseScrolltoXY(brandsRelatedToYourSearch);
		logUtil.logE("Scroll To - Brands Related To Your Search Succesfully");

	}

}
