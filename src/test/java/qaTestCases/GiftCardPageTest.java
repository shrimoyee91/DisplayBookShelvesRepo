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
		logger = report.createTest("GiftCard Page Report");
		initialization();
		
		giftPage = new GiftCardPage();
		reportInfo("Browser is Invoked");
	}
	@Test(priority = -1)
	public void vaateHomepageTitleTest() {
		giftPage.validateHomePageTitle();
		reportPass("UrbanLadder Home Page is opened.");
	}
	@Test(priority = 0)
	public void giftCardIconTest() {
		giftPage.clickOnGiftCard();
		reportPass("GiftCard Link is clicked.");
	}
	@Test(priority = 1)
	public void cardPageTitleTest() {
		giftPage.validateCardPageTitle();
		reportPass("UrbanLadder GiftCard Page is opened.");
		
	}
	@Test(priority = 2)
	public void chooseCardTest() {
		giftPage.chooseCard();
		reportPass("GiftCard is choosed.");
	}
	@Test(priority = 3)
	public void sendAmountTest() {
		giftPage.sendAmount("5000");
		reportPass("Send Amount");
	}
	@Test(priority = 4)
	public void clickNextTest() {
		giftPage.clickNext();
		reportPass("Next button is clicked.");
	}
	@DataProvider
	public Object[][] giftCardRecTestData() {
		Object recData[][]=TestUtil.getTestData(sheet1);
		return recData;
	}

	@Test(priority = 5, dataProvider = "giftCardRecTestData")
	public void fillRecFormTest(String recName, String recEmail, String recMobile) {
		giftPage.fillRecForm(recName,recEmail,recMobile);
		reportPass("Recipient details is filled.");
	}
	@DataProvider
	public Object[][] giftCardCusTestData() {
		Object cusData[][]=TestUtil.getTestData(sheet2);
		return cusData;
	}

	@Test(priority = 6, dataProvider = "giftCardCusTestData")
	public void fillCusFormTest(String cusName, String cusEmail, String cusMobile, String cusAddress, String cusPincode, String message) {
		giftPage.fillCusForm(cusName,cusEmail,cusMobile, cusAddress, cusPincode, message);
		reportPass("Customer details is filled.");
	}
	@Test(priority = 7)
	public void clickOnConfirmTest() {
		giftPage.clickConfirm();
		reportPass("Confirm button is clicked.");
	}
	@Test(priority = 8)
	public void takeScreenshotTest() {
		giftPage.captureError();
		reportPass("Error message is captured.");
	}
	@AfterClass
	public void close() {
		giftPage.endReport();
		tearDown();
	}

}
