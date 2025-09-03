package DropDownHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.basics.BrowserFactory;

public class AllDropDown {

	public static void main(String[] args) throws InterruptedException 
	{
		// Print All the options in all the dropdowns
		
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("file:///C:/Km.Sonika/Notes/Html_By_Sonika.html");
		Thread.sleep(2000);
		
		List<WebElement> dropdowns=driver.findElements(By.xpath("//select"));
		
		for (WebElement dropdown : dropdowns) 
		{
		    Select select = new Select(dropdown);
		    List<WebElement> options = select.getOptions();

		    System.out.println("Dropdown: " + dropdown.getAttribute("id"));
		    for (WebElement option : options) 
		    {
		        System.out.println(" - " + option.getText());
		    }
		    System.out.println();
		}
	}
	}


