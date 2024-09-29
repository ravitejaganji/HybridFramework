package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class LoginPage extends BasePage {
	
	@FindBy(xpath="//input[@name='username']")	
	WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password']")	
	WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@name='login']")	
	WebElement loginButton;
	
	public void usernameTextbox(String text)
	{
		usernameTextbox.sendKeys(text);
		test.log(Status.INFO, "entered text "+text+" into textbox "+usernameTextbox);
	}
	
	public void passwordTextbox(String text)
	{
		passwordTextbox.sendKeys(text);
		test.log(Status.INFO, "entered text "+text+" into textbox "+passwordTextbox);
	}
	
	public void loginButton()
	{
		loginButton.click();
		test.log(Status.INFO, "clicked button  "+loginButton);
	}
	

}
