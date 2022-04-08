package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import util.Common.BaseClass;

public class Chrome2 extends BaseClass{

	@Test(groups= {"LocalAppium"})
	public void AmazonProductSearch() throws Exception{
		appOpen(AppDir.Chrome);

		chromeBase.clearChromeTabs();
		chromeBase.open("https://www.valuedopinions.co.in/index");
		chromeBase.SwitchWebview();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fa fa-bars']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='mobileHeader-content-link ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ssarantestuser@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@class='button buttonPrimary button-full']")).click();
		Thread.sleep(2000);
		By by = By.xpath("//upp-punchcard-list[@ng-if='vm.user.id > 0']");
		chromeBase.jseScrolltoEle(by);
		int num = 2;
		WebElement shadow0 = (WebElement) driver.executeScript("return arguments[0].shadowRoot;", driver.findElement(by));
		WebElement shadow1 = (WebElement) driver.executeScript("return arguments[0].shadowRoot;", 
		shadow0.findElement(By.cssSelector("upp-punchcard[show-modal='false']")));
		
		WebElement findElement1 = shadow1.findElement(By.cssSelector("#pc-"+num));
		System.out.println(findElement1.getText());
		WebElement findElement2 = shadow1.findElement(By.cssSelector("#pc-"+num+" > div"));
		System.out.println(findElement2.getCssValue("background-color"));

		screenShotUtil.ExtentShot("Pass");
		chromeBase.SwitchNative();
		
	}
}
