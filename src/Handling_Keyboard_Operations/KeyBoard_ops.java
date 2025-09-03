package Handling_Keyboard_Operations;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.basics.BrowserFactory;

public class KeyBoard_ops {

	public static void main(String[] args) throws InterruptedException, AWTException{
		WebDriver driver = BrowserFactory.launchBrowser("chrome");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.naukri.com/nlogin/login");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[.='Register']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h2[contains(text(),'experienced')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='resume-upload']//button")).click();
		Thread.sleep(3000);
		
		Robot robot = new Robot();
		for(int i=0;i<10; i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		Thread.sleep(1000);
		
		for(int i=0;i<3; i++) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
}
}
