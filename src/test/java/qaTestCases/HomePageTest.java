package qaTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import qaBase.TestBase;
import qaPages.BookShelvepage;
//import qaPages.GiftCardPage;
import qaPages.HomePage;

public class HomePageTest extends TestBase {
	HomePage home ;
	BookShelvepage bookPage;
	public HomePageTest() {
		super();
	}
	@BeforeClass
	public void setUp() {
		//logger = report.createTest("Executing Test Cases");
		logger=report.createTest("Home Page Report");
		initialization();
		//logger.log(Status.INFO, "OPENING THE BROWSER");
		
		home = new HomePage();
		reportInfo("Browser is Invoked");
		
	}
	@Test(priority = 0)
	public void vaateHomepageTitleTest() {
//		home.validateHomePageTitle();
		try {
			String title = home.validateHomePageTitle();
			String expTitle="Up to 70% off on Online Furniture | Full House Sale - Urban Ladder";
			Assert.assertEquals(title, expTitle);
			reportPass("WEBSITE OPPENED SUCCESSFULLY");
		}
		catch(Exception e) {
			reportFail("urban ladder homepage is not opened");
		}
	}
	@Test(priority = 1)
	public void subMenuTest() throws InterruptedException {
	
		home.subMenu();
		reportPass("All menus and Submenus are Obtained Successfully");
	}
//	@Test(priority = 1)
//	public void clickOnBookShelveLinkTest() {
//		bookPage=home.clickOnBookshelvePage();
//	}
	@AfterClass
	public void close() {
		home.endReport();
		tearDown();
	}
	
}
