package Handling_WebTables;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.basics.BrowserFactory;

public class Columns_In_Rows {

	public static void main(String[] args) throws InterruptedException, AWTException
	{
		// How to find total how many columns are present inside each row?
		
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/webtables");	
		Thread.sleep(2000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		Robot robot=new Robot();
		Actions action=new Actions(driver);
		
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
		Thread.sleep(1000);
		System.out.println("Registration Form is visible: " +driver.findElement(By.xpath("//div[.='Registration Form']")).isDisplayed());
		
		WebElement firstname= driver.findElement(By.xpath("//input[@id='firstName']"));
		firstname.sendKeys("sonika");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("gautam");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("kmsonika888@gmail.com");
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys("25");
		driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@id='department']")).sendKeys("Engineering");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,400)");
		
		
		

	}
}
