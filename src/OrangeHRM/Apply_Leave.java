package OrangeHRM;

import org.checkerframework.checker.units.qual.kg;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

public class Apply_Leave 
{
//4) As user, apply for a leave, and based on leave selected, the leave count should go down by -1
	public static void main(String[] args) throws InterruptedException 
	{		
		// Launch Browser
		WebDriver driver=BrowserFactory.launchBrowser("Chrome");
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				
		Thread.sleep(5000);
		
		// Login OrangeHRM with Admin
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sonikagautam1");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
				
		Thread.sleep(5000);
		
		//Go to Leave page
		driver.findElement(By.xpath("//span[text()='Leave']")).click();
		Thread.sleep(3000);
		
		//Apply leave
		driver.findElement(By.xpath("//a[text()='Apply']")).click();
		Thread.sleep(3000);
		
		WebElement leaveType=driver.findElement(By.xpath("//div[contains(text(),'Select')]"));
		leaveType.click();
		leaveType.sendKeys(Keys.ARROW_DOWN);
		leaveType.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		WebElement fromDate=driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]"));
		fromDate.sendKeys("2025-20-08");
		fromDate.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/textarea")).sendKeys("Cold and Cough.");
		driver.findElement(By.xpath("//button[@type='submit'] 	")).click();
		Thread.sleep(5000);
		
		//see leave balance
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Entitlements ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='My Entitlements']")).click();
		Thread.sleep(5000);
	}
}
