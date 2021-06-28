package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VerifyProfile extends AddCustomerPage {
	
	WebDriver driver;

	public VerifyProfile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//	public VerifyProfile (WebDriver driver) {
//		this.driver = driver;
//	}
	
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
