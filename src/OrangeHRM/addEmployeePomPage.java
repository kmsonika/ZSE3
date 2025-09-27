package OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addEmployeePomPage 
{
	//Add employee pom page
	
	WebDriver driver;
	
	//First name Text field
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstNameTextField;
	
	//Middle name field
	@FindBy(xpath = "//input[@name='middleName']")
	WebElement middleNameTextField;
	
	//Last name field
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastNameTextField;
	
	//Employee Id field
	@FindBy(xpath = "//label[text()='Employee Id']/../../div/input")
	WebElement employeeIdTextField;
	
	//Create Login Details toggle button
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement createLoginDetailsToggleButton;
	
	//Profile image -Accepts jpg, .png, .gif up to 1MB. Recommended dimensions: 200px X 200px
	@FindBy(xpath = "//img[@alt='profile picture']/../../button")
	WebElement profilePictureAddButton;
	
	//Username text field
	@FindBy(xpath = "//label[text()='Username']/../../div/input")
	WebElement usernameTextField;
		
	//Password text field
	@FindBy(xpath = "//label[text()='Password']/../../div/input")
	WebElement passwordTextField;
	
	//Confirm Password text field
	@FindBy(xpath = "//label[text()='Confirm Password']/../../div/input']")
	WebElement confirmPasswordTextField;

				
	//Status Enable radio button
	@FindBy(xpath = "//label[text()='Enabled']")
	WebElement userStatusEnableRadioButton;

	//Status Disable radio button
	@FindBy(xpath = "//label[text()='Disabled']")
	WebElement userStatusDisableRadioButton;
		
	//Cancel button
	@FindBy(xpath = "//button[contains(normalize-space(),'Cancel')]")        //-->//button[normalize-space()='Cancel']
	WebElement cancelButton;

	//Save button
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	
	public addEmployeePomPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); // This line is critical!
	}	
	
//methods	

	// Create employee without login details	
	public void createUser(String firstName, String middleName, String lastName, CharSequence[] employeeID)
	{
		firstNameTextField.sendKeys(firstName);
		middleNameTextField.sendKeys(middleName);
		lastNameTextField.sendKeys(lastName);
		employeeIdTextField.sendKeys(employeeID);
	}
	
	public void createEmployeeWithoutLoginDetails(String firstName, String middleName, String lastName, CharSequence[] employeeID)
	{
		createUser(firstName,middleName,lastName,employeeID);
		saveButton.click();		
	}
	
	// Create employee with login details	
	public void createUsernamePassword(String userName, String password, String confirmPassword)
	{
		createLoginDetailsToggleButton.click();
		usernameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		confirmPasswordTextField.sendKeys(confirmPassword);	
	}
	
	public void createEmployeeWithLoginDetails(String firstName, String middleName, String lastName, CharSequence[] employeeID,String userName, String password, String confirmPassword ) {
		createUser(firstName,middleName,lastName,employeeID);		
		createUsernamePassword(userName, password, confirmPassword);
		saveButton.click();		
	}

}
