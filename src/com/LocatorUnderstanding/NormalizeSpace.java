package com.LocatorUnderstanding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.basics.BrowserFactory;

public class NormalizeSpace {

	public static void main(String[] args) {

		 WebDriver driver=BrowserFactory.launchBrowser("chrome");
		 driver.manage().window().maximize();
		 driver.get("https://www.facebook.com/");
		 System.out.println(driver.getTitle());
		 
		 WebElement face=driver.findElement(By.xpath("//h2[contains(normalize-space(text()),'Facebook')]"));
		 System.out.println(face.getText());
		 
		 
		 WebElement meta=driver.findElement(By.xpath("//span[contains(normalize-space(text()), 'Meta')]"));
		 System.out.println(meta.getText());
		 driver.close();
		 System.out.println("End of Code.");

	}

}
