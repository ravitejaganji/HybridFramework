package keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class GenericKeywords extends BaseTest {
	
	
	public void startBrowser()
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
		
		String browserName=configProp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
	}
	
	public void launchApp()
	{
		driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));
	}
	
	
	public void type(String locatorKey,String text)
	{
		
		//driver.findElement(By.xpath(locatorsProp.getProperty(locatorKey))).sendKeys(text);
		
		getElement(locatorKey).sendKeys(text);
	}
	
	public WebElement getElement(String locatorKey)
	{
		
		WebElement element =null;
		
		//Explicit Wait 
		
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		myWait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		
		element=driver.findElement(getLocator(locatorKey));
		
		return element;
		
	}
	
	public By getLocator(String locatorKey)
	{
		
		By by=null;
		
		if(locatorKey.endsWith("_id"))
		{
			by=By.id(locatorsProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_name"))
		{
			by=By.name(locatorsProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_linktext"))
		{
			by=By.linkText(locatorsProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_xpath"))
		{
			by=By.xpath(locatorsProp.getProperty(locatorKey));
		}
		else
		{
			by=By.xpath(locatorsProp.getProperty(locatorKey));
		}
		
		return by;
		
	}
	
	public void click(String locatorKey)
	{
		getElement(locatorKey).click();
	}
	
	public void selectOptionFromDropdown(String locatorKey,String option)
	{
		new Select(getElement(locatorKey)).selectByVisibleText(option);
	}
	
	
	public void closeBrowser()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
