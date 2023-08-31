package Resources;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	public static  ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";

		// ExtentReports , Extentsparkreposrter
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);// reponsible for creating reports
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		//reporter.config().thumbnailForBase64();
		reporter.config().getTheme();
		reporter.config().getTimeStampFormat();

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rashmi Iyengar");
		
		return extent;

	}
	
	
}
