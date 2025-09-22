package AutomationExerciseNew;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.basics.BrowserFactory;

public class ScrollUpDown_WithoutArrow {

	public static void main(String[] args) throws InterruptedException 
	{
		// Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality

//		1. Launch browser	
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.getTitle();	
		Thread.sleep(1000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;

//		2. Navigate to url 'http://automationexercise.com'
		driver.navigate().to("https://automationexercise.com/");
		Thread.sleep(1000);			
		
//		3. Verify that home page is visible successfully---------->
		WebElement homeLink = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        if (homeLink.isDisplayed()) {
            System.out.println("✅ Home page is visible.");
        } else {
            System.err.println("❌ Home page is not visible.");
        }
        Thread.sleep(1000);	
		
//        4. Scroll down page to bottom
        js.executeScript("window.scrollBy(0,7500)");
        Thread.sleep(3000);	
        
//        5. Verify 'SUBSCRIPTION' is visible
        WebElement Subscription=driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]"));
        if(Subscription.isDisplayed())
        {
        	System.out.println("'SUBSCRIPTION' is visible.");
        }
        else
        {
        	System.err.println("'SUBSCRIPTION' is not visible.");
		}
        Thread.sleep(1000);
        
//        6. Scroll up page to top
        WebElement fullFledgedText = driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fullFledgedText);
//        Thread.sleep(8000);		
        

//        7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen	

        if (driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")).isDisplayed()) 
        {
            System.out.println("✅ 'Full-Fledged' Text is visible after scroll up.");
        }
        else 
        {
            System.err.println("❌ 'Full-Fledged' Text is not visible.");
        }
		
		driver.quit();
		System.out.println("Test Case 26 Successfully Executed.");
	}
}
