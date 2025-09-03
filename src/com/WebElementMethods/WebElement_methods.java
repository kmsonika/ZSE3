package com.WebElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.basics.BrowserFactory;

public class WebElement_methods{
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getTitle());
		
		//Task-4,7 Login/Logout On OrangeHRM
		Thread.sleep(3000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		//driver.navigate().back();
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("p[class='oxd-userdropdown-name']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
		
		
		
		//Task-5 After clicking on Forgot Password,click on Reset password and print "Reset password succ.." ,message given on screen, and compare excepted message and actual message.
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
	
		//driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //--->	//forgot password is not clicking by 7 locators.
		//driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		System.out.println("End of code.");
		driver.quit();
		
	}
}
