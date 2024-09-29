package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static FileInputStream fis1;
	public static Properties configProp;
	public static FileInputStream fis2;
	public static Properties locatorsProp;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	
	@BeforeTest
	public void setUpProps()
	{
		try {
			fis1=new FileInputStream("src\\test\\resources\\Properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		configProp=new Properties();
		
		try {
			configProp.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fis2=new FileInputStream("src\\test\\resources\\Properties\\locators.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		locatorsProp=new Properties();
		
		try {
			locatorsProp.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reports=ExtentManager.getReports();
		
	}
	
	@AfterTest
	public void closeReports()
	{
		reports.flush();
	}
	
	@BeforeMethod
	public void setUp(ITestContext context)
	{
				
		test=reports.createTest(context.getCurrentXmlTest().getClasses().get(0).getName());
		
		String browserName=configProp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			test.info("chrome browser started..");
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			test.info("firefox browser started..");
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			test.info("edge browser started..");
		}
		
		// to launch app 
		
		driver.get(configProp.getProperty("url"));
		test.info("app launched using url "+configProp.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		test.info("browser closed...");
	}

}
