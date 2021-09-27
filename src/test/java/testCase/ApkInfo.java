package testCase;

import java.util.List;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import util.Base.BaseClass;

public class ApkInfo extends BaseClass{
	private String appName="ApkInfo";

	@Test(groups= {"ApkInfo.main"})
	public void ApkinfoMain() throws Exception{
		appOpen(appName);
		List<MobileElement> installedAppNameList = driver.findElementsById("com.wt.apkinfo:id/text1");
	    log("Installed Apps");
	    for (MobileElement installedAppName:installedAppNameList) {
			System.out.print(installedAppName.getText().toString()+", ");

	    }

		
	}
}
