package com.basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriver_method {

	public static void main(String[] args) {
      System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
      ChromeOptions options=new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      ChromeDriver dri =new ChromeDriver(options);
      
      dri.get("http://opensource-demo.orangehrmlive.com/");
      dri.quit();

      
	}

}
