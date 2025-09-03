package com.LocatorUnderstanding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

public class Locators {
	public static void main(String[] args)
	{
	   WebDriver driver=BrowserFactory.launchBrowser("chrome");
	   driver.manage().window().maximize();
	   
	  driver.get("https://www.facebook.com/");
	   //driver.get("https://demoqa.com/automation-practice-form");
	   
	   //1. ID
	  WebElement username=driver.findElement(By.id("email"));  
	   
	   //2. name
	  WebElement password=driver.findElement(By.name("pass")); 
	   
	   //3. tagname
	  WebElement button=driver.findElement(By.tagName("button"));
	   
	   //4. className
	   // driver.get("https://demoqa.com/automation-practice-form");
	   //WebElement cl=driver.findElement(By.className("form-control-file"));
	   
	   //5. linkText()
	   WebElement link=driver.findElement(By.linkText("Forgotten password?"));
	   
	  //6. partialLinkText()
	  WebElement pl= driver.findElement(By.partialLinkText("Forgotten"));
	  
	//7. partialLinkText()
	  WebElement css= driver.findElement(By.cssSelector("input[type='text']"));
	  
	   System.out.println("End of code");
      driver.quit();
	}

}
