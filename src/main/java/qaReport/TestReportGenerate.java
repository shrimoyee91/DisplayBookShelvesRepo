package qaReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.util.Date;


public class TestReportGenerate {
	static ExtentReports extenreports ;
	public static ExtentReports getReportInstance(){
		if(extenreports == null) {
			Date date = new Date();
			String reportName = date.toString().replaceFirst(":", "_").replaceAll(":", "_")+ ".html";
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-report\\" + reportName);
			extenreports = new ExtentReports();
			extenreports.attachReporter(sparkReporter);
			
			sparkReporter.config().setDocumentTitle("UI Automation Report");
			sparkReporter.config().setReportName("Report");
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setTimeStampFormat("MMM dd, yyy HH:mm:ss");
		}
		return extenreports;
	}
	
	

}
