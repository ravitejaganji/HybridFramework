package keywords;

import org.testng.Assert;

public class ValidateKeywords extends GenericKeywords{
	
	public void validateTitle(String expTitle)
	{
		Assert.assertEquals(driver.getTitle(), expTitle);
	}
	
	

}
