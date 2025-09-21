package DemoQA;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
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
		driver.get("https://demoqa.com/");
		Thread.sleep(2000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		Robot robot=new Robot();
		Actions action=new Actions(driver);

//Dynamic Properties
		

		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h5[contains(text(),'Elements')]")).click();
		Thread.sleep(2000);
		
		//Will enable 5 seconds
		System.out.println("Button 'Will enable 5 seconds' is enabled : "+driver.findElement(By.xpath("//button[@id='enableAfter']")).isEnabled());

		//Color Change
		WebElement colorbutton=driver.findElement(By.xpath("//button[@id='colorChange']"));
		colorbutton.isDisplayed();
		String color=colorbutton.getCssValue("color");
		System.out.println("Button 'Color Change' has color: " +color);
		
		//Visible After 5 Seconds
		System.out.println("Button 'Visible After 5 Seconds' is enabled : "+ driver.findElement(By.xpath("//button[@id='visibleAfter']")).isDisplayed());

       Thread.sleep(1000);		

	}
}
