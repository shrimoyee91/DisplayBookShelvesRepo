package qaPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import qaBase.TestBase;
import qaUtil.TestUtil;

public class GiftCardPage extends TestBase{
	TestUtil testUtil;
	JavascriptExecutor js;
	//Page Factory - OR
	//Locate GiftCards icon
	@FindBy(linkText = "Gift Cards")
	WebElement giftCards;
	//Locate Birthday/Anniversary card 
	@FindBy(xpath="//h3[contains(text(),'Birthday/Anniversary')]")
	WebElement gift;
	//Locate amount textBox
	@FindBy(xpath="//input[@placeholder='Amount']")
	WebElement amount; 
	//Locate next Button
	@FindBy(xpath="//h4[text()=' Send On: ']/following::button[text()='Next']")
	WebElement next;
	//Locate recipient details
	@FindBy(name="recipient_name")
	WebElement recName;
	@FindBy(name="recipient_email")
	WebElement recEmail;
	@FindBy(name="recipient_mobile_number")
	WebElement recMobile;
	//Locate customer details
	@FindBy(name="customer_name")
	WebElement cusName;
	@FindBy(name="customer_email")
	WebElement cusEmail;
	@FindBy(name="customer_mobile_number")
	WebElement cusMobile;
	@FindBy(name="customer_address")
	WebElement cusAddress;
	@FindBy(name="zip")
	WebElement cusPinCode ;
	@FindBy(xpath="//textarea[@name='message']")
	WebElement message ;
	//Locate confirm button
	@FindBy(xpath="//button[text()='Confirm']")
	WebElement confirmBtn ;
	
	//Initializing the page object
	public GiftCardPage() {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		
	}
	public void validateHomePageTitle() {
		
			String title=testUtil.webPageTitle();
			String expTitle="Up to 70% off on Online Furniture | Full House Sale - Urban Ladder";
			Assert.assertEquals(title, expTitle);
		
		
	}
	public void clickOnGiftCard() {
		
			giftCards.click();
			
	}
	public void validateCardPageTitle() {
		//String title = driver.getTitle();
		
			String title=testUtil.webPageTitle();
			String expTitle="Gift Card - Buy Gift Cards & Vouchers Online for Wedding, Birthday | Urban Ladder";
			Assert.assertEquals(title, expTitle);
			System.out.println(title);
			
		
	}
	
	public void chooseCard() {
		
		
			js = (JavascriptExecutor) driver;
			
			//Scroll the page 
			js.executeScript("window.scrollBy(0,20)");
			
			gift.click();
		
	}
	//Select Amount value for the Gift Card
	public void sendAmount(String amnt) {
		
		
			amount.sendKeys(amnt);
			
	}
	//Click on Next
	public void clickNext() {
		
		
			next.click();
			
	}
	//Fill the form
	//Fill Recipient's Details
	public void fillRecForm(String name, String email, String mob) {
		
		
			recName.sendKeys(name);
			recEmail.sendKeys(email);
			recMobile.sendKeys(mob);
			
	}
	//Fill Customer Details
	public void fillCusForm(String name, String email, String mob, String adr,String pin,String msg) {
		
			cusName.sendKeys(name);
			cusEmail.sendKeys(email);
		    cusMobile.sendKeys(mob);
			cusAddress.sendKeys(adr);
			cusPinCode.sendKeys(pin);
			message.sendKeys(msg);
		
	}
	//Click on Confirm
	public void clickConfirm() {
		
		
			confirmBtn.click();
			
	}
	public void captureError() {
		
		
			testUtil.takenScreenshot();
			
	}


}
