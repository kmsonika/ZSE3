package OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPomPage 
{
	WebDriver driver;
	
//List all the web elements on the page	
	//Username
	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameTextfield;
	
	//Password
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTextfield;
	
	//Login
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;	
	
	//Forgot your password?
	@FindBy(xpath = "//form//div[4]/p")
	WebElement forgotPasswordButton;	
	
	//orange HRM link text on login page
	@FindBy(xpath = "//a[text()='OrangeHRM, Inc']")
	WebElement orangeHrmDotComLinkButton;
	
	@FindBy(partialLinkText = "facebook")
	WebElement orangeHrmFacebookButton;
	
	@FindBy(partialLinkText = "linkedin")
	WebElement orangeHrmLinkedinButton;
	
	@FindBy(partialLinkText = "twitter")
	WebElement orangeHrmTwitterButton;
	
	@FindBy(partialLinkText = "youtube")
	WebElement orangeHrmYouTubeButton;

	
	
    //constructor
	public LoginPomPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//methods of class
	
	public void enterUserName(String username)
	{
		usernameTextfield.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordTextfield.sendKeys(password);
	}
	
	public void hitLogin() 
	{
		loginButton.click();
	}
	
	public void loginAsUser(String username, String Password) 
	{
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(Password);
		hitLogin();
	}
	
	
}
