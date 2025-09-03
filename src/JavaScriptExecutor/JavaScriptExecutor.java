package JavaScriptExecutor;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

public class JavaScriptExecutor 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("file:///C:/Km.Sonika/Notes/Html_By_Sonika.html");
		Thread.sleep(3000);

		//Down casting of driver reference variable to javaScriptExecutor
		JavascriptExecutor js=(JavascriptExecutor)driver;
	
		//Scrolling down
		js.executeScript("window.scrollBy(0,400)");
		
		WebElement country=driver.findElement(By.xpath("//select[@id='Countries']"));
		
		//Scrolling till find the element
		js.executeScript("arguments[0].scrollIntoView(true);", country); 
		Thread.sleep(3000);

		//clicking
		js.executeScript("arguments[0].click();", country);
		Thread.sleep(3000);
		
		//scrolling up
		js.executeScript("window.scrollBy(0,-800)");
		Thread.sleep(3000);
		
		//clicking checkbox
		WebElement  rememberMe=driver.findElement(By.xpath("//input[@type='checkbox']"));
		js.executeScript("arguments[0].click();", rememberMe);
		Thread.sleep(2000);
		WebElement firstName=driver.findElement(By.xpath("//input[@id='fname']"));
		js.executeScript("arguments[0].value='Sonika'", firstName);
		Thread.sleep(2000);
		js.executeScript("document.getElementById('mobile').value='9876543210';"); //mobile
		Thread.sleep(2000);
		//js.executeScript("document.getElementByName('password').value='Gautam123#';"); //password====> Not working
		
		Thread.sleep(3000);

		driver.quit();
		System.out.println("Core Run Successfully.");
	}

}
