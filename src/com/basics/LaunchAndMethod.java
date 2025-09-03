package com.basics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchAndMethod {
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
     
    ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	
	ChromeDriver driver=new ChromeDriver(options);	
	
//	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//	OR
	driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.navigate().back();
	driver.navigate().forward();
	driver.navigate().refresh();
	
	Thread.sleep(2000);
	
	String actualtitle=driver.getTitle();
	System.out.println("Actual Title is: "+actualtitle);
	
	String expectedTitle="OrangeHRM";
	System.out.println("Expected Title is: "+expectedTitle);
	boolean result=actualtitle.contains(expectedTitle);
	
	if (result){
		System.out.println("Test Case Pass.");
	}
	else {
		System.out.println("Test Case Fail.");
	}
	
	
	
	driver.quit();
	
	
	
	}
}
