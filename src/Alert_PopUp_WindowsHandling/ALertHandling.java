package Alert_PopUp_WindowsHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.basics.BrowserFactory;

public class ALertHandling {

	public static void main(String[] args) throws InterruptedException {
		// Alert Handling
		
	//	https://demoqa.com/elements
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.get("https://demoqa.com/elements");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Down casting of driver reference variable to javaScriptExecutor
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//Scrolling down
		js.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.xpath("//div[contains(text(),'Alerts, Frame & Windows')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Alerts')]")).click();
		Thread.sleep(1000);
		
		
			
		//Scrolling down
		js.executeScript("window.scrollBy(0,30)");
		
		driver.findElement(By.xpath("")).click();
		
		driver.findElement(By.xpath("")).click();
	}

}
