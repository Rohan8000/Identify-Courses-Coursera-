package TestCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageData.ForBusinessPage;
import PageData.ForUniversityPage;
import PageData.HomePage;
import Utility.ExcelUtility;
import Utility.FormDataprovider;

public class CourseraTest3 extends BaseClass
{
	
	public static int j=0;
	
	@Test(groups={"sanity","regression"}, priority=6)
	public static void homePage3()
	{
		
		log.info("Test case 3 Starts");
		
		HomePage hp = new HomePage(driver);
		
		driver.navigate().to("https://www.coursera.org/");
		log.info("Navigate to Homepage");
		
		hp.clickForEnterprise();
		log.info("Click on Enterprise");
		
	}
	
	@Test(dependsOnMethods="homePage3", groups={"sanity","regression"} , priority=7)
	public static void courseraForBusiness()
	{
		
		ForBusinessPage bp = new ForBusinessPage(driver);
		
		bp.clickSolutions();
		log.info("Click on solution");
		
		bp.clickCampus();
		log.info("Click on campus");
		
	}
	
	
	@Test(dataProvider="InputDataForHackathon", dataProviderClass=FormDataprovider.class,dependsOnMethods="courseraForBusiness", groups={"regression"} , priority=8)
	public static void courseraForCampus(String fname, String lname, String mail, String phNum, String insType, String insName, String role, String dept, String desc, String cnty, String st) throws IOException, InterruptedException
	{
		
		ForUniversityPage up = new ForUniversityPage(driver);
		
		driver.navigate().to("https://www.coursera.org/campus?utm_content=corp-to-landing-for-campus&utm_campaign=website&utm_medium=coursera&utm_source=header&utm_term=b-out");
		
		up.setFirstName(fname);
		log.info("Fill the firstName");
		
		up.setLastName(lname);
		log.info("Fill the lastName");
		
		up.setEmailID(mail);
		log.info("Fill email Id");
		
		up.setPhoneNum(phNum);
		log.info("Fill phone number");
		
		up.setInstitutionType(insType);
		log.info("Fill Institution Type");
		
		up.setInstitutionName(insName);
		log.info("Fill Institution Name");
		
		up.setJobRole(role);
		log.info("Fill Job Role");
		
		up.setDepartment(dept);
		log.info("Fill Department");
		
		up.setDescription(desc);
		log.info("Fill which describes your needs");
		
		up.setCountry(cnty);
		log.info("Fill Country");
		
		up.setState(st);
		log.info("Fill State");
		
		Thread.sleep(3000);
		up.clickSubmit();
		log.info("Click on Submit");
		
		String actualResult = up.getErrorMessage();
		ExcelUtility exl = new ExcelUtility("C:\\Users\\2318121\\eclipse-workspace\\Hackathon\\TestData\\InputDataForHackathon.xlsx");
		j++;
		exl.setCellData("Sheet1", j, 12, actualResult);
		Assert.assertFalse(actualResult.isEmpty());
		log.info("Capture error message");
		
		
		
		log.info("Test case 3 Ends");
		
	}
		
}
