package AutomationExerciseNew;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.basics.BrowserFactory;

import JavaScriptExecutor.JavaScriptExecutor;

public class AddinCart {
//test
	public static void main(String[] args) throws InterruptedException  
	{
		// Test Case 12: Add Products in Cart

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
		Thread.sleep(1000);
	
//		4. Click 'Products' button
		driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(1000);
		
//		5. Hover over first product and click 'Add to cart'
		WebElement AddToCart=driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]"));
		
		Actions action=new Actions(driver);	
		action.moveToElement(AddToCart).perform();
		Thread.sleep(1000);
		
		AddToCart=driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[2]"));
		AddToCart.click();
		Thread.sleep(1000);

//		6. Click 'Continue Shopping' button
		driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();
		Thread.sleep(2000);
		
//		7. Hover over second product and click 'Add to cart'
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='single-products'])[2]"))).perform();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[4]")).click();
		Thread.sleep(2000);
		
//		8. Click 'View Cart' button
		driver.findElement(By.xpath("//a/u[text()='View Cart']")).click();
		Thread.sleep(2000);
		
//		9. Verify both products are added to Cart
		
		List<WebElement> itemList=driver.findElements(By.xpath("//div[@id='cart_info']//tbody/tr"));
		int itemCount=itemList.size();
		System.out.println("Number of items: "+itemCount);
		Thread.sleep(2000);
		 System.out.println("---------------------------");

		
//		10. Verify their prices, quantity and total price
		for (WebElement item : itemList) {
		    String itemId = item.getAttribute("id");
		    System.out.println("Item ID: " + itemId);

		    WebElement priceElement = item.findElement(By.xpath(".//td[@class='cart_price']/p"));
		    WebElement quantityElement = item.findElement(By.xpath(".//td[@class='cart_quantity']/button"));
		    WebElement totalElement = item.findElement(By.xpath(".//td[@class='cart_total']/p"));

		    String price = priceElement.getText();
		    String quantity = quantityElement.getText();
		    String total = totalElement.getText();

		    System.out.println("Price: " + price);
		    System.out.println("Quantity: " + quantity);
		    System.out.println("Total: " + total);
		    System.out.println("---------------------------");
		}
	
           driver.quit();
		
	}
}
