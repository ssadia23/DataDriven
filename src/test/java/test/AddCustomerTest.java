package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import page.SummaryPage;
import page.VerifyProfile;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;
	ExcelReader exlreader = new ExcelReader("src/main/java/data/TechFios.xlsx");
	String userName = exlreader.getCellData("Login", "UserName", 2);
	String passWord = exlreader.getCellData("Login", "Password", 2);
	String fullName = exlreader.getCellData("AddContact", "FullName", 2);
	String companyName = exlreader.getCellData("AddContact", "CompanyName", 2);
	String iemail = exlreader.getCellData("AddContact", "Email", 2);
	String iphone = exlreader.getCellData("AddContact", "CompanyName", 2);
	String iaddress = exlreader.getCellData("AddContact", "Email", 2);
	String icity = exlreader.getCellData("AddContact", "City", 2);
	String icountry = exlreader.getCellData("AddContact", "Country", 2);
	String istate = exlreader.getCellData("AddContact", "State", 2);
	String izip = exlreader.getCellData("AddContact", "Zip", 2);
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() {
		driver = BrowserFactory.init();

	LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(passWord);
		loginPage.clickSignInButton();
		
	DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
	
	AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.insertFullName(fullName);	
		addCustomerPage.insertCompanyOption(companyName);
		addCustomerPage.insertEmail(iemail);
		addCustomerPage.insertPhone(iphone);
		addCustomerPage.insertAddress(iaddress);
		addCustomerPage.insertCity(icity);
		addCustomerPage.insertCountry(icountry);
		addCustomerPage.insertState(istate);
		addCustomerPage.insertip(izip);
		addCustomerPage.clickSave();
		
	SummaryPage	summaryPage = PageFactory.initElements(driver, SummaryPage.class);
		summaryPage.validateSummaryPage();
		
	VerifyProfile verifyProfile = PageFactory.initElements(driver, VerifyProfile.class);
		verifyProfile.verfiyEnteredName();
	
	}
	
	
}
