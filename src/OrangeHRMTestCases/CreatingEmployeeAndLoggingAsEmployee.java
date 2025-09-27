package OrangeHRMTestCases;

import org.openqa.selenium.WebDriver;
import com.basics.BrowserFactory;
import OrangeHRM.LeftManuPomPage;
import OrangeHRM.LoginPomPage;
import OrangeHRM.NavigationPomCode;


public class CreatingEmployeeAndLoggingAsEmployee 
{

	public static void main(String[] args) throws InterruptedException 
	{
		// Test case: Create Employee And Logging As Employee 
		
		// Launch browser
        WebDriver driver = BrowserFactory.launchBrowser("chrome");

        // Navigate to login page
        NavigationPomCode nav = new NavigationPomCode(driver);
        nav.navigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Wait for page to load
        Thread.sleep(3000);

        // Login
        LoginPomPage loginpage = new LoginPomPage(driver);
        loginpage.loginAsUser("Admin","admin123");
        Thread.sleep(3000);

		
		LeftManuPomPage leftmenu=new LeftManuPomPage(driver);
		leftmenu.clickOnPIMButton();

	}
}
