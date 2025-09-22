package AutomationExerciseNew;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import com.basics.BrowserFactory;

public class TestCasePage {

	public static void main(String[] args) throws InterruptedException 
	{
		// Test Case 7: Verify Test Cases Pageb
		
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

//		4. Click on 'Test Cases' button
		driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]")).click();
		Thread.sleep(1000);
		
//		5. Verify user is navigated to test cases page successfully
		WebElement TestCaseEle=driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]"));
		String attributelink=TestCaseEle.getAttribute("href");
		System.out.println("Test case page link: "+attributelink);
		String txt="https://automationexercise.com/test_cases";
		
		if(attributelink.equalsIgnoreCase(txt))
		{
			System.out.println("Test cases page verified successfully: Pass");
		}
		else {
			System.err.println("Test Case page:Fail");
		}
		
		driver.quit();
		System.out.println("Code of 'Test Case Page' running successfully.");


	}

}
