package AutomationExerciseNew;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class RemoveProducts {

	public static void main(String[] args) throws InterruptedException {
		//Test Case 17: Remove Products From Cart

//		1. Launch browser
    	WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();	
		Thread.sleep(1000);

//		2. Navigate to url
		driver.navigate().to("http://automationexercise.com");
		driver.getTitle();
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
		Thread.sleep(1000);
		
		//Scrolling on Home page
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(1000);
		
		
//		4. Add products to cart
		driver.findElement(By.xpath("(//div[@class='features_items']//a[contains(text(),'Add to cart')])[3]")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div[@class='features_items']//a[contains(text(),'Add to cart')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		
//		5. Click 'Cart' button
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		Thread.sleep(1000);
		
//		6. Verify that cart page is displayed
		System.out.println("Cart page is displayed: "+driver.findElement(By.xpath("//li[contains(text(),'Shopping Cart')]")).isDisplayed());
		Thread.sleep(1000);
		
//		7. Click 'X' button corresponding to particular product
		driver.findElement(By.xpath("(//a[@class='cart_quantity_delete'])[1]")).click();
		//driver.findElement(By.xpath("(//a[@class='cart_quantity_delete'])[2]")).click();
		
//		8. Verify that product is removed from the cart
		//System.out.println("Verify product is removed from the cart: "+driver.findElement(By.xpath("//div[@id='cart_info']//tbody")).isDisplayed());
		
		List<WebElement> cartItems = driver.findElements(By.xpath("//tr[@id='product-1']")); // Adjust ID if needed

		if (cartItems.size() == 0) {
		    System.out.println("✅ Product successfully removed from the cart.");
		} else {
		    System.out.println("❌ Product still present in the cart.");
		}

		
		driver.quit();
		System.out.println("Test Case 17 Successfully Executed.");	

	}

}
