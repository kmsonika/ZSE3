package AutomationExerciseNew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

public class IncorrectLogin 
{
// Test Case 3: Login User with incorrect email and password
	public static void main(String[] args) throws InterruptedException 
	{		
//		1. Launch browser
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.getTitle();	
		Thread.sleep(1000);
		
//		2. Navigate to url 'http://automationexercise.com'
		driver.navigate().to("http://automationexercise.com");
		Thread.sleep(1000);
		
//		3. Verify that home page is visible successfully
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
		
//		4. Click on 'Signup / Login' button
		driver.findElement(By.xpath("//a[contains(text(),'Signup')]")).click();
		Thread.sleep(1000);
		
//		5. Verify 'Login to your account' is visible
		String signtxt="Login to your account";
		WebElement newlogintxt=driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]"));
		String login=newlogintxt.getText();

		if(login.contains(signtxt))
		{
			System.out.println("Login to your account is visible: Passed");
		}
		else 
		{
			System.out.println("Login to your account is visible test case: Failed");
		}
		Thread.sleep(1000);
		
//		6. Enter incorrect email address and password
		driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]")).sendKeys("kmsonika71@gmail.com");
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("sonika1234#");
		Thread.sleep(1000);
		
//		7. Click 'login' button
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		Thread.sleep(2000);
		
//		8. Verify error 'Your email or password is incorrect!' is visible
		String txt="Your email or password is incorrect!";
		WebElement incLogin=driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]"));
		String incLoginTxt=incLogin.getText();
		
		if(incLoginTxt.equalsIgnoreCase("txt"))
		{
			System.out.println("Verify error message while entrting Incorrect Email/password Test case: Pass");
		}
		else 
		{
			System.out.println("Verify error message while entrting Incorrect Email/password Test case: Fail");
		}
		
		System.out.println("User Login with Incorrect Email/password code working successfully.");
		driver.quit();

	}
}