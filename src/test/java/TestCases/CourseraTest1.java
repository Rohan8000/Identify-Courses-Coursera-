package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageData.HomePage;
import PageData.SearchPage;

public class CourseraTest1 extends BaseClass
{
	@Test(groups={"sanity","regression"}, priority=0)
	public static void homePage1()
	{
		
		log.info("Test case 1 Starts");
		
		HomePage hp = new HomePage(driver);
		
		hp.setWebDevelopmentCourse();
		log.info("Search for Web Development Courses");
		
		hp.clickSearch();
		log.info("Click on Search");
		
	}
	
	@Test(dependsOnMethods="homePage1", groups={"regression"}, priority = 1)
	public static void webDevelopmentCourses()
	{
		
		SearchPage sp = new SearchPage(driver);
		
		sp.clickEnglish();
		log.info("Click on English Language");
		
		sp.clickBeginner();
		log.info("Click on Beginners level");
		
		Assert.assertTrue(sp.course1.isDisplayed());
		System.out.println(sp.course1.getText());
		log.info("Extract name of course 1");
		
		Assert.assertTrue(sp.course2.isDisplayed());
		System.out.println(sp.course2.getText());
		log.info("Extract name of course 2");
		
		Assert.assertTrue(sp.time1.isDisplayed());
		System.out.println(sp.time1.getText());
		log.info("Extract learning hours 1");
		
		Assert.assertTrue(sp.time2.isDisplayed());
		System.out.println(sp.time2.getText());
		log.info("Extract learning hours 2");
		
		Assert.assertTrue(sp.rating1.isDisplayed());
		System.out.println(sp.rating1.getText());
		log.info("Extract Rating 1");
		
		Assert.assertTrue(sp.rating2.isDisplayed());
		System.out.println(sp.rating2.getText());
		log.info("Extract Rating 2");
		
		
		System.out.println("------------------------");
		
		
		log.info("Test case 1 Ends");
		
	}
	
}
