package AutomationExerciseNew;

import java.awt.Window;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import com.basics.BrowserFactory;

public class RegisterUser {

	// Test Case 1: Register User
		public static void main(String[] args) throws InterruptedException 
		{		
//			1. Launch browser
			
			WebDriver driver=BrowserFactory.launchBrowser("chrome");
			driver.manage().window().maximize();
			driver.getTitle();	
			Thread.sleep(1000);

//			2. Navigate to url 'http://automationexercise.com'
			driver.navigate().to("http://automationexercise.com");
			Thread.sleep(1000);

//			3. Verify that home page is visible successfully---------->
			WebElement homepage=driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
			String hometxt=homepage.getText();
			
			if(hometxt.equalsIgnoreCase("Home"))
			{
				System.out.println("Home page verified: Passed");
			}
			else 
			{
				System.out.println("Test case failed for verify home page.");
			}
			Thread.sleep(1000);

//			4. Click on 'Signup / Login' button
			driver.findElement(By.xpath("//a[contains(text(),'Signup')]")).click();
			Thread.sleep(1000);

//			5. Verify 'New User Signup!' is visible
			String signtxt="New User Signup!";
			WebElement newsignuptxt=driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]"));
			String signup=newsignuptxt.getText();

			if(signup.contains(signtxt))
			{
				System.out.println("New User Signup! is visible: Passed");
			}
			else 
			{
				System.out.println("New User Signup! is visible test case: Failed");
			}
			Thread.sleep(1000);

//			6. Enter name and email address
			driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Sonika");
			driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys("kmsonika7@gmail.com");
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//form/input[@value='signup']));

//			7. Click 'Signup' button
			driver.findElement(By.xpath("//button[text()='Signup']")).click();
			Thread.sleep(2000);

//			8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
			WebElement accInfoTxt=driver.findElement(By.xpath("//b[contains(text(),'Enter Account Information')]"));
			String actualtxt=accInfoTxt.getText();
			
			if(actualtxt.equalsIgnoreCase("ENTER ACCOUNT INFORMATION"))
			{
				System.out.println("ACCOUNT INFORMATION page verified: Passed");
			}
			else 
			{
				System.out.println("Test case failed for ACCOUNT INFORMATION page.");
			}
			Thread.sleep(2000);

//			9. Fill details: Title, Name, Email, Password, Date of birth
			driver.findElement(By.xpath("//input[@value='Mrs']")).click();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sonika123#");
			Thread.sleep(2000);

			WebElement days=driver.findElement(By.xpath("//select[@id='days']"));
			Select sel=new Select(days);
			sel.selectByValue("8");
			Thread.sleep(1000);

			WebElement month=driver.findElement(By.xpath("//select[@id='months']"));
			Select selmonth=new Select(month);
			selmonth.selectByVisibleText("May");
			Thread.sleep(1000);

			WebElement year=driver.findElement(By.xpath("//select[@id='years']"));
			Select selyear=new Select(year);
			selyear.selectByVisibleText("1940");
			Thread.sleep(1000);
			

//			JavascriptExecutor js=(JavascriptExecutor)driver;
//			js.executeScript("window.scrollBy(0,400))");
//			Thread.sleep(1000);

//			10. Select checkbox 'Sign up for our newsletter!'
			driver.findElement(By.xpath("//input[@id='optin']")).click();

//			11. Select checkbox 'Receive special offers from our partners!'
			driver.findElement(By.xpath("//input[@id='newsletter']")).click();
			Thread.sleep(2000);

//			12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
			driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("sonika");
			driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("gautam");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//input[@id='company']")).sendKeys("DNK");
			driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("DNK");
			driver.findElement(By.xpath("//input[@id='state']")).sendKeys("UP");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//input[@id='city']")).sendKeys("G.Noida");
			driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("123456");
			driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("9876543210");
			Thread.sleep(2000);

//			13. Click 'Create Account button'
			driver.findElement(By.xpath("//button[text()='Create Account']")).click();
			Thread.sleep(2000);
			
//			Alert alert=driver.switchTo().alert();
//			System.out.println("ALert is: "+alert.getText());
//			alert.dismiss();
//			Thread.sleep(2000);
//			

//			14. Verify that 'ACCOUNT CREATED!' is visible
			WebElement accCreated=driver.findElement(By.xpath("//b[contains(text(),'Account Created!')]"));
			String accCreatedpage=accCreated.getText();
			if(accCreatedpage.equalsIgnoreCase("ACCOUNT CREATED!"))
			{
				System.out.println("ACCOUNT CREATED! page visible: Passed");
			}
			else 
			{
				System.out.println("ACCOUNT CREATED! page visible: Fail");
			}
			Thread.sleep(2000);


//			15. Click 'Continue' button
			driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
			Thread.sleep(2000);

//			16. Verify that 'Logged in as username' is visible
			WebElement loggedIn=driver.findElement(By.xpath("//a[contains(text(),'Logged')]"));
			//WebElement username=driver.findElement(By.xpath(""));

			System.out.println(loggedIn.getText());
			Thread.sleep(2000);

//			17. Click 'Delete Account' button
			driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();

//			18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
			WebElement deleteAccpage=driver.findElement(By.xpath("//b[contains(text(),'Account Deleted')]"));
			String deleteAccTxt=deleteAccpage.getText();
			if(deleteAccTxt.equalsIgnoreCase("ACCOUNT DELETED!"))
			{
				System.out.println("ACCOUNT DELETED! page visible: Passed");
			}
			else 
			{
				System.out.println("ACCOUNT DELETED! page visible: Fail");
			}
			Thread.sleep(2000);

			//click 'Continue' button
			driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
			Thread.sleep(3000);

			System.out.println("User registration code working successfully.");
			driver.quit();

		}
	}