package OrangeHRM;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

//Tasks--->Use selenium to achieve following test cases

//1) Create a user in orangehrm using admin and then login via that user
//2) Terminate the created user using admin, and user should not be able to login anymore and get proper error message on logging
//3) Login as admin and entitle a leave to the employee
//4) As user, apply for a leave, and based on leave selected, the leave count should go down by -1

public class CreateUser_Login_Terminate_Add_And_AppyLeave 
{

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
				
//				if(sideBarName.contains("Admin"))---->if condition not working
//				{
//				list.click();
//				}	
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
			ename.sendKeys("p");
			Thread.sleep(2000);
			ename.sendKeys(Keys.ARROW_DOWN);
			ename.sendKeys(Keys.ENTER);
			
			
			//Select Status
			WebElement status=driver.findElement(By.xpath("(//div[2]/div/div/div[@tabindex='0'])[2]"));
			status.click();
			status.sendKeys(Keys.ARROW_DOWN);
			status.sendKeys(Keys.ENTER);
			
			//enter username
			driver.findElement(By.xpath("(//div//input)[3]")).sendKeys("sonikagautam");
			
			//enter password
			driver.findElement(By.xpath("(//div//input[@type='password'])[1]")).sendKeys("admin1234");
			
			//confirm password
			driver.findElement(By.xpath("(//div//input[@type='password'])[2]")).sendKeys("admin1234");
			
			//save
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(2000);
			
//3) Login as admin and entitle a leave to the employee
			
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
			
			driver.findElement(By.xpath("//div/div[2]/input")).sendKeys("1");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()=' Confirm ']")).click();
		
			// Logout OrangeHRM
			WebElement profile=driver.findElement(By.xpath("//div/ul/li/span/p"));
			profile.click();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
					
			Thread.sleep(3000);
			
// Login with created user (//1) Create a user in Orangehrm using admin and then login via that user)
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sonikagautam");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin1234");
			driver.findElement(By.xpath("//button[@type='submit']")).click();	
			Thread.sleep(2000);
			
//4) As user, apply for a leave, and based on leave selected, the leave count should go down by -1	
			
			//Go to Leave page
					driver.findElement(By.xpath("//span[text()='Leave']")).click();
					Thread.sleep(3000);
					
					//Apply leave
					driver.findElement(By.xpath("//a[text()='Apply']")).click();
					Thread.sleep(3000);
					WebElement leaveTy=driver.findElement(By.xpath("//div[contains(text(),'Select')]"));
					leaveTy.click();
					Thread.sleep(2000);
					leaveTy.sendKeys(Keys.ARROW_DOWN);
					leaveTy.sendKeys(Keys.ENTER);
					
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
			
			Thread.sleep(3000);
			// Logout OrangeHRM
			WebElement pro=driver.findElement(By.xpath("//div/ul/li/span/p"));
			pro.click();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
			
	//2. Terminate the created user using admin, and user should not be able to login anymore and get proper error message on logging
					Thread.sleep(3000);
			// Login OrangeHRM with Admin
					driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
					driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
					driver.findElement(By.xpath("//button[@type='submit']")).click();				
					Thread.sleep(3000);
					
					driver.findElement(By.xpath("//span[.='Admin']")).click();
					Thread.sleep(1000);
					
					//search user
					driver.findElement(By.xpath("//div/div[2]/input")).sendKeys("sonikagautam");
					driver.findElement(By.xpath("(//div/button[2])[1]")).click();
					Thread.sleep(3000);
					
					//delete user
					driver.findElement(By.xpath("(//div[1]/button[@type=\"button\"])[4]")).click();
					driver.findElement(By.xpath("(//div /button[@type=\"button\"])[9]")).click();
					Thread.sleep(3000);

					// Logout OrangeHRM
					WebElement profile2=driver.findElement(By.xpath("//div/ul/li/span/p"));
					profile2.click();
					driver.findElement(By.xpath("//a[text()='Logout']")).click();
					Thread.sleep(3000);
					
					//try to Login with deleted user
					driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sonikagautam");
					driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin1234");
					driver.findElement(By.xpath("//button[@type='submit']")).click();	
					
					//print error message	-->Invalid credentials
					String expectedStr="Invalid credentials";                  //Expected String
					System.out.println("Expected String is: "+expectedStr);
					
					Thread.sleep(2000);
					WebElement Str=driver.findElement(By.xpath("//div//p[text()='Invalid credentials']"));
					String actualStr=Str.getText();
					System.out.println("Actual String is: "+actualStr);                           //Actual String
					
					if(actualStr.equalsIgnoreCase(expectedStr))                                   //Comparing actual result and expected result
					{
						System.out.println("Test Case Passed.");
					}
					else 
					{
						System.out.println("Test Case Failed.");
					}
			
			Thread.sleep(5000);
					
			//Closing browser
			driver.quit();
			System.out.println("Code Run Successfully.");	

	}

}
