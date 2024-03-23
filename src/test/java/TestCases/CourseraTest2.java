package TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageData.HomePage;
import PageData.SearchPage;

public class CourseraTest2 extends BaseClass
{
	@Test(groups={"sanity","regression"},priority=2)
	public static void homePage2() throws InterruptedException
	{
		
		log.info("Test case 2 Starts");
		
		HomePage hp = new HomePage(driver);
		
		driver.navigate().to("https://www.coursera.org/");
		log.info("Navigate to Homepage");
		
		hp.clickSearch();
		log.info("Click on Search");
		
	}
	
	@Test(dependsOnMethods="homePage2", groups={"regression"}, priority=3)
	public static void languageLearning()
	{
		
		SearchPage sp = new SearchPage(driver);
		
		sp.clickSeeMoreSubject();
		log.info("Click see more in Subject");
		
		sp.clickLanguageLearning();
		log.info("Click Language Learning");
		
		sp.clickApply();
		log.info("Click on Apply");
		
		List<WebElement> actualResult2 = sp.getLevel();
		System.out.println("Total number of levels = "+ actualResult2.size());
		for (WebElement level : actualResult2) 
		{
		   		
		Assert.assertTrue(level.isDisplayed());
		System.out.println(level.getText());
		          
		}
		log.info("Extract Levels");
		    	
		    	
		System.out.println("------------------------");
		
		
		sp.clickSeeMoreLanguage();
		log.info("Click see more in Languages");
		
		List<WebElement> actualResult1 = sp.getLanguage();
		System.out.println("Total number of languages = "+ actualResult1.size());
    	for (WebElement language : actualResult1) 
          {
    		
            System.out.println(language.getText());
          
          }
    	log.info("Extract Languages");
		
		
		System.out.println("------------------------");
		
		
		log.info("Test case 2 Ends");    	
    	
	}
	
}
