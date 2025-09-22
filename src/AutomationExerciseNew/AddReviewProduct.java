package AutomationExerciseNew;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class AddReviewProduct 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Test Case 21: Add review on product
		
//		1. Launch browser	
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.getTitle();	
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;

//		2. Navigate to url 'http://automationexercise.com'
		driver.navigate().to("https://automationexercise.com/");
		Thread.sleep(1000);		
		

//		3. Click on 'Products' button
		driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
		
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		
//		4. Verify user is navigated to ALL PRODUCTS page successfully
		System.out.println("ALL PRODUCTS page is visible : "+driver.findElement(By.xpath("//div//h2[contains(text(),'Products')]")).isDisplayed());
		
//		5. Click on 'View Product' button
		driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]")).click();
		
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		
//		6. Verify 'Write Your Review' is visible
		System.out.println("Write Your Review' is visible : "+driver.findElement(By.xpath("//a[contains(text(),'Write Your Review')]")).isDisplayed());
		
//		7. Enter name, email and review
		driver.findElement(By.xpath("//input[@placeholder='Your Name']")).sendKeys("Sonika Gautam");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("kmsonika009@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@placeholder='Add Review Here!']")).sendKeys("Testing by qa.");
		Thread.sleep(1000);
		
//		8. Click 'Submit' button
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		Thread.sleep(1000);
		
//		9. Verify success message 'Thank you for your review.'		
		WebElement reviewMessage=driver.findElement(By.xpath("//span[contains(text(),'Thank you for your review.')]"));
		
		if(reviewMessage.getText().equalsIgnoreCase("Thank you for your1 review."))
		{
			System.out.println("Success message 'Thank you for your review.' is showing : Passed");
		}
		else
		{
			System.err.println("Success message 'Thank you for your review.' is showing : Failed");
		}
		Thread.sleep(1000);
		
		driver.quit();
		System.out.println("Test Case 21 Successfully Executed.");	
	}
}
