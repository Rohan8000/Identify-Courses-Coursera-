package PageData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ForUniversityPage extends BasePage
{

	public ForUniversityPage(WebDriver driver) 
	{
		
		super(driver);
		
	}
	
	
	@FindBy(id="FirstName")
	public WebElement firstName;
	@FindBy(id="LastName")
	public WebElement lastName;
	@FindBy(id="Email")
	public WebElement emailID;
	@FindBy(id="Phone")
	public WebElement phoneNum;
	@FindBy(id="Institution_Type__c")
	public WebElement institutionType;
	@FindBy(id="Company")
	public WebElement institutionName;
	@FindBy(id="Title")
	public WebElement jobRole;
	@FindBy(id="Department")
	public WebElement department;
	@FindBy(id="What_the_lead_asked_for_on_the_website__c")
	public WebElement description;
	@FindBy(id="Country")
	public WebElement country;
	@FindBy(id="State")
	public WebElement state;
	@FindBy(xpath=("//button[@type='submit']"))
	public WebElement submit;
	@FindBy(xpath=("//div[@class='mktoErrorMsg']"))
	public WebElement errorMessage;
	
	
	public void setFirstName(String fName)
	{
		
		firstName.sendKeys(fName);
	
	}
	
	public void setLastName(String lName)
	{
		
		lastName.sendKeys(lName);
	
	}
	
	public void setEmailID(String mail)
	{
		
		emailID.sendKeys(mail);
	
	}
	
	public void setPhoneNum(String phNum)
	{
		
		phoneNum.sendKeys(phNum);
	
	}
	
	public void setInstitutionType(String insType)
	{
		
		Select dropdown = new Select(institutionType);
		dropdown.selectByVisibleText(insType);
	
	}
	
	public void setInstitutionName(String insName)
	{
		
		institutionName.sendKeys(insName);
	
	}
	
	public void setJobRole(String role)
	{
		
		Select dropdown = new Select(jobRole);
		dropdown.selectByVisibleText(role);
	
	}
	
	public void setDepartment(String dept)
	{
		
		Select dropdown = new Select(department);
		dropdown.selectByVisibleText(dept);
	
	}
	
	public void setDescription(String desc)
	{
		
		Select dropdown = new Select(description);
		dropdown.selectByVisibleText(desc);
	
	}
	
	public void setCountry(String cnty)
	{
		
		Select dropdown = new Select(country);
		dropdown.selectByVisibleText(cnty);
	
	}
	
	public void setState(String st)
	{
		
		Select dropdown = new Select(state);
		dropdown.selectByVisibleText(st);
	
	}
	
	public void clickSubmit()
	{
		
		submit.click();
	
	}
	
	public  String getErrorMessage()
	{
		
		return errorMessage.getText();
	
	}
	
}
