package page;

import java.util.Random;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using ="//h2[contains(text(), 'Dashboard')]") WebElement Dashboard_Element;
	@FindBy(how=How.XPATH, using ="//input[@id='account']") WebElement Name_Element;
	@FindBy(how=How.XPATH, using ="//select[@id='cid']") WebElement Company_Element;
	@FindBy(how=How.XPATH, using ="//input[@id='email']") WebElement Email_Element;
	@FindBy(how=How.XPATH, using ="//input[@id='phone']") WebElement Phone_Element;
	@FindBy(how=How.XPATH, using ="//input[@id='address']") WebElement Address_Element;
	@FindBy(how=How.XPATH, using ="//input[@id='city']") WebElement City_Element;
	@FindBy(how=How.XPATH, using ="//input[@id='state']") WebElement State_Element;
	@FindBy(how=How.XPATH, using ="//input[@id='zip']") WebElement Zip_Element;
	@FindBy(how=How.XPATH, using ="//select[@id='country']") WebElement Country_Element;
	@FindBy(how=How.XPATH, using ="//button[@type='submit' and @id='submit']") WebElement Save_Element;
	
		String enteredName;
	public void insertFullName(String name) {	
		enteredName = name + randomGenerator(999);
		Name_Element.sendKeys(enteredName);	
	}
	
	public void insertCompanyOption(String company) {	
		DropDown(Company_Element, company);
	}
	
	public void insertEmail(String email) {	
		Email_Element.sendKeys(randomGenerator(999)+email);	
	}
	public void insertPhone(String phone) {	
		int ranNumber = randomGenerator(999);
		Phone_Element.sendKeys(ranNumber+phone);	
	}
	public void insertAddress(String address) {	
		Address_Element.sendKeys(address);	
	}
	public void insertCity(String city) {	
		Address_Element.sendKeys(city);	
	}
	
	public void insertCountry(String country) {	
		DropDown(Country_Element, country);	
	}
	public void insertState(String state) {	
		Address_Element.sendKeys(state);	
	}
	public void insertip(String zip) {	
		Address_Element.sendKeys(zip);	
	}
	public void clickSave() {	
		Save_Element.click();	
	}
	
	
	public void validateDashboardPage() {
		
		Assert.assertEquals(Dashboard_Element.getText(), "Dashboard", "Wrong Page");
		
	}
	
	public void verfiyEnteredName() {
		
		String beforeXpath = "//tbody/tr[";
		String afterXpath = "]/td[3]";
		
		for(int i = 1; i<=10; i++) {
			String name = driver.findElement(By.xpath(beforeXpath+ i + afterXpath)).getText();
			
//			Assert.assertEquals(name, enteredName, "wrong");
//			break;
			
			if(name.contains(enteredName)) {
				System.out.println("Entered name exist");
				driver.findElement(By.xpath(beforeXpath + i + "]/td[3]/following-sibiling::td[4]/a[2]" )).click();
			}
		}
		
		
		
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3] 
	//tbody/tr[i]/td[3]
		
		//tbody/tr[i]/td[3]/following-sibiling::td[4]/a[2]
	}

	
}
