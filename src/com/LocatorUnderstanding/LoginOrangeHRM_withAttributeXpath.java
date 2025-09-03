package com.LocatorUnderstanding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.basics.BrowserFactory;

public class LoginOrangeHRM_withAttributeXpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Application Title is :"+driver.getTitle());
		
//1. Login Orange HRM using "Xpath by Attribute"
		//username-->//input[@name='username']
		//password--->//input[@name='password']
		//Login button---->//button[@type='submit']
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();                    //Login  (Xpath by Attribute)
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
		driver.findElement(By.xpath("(//a[@role='menuitem'])[4]")).click();                  //Logout
 
//2. Login Orange HRM using "Relative Xpath" + "absolute Xpath"
		        //username-->//form/div//div[2]/input
				//password--->//form/div[2]//div[2]/input
				//Login button---->//form/div[3]/button
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//form/div//div[2]/input")).sendKeys("Admin");
		driver.findElement(By.xpath("//form/div[2]//div[2]/input")).sendKeys("admin123");
		driver.findElement(By.xpath("//form/div[3]/button")).click();                        //Login   (Relative Xpath + absolute Xpath)
		
			System.out.println("Code Run Successfully.");
			driver.quit();
	}
}
