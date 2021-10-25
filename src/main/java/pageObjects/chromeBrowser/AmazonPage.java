package pageObjects.chromeBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.Common.BaseClass;

public class AmazonPage  extends BaseClass{
	
	private By searchBox = By.xpath("//input[@id='nav-search-keywords']");
	
	public void enterSearchBox(String searchKeyword) {
		driver.findElement(searchBox).sendKeys(searchKeyword+Keys.ENTER);
		logUtil.logE(searchKeyword+" - Searched Succesfully");

	}

}
