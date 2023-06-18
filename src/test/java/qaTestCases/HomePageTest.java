package qaTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
		logger = report.createTest("Executing Test Cases");
		initialization();
		
		home = new HomePage();
		reportPass("Browser is Invoked");
		
	}
	@Test(priority = 0)
	public void vaateHomepageTitleTest() {
//		home.validateHomePageTitle();
		String title = home.validateHomePageTitle();
		String expTitle="Up to 70% off on Online Furniture | Full House Sale - Urban Ladder";
		Assert.assertEquals(title, expTitle);
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority = 1)
	public void subMenuTest() {
	try {
		home.subMenu();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	reportPass("Test Case Passed Successfully");
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
