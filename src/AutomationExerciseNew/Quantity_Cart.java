package AutomationExerciseNew;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class Quantity_Cart {

	public static void main(String[] args) throws InterruptedException 
	{	
// Test Case 13: Verify Product quantity in Cart
		
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
		js.executeScript("window.scrollBy(0,550)");
		Thread.sleep(1000);
		
		
//		4. Click 'View Product' for any product on home page
		driver.findElement(By.xpath("(//div[@class='features_items']//div/ul//a[contains(text(),'View Product')])[1]")).click();
		Thread.sleep(1000);
		
		
//		5. Verify product detail is opened
		WebElement productDetails=driver.findElement(By.xpath("//div[@class='product-details']"));
		String ProductTxt=productDetails.getText();
		System.out.println(ProductTxt);
		
		if(productDetails.isDisplayed())
		{
			System.out.println("Product Detail is opened: Passed");
		}
		else 
		{
			System.err.println("Product Detail is not opened: Failed");
		}
		Thread.sleep(1000);
		
		
//		6. Increase quantity to 4
		WebElement quantity=driver.findElement(By.xpath("//input[@name='quantity']"));
		quantity.clear();
		quantity.sendKeys("4");
		Thread.sleep(1000);
		
//		7. Click 'Add to cart' button
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		
//		8. Click 'View Cart' button
		driver.findElement(By.xpath("//u[contains(text(),'View Cart')]")).click();
		Thread.sleep(1000);
				
				
//		9. Verify that product is displayed in cart page with exact quantity
		WebElement CartproductQuantity=driver.findElement(By.xpath("//td[@class='cart_quantity']//button"));
		String productQuantity=CartproductQuantity.getText();
		System.out.println("Product Quantity in Cart:" +productQuantity);
		
		if(productQuantity.equalsIgnoreCase("5"))
		{
			System.out.println("Product is displayed in cart page with exact quantity: Passed");
		}
		else 
		{
			System.err.println("Product is displayed in cart page with exact quantity: Failed");
		}
		Thread.sleep(1000);
		
		driver.quit();
		System.out.println("Test Case 13 successfully executed.");
		
	}

}

