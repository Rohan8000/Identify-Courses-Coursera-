package PageData;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage
{

	public SearchPage(WebDriver driver) 
	{
		
		super(driver);
		
	}
	
	
	@FindBy(xpath=("(//span[text()='English'])[1]"))
	public WebElement eng;
	@FindBy(xpath=("(//span[text()='Beginner'])"))
	public WebElement beginner;
	@FindBy(xpath=("(//div[@class='cds-ProductCard-content'])[1]//h3"))
	public WebElement course1;
	@FindBy(xpath=("(//div[@class='cds-ProductCard-content'])[2]//h3"))
	public WebElement course2;
	@FindBy(xpath=("(//div[@class='cds-CommonCard-metadata'])[1]//p"))
	public WebElement time1;
	@FindBy(xpath=("(//div[@class='cds-CommonCard-metadata'])[2]//p"))
	public WebElement time2;
	@FindBy(xpath=("(//div[@class = 'cds-CommonCard-ratings'])[1]//p"))
	public WebElement rating1;
	@FindBy(xpath=("(//div[@class = 'cds-CommonCard-ratings'])[2]//p"))
	public WebElement rating2;
	@FindBy(xpath=("(//div[@class='css-vjl5rq']/button)[1]"))
	public WebElement seeMoreSubject;
	@FindBy(xpath=("//div[@class='cds-Dialog-dialog']//div[contains(@data-testid,'Language Learning-')]"))
	public WebElement languageLearning;
	@FindBy(xpath=("//button[@class='cds-149 cds-button-disableElevation cds-button-primary css-1dxh3kl']"))
	public WebElement apply;
	@FindBy(xpath=("(//div[@class='css-vjl5rq']/button)[2]"))
	public WebElement seeMoreLanguage;
	@FindBy(xpath=("//div[@id='checkbox-group']//div[@class='cds-checkboxAndRadio-labelText']/span"))
	public List<WebElement> language;
	@FindBy(xpath=("//div[@data-testid='search-filter-group-Level']//div[@class='cds-checkboxAndRadio-labelText']/span[1]/span"))
	public List<WebElement> level;
	
	
	
	public void clickEnglish()
	{
		
		eng.click();
	
	}
	
	public void clickBeginner()
	{
		
		beginner.click();
	
	}
	
	public void getName()
	{
		
		course1.getText();
		course2.getText();
	
	}
	
	public void getTime()
	{
		
		time1.getText();
		time2.getText();
	
	}
	
	public void getRating()
	{
		
		rating1.getText();
		rating2.getText();
	
	}
	
	public void clickSeeMoreSubject()
	{
		
		seeMoreSubject.click();
	
	}
	
	public void clickLanguageLearning()
	{
		
		languageLearning.click();
	
	}
	
	public void clickApply()
	{
		
		apply.click();
	
	}
	
	public void clickSeeMoreLanguage()
	{
		
		seeMoreLanguage.click();
	
	}
	
	public List<WebElement> getLanguage()
	{
		
		return language;
	
	}
	
	public List<WebElement> getLevel()
	{
		
		return level;
		
	}
	
}
