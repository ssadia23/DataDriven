package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

		WebDriver driver; 
		
		public LoginPage (WebDriver driver) {
			this.driver = driver;
			
		}
		
		//Element Library
		@FindBy (how=How.XPATH, using ="//input[@id='username']") WebElement USER_NAME;
		@FindBy (how=How.XPATH, using ="//input[@id='password']") WebElement PASSWORD;
		@FindBy (how=How.XPATH, using ="//button[@name='login']") WebElement SUBMIT;
		
		
		//interactive method
		public void insertUserName(String userName) {
			 USER_NAME.sendKeys(userName);
		}
		public void insertPassword(String Password) {
			 PASSWORD.sendKeys(Password);
		}
		public void clickSignInButton() {
			 SUBMIT.click();
		}
		
		public void signInOperation(String userName, String password) {
			USER_NAME.sendKeys(userName);
			PASSWORD.sendKeys(password);
			SUBMIT.click();
			
		}
	
}
