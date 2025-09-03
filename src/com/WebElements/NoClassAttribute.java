package com.WebElements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class NoClassAttribute {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("Application Title is: "+driver.getTitle());
		
		
		driver.findElement(By.xpath("//textarea[@aria-label='Search']")).sendKeys("Selenium Java");
		Thread.sleep(2000);
		
		List<WebElement> links=driver.findElements(By.xpath("(//div[@class='OBMEnb'])[1]//*"));
		List<WebElement> withoutClass=new ArrayList<WebElement>();
		Thread.sleep(2000);
		
		for(WebElement el : links)
		{
			String text=el.getAttribute("class");
			System.out.println(text);
			
//			if(!text.equals(links)) {
//			String ewc=el.getText().trim();
//			System.out.println(ewc);
			
			if (!text.equals(withoutClass))
			{
				//String ewc=el.getText().trim();
				//System.out.println(ewc);		
				System.out.println("/t Links: "+links);
				System.out.println("/t without class: "+withoutClass);

				break;
			}
		}
		
		driver.quit();
		System.out.println("Code run successfully.");
	}

}
