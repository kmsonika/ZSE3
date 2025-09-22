package AutomationExerciseNew;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class AddToCart_RecommendedItems {

	public static void main(String[] args) throws InterruptedException {
		// Test Case 22: Add to cart from Recommended items
		
//		1. Launch browser	
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.getTitle();	
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;

//		2. Navigate to url 'http://automationexercise.com'
		driver.navigate().to("https://automationexercise.com/");
		Thread.sleep(1000);	
		
//		3. Scroll to bottom of page
		js.executeScript("window.scrollBy(0,7500)");
		Thread.sleep(1000);	
		
//		4. Verify 'RECOMMENDED ITEMS' are visible		
		System.out.println("'RECOMMENDED ITEMS' Text is visible : "+driver.findElement(By.xpath("//div[@class='recommended_items']/h2")).isDisplayed());
		Thread.sleep(4000);	
		
//		5. Click on 'Add To Cart' on Recommended product
		driver.findElement(By.xpath("(//div[@class='single-products']//p[contains(text(),'Men Tshirt')])[3]/..//a")).click();
		Thread.sleep(2000);	
		
//		6. Click on 'View Cart' button
		driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();		
		Thread.sleep(2000);	
		
		//testing empty cart
//		js.executeScript("window.scrollBy(0,-7500)");
//		Thread.sleep(2000);	
//		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
//		Thread.sleep(2000);	
			
//		7. Verify that product is displayed in cart page
		List<WebElement> recommendedProducts=driver.findElements(By.xpath("//div[@id='cart_info']//tbody"));
		if(!recommendedProducts.isEmpty())
		{
			System.out.println("Products are available in Cart.");
		}
		else
		{
			System.err.println("Products are not available in Cart.");
		}
		Thread.sleep(1000);
		
        driver.quit();
	    System.out.println("Test Case 22 Successfully Executed.");	
	}
}
