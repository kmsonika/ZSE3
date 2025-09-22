package AutomationExerciseNew;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

public class View_CartBrandProducts {

	public static void main(String[] args) throws InterruptedException 
	{
		// Test Case 19: View & Cart Brand Products
		
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
		
//		4. Verify that Brands are visible on left side bar		
		System.out.println("Number of Brands : "+driver.findElements(By.xpath("//div[@class='brands-name']//ul/li")).size());
		
		List<WebElement> BrandsName=driver.findElements(By.xpath("//div[@class='brands-name']/ul//li//a"));		
		for(WebElement Brands : BrandsName)
		{
		System.out.println("Brands Name:"+Brands.getText());
		}
		
		WebElement brands= driver.findElement(By.xpath("//div[@class='brands-name']/ul"));			
		if(brands.isDisplayed())
		{
			System.out.println("Brands are visible on left side bar.");
		}
		else 
		{
			System.err.println("Brands are not visible on left side bar.");
		}
		Thread.sleep(1000);
		
//		5. Click on any brand name
		driver.findElement(By.xpath("//div[@class='brands-name']/ul/li/a[text()='H&M']")).click();
		Thread.sleep(1000);
		
//		6. Verify that user is navigated to brand page and brand products are displayed
		WebElement brandHM= driver.findElement(By.xpath("//h2[contains(text(),'H&M Products')]"));
		if(brandHM.isDisplayed())
		{
			System.out.println("H&M Brand Page is visible.");
		}
		else 
		{
			System.err.println("H&M Brand Page is not visible.");
		}
		Thread.sleep(1000);
		
		List<WebElement> brandProducts=driver.findElements(By.xpath("//div[@class='features_items']//div[@class='single-products']"));		
		if(!brandProducts.isEmpty())
		{
			System.out.println("Brand Products are available: "+brandProducts.size());
		}
		else 
		{
			System.err.println("Brand Products are not available.");
		}
		
		List<WebElement> brandProductsDetails=driver.findElements(By.xpath("//div[@class='features_items']//div[@class='single-products']//p"));
		for(WebElement productName: brandProductsDetails) 
		{
			if(productName.isDisplayed())
			{
			System.out.println("H&M Product Name is: "+productName.getText());
		    }
		}
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);

		
//		7. On left side bar, click on any other brand link
		driver.findElement(By.xpath("//div[@class='brands-name']/ul/li/a[text()='Biba']")).click();
		Thread.sleep(1000);
		
//		8. Verify that user is navigated to that brand page and can see products
		WebElement brandBiba= driver.findElement(By.xpath("//div[@class='brands-name']/ul/li/a[text()='Biba']"));
		if(brandBiba.isDisplayed())
		{
			System.out.println("BiBa Brand Page is visible.");
		}
		else 
		{
			System.err.println("BiBa Brand Page is not visible.");
		}
		Thread.sleep(1000);
		
		List<WebElement> BibaProducts=driver.findElements(By.xpath("//div[@class='features_items']//div[@class='single-products']"));		
		if(!BibaProducts.isEmpty())
		{
			System.out.println("BiBa Brand Products are available: "+BibaProducts.size());
		}
		else 
		{
			System.err.println("BiBa Brand Products are not available.");
		}
		
		List<WebElement> BibabrandProductsDetails=driver.findElements(By.xpath("//div[@class='features_items']//div[@class='single-products']//p"));
		for(WebElement BibaproductName: BibabrandProductsDetails) 
		{
			if(BibaproductName.isDisplayed())
			{
			System.out.println("BiBa Product Name is: "+BibaproductName.getText());
		    }
		}
		Thread.sleep(1000);
		
		
		driver.quit();
		System.out.println("Test Case 19 Successfully Executed.");	
		
	}
}
