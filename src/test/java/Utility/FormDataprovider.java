package Utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class FormDataprovider 
{
	@DataProvider(name="InputDataForHackathon")
	public String [][] getData() throws IOException
	{
		
		//Taking xl file from testData
		String path="C:\\Users\\2318121\\eclipse-workspace\\Hackathon\\TestData\\InputDataForHackathon.xlsx";
		
		//Creating an object for XLUtility
		ExcelUtility xlutil=new ExcelUtility(path);
		int totalrows=12;	
		int totalcols=11;
		
		//Created for two dimension array which can store the data user and password
		String logindata[][]=new String[totalrows][totalcols];
		
		//1 - Read the data from xl storing in two deminsional array
		for(int i=1; i<=totalrows;i++)
		{
			
			//0 - i is rows j is col
			for(int j=0;j<totalcols;j++)
			{
				
				//1,0
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);
				
			}
			
		}
		
		//Returning two dimension array
		return logindata;
	
	}
	
}
