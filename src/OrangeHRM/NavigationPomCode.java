package OrangeHRM;

import org.openqa.selenium.WebDriver;
import com.basics.BrowserFactory;

public class NavigationPomCode
{	
	WebDriver driver;

	// Constructor to initialize WebDriver
	public NavigationPomCode(WebDriver driver)
	{
		this.driver=driver;
	}
		
	public void navigateTo(String url)
	{
		driver.manage().window().maximize();
		driver.navigate().to(url);
		
	}	
}
