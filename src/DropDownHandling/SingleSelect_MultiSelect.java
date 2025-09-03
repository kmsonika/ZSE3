package DropDownHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.basics.BrowserFactory;

public class SingleSelect_MultiSelect {

	public static void main(String[] args) throws InterruptedException {
		// Print All the options in all the dropdowns
		
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("file:///C:/Km.Sonika/Notes/Html_By_Sonika.html");
		Thread.sleep(2000);
		
		//Single Select Dropdown	
		WebElement singledrop=driver.findElement(By.xpath("//select[@id='Countries']"));	
		
		Select select=new Select(singledrop);
		select.selectByIndex(4);
		Thread.sleep(2000);
		select.selectByValue("AU");
		Thread.sleep(2000);
		select.selectByVisibleText("India");
		
		//Print All dropdown options
		System.out.println("\n Sigle Dropdown List options: \n " + singledrop.getText());
		
		Thread.sleep(2000);
		
		WebElement multidrop=driver.findElement(By.xpath("(//select[@id='Courses'])[1]"));	
	    select=new Select((WebElement) multidrop);
		select.selectByIndex(2);
		Thread.sleep(2000);
		select.selectByValue("SP");
		Thread.sleep(2000);
		select.selectByVisibleText("other");
		Thread.sleep(2000);
		
		//Print All dropdown options
		System.out.println("\n Multiple Dropdown List options: \n " + multidrop.getText());
				
		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Code working fine.");


	}

}
