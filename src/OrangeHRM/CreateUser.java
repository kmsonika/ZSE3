package OrangeHRM;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

//Tasks
public class CreateUser {
//1) Create a user in Orangehrm using admin and then login via that user

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
				
		Thread.sleep(3000);
		
		//printing side bar list
		
		List<WebElement> sideBar=driver.findElements(By.xpath("//aside/*"));
		for (WebElement list : sideBar) 
		{
			String sideBarName=list.getText();
			System.out.println("Side Bar list: "+sideBarName);
			
//			if(sideBarName.contains("Admin"))---->if condition not working
//			{
//			list.click();
//			}	
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Admin']")).click();
		
		Thread.sleep(2000);
		//Creating New User
		driver.findElement(By.xpath("(//button//i)[4]")).click();
		
//Add User--------->
		Thread.sleep(2000);
		
		//select user Role
		WebElement userRole=driver.findElement(By.xpath("(//div[2]/div/div/div[@tabindex='0'])[1]"));
		userRole.click();
		userRole.sendKeys(Keys.ARROW_DOWN);
		userRole.sendKeys(Keys.ENTER);
		
		//Enter employee name
		WebElement ename=driver.findElement(By.xpath("//div//input[@placeholder='Type for hints...']"));
		ename.sendKeys("peter");
		Thread.sleep(2000);
		ename.sendKeys(Keys.ARROW_DOWN);
		ename.sendKeys(Keys.ENTER);
		
		
		//Select Status
		WebElement status=driver.findElement(By.xpath("(//div[2]/div/div/div[@tabindex='0'])[2]"));
		status.click();
		status.sendKeys(Keys.ARROW_DOWN);
		status.sendKeys(Keys.ENTER);
		
		//enter username
		driver.findElement(By.xpath("(//div//input)[3]")).sendKeys("sonikagautam1");
		
		//enter password
		driver.findElement(By.xpath("(//div//input[@type='password'])[1]")).sendKeys("admin1234");
		
		//confirm password
		driver.findElement(By.xpath("(//div//input[@type='password'])[2]")).sendKeys("admin1234");
		
		//save
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
        Thread.sleep(3000);
		
     // Logout OrangeHRM
     		WebElement profile=driver.findElement(By.xpath("//div/ul/li/span/p"));
     		profile.click();
     		driver.findElement(By.xpath("//a[text()='Logout']")).click();
     		
		Thread.sleep(3000);
		
// Login with created user (//1) Create a user in Orangehrm using admin and then login via that user)
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sonikagautam1");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
		
		Thread.sleep(5000);
				
		//Closing browser
		driver.quit();
		System.out.println("Code Run Successfully.");		
	}
}
