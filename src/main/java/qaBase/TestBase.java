package qaBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



import io.github.bonigarcia.wdm.WebDriverManager;
import qaUtil.TestUtil;
import qaReport.TestReportGenerate;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports report;
	//public ExtentReports report = TestReportGenerate.getReportInstance();
	public ExtentTest logger;
	
	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream finp = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\qaConfig\\config.properties");
			prop.load(finp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		report = TestReportGenerate.getReportInstance();
	}
		

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		//Page Load Time
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
		
	}
		// Function to show the failed test cases in the report
		public void reportInfo(String report) {
			logger.log(Status.INFO, report);
			
		}

		// Function to show the failed test cases in the report
		public void reportFail(String report) {
		logger.log(Status.FAIL, report);
		
		}



		// Function to show the passed test cases in the report
		public void reportPass(String report) {
		logger.log(Status.PASS, report);
		
		}
		// To input all data to the report
		public void endReport() {
		report.flush();
		}

	public static void tearDown() {
		driver.quit();
	}

}
