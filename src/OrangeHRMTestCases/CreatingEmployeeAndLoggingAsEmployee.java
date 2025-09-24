package OrangeHRMTestCases;

import org.openqa.selenium.WebDriver;
import com.basics.BrowserFactory;
import OrangeHRM.LeftManuPomPage;
import OrangeHRM.LoginPomPage;

public class CreatingEmployeeAndLoggingAsEmployee 
{

	public static void main(String[] args) throws InterruptedException 
	{
		// Test case: Create Employee And Logging As Employee 
		
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		LoginPomPage loginpage=new LoginPomPage(driver);
		loginpage.loginAsUser("Admin", "admin123");
		
		LeftManuPomPage leftmenu=new LeftManuPomPage(driver);
		leftmenu.clickOnPIMButton();

	}

}
