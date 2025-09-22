package AutomationExerciseNew;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class SearchProducts_VerifyCartAfterLogin 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Test Case 20: Search Products and Verify Cart After Login
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
		
//		5. Enter product name in search input and click search button
		driver.findElement(By.xpath("//input[@placeholder='Search Product']")).sendKeys("Tshirt");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='submit_search']")).click();
		Thread.sleep(1000);
		
//		6. Verify 'SEARCHED PRODUCTS' is visible
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(1000);
		System.out.println("SEARCHED PRODUCTS page is visible : "+driver.findElement(By.xpath("//div//h2[contains(text(),'Searched Products')]")).isDisplayed());
		
//		7. Verify all the products related to search are visible
		List<WebElement> searchResults=driver.findElements(By.xpath("//div[@class='features_items']//div[@class='single-products']"));
		List<WebElement> productResults=driver.findElements(By.xpath("//div[@class='features_items']//div[@class='single-products']//p"));
		if (!searchResults.isEmpty()) 
		{
		    System.out.println("Search results are visible. Total products found: " + searchResults.size());
		    for (WebElement product : productResults) 
		    {
		        if (product.isDisplayed()) 
		        {
		            System.out.println("- " + product.getText());
		        } 
		    }
		} 
		else 
		{
		    System.err.println("❌ No products found for the search.");
		}
		Thread.sleep(1000);
		
//		8. Add those products to cart
		
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		//js.executeScript("argument[0].click();",driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		Thread.sleep(2000);
		
		System.out.println("Continue Shopping button clicked.");
		Thread.sleep(1000);
		
//		9. Click 'Cart' button and verify that products are visible in cart
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		Thread.sleep(1000);
	
		
		List<WebElement> cartProducts=driver.findElements(By.xpath("//div[@id='cart_info']//tbody"));
		if(!cartProducts.isEmpty())
		{
			System.out.println("Products are available in Cart.");
		}
		else
		{
			System.err.println("Products are not available in Cart.");
		}
		Thread.sleep(1000);
		
//		10. Click 'Signup / Login' button and submit login details
		driver.findElement(By.xpath("//a[contains(text(),'Signup')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]")).sendKeys("kmsonika1002@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("sonika123#");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(1000);	
		
		
//		11. Again, go to Cart page
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		
//		12. Verify that those products are visible in cart after login as well						
		List<WebElement> cartProducts2=driver.findElements(By.xpath("//div[@id='cart_info']//tbody"));
		
		if(!cartProducts2.isEmpty())
		{
			System.out.println("Products are available in Cart.");
			System.out.println("Prodduct details are: "+driver.findElement(By.xpath("//div[@id='cart_info']//tbody/tr")).getText());
		}
		else
		{
			System.err.println("Products are not available in Cart.");
		}
		Thread.sleep(1000);
		
		
		driver.quit();
		System.out.println("Test Case 20 Successfully Executed.");	
		
	}
}
