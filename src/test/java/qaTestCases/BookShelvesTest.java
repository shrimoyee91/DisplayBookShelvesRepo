package qaTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qaBase.TestBase;
import qaPages.BookShelvepage;
//import qaPages.GiftCardPage;

public class BookShelvesTest extends TestBase{
	BookShelvepage shelvePage;
	public BookShelvesTest() {
		// TODO Auto-generated constructor stub
	
		super();
	}
	@BeforeClass
	public void setUp() {
		logger = report.createTest("Executing Test Cases");
		initialization();
		
		shelvePage = new BookShelvepage();
		reportPass("Browser is Invoked");
	}
	@Test(priority = -1)
	public void validateHomepageTitleTest() {
		shelvePage.validateHomePageTitle();
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority=0)
	public void clickBookShelveIconTest() {
		shelvePage.clickBookShelveIcon();
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority = 1)
	public void clickOnPopUpTest() {
		shelvePage.clickOnPopUp();
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority = 2)
	public void openStorageTest() {
		shelvePage.openStorage();
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority = 3)
	public void priceLimitTest() {
		shelvePage.priceLimit();
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority = 4)
	public void inStockTest() {
		shelvePage.inStock();
		reportPass("Test Case Passed Successfully");
	}
	@Test(priority = 5)
	public void displayDisplayBookShelvesTest() {
		shelvePage.displayBookShelves();
		reportPass("Test Case Passed Successfully");
	}
	@AfterClass
	public void close() {
		shelvePage.endReport();
		tearDown();
	}

}
