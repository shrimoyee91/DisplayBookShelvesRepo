package qaPages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import qaBase.TestBase;
import qaUtil.TestUtil;

public class BookShelvepage extends TestBase{
	TestUtil testUtil;
	JavascriptExecutor js;
	Actions action;
	WebDriverWait wait ;
	//Initializing the page object
	public BookShelvepage() {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		
	}
	public void validateHomePageTitle() {
		logger = report.createTest("Home  Page is opening.");
		try {
			String title=testUtil.webPageTitle();
			String expTitle="Up to 70% off on Online Furniture | Full House Sale - Urban Ladder";
			Assert.assertEquals(title, expTitle);
			System.out.println(title);
			reportPass("UrbanLadder Home Page is opened.");
		}
		catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	//Click on BookShelve Page Icon
	public void clickBookShelveIcon() {
		logger = report.createTest("Bookshelve icon is clicking.");
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,20)");
			driver.findElement(By.linkText(prop.getProperty("bookShelveIcon_LinkText"))).click();
			reportPass("UrbanLadder BookShelve Page is opened.");
		}
		catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	//Click on PopUp
	public void clickOnPopUp() {
		logger = report.createTest("Switch to bookshelve page and handle the popUp.");
		try {
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			for (String window : allWindows) {
				if (!window.equals(parentWindow)) {
					String childWindow = window;
					driver.switchTo().window(childWindow);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='close-reveal-modal hide-mobile']")));
					driver.findElement(By.xpath(prop.getProperty("popUp_Xpath"))).click();
				}
			}
			reportPass("PopUp is closed.");
		}
		catch (Exception e) {
			reportFail(e.getMessage());
		}
		
	}
	//Click on Open
	public void openStorage() {
		logger = report.createTest("Click on open storage");
		try {
			//Find Storage Filter
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("storage_Xpath"))));
			//action.moveToElement((WebElement) By.xpath(prop.getProperty("storage_Xpath"))).perform();
			//Move to Open
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("open_Xpath"))));
			//action.moveToElement((WebElement) By.xpath(prop.getProperty("open_Xpath"))).perform();
			driver.findElement(By.xpath(prop.getProperty("open_Xpath"))).click();
			reportPass("Open storage is clicked.");
		}
		catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	//Click on PriceSlider
	public void priceLimit() {
		logger = report.createTest("Click on price limit.");
		try {
			//Find Price Slider
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("price_Xpath"))));
			//Move to Price Limit
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("sliderPath_ID"))));
			driver.findElement(By.id(prop.getProperty("sliderPath_ID"))).click();
			reportPass("Price limit is set.");
		}
		catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	//Click on Exclude outOfStock
	public void inStock() {
		logger = report.createTest("Exclude out of stock.");
		try {
			driver.findElement(By.xpath(prop.getProperty("inStock_Xpath"))).click();
			reportPass("In stock is set.");
		}
		catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	//Display BookShelves
	public void displayBookShelves() {
		logger = report.createTest("Display bookshelves.");
		try {
			List<WebElement> prices = driver.findElements(By.xpath(prop.getProperty("prices_Xpath")));
			List<WebElement> names = driver.findElements(By.xpath(prop.getProperty("names_Xpath")));
			for (int i = 0; i <3; i++) {
				System.out.println(names.get(i).getText() + " - "
										+ prices.get(i).getText());
			}
			//return new HomePage();
			reportPass("Bookshelves are displayed.");
		}
		catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	

}
