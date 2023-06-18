package qaReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class TestReportGenerate {
	static ExtentReports extenreports ;
	public static ExtentReports getReportInstance(){
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\shrim\\eclipse-workspace\\INTQEA23QE002\\src\\main\\java\\qaReport\\report.html");
		try {
			extenreports = new ExtentReports();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		extenreports.attachReporter(sparkReporter);
		
		return extenreports;
	}
	

}
