package AutomationExerciseNew;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

import JavaScriptExecutor.JavaScriptExecutor;

public class SearchProduct {

	public static void main(String[] args) throws InterruptedException 
	{
		//Test Case 9: Search Product-------------------------->
		
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
		
//		4. Click on 'Products' button
		driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
		Thread.sleep(1000);

		
//		5. Verify user is navigated to ALL PRODUCTS page successfully
		WebElement allProducts=driver.findElement(By.xpath("//h2[contains(text(),'All Products')]"));
		String allProductActual=allProducts.getText();
		Thread.sleep(2000);
		
		if(allProductActual.equalsIgnoreCase("All Products1"))
		{
			System.out.println("ALL PRODUCTS page verified: Passed");
		}
		else 
		{
			System.err.println("Test case failed for verify ALL PRODUCT page.");
		}
		Thread.sleep(2000);
		
		
		//scroll down
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		
//		6. Enter product name in search input and click search button
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("122");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		
//		7. Verify 'SEARCHED PRODUCTS' is visible
		WebElement searchProduct=driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]"));
		;
		if(searchProduct.isDisplayed())
		{
			System.out.println("SEARCHED PRODUCTS text is showing:"+ searchProduct.getText());
		}
		else 
		{
			System.err.println("SEARCHED PRODUCTS text is not showing.");

		}
		Thread.sleep(2000);
		
//		8. Verify all the products related to search are visible
		List<WebElement> searchedProducts = driver.findElements(By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']"));

		if (searchedProducts.size() > 0) 
		{
		    System.out.println("Total searched products found: " + searchedProducts.size());

		    boolean allVisible = true;
		    for (WebElement product : searchedProducts) 
		    {
		        if (!product.isDisplayed())
		        {
		            allVisible = false;
		            System.err.println("A product is not visible.");
		        }
		    }

		    if (allVisible)
		    {
		        System.out.println("All searched products are visible: Passed");
		    }
		    else 
		    {
		        System.err.println("Some searched products are not visible: Failed");
		    }
		} 
		
		else 
		{
		    System.err.println("No products found related to the search: Failed");
		}	
		
		Thread.sleep(1000);
		
		driver.quit();
		System.out.println("Search product code working fine.");

	}

}
