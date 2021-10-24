package testCase;

import org.testng.annotations.Test;

import pageObjects.chromeBrowser.AmazonPage;
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
		
		chromeBase.clearChromeTabs();
		chromeBase.open(browseURL);
		chromeBase.SwitchWebview();

		AmazonPage amazonPage = new AmazonPage(driver);
		amazonPage.enterSearchBox(searchKeyword);
		
		screenShotUtil.ExtentShot("Pass");
		chromeBase.SwitchNative();
		
	}
}
