package com.LocatorUnderstanding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

public class CSS_Locator_Task2 {
	
//TASK- On DEMO-QA forms page, locate each element using cssSelector
	
	public static void main(String[] args) 
	{
		WebDriver driver=BrowserFactory.launchBrowser("edge");
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		 //Tool QA
		 WebElement toolqa=driver.findElement(By.cssSelector("img[src='/images/Toolsqa.jpg']"));
		 
		//Practice Form
		 WebElement form=driver.findElement(By.cssSelector("h1[class=\"text-center\"]"));
		
		//Student Registration Form (Text)
//---------->can not do with cssSelector
		
		//Name
		 WebElement firstname=driver.findElement(By.cssSelector("input[placeholder='First Name']"));
		 WebElement lastname=driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
		
		//Email
		 WebElement useremail=driver.findElement(By.cssSelector("input[id='userEmail']"));
		
		//Gender
		 WebElement gendermale=driver.findElement(By.cssSelector("input[value='Male']"));
		 WebElement genderFemale=driver.findElement(By.cssSelector("input[value='Female']"));
		 WebElement genderOther=driver.findElement(By.cssSelector("input[value='Other']"));

		
		//Mobile
		 WebElement mobileNumber=driver.findElement(By.cssSelector("input[id='userNumber']"));
		
		//Date of Birth
		 WebElement DOB=driver.findElement(By.cssSelector("input[id='dateOfBirthInput']"));
		
		//Subjects
		 WebElement Subject=driver.findElement(By.cssSelector("div[id='subjectsContainer']"));
		
		
//----------->//Hobbies------------->here we can not correctly find hobby name with cssSelector
		 WebElement checkboxSports=driver.findElement(By.cssSelector("input[id='hobbies-checkbox-1']")); //Sports
		 WebElement checkboxReading=driver.findElement(By.cssSelector("input[id='hobbies-checkbox-2']"));  //Reading
		 WebElement checkboxMusic=driver.findElement(By.cssSelector("input[id='hobbies-checkbox-3']"));  //Music
		
		//Picture
		 WebElement uploadpicture=driver.findElement(By.cssSelector("input[id='uploadPicture']"));

		
		//Current Address
		 WebElement currentAddress=driver.findElement(By.cssSelector("textarea[id='currentAddress']"));
		
         //State and City (dropdown)---------->here is dropdown value
		 WebElement State=driver.findElement(By.cssSelector("div[id='state']"));
		 WebElement city=driver.findElement(By.cssSelector("div[id='city']"));
		
         //Submit
		 WebElement submit=driver.findElement(By.cssSelector("button[id='submit']"));

		
		driver.quit();

	}
}
