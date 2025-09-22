package AutomationExerciseNew;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.basics.BrowserFactory;

public class SubscriptionHome 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Test Case 10: Verify Subscription in home page
		
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
		
		if(homepage.getText().equalsIgnoreCase("Home"))
		{
			System.out.println("Home page verified: Passed");
		}
		else 
		{
			System.out.println("Test case failed for verify home page.");
		}
		Thread.sleep(1000);

		
//		4. Scroll down to footer
		WebElement subscriptionEle=driver.findElement(By.xpath("//h2[text()='Subscription']"));
		
		Actions action=new Actions(driver);
		action.moveToElement(subscriptionEle).perform();
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(1000);
		
//		5. Verify text 'SUBSCRIPTION'
		if(subscriptionEle.isDisplayed())
		{
			System.out.println("SUBSCRIPTION is visible on Home page.");
		}
		else 
		{
			System.err.println("SUBSCRIPTION is not visible on Home page.");
		}
		
//		6. Enter email address in input and click arrow button
		driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("kmsonika@gmail.com");		
		driver.findElement(By.xpath("//button[@id='subscribe']")).click();
		
//		7. Verify success message 'You have been successfully subscribed!' is visible
		WebElement subscribed=driver.findElement(By.xpath("//div[contains(text(),'You have been successfully subscribed!')]"));
		
		if(subscribed.getText().equalsIgnoreCase("You have been successfully subscribed!"))
		{
			System.out.println("Success message verified after SUBSCRIPTION: " + subscribed.getText());
		}
		else 
		{
			System.err.println("Success message not visible after SUBSCRIPTION.");
		}
		Thread.sleep(2000);
		
		driver.quit();
		System.out.println("Home page SUBSCRIPTION code working fine.");
		
	}
}
