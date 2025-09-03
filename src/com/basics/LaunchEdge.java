package com.basics;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class LaunchEdge {

	public static void main(String[] args) {
	System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");
	
	EdgeOptions options=new EdgeOptions();
	options.addArguments("--remote-allow-origins=*");
	
	EdgeDriver driver=new EdgeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	//driver.launchApp("https://www.facebook.com/login");
	

	}

}
