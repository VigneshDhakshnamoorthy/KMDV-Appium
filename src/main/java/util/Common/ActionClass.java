package util.Common;

import java.time.Duration;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ActionClass extends BaseClass {

	public void WaitSec(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void WaitMilliSec(int MilliSec) {
		try {
			Thread.sleep(MilliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean WaitForElement(By by, int Seconds) {
		for (int i =1; i<=Seconds*1000 ; i++) {
			try {
				driver.findElement(by);
				return true;
			}catch(Exception e) {
				WaitMilliSec(1);
			}
		}
		return false;
	}
	public boolean WaitUnlimit(By by) {
		while(true) {
			try {
				driver.findElement(by);
				return true;
			}catch(Exception e) {
				WaitMilliSec(1);
			}
			}
		
	}
	public void ClickElement(By by) {
		if(WaitForElement(by,60)) {
			driver.findElement(by).click();
		}else {
			logUtil.logE("Element Not Found :  "+by);
		}
	}

	public void TypeinElement(By by, String Value) {
		if(WaitForElement(by,60)) {
			driver.findElement(by).sendKeys(Value);
		}else {
			logUtil.logE("Element Not Found :  "+by);
		}
	}


	public void scrollUiText(String ScrollText) {
		String ScrollCommand = "new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView("                      
				+ "new UiSelector().textContains(\""+ScrollText+"\"));";
		By androidUIAutomator = MobileBy.AndroidUIAutomator(ScrollCommand);
		driver.findElement(androidUIAutomator);
		logUtil.logE("Scroll to - "+ScrollText+" -  Succesfully");
	}
	
	public MobileElement getUIele(String ScrollText) {
		String ScrollCommand = "new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView("                      
				+ "new UiSelector().textContains(\""+ScrollText+"\"));";
		By androidUIAutomator = MobileBy.AndroidUIAutomator(ScrollCommand);
		return driver.findElement(androidUIAutomator);
	}
	
	public Point getUIpoint(String ScrollText) {
		String ScrollCommand = "new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView("                      
				+ "new UiSelector().textContains(\""+ScrollText+"\"));";
		By androidUIAutomator = MobileBy.AndroidUIAutomator(ScrollCommand);
		return driver.findElement(androidUIAutomator).getLocation();
	}

	public Map<String, Object> getSessionDetails() {
		return driver.getSessionDetails();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public ScreenOrientation getOrientation() {
		ScreenOrientation orientation = driver.getOrientation();
		logUtil.logE("Orientation : "+orientation);
		return orientation;
	}

	public void rotateScreen(String Orientation) {

		switch (Orientation) {

		case "LANDSCAPE":
			driver.rotate(ScreenOrientation.LANDSCAPE);
			break;

		case "PORTRAIT":
			driver.rotate(ScreenOrientation.PORTRAIT);
			break;

		default:
			logUtil.logC("Provide Proper App Name");

		}

	}

	public Location getLocation() {
		logUtil.logE("Location - "+driver.location().toString());
		return driver.location();
	}

	public void setLocation(Location location) {
		driver.setLocation(location);
		
	}
	
	public void touchMoveTo(MobileElement ele1, MobileElement ele2) {
		
		 int startX = ele1.getLocation().getX();
	     int startY = ele1.getLocation().getY();
	     int endX = ele2.getLocation().getX();
	     int endY = ele2.getLocation().getY();
	     
	     
		new AndroidTouchAction (driver)
		  .press (PointOption.point (startX, startY))
		  .waitAction (WaitOptions.waitOptions (Duration.ofMillis(1000)))
		  .moveTo (PointOption.point (endX, endY))
		  .release ()
		  .perform ();
	}
	
	public void touchMoveTo(Point point1, Point point2) {
	     
		new AndroidTouchAction (driver)
		  .press (PointOption.point (point1))
		  .waitAction (WaitOptions.waitOptions (Duration.ofMillis(1000)))
		  .moveTo (PointOption.point (point2))
		  .release ()
		  .perform ();
	}
	

}
