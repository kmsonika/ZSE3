package AutomationExerciseNew;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class OrderPlace_AfterLogin {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Test Case 16: Place Order: Login before Checkout
		
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
		
//		5. Fill email, password and click 'Login' button
		driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]")).sendKeys("kmsonika7@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("sonika123#");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(1000);	
		
		
//		6. Verify 'Logged in as username' at top
		System.out.println("USER : "+driver.findElement(By.xpath("//a[contains(text(),'Logged')]")).getText());
		Thread.sleep(1000);
		
//		7. Add products to cart
		js.executeScript("window.scrollBy(0,600)");
		
		driver.findElement(By.xpath("(//div[@class='features_items']//a[contains(text(),'Add to cart')])[5]")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div[@class='features_items']//a[contains(text(),'Add to cart')])[7]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		Thread.sleep(1000);
		
		
//		8. Click 'Cart' button
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		Thread.sleep(1000);
		
//		9. Verify that cart page is displayed
		System.out.println("Cart page is displayed: "+driver.findElement(By.xpath("//li[contains(text(),'Shopping Cart')]")).isDisplayed());
		Thread.sleep(1000);
		
		
//		10. Click Proceed To Checkout
		driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();
		Thread.sleep(1000);
		
//		11. Verify Address Details and Review Your Order
		System.out.println("Address Details showing : "+driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]")).isDisplayed());
		Thread.sleep(1000);
		System.out.println("Review Your Order : "+driver.findElement(By.xpath("//h2[contains(text(),'Review Your Order')]")).isDisplayed());
		Thread.sleep(1000);
		
//		12. Enter description in comment text area and click 'Place Order'
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Testing by QA.");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
		Thread.sleep(1000);
		
//		13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
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
		
//		14. Click 'Pay and Confirm Order' button
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
//		15. Verify success message 'Your order has been placed successfully!'
		//error------------->		
//		System.out.println("Your order has been placed successfully!: "+driver.findElement(By.xpath("//div[contains(text(),'Your order has been placed successfully!')]")).isDisplayed());	//error showing
		System.out.println("Congratulations! Your order has been confirmed!: "+driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]")).isDisplayed());		
		Thread.sleep(2000);		
		
//		16. Click 'Delete Account' button
		driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();
		Thread.sleep(2000);		
		
//		17. Verify 'ACCOUNT DELETED!' and click 'Continue' button	
		System.out.println("ACCOUNT DELETED! displayed: "+driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).isDisplayed());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		Thread.sleep(1000);	
		
		driver.quit();
		System.out.println("Test Case 16 Successfully Executed.");	

	}
}
