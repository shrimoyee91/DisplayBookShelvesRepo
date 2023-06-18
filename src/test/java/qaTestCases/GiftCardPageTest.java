package qaTestCases;


import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qaBase.TestBase;
import qaPages.GiftCardPage;
import qaUtil.TestUtil;

public class GiftCardPageTest extends TestBase{
	
	GiftCardPage giftPage;
	TestUtil testUtil;
	String sheet1 = "GiftCardRecForm";
	String sheet2 = "GiftCardCusForm";
	
	public GiftCardPageTest() {
		super();
	}
	@BeforeClass
	public void setUp() {
		logger = report.createTest("Executing Test Cases");
		initialization();
		
		giftPage = new GiftCardPage();
		reportPass("Browser is Invoked");
	}
	@Test(priority = -1)
	public void vaateHomepageTitleTest() {
		giftPage.validateHomePageTitle();
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority = 0)
	public void giftCardIconTest() {
		giftPage.clickOnGiftCard();
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority = 1)
	public void cardPageTitleTest() {
		giftPage.validateCardPageTitle();
		reportPass("Test Case Passed Successfully");
		
	}
	@Test(priority = 2)
	public void chooseCardTest() {
		giftPage.chooseCard();
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority = 3)
	public void sendAmountTest() {
		giftPage.sendAmount("5000");
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority = 4)
	public void clickNextTest() {
		giftPage.clickNext();
		reportPass("Test Case Passed Successfully");
	}
	@DataProvider
	public Object[][] giftCardRecTestData() {
		Object recData[][]=TestUtil.getTestData(sheet1);
		return recData;
	}

	@Test(priority = 5, dataProvider = "giftCardRecTestData")
	public void fillRecFormTest(String recName, String recEmail, String recMobile) {
		giftPage.fillRecForm(recName,recEmail,recMobile);
		reportPass("Test Case Passed Successfully");
	}
	@DataProvider
	public Object[][] giftCardCusTestData() {
		Object cusData[][]=TestUtil.getTestData(sheet2);
		return cusData;
	}

	@Test(priority = 6, dataProvider = "giftCardCusTestData")
	public void fillCusFormTest(String cusName, String cusEmail, String cusMobile, String cusAddress, String cusPincode, String message) {
		giftPage.fillCusForm(cusName,cusEmail,cusMobile, cusAddress, cusPincode, message);
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority = 7)
	public void clickOnConfirmTest() {
		giftPage.clickConfirm();
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority = 8)
	public void takeScreenshotTest() {
		giftPage.captureError();
		reportPass("Test Case Passed Successfully");
	}
	@AfterClass
	public void close() {
		giftPage.endReport();
		tearDown();
	}

}
