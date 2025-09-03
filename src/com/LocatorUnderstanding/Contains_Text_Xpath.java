package com.LocatorUnderstanding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.basics.BrowserFactory;

//Task9: On Facebook page, Locate each element using Contains() or Text()

public class Contains_Text_Xpath 
{
	public static void main(String[] args) 
	{
		 WebDriver driver=BrowserFactory.launchBrowser("chrome");
		 driver.manage().window().maximize();
		 driver.get("https://www.facebook.com/");
		 System.out.println(driver.getTitle());
		
		 //Email
		 WebElement email=driver.findElement(By.cssSelector("input[type='text']"));
		 
		 //Password
		WebElement password=driver.findElement(By.cssSelector("input[type='password']"));
		 
		 //Login Button
		WebElement loginbutton=driver.findElement(By.cssSelector("button[name='login']"));

		 //Forgot Password
//---->> WebElement forgotpassword=driver.findElement(By.cssSelector("a[id='u_0_6_xq']")); //------>ISSUE with cssSelector, not able to find path
		 
		 WebElement pl= driver.findElement(By.partialLinkText("Forgotten"));
		 
		 //Create New account
		WebElement newAccount=driver.findElement(By.cssSelector("a[data-testid=\"open-registration-form-button\"]"));
		 
		 //Facebook (text)
		//WebElement fb=driver.findElement(By.cssSelector("img[alt='Facebook']"));
		WebElement fb=driver.findElement(By.cssSelector("h2[class='_8eso']"));
		
		 //Create a Page for a celebrity, brand or business. (Text)
        WebElement cr=driver.findElement(By.cssSelector("div[id='reg_pages_msg']"));
        
        //English (UK)
//------>WebElement english=driver.findElement(By.cssSelector("English (UK)"));------------>ISSUE with cssSelector (InvalidSelectorException)
		 
		 //Hindi
     WebElement hindi=driver.findElement(By.cssSelector("a[title='Hindi']"));
   		   
       //URDU
      WebElement urdu=driver.findElement(By.cssSelector("a[title='Urdu']"));
        
      //Punjabi
      WebElement Punjabi=driver.findElement(By.cssSelector("a[title='Punjabi']"));
        
     //Bengali
       WebElement Bengali=driver.findElement(By.cssSelector("a[title='Bengali']"));
        
		 //Gujarati
       WebElement Gujarati=driver.findElement(By.cssSelector("a[title='Gujarati']"));
        
        //Marathi
        WebElement Marathi=driver.findElement(By.cssSelector("a[title='Marathi']"));
        
        //Telugu
       WebElement Telugu=driver.findElement(By.cssSelector("a[title='Telugu']"));
        
        //Malayalam
       WebElement Malayalam=driver.findElement(By.cssSelector("a[title='Malayalam']"));
        
        //Kannada
     WebElement Kannada=driver.findElement(By.cssSelector("a[title='Kannada']"));
        
		//Button(+)
//-----> WebElement plusbutton=driver.findElement(By.cssSelector("a[role='button']")); //--------->a[role='button']--->3count {ISSUE with cssSelector }
        WebElement plusbutton=driver.findElement(By.cssSelector("i[class='img sp_GPvE0syHYuh sx_8e0301']"));
        
       //Sign UP
      WebElement singup=driver.findElement(By.cssSelector("a[title='Sign up for Facebook']"));
		 
        //Login
      WebElement log=driver.findElement(By.cssSelector(" a[title='Log in to Facebook']"));
		 
        //Messenger,
        WebElement Messenger=driver.findElement(By.cssSelector(" a[title='Take a look at Messenger.']"));
        
        //Facebook Lite,
       WebElement fblite=driver.findElement(By.cssSelector(" a[title='Facebook Lite for Android.']"));
       
        //Video,
       WebElement Video=driver.findElement(By.cssSelector(" a[title='Browse in Video']"));
       
        //Meta Pay,
       WebElement Meta=driver.findElement(By.cssSelector(" a[title='Learn more about Meta Pay']"));
       
       // Meta Store,
       WebElement metaStore=driver.findElement(By.cssSelector(" a[title='Discover Meta']"));
       
       // Meta Quest,
      WebElement MetaQuest=driver.findElement(By.cssSelector(" a[title='Learn more about Meta Quest']"));
      
        //Ray-Ban Meta,
        WebElement MetaRay=driver.findElement(By.cssSelector(" a[title='Learn more about Ray-Ban Meta']"));
        
        //Meta AI,
        WebElement MetaAI=driver.findElement(By.cssSelector(" a[title='Meta AI']"));
        
        //Instagram,
        WebElement Instagram=driver.findElement(By.cssSelector(" a[title='Take a look at Instagram']"));
        
        //Threads,
        WebElement Threads=driver.findElement(By.cssSelector(" a[title='Check out Threads']"));
        
       // Voting Information Centre,
        WebElement Centre=driver.findElement(By.cssSelector(" a[title='See the Voting Information Centre']"));
        
       // Privacy Policy,
        WebElement Policy=driver.findElement(By.cssSelector(" a[title='Learn how we collect, use and share information to support Facebook.']"));
        
       // Privacy Centre,
        WebElement Center=driver.findElement(By.cssSelector(" a[title='Learn how to manage and control your privacy on Facebook.']"));
        
       // About,
        WebElement About=driver.findElement(By.cssSelector(" a[title='Read our blog, discover the resource centre and find job opportunities.']"));
        
       // Create ad,
        WebElement ad=driver.findElement(By.cssSelector(" a[title='Advertise on Facebook']"));
        
       // Create Page,
        WebElement Page=driver.findElement(By.cssSelector(" a[title='Create a Page']"));
        
      //  Developers,
        WebElement Developers=driver.findElement(By.cssSelector(" a[title='Learn more about Meta Quest']"));
        
       // Careers,
        WebElement Careers=driver.findElement(By.cssSelector(" a[title='Make your next career move to our brilliant company.']"));
        
        //Cookies,
        WebElement Cookies=driver.findElement(By.cssSelector(" a[title='Learn about cookies and Facebook.']"));
        
      //  AdChoices,
        WebElement AdChoices=driver.findElement(By.cssSelector(" a[title='Learn about Ad Choices.']"));
        
       // Terms,
        WebElement Terms=driver.findElement(By.cssSelector(" a[title='Review our terms and policies.']"));
        
       // Help,
        WebElement Help=driver.findElement(By.cssSelector(" a[title='Visit our Help Centre.']"));
        
       // Contact uploading and non-users
        WebElement Contact=driver.findElement(By.cssSelector(" a[title='Visit our contact uploading and non-users notice.']"));
        
       
//----->//Meta © 2025

       
		 System.out.println("End of Code.");
		 driver.quit();
		



	}

}
