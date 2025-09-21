package Alert_PopUp_WindowsHandling;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.basics.BrowserFactory;

public class FileUploadPopUp {

public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = BrowserFactory.launchBrowser("chrome");
		JavascriptExecutor js = (JavascriptExecutor)(driver);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.naukri.com/nlogin/login");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[.='Register']")).click();
		Thread.sleep(2000);	
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//h2[contains(text(),'experienced')]")).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//div[@class='resume-upload']//button")).click();
		Thread.sleep(3000);
		
		Robot robot = new Robot();
		robot.delay(500);
		
		//copying the path address and storing it in clipboard
		String filePath = "C:\\Users\\Sonika Gautam\\Downloads\\Testing222.docx";
		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
		
		
		//press cmd + TAB to make sure, that the focus is on dialog(optional)
//		robot.keyPress(KeyEvent.VK_META);
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_META);
//		robot.delay(500);
		
		//Use robot to move acorss the file upload window
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		//hit enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
