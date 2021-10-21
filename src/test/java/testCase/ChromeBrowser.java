package testCase;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import util.Common.BaseClass;
import util.Data.ExcelUtil;

public class ChromeBrowser extends BaseClass{
	private String appName="Chrome";


	@Test(groups= {"LocalAppium"})
	public void AmazonProductSearch() throws Exception{
		appOpen(appName);
		xlutil = new ExcelUtil(pathUtil.getExcelPath("ChromeExcelData.xlsx"));
		String browseURL=xlutil.getCellDataByValue("Sheet1", "browseURL", "value");
		String searchKeyword=xlutil.getCellDataByValue("Sheet1", "searchKeyword", "value");
		actionClass.clearChromeTabs();
		driver.get(browseURL);
		logUtil.logE(browseURL+"\nOpened in "+appName+" Browser Succesfully");

		actionClass.SwitchWebview();
		screenShotUtil.ExtentShot("Pass");

		driver.findElementByXPath("//input[@id='nav-search-keywords']").sendKeys(searchKeyword+Keys.ENTER);
		
		logUtil.logE(searchKeyword+" - Searched Succesfully");
		actionClass.SwitchNative();
		
	}
}
