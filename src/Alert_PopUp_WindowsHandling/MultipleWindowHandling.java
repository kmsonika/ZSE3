package Alert_PopUp_WindowsHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultipleWindowHandling 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Multi window handling
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
	     
	     ChromeOptions options= new ChromeOptions();
	     options.addArguments("--remote-allow-origins=*");
	     
	     ChromeDriver driver=new ChromeDriver(options);
	     driver.get("https://demoqa.com/automation-practice-form");
	     
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		
		
		
		
		
		

	}
}
