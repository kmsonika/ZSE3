package com.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public static WebDriver launchBrowser(String browserName)
	{
	WebDriver driver=null;
	
	if (browserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications"); // 👈 This disables alert notifications of browser
 //     options.addArguments("--incognito"); // 👈 This enables incognito mode
        
	    driver =new ChromeDriver(options);
		System.out.println("Chrome Browser Launched.");
	}
		
	else if (browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			EdgeOptions options1=new EdgeOptions();
			options1.addArguments("--remote-allow-origins=*");
//		     options.addArguments("--incognito");
			driver =new EdgeDriver(options1);
			System.out.println("Edge Browser Launched.");
		}
	
	else if (browserName.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.edge.driver", "./drivers/geckodriver.exe");
			driver =new FirefoxDriver();
			System.out.println("Firefox Browser Launched.");
		}
	else {
		System.out.println("Browser is not in Scope.");
	}
		return driver;
	}	
	}

