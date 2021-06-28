package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends BasePage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using ="//h2[contains(text(), 'Dashboard')]") WebElement Dashboard_Element;
	@FindBy(how=How.XPATH, using ="//span[contains(text(),'Customers')]") WebElement Customer_Element;
	@FindBy(how=How.XPATH, using ="//a[contains(text(),'Add Customer')]") WebElement Add_Customer_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement LIST_CUSTOMERS_FIELD;
	
	public void validateDashboardPage() {
		
		Assert.assertEquals(Dashboard_Element.getText(), "Dashboard", "Wrong Page");
		
	}
	
	public void clickCustomerButton() {
		//BasePage.javaClick(Customer_Element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Customer_Element);
	}
	public void clickAddCustomerButton() {
		Add_Customer_Element.click();
	}
	
	public void clickListCustomersButton() {
		LIST_CUSTOMERS_FIELD.click();
	}
	
}
