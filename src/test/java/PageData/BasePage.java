package PageData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseClass;

public class BasePage extends BaseClass
{
	
	BasePage(WebDriver driver)
	{
		
		BasePage.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
}
