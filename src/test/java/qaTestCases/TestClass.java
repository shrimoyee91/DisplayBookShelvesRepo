package qaTestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import qaBase.TestBase;
import qaPages.BookShelvepage;
import qaPages.GiftCardPage;
import qaPages.HomePage;

public class TestClass extends TestBase{
	HomePage home ;
	BookShelvepage bookPage;
	GiftCardPage giftPage;
	public TestClass() {
		super();
	}
	@BeforeTest
	public void setUp() {
		logger = report.createTest("Executing Test Cases");
		initialization();
		
		home = new HomePage();
		bookPage= new BookShelvepage();
		giftPage = new GiftCardPage();
		reportInfo("Browser is Invoked");
		
	}
	@Test(priority = 1)
	public void homeTest() {
		logger = report.createTest("HomePage Test Report.");
		home.validateHomePageTitle();
		logger.pass("proper url is open");
		try {
			home.subMenu();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.pass("Submenu extracted.");
	}
	@Test(priority = 2)
	public void giftTest() {
		logger = report.createTest("GiftCard Page Test Report.");
		giftPage.validateHomePageTitle();
		logger.pass("home page title.");
		giftPage.clickOnGiftCard();
		logger.pass("click gift card.");
		giftPage.validateCardPageTitle();
		logger.pass("card page title.");
		giftPage.chooseCard();
		logger.pass("choose card.");
		giftPage.sendAmount("5000");
		logger.pass("Set amount.");
		giftPage.clickNext();
		logger.pass("click next.");
		giftPage.fillRecForm("recName","recEmail","recMobile");
		logger.pass("rec details.");
		giftPage.fillCusForm("cusName","cusEmail","cusMobile", "cusAddress", "cusPincode", "message");
		logger.pass("cus details.");
		giftPage.clickConfirm();
		logger.pass("form submit.");
		reportPass("Test Case Passed Successfully");
	}
	@AfterTest
	public void close() {
		home.endReport();
		giftPage.endReport();
		tearDown();
	}

}
