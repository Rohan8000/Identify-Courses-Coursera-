package BasePackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

public class BaseClass 
{
	public static WebDriver driver;
	public WebDriverWait myWait;
	public JavascriptExecutor js;
	public static Logger log;
	
	@BeforeTest(groups={"sanity","regression"})
	@Parameters({"Browser","Url"})
	public void create(String br, String url) throws Exception
	{
		
		//Loading log4j2 file
		log = LogManager.getLogger(this.getClass());
		
		//Create driver
		if(br.equals("chrome"))
		{
		driver = new ChromeDriver();
		}
		else 
		{
		driver = new EdgeDriver();
		}
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Delete all cookies
		driver.manage().deleteAllCookies();
		
		//Open the link
		driver.get(url);
		
	}
	
	@AfterTest(groups={"sanity","regression"})
	public void close()
	{
		
		//Close Browser
		driver.quit();
	
	}
	
	public String captureScreen(String tname) throws IOException 
	{
		 
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\Screenshot\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		Files.copy(sourceFile, targetFile);
		return targetFilePath;
 
	}
	
//	public static String randomeString()
//	{
//		
//		String generatedString=RandomStringUtils.randomAlphabetic(5);
//		return generatedString;
//	
//	}
//	
//	public static String randomeNumber()
//	{
//		
//		String generatedString=RandomStringUtils.randomNumeric(10);
//		return generatedString;
//	
//	}
//	
//	public static String randomAlphaNumeric()
//	{
//		
//		String str=RandomStringUtils.randomAlphabetic(3);
//		String num=RandomStringUtils.randomNumeric(3);
//		
//		return (str+"@"+num);
//	
//	}
	
}
