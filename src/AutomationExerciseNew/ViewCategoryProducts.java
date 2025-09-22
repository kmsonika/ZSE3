package AutomationExerciseNew;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;
import JavaScriptExecutor.JavaScriptExecutor;

public class ViewCategoryProducts {

	public static void main(String[] args) throws InterruptedException 
	{
		// Test Case 18: View Category Products
		
//		1. Launch browser	
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.getTitle();	
		Thread.sleep(1000);

//		2. Navigate to url 'http://automationexercise.com'
		driver.navigate().to("https://automationexercise.com/");
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);

		
//		3. Verify that categories are visible on left side bar
		WebElement categories= driver.findElement(By.xpath("//h2[contains(text(),'Category')]/../div[@id='accordian']"));
		System.out.println("Categories are visible on left side bar : "+categories.isDisplayed());
		System.out.println("Categories : "+categories.getText());
		Thread.sleep(1000);
		
//		4. Click on 'Women' category
		driver.findElement(By.xpath("(//h4//a/span)[1]")).click();
		Thread.sleep(1000);

		
//		5. Click on any category link under 'Women' category, for example: Dress
		driver.findElement(By.xpath("//div[@id='Women']//ul//a[contains(text(),'Dress')]")).click();
		Thread.sleep(1000);

		
//		6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
		System.out.println("Category page is displayed: "+driver.findElement(By.xpath("//h2[contains(text(),'Category')]/../div[@id='accordian']")).isDisplayed());
		WebElement webwomentTops=driver.findElement(By.xpath("//h2[contains(text(),'Women - Dress Products')]"));
		if (webwomentTops.getText().equals("Women - Dress Products"))
		{
			System.out.println("confirm text 'WOMEN - TOPS PRODUCTS' : "+webwomentTops.getText());
		}
		else
		{
			System.err.println("Text 'WOMEN - TOPS PRODUCTS is not displayed");
		}		
		Thread.sleep(1000);

//		7. On left side bar, click on any sub-category link of 'Men' category
		driver.findElement(By.xpath("(//div//h4//a)[2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='Jeans ']")).click();
		Thread.sleep(1000);
	
//		8. Verify that user is navigated to that category page
		WebElement mensCategory=driver.findElement(By.xpath("//h2[text()='Men - Jeans Products']"));
		System.out.println("Men's Category page is displayed: "+mensCategory.isDisplayed());
		System.out.println("Text Men - Jeans Products is matched with : "+mensCategory.getText());
		Thread.sleep(1000);


		driver.quit();
		System.out.println("Test Case 18 Successfully Executed.");	

		
	}
}
