package DemoQA;

import java.awt.AWTException;
import java.awt.Robot;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.antlr.v4.runtime.atn.SemanticContext.OR;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.LocatorUnderstanding.Contains_Text_Xpath;
import com.basics.BrowserFactory;

public class RadioButton {

	public static void main(String[] args) throws InterruptedException, AWTException 
	{

		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/broken");
		Thread.sleep(2000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		Robot robot=new Robot();
		Actions action=new Actions(driver);

//Broken Links - Images
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(1000);
		
/*		// Get all image elements
		List<WebElement> images = driver.findElements(By.xpath("//div/img"));

		
		//Valid image
		  //List<WebElement> images = driver.findElements(By.xpath("//div/img"));

		https://the-internet.herokuapp.com/
		//Broken image
		driver.findElement(By.xpath("//a[@id='created']")).click();
*/		
		
		
		//Valid Link
       WebElement validLink= driver.findElement(By.xpath("//a[.='Click Here for Valid Link']"));
       Thread.sleep(1000);	
       String url=validLink.getAttribute("href");
       if (url != null && !url.isEmpty() && url.equalsIgnoreCase("https://demoqa.com"))
	    {
	    	System.out.println("✅ Valid Link:  " + url);
	    }
	    else 
	    {
	    	System.err.println("❌ Broken Link: " + url);
		}
       Thread.sleep(1000);	

       
     //Broken Link
       WebElement InvalidLink= driver.findElement(By.xpath("//a[.='Click Here for Broken Link']"));
       Thread.sleep(1000);	
       String urlnew=InvalidLink.getAttribute("href");
       if (urlnew != null && !urlnew.isEmpty() && urlnew.equalsIgnoreCase("https://the-internet.herokuapp.com"))
	    {
	    	System.out.println("✅ Valid Link:  " + urlnew);
	    }
	    else 
	    {
	    	System.err.println("❌ Broken Link: " + urlnew);
		}
       Thread.sleep(1000);	

/*	List<WebElement> links=driver.findElements(By.xpath("//div[@class='row']/div/div[2]/a"));
		for (WebElement link : links) 
		{
		    String url = link.getAttribute("href");	    
		    if (url != null && !url.isEmpty() && url.equalsIgnoreCase("https://demoqa.com/") ||  url.equalsIgnoreCase("https://the-internet.herokuapp.co"))
		    {
		    	System.out.println("✅ Valid Link:  " + url);
		    }
		    else 
		    {
		    	System.err.println("❌ Broken Link: " + url);
			}	
		}
*/	

	}
}
