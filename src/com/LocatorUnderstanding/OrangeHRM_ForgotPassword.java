package com.LocatorUnderstanding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

public class OrangeHRM_ForgotPassword {
	
//Task- Compare expected word and actual word	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=BrowserFactory.launchBrowser("chrome");                                     //Launch Browser
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  //Navigate on Orange HRM
		System.out.println("Application Title is: "+driver.getTitle());
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//form/div//div[2]/input")).sendKeys("Admin");
		driver.findElement(By.xpath("//form/div[2]//div[2]/input")).sendKeys("admin123");
		driver.findElement(By.xpath("//form/div[3]/button")).click();                                //LogIn Orange HRM

		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
		driver.findElement(By.xpath("(//a[@role='menuitem'])[4]")).click();           //Logout from Orange HRM
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//form/div/p")).click();                         //Click on "forgot password" button
		
		//Forgot Password page
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");  //Enter email
		driver.findElement(By.xpath("//button[@type='submit']")).click();             //Click on "Reset Password" button
		
		//Compare expected word and actual word		
		String expectedStr="Reset Password link sent successfully";                  //Expected String
		System.out.println("Expected String is: "+expectedStr);
		
		Thread.sleep(3000);
		WebElement Str=driver.findElement(By.xpath("//div/h6"));
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
		
		Thread.sleep(2000);
		driver.close();                                                               //Closing tab.
		System.out.println("Code Run Successfully.");
	}
}
