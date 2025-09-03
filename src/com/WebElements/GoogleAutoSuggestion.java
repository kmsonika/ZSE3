package com.WebElements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class GoogleAutoSuggestion 
{
	
//Task -> click on auto suggested lined while searching on google
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("Application Title is: "+driver.getTitle());
		
		WebElement element=driver.findElement(By.xpath("//textarea[@aria-label='Search']"));
		element.sendKeys("Selenium Java");
		element.click();
		Thread.sleep(2000);
		
	//2. click by arrow down----->
//		element.sendKeys(Keys.DOWN);
//		element.sendKeys(Keys.DOWN);
//		element.sendKeys(Keys.DOWN);
//		element.click();
//		Thread.sleep(2000);

		List<WebElement> links=driver.findElements(By.xpath("(//div[@class='OBMEnb'])[1]//b"));
		Thread.sleep(2000);
		
//		//1. Click by Text----->
		for(WebElement el : links)
		{
//			//all text of elements will print
        System.out.println(el.getText());
//			//or
			//String text=el.getText();
			//System.out.println(text);
        
//			if(text.contains("dependency"))
//			 {
//			el.click();
//		     }		
          
          
          //3. click by index
		  Thread.sleep(2000);
          links.get(3).click();              
		}
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Code run successfully.");
	}
}