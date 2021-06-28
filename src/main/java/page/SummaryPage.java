package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class SummaryPage {
	
	WebDriver driver;
	
	public void SummaryPageVerification (WebDriver driver) {
		this.driver = driver;
	}
		
		@FindBy(how=How.XPATH, using ="//*[@id='summary']") WebElement Summary_Element;
	
	public void validateSummaryPage() {
		
		Assert.assertEquals(Summary_Element.getText(), "Summary", "Wrong Page");
		
	}
	
}
