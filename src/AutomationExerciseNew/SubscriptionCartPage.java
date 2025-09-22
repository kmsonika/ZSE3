package AutomationExerciseNew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class SubscriptionCartPage {

	public static void main(String[] args) throws InterruptedException 
	{
		// Test Case 11: Verify Subscription in Cart page
		
//		1. Launch browser
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.getTitle();	
		Thread.sleep(1000);

//		2. Navigate to url 'http://automationexercise.com'
		driver.navigate().to("http://automationexercise.com");
		Thread.sleep(1000);

//		3. Verify that home page is visible successfully---------->
		WebElement homepage=driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		String hometxt=homepage.getText();
		
		if(hometxt.equalsIgnoreCase("Home"))
		{
			System.out.println("Home page verified: Passed");
		}
		else 
		{
			System.out.println("Test case failed for verify home page.");
		}
		Thread.sleep(2000);
		
//		4. Click 'Cart' button
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		Thread.sleep(1000);

//		5. Scroll down to footer
		
		
		
//		6. Verify text 'SUBSCRIPTION'
		WebElement SubscriptionCart=driver.findElement(By.xpath("//h2[.='Subscription']"));
		String subscriptionCartText=SubscriptionCart.getText();
		Thread.sleep(1000);
		if(subscriptionCartText.equalsIgnoreCase("Subscription"))
		{
			System.out.println("Subsription is available on Cart page.");
		}
		else 
		{
			System.err.println("Subsription is not available on Cart page.");
		}
		Thread.sleep(1000);
		
//		7. Enter email address in input and click arrow button
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kmsonika@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		
//		8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement subscribedCartPage=driver.findElement(By.xpath("//div[contains(text(),'You have been successfully subscribed!')]"));
		
		if(subscribedCartPage.getText().equalsIgnoreCase("You have been successfully subscribed!"))
		{
			System.out.println("Success message verified after SUBSCRIPTION: " + subscribedCartPage.getText());
		}
		else 
		{
			System.err.println("Success message not visible after SUBSCRIPTION.");
		}

			
		driver.quit();
		System.out.println("");

	}
}
