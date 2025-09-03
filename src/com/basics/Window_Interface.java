package com.basics;

import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class Window_Interface  {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.get("http://opensource-demo.orangehrmlive.com/");
		
		//driver.manage().window().maximize();
		System.out.println(driver.manage().window().getSize());                  //(1051, 798)
		
		Dimension d=new Dimension(1500, 1600);
		Thread.sleep(3000);
	    driver.manage().window().setSize(d);
	    System.out.println(driver.manage().window().getSize());
	
	
	    System.out.println(driver.manage().window().getPosition());
	    Point p=new Point(5,5);
	    Thread.sleep(3000);
	    driver.manage().window().setPosition(p);
	    
	    System.out.println(driver.manage().window().getPosition());
		driver.close();

	}

}
