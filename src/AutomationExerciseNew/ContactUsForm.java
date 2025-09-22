package AutomationExerciseNew;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.basics.BrowserFactory;

public class ContactUsForm 
{
	public static void main(String[] args) throws InterruptedException, AWTException {
		// Test Case 6: Contact Us Form
		
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
		
//		4. Click on 'Contact Us' button
		driver.findElement(By.xpath("//a[contains(text(),'Contact us')]")).click();
		Thread.sleep(1000);
		
//		5. Verify 'GET IN TOUCH' is visible
		WebElement contactEle=driver.findElement(By.xpath("//div/h2[contains(text(),'Get In Touch')]"));
		String Contacttxt=contactEle.getText();
		
		if(Contacttxt.equalsIgnoreCase("GET IN TOUCH"))
		{
			System.out.println("Verify 'GET IN TOUCH' is visible: Passed");
		}
		else 
		{
			System.err.println("Verify 'GET IN TOUCH' is visible: Failed");
		}
		Thread.sleep(1000);
		
//		6. Enter name, email, subject and message
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("sonika G"); //name
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kmsonika67@gmail.com"); //email
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("Testing Purpose Checking"); //subject
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello, this is my code."); //subject
		Thread.sleep(1000);
		
    	JavascriptExecutor js=(JavascriptExecutor)driver;
		
//		7. Upload file
		WebElement file=driver.findElement(By.xpath("//input[@type='file']"));
		
		//Using JavaScriptExecutor
		js.executeScript("arguments[0].click()", file);
		Thread.sleep(1000);
		
		//Performing KeyBoard Operations
	 	Robot robot = new Robot();
		for(int i=0;i<10; i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}		
		Thread.sleep(1000);
		
		for(int i=0;i<2; i++) 
		{
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

		Thread.sleep(1000);	
		}
		
		for(int i=0;i<4; i++) 
		{
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);	
		Thread.sleep(1000);	
		}
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);	
		Thread.sleep(3000);	
	
		
//		8. Click 'Submit' button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

//		9. Click OK button
		
//		Alert handling
		
		//Cancel the alert
		Alert alert=driver.switchTo().alert();
		System.out.println("Alert Cancel message: "+alert.getText());
		alert.dismiss(); 
		Thread.sleep(2000);	
		
		//Accept the alert	
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		alert=driver.switchTo().alert();
		System.out.println("Alert Accept message: "+alert.getText());
		Thread.sleep(1000);	
		alert.accept();  
		Thread.sleep(2000);		
		
//		10. Verify success message 'Success! Your details have been submitted successfully.' is visible
		WebElement successEle=driver.findElement(By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]"));
		String successTxt=successEle.getText();
		if(successTxt.equalsIgnoreCase("Success! Your details have been submitted successfully."))
		{
			System.out.println("Contact Us success message test case: Pass");
		}
		else 
		{
			System.err.println("Contact Us success message test case: Fail");
		}
		
		Thread.sleep(1000);
		
//		11. Click 'Home' button and verify that landed to home page successfully
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		Thread.sleep(3000);
		
		homepage=driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		hometxt=homepage.getText();
		
		if(hometxt.equalsIgnoreCase("Home"))
		{
			System.out.println("Home page verified: Passed");
		}
		else 
		{
			System.out.println("Test case failed for verify home page.");
		}
		Thread.sleep(1000);
		
		driver.quit();
		System.out.println("Code of 'Contact Us Form' running successfully.");

	}
}
