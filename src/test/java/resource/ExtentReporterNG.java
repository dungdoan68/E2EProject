package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extentReport;
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("E2E Tutorials");
		report.config().setReportName("Result E2E");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(report);
		extentReport.setSystemInfo("E2E report", "Dung Test");
		extentReport.setSystemInfo("Platfom", "Chomre");
		extentReport.setSystemInfo("OS", "Win 10");
		
		return extentReport;
	}

}
