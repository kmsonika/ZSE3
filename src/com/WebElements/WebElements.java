package com.WebElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class WebElements {

	public static void main(String[] args) {
		// WebElement and  WebElements
		
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		System.out.println("Application Title is: "+driver.getTitle());
		
		List<WebElement> elements=driver.findElements(By.xpath("//a"));
		
		for (WebElement el : elements)
		{
			//System.out.println(el.getText()); or
			
			String texts=el.getText();
			System.out.println(texts);
			
			if(texts.equalsIgnoreCase("Ray-Ban Meta"))
			{
				el.click();
			}
			
			driver.quit();
		}
		
	}

}
