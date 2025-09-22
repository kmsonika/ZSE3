package AutomationExerciseNew;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.basics.BrowserFactory;

public class OrderPlace_BeforeCheckout {

	public static void main(String[] args) throws InterruptedException, AWTException {
		//Test Case 15: Place Order: Register before Checkout
		
//		1. Launch browser	
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.getTitle();	
		Thread.sleep(1000);

//		2. Navigate to url 'http://automationexercise.com'
		driver.navigate().to("https://automationexercise.com/");
		Thread.sleep(1000);

//		3. Verify that home page is visible successfully---------->
		WebElement homeLink = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        if (homeLink.isDisplayed()) {
            System.out.println("✅ Home page is visible.");
        } else {
            System.out.println("❌ Home page is not visible.");
        }

		Thread.sleep(1000);		
		
//		4. Click 'Signup / Login' button
		driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
//		5. Fill all details in Signup and create account
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Sonika002");
		driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys("kmsonika1002@gmail.com");
        //driver.findElement(By.xpath("//form[@action='/signup']//button[@type='submit']")).click();
		Thread.sleep(1000);
		
		// Click 'Signup' button
				driver.findElement(By.xpath("//button[text()='Signup']")).click();
				Thread.sleep(2000);
				
				//Fill details: Title, Name, Email, Password, Date of birth
				driver.findElement(By.xpath("//input[@value='Mrs']")).click();
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sonika123#");
				Thread.sleep(2000);

				js.executeScript("window.scrollBy(0,200)");
				
				WebElement days=driver.findElement(By.xpath("//select[@id='days']"));
				Select sel=new Select(days);
				sel.selectByValue("8");
				Thread.sleep(1000);

				WebElement month=driver.findElement(By.xpath("//select[@id='months']"));
				Select selmonth=new Select(month);
				selmonth.selectByVisibleText("May");
				Thread.sleep(1000);

				WebElement year=driver.findElement(By.xpath("//select[@id='years']"));
				Select selyear=new Select(year);
				selyear.selectByVisibleText("1940");
				Thread.sleep(1000);

				js.executeScript("window.scrollBy(0,200)");
				
		        //Select checkbox 'Sign up for our newsletter!'
				driver.findElement(By.xpath("//input[@id='optin']")).click();

		        //Select checkbox 'Receive special offers from our partners!'
				driver.findElement(By.xpath("//input[@id='newsletter']")).click();
				Thread.sleep(2000);
				
				js.executeScript("window.scrollBy(0,200)");

		        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
				driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("sonika");
				driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("gautam");
				Thread.sleep(2000);

				driver.findElement(By.xpath("//input[@id='company']")).sendKeys("DNK");
				driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("DNK");
				driver.findElement(By.xpath("//input[@id='state']")).sendKeys("UP");
				
				js.executeScript("window.scrollBy(0,350)");
				Thread.sleep(2000);

				driver.findElement(By.xpath("//input[@id='city']")).sendKeys("G.Noida");
				driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("123456");
				driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("9876543210");
				Thread.sleep(2000);

		        //Click 'Create Account button'
				driver.findElement(By.xpath("//button[text()='Create Account']")).click();
				Thread.sleep(2000);
		
//		6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
		System.out.println("Account Created! page displayed : "+driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]")).isDisplayed());
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		Thread.sleep(1000);
		
//		7. Verify ' Logged in as username' at top
		System.out.println("USER : "+driver.findElement(By.xpath("//a[contains(text(),'Logged')]")).getText());
		Thread.sleep(1000);
		
//		8. Add products to cart
		js.executeScript("window.scrollBy(0,600)");
		
		driver.findElement(By.xpath("(//div[@class='features_items']//a[contains(text(),'Add to cart')])[5]")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div[@class='features_items']//a[contains(text(),'Add to cart')])[7]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		Thread.sleep(1000);
		
//		9. Click 'Cart' button
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		Thread.sleep(1000);
		
		
//		10. Verify that cart page is displayed
		System.out.println("Cart page is displayed: "+driver.findElement(By.xpath("//li[contains(text(),'Shopping Cart')]")).isDisplayed());
		Thread.sleep(1000);
		
//		11. Click Proceed To Checkout
		driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();
		Thread.sleep(1000);
		
//		12. Verify Address Details and Review Your Order
		System.out.println("Address Details showing : "+driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Review Your Order : "+driver.findElement(By.xpath("//h2[contains(text(),'Review Your Order')]")).isDisplayed());
		Thread.sleep(1000);
		
//		13. Enter description in comment text area and click 'Place Order'
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Testing by QA.");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
		Thread.sleep(1000);
		
//		14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
		driver.findElement(By.xpath("//label[contains(text(),'Name on Card')]/../input")).sendKeys("YES SONIKA");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Card Number')]/../input")).sendKeys("01234567890");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'CVC')]/../input")).sendKeys("1321");
		
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Expiration')]/../input")).sendKeys("02");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2026");
		
//		15. Click 'Pay and Confirm Order' button
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
//		16. Verify success message 'Your order has been placed successfully!'
		//error------------->		
//		System.out.println("Your order has been placed successfully!: "+driver.findElement(By.xpath("//div[contains(text(),'Your order has been placed successfully!')]")).isDisplayed());	//error showing
		System.out.println("Congratulations! Your order has been confirmed!: "+driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]")).isDisplayed());		
		Thread.sleep(2000);		
		
//		17. Click 'Delete Account' button
		driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();
		Thread.sleep(2000);		
		
//		18. Verify 'ACCOUNT DELETED!' and click 'Continue' button	
		System.out.println("ACCOUNT DELETED! displayed: "+driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).isDisplayed());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		Thread.sleep(1000);	
		
		driver.quit();
		System.out.println("Test Case 15 Successfully Executed.");	
		
	}
}
