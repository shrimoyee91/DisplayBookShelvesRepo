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
		
			String title=testUtil.webPageTitle();
			String expTitle="Up to 70% off on Online Furniture | Full House Sale - Urban Ladder";
			Assert.assertEquals(title, expTitle);
			System.out.println(title);
		
	}
	//Click on BookShelve Page Icon
	public void clickBookShelveIcon() {
		
		
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,20)");
			driver.findElement(By.linkText(prop.getProperty("bookShelveIcon_LinkText"))).click();
			
		
	}
	//Click on PopUp
	public void clickOnPopUp() {
		
		
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
		
		
	}
	//Click on Open
	public void openStorage() {
		
	
			//Find Storage Filter
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("storage_Xpath"))));
			//action.moveToElement((WebElement) By.xpath(prop.getProperty("storage_Xpath"))).perform();
			//Move to Open
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("open_Xpath"))));
			//action.moveToElement((WebElement) By.xpath(prop.getProperty("open_Xpath"))).perform();
			driver.findElement(By.xpath(prop.getProperty("open_Xpath"))).click();
			
	}
	//Click on PriceSlider
	public void priceLimit() {
		
		
			//Find Price Slider
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("price_Xpath"))));
			//Move to Price Limit
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("sliderPath_ID"))));
			driver.findElement(By.id(prop.getProperty("sliderPath_ID"))).click();
			
	}
	//Click on Exclude outOfStock
	public void inStock() {
			driver.findElement(By.xpath(prop.getProperty("inStock_Xpath"))).click();
			
		
	}
	//Display BookShelves
	public void displayBookShelves() {
		
		
			List<WebElement> prices = driver.findElements(By.xpath(prop.getProperty("prices_Xpath")));
			List<WebElement> names = driver.findElements(By.xpath(prop.getProperty("names_Xpath")));
			for (int i = 0; i <3; i++) {
				System.out.println(names.get(i).getText() + " - "
										+ prices.get(i).getText());
			
	}
	}
	
	

}
