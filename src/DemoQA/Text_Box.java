package DemoQA;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.basics.BrowserFactory;

public class Text_Box 
{
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		Thread.sleep(3000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		Robot robot=new Robot();
		Actions action=new Actions(driver);

// ELEMENTS ------------------------------------------------------------->
		driver.findElement(By.xpath("//h5[contains(text(),'Elements')]")).click();
		Thread.sleep(1000);
		
//      1. Text box
		driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")).click();			
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("sonika Gautam");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("kmsonika77@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Testing Noida");
		js.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("Greater Noida");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(2000);		

//      2. Check Box	
		driver.findElement(By.xpath("//span[.='Check Box']")).click();			
		driver.findElement(By.xpath("//input[@type='checkbox']//../span[@class='rct-checkbox']")).click();
		
		WebElement result=driver.findElement(By.xpath("//div[@id='result']"));
		System.out.println("Result Text after clicking on checkbox: "+result.getText());
		Thread.sleep(2000);	
		
		driver.findElement(By.xpath("//button[@title='Expand all']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@title='Collapse all']")).click();	
		Thread.sleep(2000);
		
//      3. Radio Button
		driver.findElement(By.xpath("//span[.='Radio Button']")).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");		
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[@for='yesRadio']")));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//label[.='Impressive']")));
		Thread.sleep(1000);		
		//driver.findElement(By.xpath("//input[@id='noRadio']")).click();


//      4. Web Tables
		driver.findElement(By.xpath("//span[.='Web Tables']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
		Thread.sleep(1000);
		System.out.println("Verify Registration Form is visible: " +driver.findElement(By.xpath("//div[.='Registration Form']")).isDisplayed());
		
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
		
		//searchbox
		driver.findElement(By.xpath("//input[@id='searchBox']")).sendKeys("sonika");
		Thread.sleep(1000);
		
		//Edit
		driver.findElement(By.xpath("//span[@title='Edit']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='firstName']")).click();
	
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("sonika1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//span[@title='Delete']")).click();		
		Thread.sleep(1000);
		
//      5.  Buttons
		driver.findElement(By.xpath("//span[.='Buttons']")).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,400)");		
		Thread.sleep(1000);
	
		action.moveToElement(driver.findElement(By.xpath("//button[@id='doubleClickBtn']"))).doubleClick().perform();
		Thread.sleep(1000);
		
		action.moveToElement(driver.findElement(By.xpath("//button[.='Right Click Me']"))).contextClick().perform();
		Thread.sleep(1000);
		
		WebElement oneClick=driver.findElement(By.xpath("//button[.='Click Me']"));
		action.moveToElement(oneClick).click().perform();	
		Thread.sleep(1000);
		
//      6. Links
		
		driver.findElement(By.xpath("//span[.='Links']")).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		
	//Links will open new tab		
		// Click the first link
		driver.findElement(By.xpath("//a[.='Home']")).click();
		Thread.sleep(1000);

		// Click the second link
		driver.findElement(By.xpath("(//a[contains(text(),'Home')])[2]")).click();
		Thread.sleep(1000);

		// Get all window handles
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println("Window session ids: \n"+tabs);
		Thread.sleep(1000);

		// Switch to the second tab
		driver.switchTo().window(tabs.get(1));
		System.out.println("Title of new tab1: " + driver.getTitle());
		Thread.sleep(1000);
		
		driver.switchTo().window(tabs.get(2)); 
		Thread.sleep(1000);
		
		driver.switchTo().window(tabs.get(1)); 
		Thread.sleep(1000);
		
		// Now you're in the new tab — you can interact with it
		System.out.println("Title of new tab2: " + driver.getTitle());
		

		// Optional: Close the new tab and switch back
		driver.close(); // closes current tab
		Thread.sleep(1000);	
		driver.switchTo().window(tabs.get(0)); // switches back to original tab
		
		//Links will send an api call
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(1000);
		
		//Created
		driver.findElement(By.xpath("//a[@id='created']")).click();
		Thread.sleep(1000);	
		System.out.println("Text after click on 'Created' : "+driver.findElement(By.xpath("//p[@id='linkResponse']")).getText());
		Thread.sleep(1000);
		
		//No Content
		driver.findElement(By.xpath("//a[@id='no-content']")).click();
		Thread.sleep(1000);	
		System.out.println("Text after click on 'No Content' : "+driver.findElement(By.xpath("//p[@id='linkResponse']")).getText());
		Thread.sleep(1000);
		
		//Moved
		driver.findElement(By.xpath("//a[@id='moved']")).click();
		Thread.sleep(1000);
		System.out.println("Text after click on 'Moved' : "+driver.findElement(By.xpath("//p[@id='linkResponse']")).getText());
		Thread.sleep(1000);
		
		//Bad Request
		driver.findElement(By.xpath("//a[@id='bad-request']")).click();
		Thread.sleep(1000);
		System.out.println("Text after click on 'Bad Request' : "+driver.findElement(By.xpath("//p[@id='linkResponse']")).getText());
		Thread.sleep(1000);
		
		//Unauthorized
		driver.findElement(By.xpath("//a[@id='unauthorized']")).click();
		Thread.sleep(1000);
		System.out.println("Text after click on 'Unauthorizedt' : "+driver.findElement(By.xpath("//p[@id='linkResponse']")).getText());
		Thread.sleep(1000);
		
		//Forbidden
		driver.findElement(By.xpath("//a[@id='forbidden']")).click();
		Thread.sleep(1000);
		System.out.println("Text after click on 'Forbidden' : "+driver.findElement(By.xpath("//p[@id='linkResponse']")).getText());
		Thread.sleep(1000);
		
		//Not Found
		driver.findElement(By.xpath("//a[@id='invalid-url']")).click();
		Thread.sleep(1000);
		System.out.println("Text after click on 'Not Found' : "+driver.findElement(By.xpath("//p[@id='linkResponse']")).getText());
		Thread.sleep(2000);
		
		
		
//      7. Broken Links - Images

		driver.findElement(By.xpath("//span[contains(text(),'Broken Links')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(""));
		Thread.sleep(1000);
		driver.findElement(By.xpath(""));
		Thread.sleep(1000);
/*		
//      8. Upload and Download
		driver.findElement(By.xpath("//span[.='Radio Button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(""));
		Thread.sleep(1000);
		driver.findElement(By.xpath(""));
		Thread.sleep(1000);
		
	*/	
		
//      9. Radio Button
		
		
//      3. Radio Button
		
		driver.close();
		
	}
}
