package PageData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	
	public HomePage(WebDriver driver) 
	{
		
		super(driver);
	
	}
	
	
	@FindBy(xpath=("(//input[@type='text'])[1]"))
	public WebElement web;
	@FindBy(xpath=("//button[@class='nostyle search-button']/div"))
	public WebElement search;
	@FindBy(xpath=("(//div[@role='navigation']/a)[1]"))
	public WebElement individuals;
	@FindBy(xpath=("(//ul[@class='rc-SubFooterSection__content-column-links']/li/a)[58]"))
	public WebElement enterprise;
	
	
	public void setWebDevelopmentCourse()
	{
		
		web.sendKeys("web development courses");
	
	}
	
	public void clickSearch()
	{
		
		search.click();
	
	}
	
	public void clickForIndividuals()
	{
		
		individuals.click();
	
	}
	
	public void clickForEnterprise()
	{
		
		enterprise.click();
	
	}
	
}
