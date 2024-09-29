package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage extends BasePage{
	
	@FindBy(xpath = "//select[@name='location']")
	WebElement locationDropdown;
	
	@FindBy(xpath = "//select[@name='hotels']")
	WebElement hotelsDropdown;
	
	@FindBy(xpath = "//input[@name='datepick_in']")
	WebElement checkInDateTextbox;
	
	public void locationDropdown(String option)
	{
		//new Select(locationDropdown).selectByVisibleText(option);
		selectOptionDropdown(locationDropdown, option);
	}
	
	public void hotelsDropdown(String option)
	{
		//new Select(locationDropdown).selectByVisibleText(option);
		selectOptionDropdown(hotelsDropdown, option);
	}
	
	public void checkInDateTextbox(String date)
	{
		//checkInDateTextbox.clear();
		//checkInDateTextbox.sendKeys(null);
		clearAndType(checkInDateTextbox, date);
	}
	
	

}
