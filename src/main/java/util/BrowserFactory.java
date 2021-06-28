package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BrowserFactory {

	static WebDriver driver;
	static String browser = null;
	static String url = null;

	public static void readConfig() {
	//Bufferreader //InputStream//Filereader//scanner -- helps to read any type of file
		//Properties prop = new Properties(); ---- for java to understand the file

		Properties prop = new Properties();

		try {
			InputStream input = new FileInputStream("/Users/sadia/Desktop/Selenium/ExcelProjectSadia/src/main/java/config/config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public static WebDriver init() {
		readConfig();
			
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/sadia/Desktop/IT/Selenium/geckodriver");
			driver = new FirefoxDriver();
		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	@AfterClass
	public static void TearDown() {
		driver.close();
		driver.quit();

	}

	
}
