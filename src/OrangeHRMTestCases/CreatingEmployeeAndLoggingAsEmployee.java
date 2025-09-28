package OrangeHRMTestCases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.basics.BrowserFactory;
import OrangeHRM.LeftManuPomPage;
import OrangeHRM.LoginPomPage;
import OrangeHRM.NavigationPomCode;
import OrangeHRM.PIMPomPage;
import OrangeHRM.addEmployeePomPage;


public class CreatingEmployeeAndLoggingAsEmployee 
{

	public static void main(String[] args) throws InterruptedException, AWTException 
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
		Thread.sleep(3000);
		
		PIMPomPage pimPage= new PIMPomPage(driver);
		pimPage.addEmployeePage();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@alt='profile picture']/../../button")).click();
		
		addEmployeePomPage addEmployee=new addEmployeePomPage(driver);
		addEmployee.profile();
		//addEmployee.copyPathAddressForUpload("C:\\Users\\Sonika Gautam\\Pictures\\IMG_6377.JPG");
		addEmployee.selectProfileImage("C:\\Users\\Sonika Gautam\\Pictures\\IMG_6377.JPG");
		Thread.sleep(3000);
		addEmployee.createEmployeeWithLoginDetails("Enaya", "Gautam", "EN", "123", "Enaya123", "Enaya123#", "Enaya123#");
		
		

	}
}
