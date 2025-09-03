package com.WebElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

public class Keyboard_Operation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
        //Clear()
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).clear(); 
		
		//keyboard operations
		//1. BACK_SPACE
		WebElement username=driver.findElement(By.name("username"));
		username.sendKeys("Admins"); //wrong username entered, now we using keyboard operation to perform task
		Thread.sleep(3000);
		username.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.name("username")).clear(); //--> field data is not clearing here
		Thread.sleep(3000);
		username.sendKeys(Keys.CONTROL + "a");
		username.sendKeys(Keys.CONTROL + "c");
		username.sendKeys(Keys.DELETE);
		
		
		//2. CONTROL + ("a" or "v" ....etc)
		username.sendKeys("adminertyui5678"); 
		Thread.sleep(3000);
		username.sendKeys(Keys.CONTROL+"a");
		username.sendKeys(Keys.DELETE); //OR username.sendKeys(Keys.BACK_SPACE);--->//here we need to clear all text in username field.
		
		//want to send sometext directly
//		username.sendKeys(Keys.SHIFT,"admin 1");  //here 1 becomes ! because of shift key, so now we will using NUMPAD 1 value.
		username.sendKeys(Keys.SHIFT,"admin ");
		username.sendKeys(Keys.NUMPAD1);  //"admin 1" will enter in field.
		Thread.sleep(3000);
		
		//copy and past
		WebElement password=driver.findElement(By.cssSelector("input[name='password']"));
		password.sendKeys(Keys.CONTROL+"v");
		
		
		//Task7. Clear the entire text without using clear()---------???
		
		
		Thread.sleep(3000);
		System.out.println("End of code.");
		driver.quit();
	}

}
