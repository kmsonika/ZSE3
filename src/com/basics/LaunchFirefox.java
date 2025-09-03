package com.basics;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LaunchFirefox {

	public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
    
    //This is not required for Firefox browser.
   //FirefoxOptions options=new FirefoxOptions();
   //options.addArguments("--remote-allow-origins=*");
    
    FirefoxDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
    driver.get("https://www.facebook.com/");
   
  
	}
}
