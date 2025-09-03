package OrangeHRM;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.WebElements.WebElements;
import com.basics.BrowserFactory;

public class TerminateUser 
{
//2. Terminate the created user using admin, and user should not be able to login anymore and get proper error message on logging
	public static void main(String[] args) throws InterruptedException 
	{
		
		// Launch Browser
		WebDriver driver=BrowserFactory.launchBrowser("Chrome");
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Application Title : "+driver.getTitle());		
		Thread.sleep(3000);
		
		// Login OrangeHRM with Admin
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();				
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[.='Admin']")).click();
		Thread.sleep(1000);
		
		//search user
		driver.findElement(By.xpath("//div/div[2]/input")).sendKeys("sonikagautam1");
		driver.findElement(By.xpath("(//div/button[2])[1]")).click();
		Thread.sleep(3000);
		
		//delete user
		driver.findElement(By.xpath("(//div[1]/button[@type=\"button\"])[4]")).click();
		driver.findElement(By.xpath("(//div /button[@type=\"button\"])[9]")).click();
		Thread.sleep(3000);

		// Logout OrangeHRM
		WebElement profile2=driver.findElement(By.xpath("//div/ul/li/span/p"));
		profile2.click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(3000);
		
		//try to Login with deleted user
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sonikagautam1");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
		
		//print error message	-->Invalid credentials
		String expectedStr="Invalid credentials";                  //Expected String
		System.out.println("Expected String is: "+expectedStr);
		
		Thread.sleep(2000);
		WebElement Str=driver.findElement(By.xpath("//div//p[text()='Invalid credentials']"));
		String actualStr=Str.getText();
		System.out.println("Actual String is: "+actualStr);                           //Actual String
		
		if(actualStr.equalsIgnoreCase(expectedStr))                                   //Comparing actual result and expected result
		{
			System.out.println("Test Case Passed.");
		}
		else 
		{
			System.out.println("Test Case Failed.");
		}
         Thread.sleep(3000);
		
         //Closing browser
           driver.quit();
           System.out.println("Code Run Successfully.");
		}		
	}


