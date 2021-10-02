package util.Report;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import util.Common.BaseClass;

public class ExtentReportUtil extends BaseClass{
	public ExtentReports Ereport;
	public ExtentSparkReporter Espark;
	public ExtentTest Etest;
	public File extentReportRoot = new File(pathUtil.getExtentReportPath("ExtentReport.html"));

	public void StartExtentReport() {
		Ereport = new ExtentReports();
		Espark = new ExtentSparkReporter(extentReportRoot.getAbsolutePath());
		Ereport.attachReporter(Espark);
	}

	public void StartExtentTest(String TestName) {
		Etest = Ereport.createTest(TestName);

	}

	public void ExtentInfo(String Message) {
		Etest.log(Status.INFO, Message);
	}

	public void ExtentPass(String Message) {
		Etest.log(Status.PASS, Message);
	}

	public void ExtentFail(String Message) {
		Etest.log(Status.FAIL, Message);
	}

	public void ExtentSkip(String Message) {
		Etest.log(Status.SKIP, Message);
	}

	public void ExtentWarn(String Message) {
		Etest.log(Status.WARNING, Message);
	}
	public void ExtentScreenShot(String testStatus, String Path) {
		switch (testStatus) {

		case "Pass":
			Etest.pass(MediaEntityBuilder.createScreenCaptureFromPath(Path).build());
			break;
		case "Fail":
			Etest.fail(MediaEntityBuilder.createScreenCaptureFromPath(Path).build());
			break;
		case "Skip":
			Etest.skip(MediaEntityBuilder.createScreenCaptureFromPath(Path).build());
			break;
		case "Info":
			Etest.info(MediaEntityBuilder.createScreenCaptureFromPath(Path).build());
			break;
		case "Warn":
			Etest.warning(MediaEntityBuilder.createScreenCaptureFromPath(Path).build());
			break;
		
			}
		}
		public void EndExtentReport() {
			Ereport.flush();
		}
	}
