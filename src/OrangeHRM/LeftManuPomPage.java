package OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftManuPomPage 
{
// Left Menu list
	
	WebDriver driver;
	
	//Dashboard
	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement dashboardButton;
	
	//Admin
	@FindBy(xpath = "//span[text()='Admin']")
	WebElement adminButton;
	
	//PIM
	@FindBy(xpath = "//span[text()='PIM']")
	WebElement PIMButton;
	
	//Leave
	@FindBy(xpath = "//span[text()='Leave']")
	WebElement leaveButton;
	
	//Time
	@FindBy(xpath = "//span[text()='Time']")
	WebElement timeButton;
	
	//Recruitment
	@FindBy(xpath = "//span[text()='Recruitment']")
	WebElement recruitmentButton;

	//My Info
	@FindBy(xpath = "//span[text()='My Info']")
	WebElement myInfoButton;
	
	//Performance
	@FindBy(xpath = "//span[text()='Performance']")
	WebElement performanceButton;
	
	//Directory
	@FindBy(xpath = "//span[text()='Directory']")
	WebElement DirectoryButton;
	
	//Maintenance
	@FindBy(xpath = "//span[text()='Maintenance']")
	WebElement maintenanceButton;
	
	//Claim
	@FindBy(xpath = "//span[text()='Claim']")
	WebElement claimButton;
	
	//Buzz
	@FindBy(xpath = "//span[text()='Buzz']")
	WebElement buzzButton;
	
	
	public LeftManuPomPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); // This line is critical!
	}
	
//Methods
	
	public void clickOnDashboardButton()
	{
		dashboardButton.click();
	}
	
	public void clickOnAdminButton()
	{
		adminButton.click();
	}
	
	public void clickOnPIMButton()
	{
		PIMButton.click();
	}
	
	public void clickOnLeaveButton()
	{
		leaveButton.click();
	}
	
	
	public void clickOnTimeButton()
	{
		timeButton.click();
	}
	
	
	public void clickOnRecruitmentButton()
	{
		recruitmentButton.click();
	}
	
	
	public void clickOnMyInfoButton()
	{
		myInfoButton.click();
	}
	
	public void clickOnPerformanceButton()
	{
		performanceButton.click();
	}
	
	
	
	public void clickOnDirectoryButton()
	{
		DirectoryButton.click();
	}
	
	
	public void clickOnMaintenanceButton()
	{
		maintenanceButton.click();
	}
	
	
	public void clickOnClaimButton()
	{
		claimButton.click();
	}
	
	
	
	public void clickOnBuzzButton()
	{
		buzzButton.click();
	}
	
	
}
