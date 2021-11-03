package util.Common;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import util.Capability.AppiumServerUtil;
import util.Capability.DesirCapUtil;
import util.Capability.EmulatorUtil;
import util.Capability.PathUtil;
import util.Report.ExtentReportUtil;
import util.Report.LogUtil;
import util.Report.ScreenShotUtil;

public class InitiationClass extends BaseClass  {

	public void InitiateClasses() {
		emuUtil = new EmulatorUtil();
		appiumUtil = new AppiumServerUtil();
		pathUtil= new PathUtil();
		desireCap = new DesirCapUtil();
		logUtil= new LogUtil();
		ERU= new ExtentReportUtil();
		actionClass= new ActionClass();
		chromeBase = new ChromeBase();
		screenShotUtil= new ScreenShotUtil();
		emulator = emuUtil.emuID();
	    avdName = emuUtil.avdName();
	    cleanFolderRLS();
		
		
	}
	
	public void InitiateAppiumDriver(AppDir aPPName) {
		driver = new AppiumDriver<MobileElement>(desireCap.Url(),desireCap.App(aPPName));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		logUtil.logE(aPPName+" - Aplication is Opening");
	}
	
	public void QuitDriver() {
		logUtil.logE(APPName+" - Aplication is Closing");
		driver.quit();
	}
	
	public void cleanFolderRLS() {
		File mainFolder = new File(pathUtil.RLCroot.toString());
		 File[] mainFolders = mainFolder.listFiles();
		    if(mainFolders!=null) { //some JVMs return null for empty dirs
		        for(File fo: mainFolders) {
		        	File folder = new File (pathUtil.RLCroot,fo.getName());
		        	deleteFolder(folder);
		        }
		    }
	}
	
	public void deleteFolder(File folder) {
		File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isDirectory()) {
	                deleteFolder(f);
	            } else {
	                f.delete();
	            }
	        }
	    }
	}
	
}
