package AutomationExerciseNew;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import com.basics.BrowserFactory;

public class RegisterUserWithExistingEmail {

	public static void main(String[] args) throws InterruptedException {
		// Test Case 5: Register User with existing email
		
//		1. Launch browser
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.getTitle();	
		Thread.sleep(1000);

//		2. Navigate to url 'http://automationexercise.com'
		driver.navigate().to("http://automationexercise.com");
		Thread.sleep(1000);

//		3. Verify that home page is visible successfully---------->
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

//		5. Verify 'New User Signup!' is visible
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

//		6. Enter name and email address
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Sonika");
		driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys("kmsonika77@gmail.com");
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//form/input[@value='signup']));

//		7. Click 'Signup' button
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		Thread.sleep(2000);

//      8. Verify error 'Email Address already exist!' is visible
		String emailExistTxt="Email Address already exist!";
		WebElement emailelement=driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]"));
		String emailtxt=emailelement.getText();
		if(emailtxt.equalsIgnoreCase(emailExistTxt))
		{
			System.err.println("User already Registered. Please try with another Email Id.");
		}
		else 
		{
		System.out.println("'Email Address is not already registered. user can registered with same email.");	
		}
		
		driver.quit();
		System.out.println("");

	}

}
