package com.basics;
import org.openqa.selenium.WebDriver.Window;
import java.lang.foreign.Linker.Option;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;

public class WebdriverMethods {

	public static void main(String[] args) throws InterruptedException 
	{
	 WebDriver driver=BrowserFactory.launchBrowser("chrome");	 
	 //Webdriver Methods
	 
	 //1. get()
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 
	 //2. navigate()
	// driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.navigate().back();
		//driver.navigate().forward();
		//driver.navigate().refresh();
		
		Thread.sleep(2000);
		
		//3.. getTitle()
		String actualtitle=driver.getTitle();
		System.out.println("Actual Title is: "+actualtitle);
		if (actualtitle.contains("OrangeHRM")){
			System.out.println("Test Case Pass.");
		}
		else {
			System.out.println("Test Case Fail.");
		}
		
		//4. getCurrentUrl()
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		//5. close()---->close active tab
		Thread.sleep(5000);
		 //driver.close();
		
		//6. getWindowHandle()
		 String sessionId=driver.getWindowHandle();
		 System.out.println("Tab Session ID: "+sessionId);
		 
		 //7. getWindowHandles()
		 String windowHandleOriginal= driver.getWindowHandle();
         
		//8. switchTo()
		 driver.switchTo().window(windowHandleOriginal);
		 
		//9. getPageSource()
		 System.out.println("Page source is below: "+driver.getPageSource());
		 
		 //10. manage()
		Options opt=driver.manage();
		Window wi=opt.window();
		 wi.maximize();
		 
		 //OR
		 
		//driver.manage().window().maximize();    //Method chaining
		 
		//11. quit()--->close browser
        driver.quit();
	}
}
