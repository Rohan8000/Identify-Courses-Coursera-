package PageData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForBusinessPage extends BasePage
{
	
	public ForBusinessPage(WebDriver driver) 
	{
		
		super(driver);
		
	}
	
	
	@FindBy(xpath=("(//div[@class='css-tl9vba']/a)[2]"))
	public WebElement solution;
	@FindBy(xpath=("(//div[@class='css-1ftyu27']/a)[9]"))
	public WebElement campus;
	
	
	public void clickSolutions()
	{
		
		solution.click();
	
	}
	
	public void clickCampus()
	{
		
		campus.click();
	
	}
	
}
