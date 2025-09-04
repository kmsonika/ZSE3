package Alert_PopUp_WindowsHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.basics.BrowserFactory;

public class PopUpHandling {

	public static void main(String[] args) throws InterruptedException 
	{
	//	1. Launch browser
    	WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();	
		Thread.sleep(1000);

//		2. Navigate to url
		driver.navigate().to("https://www.irctc.co.in/nget/train-search");
		driver.getTitle();
		Thread.sleep(1000);
		
		// POP UP handling
		driver.findElement(By.xpath("//button[.='OK']")).click();
		Thread.sleep(1000);
		
		//Alert handling
		//Alert alert=driver.switchTo().alert();
		
 		
		
		//select date calendar
		
		
		//Way1
		
		//Way2
		
		//Way3
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
