package util.Report;


import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.testng.Reporter;

import util.Common.BaseClass;

public class LogUtil extends BaseClass {

	private File logsRoot;
	private Logger logger;
	private FileHandler fh;
	
	public void logE(String LogMessage) {
		Reporter.log(LogMessage);
		ERU.ExtentPass(LogMessage);
		logInfo(LogMessage);
		System.out.println(LogMessage);
	}		

	public void logC(String LogMessage) {
		System.out.println(LogMessage);
	}	


	public void startLogging(String testName) {
		LogManager.getLogManager().reset();
		logsRoot = new File(pathUtil.getLoggerPath(testName+".log"));
		System.setProperty("java.util.logging.SimpleFormatter.format",
				"[%1$tF %1$tT] %5$s %n");

		logger = Logger.getLogger(testName);  
		try {
			fh = new FileHandler(logsRoot.getAbsolutePath());
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();  
		fh.setFormatter(formatter);  
	}

	public void logInfo(String logMessage) {
		logger.info(logMessage);
	}

	public void logWarn(String logMessage) {
		logger.warning(logMessage);
	}
}
