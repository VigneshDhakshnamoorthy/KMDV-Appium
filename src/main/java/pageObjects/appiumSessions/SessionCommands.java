package pageObjects.appiumSessions;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.html5.Location;
import io.appium.java_client.Setting;
import io.appium.java_client.driverscripts.ScriptOptions;
import io.appium.java_client.serverevents.CustomEvent;
import util.Common.BaseClass;

public class SessionCommands  extends BaseClass{

	public void allCommands() {
		driver.quit(); // End Session

		driver.getSessionDetails(); // Get Session Capabilities

		//driver.back(); // Go Back

		((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Take Screenshot

		driver.getPageSource(); //Get Page Source

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // Set Timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Set Implicit Wait Timeout
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS); // Set Script Timeout

		driver.getOrientation(); // Get Orientation
		driver.rotate(ScreenOrientation.LANDSCAPE); // Set Orientation

		driver.location(); // Get Geolocation
		driver.setLocation(new Location(49, 123, 10)); // Set Geolocation

		driver.manage().logs().getAvailableLogTypes(); // Get available log types
		driver.manage().logs().get("driver"); // Get Logs


		CustomEvent evt = new CustomEvent();
		evt.setEventName("funEvent");
		evt.setVendor("appium");
		driver.logEvent(evt); // Log event

		driver.getEvents(); // Get events



		driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 5000); // Update Device Settings

		driver.getSettings(); // Retrieve Device Settings

		String script = "const el = await driver.$('~foo');\n"+"await el.click();";
		driver.executeDriverScript(script, new ScriptOptions().withTimeout(200));
		// Execute Driver Script









	}

}
