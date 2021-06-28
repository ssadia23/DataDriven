package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	// WebDriver driver;

	public int randomGenerator(int num) {
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(num);
		return randomNumber;
	}

	public void DropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}


	public static void javaClick(WebElement webElement) {
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", webElement);
	}

}
