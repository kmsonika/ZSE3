package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPomPage 
{
	WebDriver driver;
	
	//Employee List Page
	By goToEmployeeListPage= By.xpath("//a[contains(text(),'Employee List')]");
	
	//Add Employee Page
	By goToAddEmployeePage= By.xpath("//a[contains(text(),'Add Employee')]");
	
	//Reports Page
	By goToReportsPage= By.xpath("//a[contains(text(),'Reports')]");
	
//Configurations Dropdown list :
	By ConfigurationList=By.xpath("//span[contains(text(),'Configuration ')]");
		
	//1. Optional Field
	By goToOptionalFieldsPage= By.xpath("//a[contains(text(),'Optional Fields')]");
	
	//2. Custom Fields
	By goToCustomFieldPage= By.xpath("//a[contains(text(),'Custom Fields')]");
	
	//3. Data Import
	By goToDataImportPage= By.xpath("//a[contains(text(),'Data Import')]");
	
	//4. Reporting methods
	By goToReportingMethodsPage= By.xpath("//a[contains(text(),'Reporting Methods')]");
	
	//5. Termination Reasons
	By goToTerminationReasonsPage=By.xpath("//a[contains(text(),'Termination Reasons')]");
	
	
	//constructor and Methods
	public PIMPomPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void employeeListPage()
	{
		driver.findElement(goToEmployeeListPage).click();
	}
	
	public void addEmployeePage()
	{
		driver.findElement(goToAddEmployeePage).click();
	}
	
	public void reportsPage()
	{
		driver.findElement(goToReportsPage).click();
	}
	
	public void ConfigurationListPage()
	{
		driver.findElement(ConfigurationList).click();
	}
	
	
	public void optionalFieldsPage()
	{
		ConfigurationListPage();
		driver.findElement(goToOptionalFieldsPage).click();
	}
	
	
	public void customFieldPage()
	{
		ConfigurationListPage();
		driver.findElement(goToCustomFieldPage).click();
	}
	
	public void dataImportPage()
	{
		ConfigurationListPage();
		driver.findElement(goToDataImportPage).click();
	}
	
	public void reportingMethodsPage()
	{
		ConfigurationListPage();
		driver.findElement(goToReportingMethodsPage).click();
	}
	
	public void terminationReasonsPage()
	{
		ConfigurationListPage();
		driver.findElement(goToTerminationReasonsPage).click();
	}
}
