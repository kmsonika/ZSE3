package AutomationExerciseNew;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class ProductDetails {

	public static void main(String[] args) throws InterruptedException 
	{
		// Test Case 8: Verify All Products and product detail page
		
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
		
//		4. Click on 'Products' button
		driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
		Thread.sleep(1000);
		
		//scrolling for viewing all products
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
	
		
//		5. Verify user is navigated to ALL PRODUCTS page successfully
		WebElement allProducts=driver.findElement(By.xpath("//h2[contains(text(),'All Products')]"));
		String allProductActual=allProducts.getText();
		Thread.sleep(1000);
		
		if(allProductActual.equalsIgnoreCase("All Products"))
		{
			System.out.println("ALL PRODUCTS verified: Passed");
		}
		else 
		{
			System.out.println("Test case failed for verify ALL PRODUCT page.");
		}
		Thread.sleep(1000);
		
//		6. The products list is visible
		List<WebElement> ProductListEle= driver.findElements(By.xpath("//h2[contains(text(),'All Products')]/.."));
		System.out.println("No. of items: "+ProductListEle.size());
	
		if (!ProductListEle.isEmpty()) 
		{
            System.out.println("Products list is visible. Total products found: " + ProductListEle.size());
        } else 
        {
            System.out.println("Products list is NOT visible.");
        }		
		

//		7. Click on 'View Product' of first product
		WebElement viewProduct=driver.findElement(By.xpath("(//div[@class='choose']/ul/li/a)[1]"));
		String view=viewProduct.getAttribute("href");
		viewProduct.click();		
		Thread.sleep(2000);
		
//		8. User is landed to product detail page
		String expLink="https://automationexercise.com/product_details/1";
		if(view!=null && view.equalsIgnoreCase(expLink))
		{
			System.out.println("User is Landed to Product Details.");
		}
		else
		{
			System.err.println("User is not Landed to Product Details.");
			System.out.println("Excepted URL: "+expLink);
			System.out.println("Actual Url: "+view);
		}
		Thread.sleep(2000);
		
//		9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
		WebElement productInfo=driver.findElement(By.xpath("//div[@class='product-information']"));
		Thread.sleep(1000);
		
		String productName = productInfo.findElement(By.xpath("//div[@class='product-information']//h2")).getText();
		String category = productInfo.findElement(By.xpath("(//div[@class='product-information']/p)[1]")).getText();
		String price = productInfo.findElement(By.xpath("//div[@class='product-information']/span/span")).getText();
		String availability = productInfo.findElement(By.xpath("(//div[@class='product-information']/p)[2]")).getText();
		String condition = productInfo.findElement(By.xpath("(//div[@class='product-information']/p)[3]")).getText();
		String brand = productInfo.findElement(By.xpath("(//div[@class='product-information']/p)[4]")).getText();
		Thread.sleep(1000);
		
// Print and verify each detail
		System.out.println("Product Name: " + productName);
		System.out.println("Category: " + category);
		System.out.println("Price: " + price);
		System.out.println("Availability: " + availability);
		System.out.println("Condition: " + condition);
		System.out.println("Brand: " + brand);
		
		if( !productName.isEmpty() && !category.isEmpty() && !price.isEmpty() && !availability.isEmpty() && !condition.isEmpty() && !condition.isEmpty() && !brand.isEmpty() )
		{
			System.out.println("Product details are visible: Passed");
		}
		else 
		{
			System.err.println("Product details are missing: Failed");
		}
		Thread.sleep(1000);	
		
		driver.quit();
		System.out.println("Product details page has been verified.");

	}
}
