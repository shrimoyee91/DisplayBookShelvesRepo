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
		logger = report.createTest("BookShelve Page Report");
		initialization();
		
		shelvePage = new BookShelvepage();
		reportInfo("Browser is Invoked");
	}
	@Test(priority = -1)
	public void validateHomepageTitleTest() {
		shelvePage.validateHomePageTitle();
		reportPass("UrbanLadder Home Page is opened successfully");
	}
	@Test(priority=0)
	public void clickBookShelveIconTest() {
		shelvePage.clickBookShelveIcon();
		reportPass("UrbanLadder BookShelve Page is opened.");
	}
	@Test(priority = 1)
	public void clickOnPopUpTest() {
		shelvePage.clickOnPopUp();
		reportInfo("PopUp is closed.");
	}
	@Test(priority = 2)
	public void openStorageTest() {
		shelvePage.openStorage();
		reportPass("Open storage is clicked.");
	}
	@Test(priority = 3)
	public void priceLimitTest() {
		shelvePage.priceLimit();
		reportPass("Price limit is set.");
	}
	@Test(priority = 4)
	public void inStockTest() {
		shelvePage.inStock();
		reportPass("In stock is set.");
	}
	@Test(priority = 5)
	public void displayDisplayBookShelvesTest() {
		shelvePage.displayBookShelves();
		reportPass("Bookshelves are displayed.");
	}
	@AfterClass
	public void close() {
		shelvePage.endReport();
		tearDown();
	}

}
