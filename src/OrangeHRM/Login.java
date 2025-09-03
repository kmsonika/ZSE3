package OrangeHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

public class Login 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Launch Browser
		WebDriver driver=BrowserFactory.launchBrowser("Chrome");
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Application Title : "+driver.getTitle());
		
		Thread.sleep(3000);
		
		// Login OrangeHRM with Admin
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
		
		Thread.sleep(3000);
		
		// Logout OrangeHRM
		WebElement profile=driver.findElement(By.xpath("//div/ul/li/span/p"));
		profile.click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		Thread.sleep(3000);
		
		//Closing browser
		driver.quit();
		System.out.println("Code Run Successfully.");
	}
}
