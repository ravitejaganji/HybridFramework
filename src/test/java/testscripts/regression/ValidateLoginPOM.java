package testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class ValidateLoginPOM extends BaseTest{
	
	@Test
	public void validateLoginTest()
	{
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.usernameTextbox("reyaz0806");
		
		loginPage.passwordTextbox("reyaz123");
		
		loginPage.loginButton();
		
		loginPage.verifyTitle("Adactin.com - Search Hotel");
		
		
	}

}
