package AutomationExerciseNew;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.basics.BrowserFactory;

public class AddressDetails_CheckoutPage 
{

	public static void main(String[] args) throws InterruptedException 
	{
		// Test Case 23: Verify address details in checkout page

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
		WebElement username=driver.findElement(By.xpath("//input[@placeholder='Name']"));
		username.sendKeys("Sonika0022");
		WebElement email=driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]"));
		email.sendKeys("kmsonika10102@gmail.com");
		Thread.sleep(1000);
		
		// Click 'Signup' button
				WebElement signUp=driver.findElement(By.xpath("//button[text()='Signup']"));
				signUp.click();
				Thread.sleep(2000);			
				
//				WebElement EmailAlreadyExist=driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]"));			
//				if(EmailAlreadyExist.isDisplayed())
//				{
//					username.clear();
//					Thread.sleep(1000);
//					username.sendKeys("Sonika1002");
//					Thread.sleep(1000);
//					email.clear();
//					Thread.sleep(1000);
//					email.sendKeys("kmsonika2002@gmail.com");
//					Thread.sleep(1000);
//					signUp.click();
//				}
//				else
//				{
//					System.out.println("Email id already does not exist.");
//				}
//				
				
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
		
		
//		12. Verify that the delivery address is same address filled at the time registration of account
		System.out.println("'Your delivery address' is displayed : "+driver.findElement(By.xpath("//h3[contains(text(),'Your delivery address')]")).isDisplayed());
		
		WebElement DeliveryAddress=driver.findElement(By.xpath("//ul[@id='address_delivery']"));
		String DeliveryDetails=DeliveryAddress.getText();
		System.out.println("Delivery Address is: /n"+DeliveryDetails);
		
		if(DeliveryDetails.contains("sonika gautam") && DeliveryDetails.contains("DNK") && DeliveryDetails.contains("DNK") && DeliveryDetails.contains("G.Noida UP 123456") && DeliveryDetails.contains("India") && DeliveryDetails.contains("9876543210"))
		{
			System.out.println("Delivery address matches registration details.");
		}
		else
		{
			System.err.println("Delivery address does not match");
		}
		Thread.sleep(2000);	
		
//		13. Verify that the billing address is same address filled at the time registration of account
		System.out.println("'Billing Address section visible: : "+driver.findElement(By.xpath("//h3[contains(text(),'Your billing address')]")).isDisplayed());
		
		WebElement billingAddress=driver.findElement(By.xpath("//ul[@id='address_invoice']"));
		String billingDetails=billingAddress.getText();
		System.out.println("Billing Address is: /n"+billingDetails);
		
		if(billingDetails.contains("sonika gautam") && billingDetails.contains("DNK1") && billingDetails.contains("DNK") && billingDetails.contains("G.Noida UP 123456") && billingDetails.contains("India") && DeliveryDetails.contains("9876543210"))
		{
			System.out.println("Billing address matches registration details.");
		}
		else
		{
			System.err.println("Billing address does not match");
		}
		Thread.sleep(2000);	
		
//		14. Click 'Delete Account' button
		driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();
		Thread.sleep(2000);	
		
//		15. Verify 'ACCOUNT DELETED!' and click 'Continue' button		
		System.out.println("ACCOUNT DELETED! displayed: "+driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).isDisplayed());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		Thread.sleep(1000);		
				
		 driver.quit();
		 System.out.println("Test Case 23 Successfully Executed.");	
		 
	}
}
