package OrangeHRM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasePageOrangeHRM
{
	//Select, Robot, Actions, javaScriptExecutor etc...	
	WebDriver driver;
	JavascriptExecutor js;
	Actions actions;
	Robot robot;
	Select select;
	StringSelection selection;
	
	public BasePageOrangeHRM(WebDriver driver) throws AWTException
	{
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
        this.robot = new Robot(); // Handle AWTException
      // this.select=new Select(element);
       // this.selection=new StringSelection(null);
    }
	
	//Copying the path address and storing it in Clipboard
	public void copyPathAddressForUpload(String filePathToUpload)
	{
		selection=new StringSelection(filePathToUpload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
	}
	
	//Press cmd + TAB to make sure, that the focus is on dialog(optional)
	public void Uploadfile(String filePathToUpload)
	{
	copyPathAddressForUpload(filePathToUpload);
		
	//Use robot to move across the file upload window
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
				
	//hit enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}


	
	

}
