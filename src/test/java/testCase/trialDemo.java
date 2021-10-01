package testCase;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import util.Common.BaseClass;

public class trialDemo extends BaseClass {
	public static File logsRoot = new File(pathUtil.classPathRoot,"/Report-ScreenShot/Logs/LogReport.log");

public static void main(String[] args) throws Throwable {
		LogManager.getLogManager().reset();

		System.setProperty("java.util.logging.SimpleFormatter.format",
            "[%1$tF %1$tT] %5$s %n");
		Logger logger = Logger.getLogger("");  
		logger.setUseParentHandlers(false);

		FileHandler fh = new FileHandler(logsRoot.getAbsolutePath());  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  


        // the following statement is used to log any messages  
        logger.info("My first log");  


    logger.info("Hi How r u?");  


}
}
