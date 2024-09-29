package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.UtilKit;

public class ValidateLoginPOMandDataProvider extends BaseTest{
	
	@Test(dataProvider = "getData")
	public void validateLoginTest(HashMap<String, String> dataMap)
	{
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.usernameTextbox(dataMap.get("username"));
		
		loginPage.passwordTextbox(dataMap.get("password"));
		
		loginPage.loginButton();
		
		loginPage.verifyTitle(dataMap.get("expected Title"));
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC- 101");
		
		return data;
		
	}

}
