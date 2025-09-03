package com.basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LunachChrome 
{
	public static void main(String[] args) 
	{
     System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
     
     ChromeOptions options= new ChromeOptions();
     options.addArguments("--remote-allow-origins=*");
     
     ChromeDriver driver=new ChromeDriver(options);
     driver.get("https://www.facebook.com/");
     
	 driver.manage().window().maximize();
	 
	 System.out.println("Page Title Name is: "+driver.getTitle());
	 driver.quit();
	}

}
