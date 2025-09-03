package OrangeHRM;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

public class Leave_Entitle 
{
//3) Login as admin and entitle a leave to the employee
	
	public static void main(String[] args) throws InterruptedException 
	{
		// Launch Browser
				WebDriver driver=BrowserFactory.launchBrowser("Chrome");
				driver.manage().window().maximize();
				driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				System.out.println("Application Title : "+driver.getTitle());
						
				Thread.sleep(5000);
						
				// Login OrangeHRM with Admin
				driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
				driver.findElement(By.xpath("//button[@type='submit']")).click();	

				Thread.sleep(5000);
				
				//Go to Leave page
				driver.findElement(By.xpath("//span[text()='Leave']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='Entitlements ']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[text()='Add Entitlements']")).click();
				
				//Add leave
				Thread.sleep(2000);
				WebElement empName=driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
				empName.sendKeys("Peter Anderson");
				Thread.sleep(2000);
				empName.sendKeys(Keys.ARROW_DOWN);
				empName.sendKeys(Keys.ENTER);
				
				WebElement leaveType=driver.findElement(By.xpath("//div[contains(text(),'Select')]"));
				leaveType.click();
				leaveType.sendKeys(Keys.ARROW_DOWN);
				leaveType.sendKeys(Keys.ARROW_DOWN);
				leaveType.sendKeys(Keys.ARROW_DOWN);
				leaveType.sendKeys(Keys.ARROW_DOWN);
				leaveType.sendKeys(Keys.ENTER);
				
				driver.findElement(By.xpath("//div/div[2]/input")).sendKeys("5");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[text()=' Confirm ']")).click();

	}

}
