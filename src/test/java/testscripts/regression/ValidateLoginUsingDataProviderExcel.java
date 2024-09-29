package testscripts.regression;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class ValidateLoginUsingDataProviderExcel extends BaseTest {
	
	
	
	@Test(dataProvider="getTestData")
	public void validateLoginTest1(HashMap<String, String> testDataMap)
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(testDataMap.get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(testDataMap.get("password"));
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Assert.assertEquals(driver.getTitle(), testDataMap.get("expected Title"));
		//Assert.assertTrue(driver.findElement(By.xpath("//input[@id='username_show']")).isDisplayed());
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		 Object[][] data=new Object[1][1];
		 
		 /*
		  *   10   int[] a=new int[1];  a[0]=10;
		  *   
		  *   10 20 30 int[] a=new int[3];  a[0]=10;a[1]=20;a[2]=30;
		  *   
		  *   10 20 30			int[][] a= new int[2][3];   a[0][0]=10;a[0][1]=20;a[0][2]=30
		  *   100 200 300
		  *   
		  *   10          int[][] a=new int[1][1]; a[0][0]=10;
		  */
			
			
		data[0][0]=UtilKit.getTestDataFromExcel("TC-102");
			
		return data;
		
	}


}
