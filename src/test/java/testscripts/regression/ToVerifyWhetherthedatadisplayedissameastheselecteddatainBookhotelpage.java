package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class ToVerifyWhetherthedatadisplayedissameastheselecteddatainBookhotelpage extends BaseTest{

	
	@Test(dataProvider = "getData")
	public void validateDataDiplayed(HashMap<String, String> dataMap) throws InterruptedException
	{
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		
		lp.usernameTextbox(dataMap.get("username"));
		
		lp.passwordTextbox(dataMap.get("password"));
		
		lp.loginButton();
		
		SearchHotelPage shp=PageFactory.initElements(driver, SearchHotelPage.class);
		
		shp.verifyTitle(dataMap.get("expected Title"));
		
		shp.locationDropdown(dataMap.get("location"));
		Thread.sleep(3000);
		shp.hotelsDropdown(dataMap.get("hotel"));
		Thread.sleep(3000);
		
		shp.checkInDateTextbox(dataMap.get("Check In Date"));
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-113");
		
		return data;
		
	}
	
}
