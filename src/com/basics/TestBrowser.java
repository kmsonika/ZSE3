package com.basics;
import org.openqa.selenium.WebDriver;

public class TestBrowser {

	public static void main(String[] args) {
     WebDriver driver=BrowserFactory.launchBrowser("chrome");
     driver.manage().window().maximize();
     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
     
     driver.quit();

     
     

	}

}
