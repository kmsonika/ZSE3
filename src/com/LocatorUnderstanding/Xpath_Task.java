package com.LocatorUnderstanding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.basics.BrowserFactory;

public class Xpath_Task {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		System.out.println("Application title is: "+driver.getTitle());
		
		//TASK 8--->Xpath Task (Absolute Xpath)
			
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[1]/div[2]/input")).sendKeys("Sonika");  //FirstName
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[1]/div[4]/input")).sendKeys("Gautam");  //LastName
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[2]/div[2]/input\r\n")).sendKeys("kmsonika7@gmail.com"); //Email
		
		//Gender
    	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[3]/div[2]/div[1]")).click();  //Male
    	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[3]/div[2]/div[3]")).click(); //Other
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[3]/div[2]/div[2]")).click(); //Female
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[4]/div[2]/input")).sendKeys("9876543210"); //Mobile Number
		
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[5]/div[2]/div/div/input")).click(); //DOB
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[4]/div[2]/input")).click(); //Mobile Number
		
		//Subject
		WebElement subject=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[6]/div[2]/div/div/div[1]/div[2]/div/input"));
		Thread.sleep(3000);
		subject.sendKeys("s"); //subject.sendKeys("Hindi")
		subject.sendKeys(Keys.ARROW_DOWN); //OR //subject.sendKeys(Keys.ENTER);  
		subject.sendKeys(Keys.ENTER);
		subject.sendKeys("en");
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ARROW_UP);
		subject.sendKeys(Keys.ENTER);
		

		//Hobbies
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[1]/label")).click(); //Sports
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[2]/label")).click(); //Reading
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[7]/div[2]/div[3]/label")).click(); //Music
		

		//driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[8]/div[2]/div/input")).click(); //image
            
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[9]/div[2]/textarea")).sendKeys("Greater Noida, UP, 203201");  //current address
		
      //here is selection dropdown--issue
//		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[10]/div[2]/div")).click(); //State
//		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[10]/div[3]/div")).click(); //City
		
        Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[11]/div/button")).click(); //Submit
		
//Problem--> when we scrolling down page manually then elements are finding and values are entering otherwise "ElementClickInterceptedException" coming.
				
		Thread.sleep(2000);
		System.out.println("End of code.");
		driver.quit();

	}
}
