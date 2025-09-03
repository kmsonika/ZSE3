package Mouse_Operation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.basics.BrowserFactory;

import JavaScriptExecutor.JavaScriptExecutor;

public class MouseOperations {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.navigate().to("https://demoqa.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//Down casting of driver reference variable to javaScriptExecutor
		JavascriptExecutor js=(JavascriptExecutor)driver;

		//Scrolling down
		js.executeScript("window.scrollBy(0,110)");
			
		//click on "Element"
		Thread.sleep(3000);
		WebElement element=driver.findElement(By.xpath("//h5[text()='Elements']"));
		js.executeScript("arguments[0].click();", element);
	
		//to perform mouse operation, we need to create parameterized object of Actions
		 Actions act=new Actions(driver);
		
		//click on "Buttons"
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Buttons']")).click();
		
		//Scrolling down
		js.executeScript("window.scrollBy(0,120)");
		
		Thread.sleep(2000);
		act.doubleClick(driver.findElement(By.xpath("//button[.='Double Click Me']"))).perform();
		Thread.sleep(2000);
		act.contextClick(driver.findElement(By.xpath("//button[.='Right Click Me']"))).perform();
		Thread.sleep(2000);
		act.click(driver.findElement(By.xpath("//button[.='Click Me']"))).perform();
		Thread.sleep(2000);
		
		//
		driver.findElement(By.xpath(""));
		
		
		

	}

}
