package qaPages;

//import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import qaBase.TestBase;
import qaUtil.TestUtil;

public class HomePage extends TestBase {
	
	JavascriptExecutor js;
	TestUtil testUtil;
	
	//Locate Storage 
	@FindBy(xpath = "//li[@class='topnav_item storageunit']/span[@class='topnav_itemname']")
	WebElement storage;
	//Initializing the page object
	public HomePage() {
		PageFactory.initElements(driver, this);
		
		testUtil = new TestUtil();
			
	}
	public String validateHomePageTitle() {
		logger = report.createTest("Home  Page is opening.");
		
			String title=testUtil.webPageTitle();
//			String expTitle="Up to 70% off on Online Furniture | Full House Sale - Urban Ladder";
//			Assert.assertEquals(title, expTitle);
			System.out.println(title);
			reportInfo("UrbanLadder Home Page is opened.");
			
		
		return title;
		
	}
	public void subMenu() throws InterruptedException {
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		logger = report.createTest("Obtain all menu and submenus in Collection.");
		
		try {
			Actions action = new Actions(driver);
			
			action.moveToElement(storage).perform();
			List<WebElement> allProduct = driver.findElements(By.xpath("//ul[@class='inline-list left']"));

			List<String> subMenuItem = new ArrayList<String>();
			System.out.println(allProduct.size());
			System.out.print("****** Menu and sublists under storage tab ******");
			Thread.sleep(1000);
			
			for(int i=0;i<allProduct.size();i++) {
				WebElement product = allProduct.get(i); 
				String sMenu = product.getText();
				System.out.println(sMenu);
				subMenuItem.add(sMenu);
			}
			reportPass("All menus and Submenus are Obtained Successfully");
		
		}
		catch (Exception e) {
			reportFail(e.getMessage());
		}
	
	}
//	public BookShelvepage clickOnBookshelvePage() {
//		js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,20)");
//		driver.findElement(By.linkText(prop.getProperty("bookShelveIcon_LinkText"))).click();
//		return new BookShelvepage();
//	}

}
