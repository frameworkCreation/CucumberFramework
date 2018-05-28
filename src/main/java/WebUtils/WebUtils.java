package WebUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebUtils {

	public static WebElement FindElement(WebDriver driver, String locator, String locatorValue) {
		WebElement we = null;
		if (locator.equalsIgnoreCase("Xpath")) {
			we = driver.findElement(By.xpath(locatorValue));

		} else if (locator.equalsIgnoreCase("CSS")) {
			we = driver.findElement(By.cssSelector(locatorValue));

		} else if (locator.equalsIgnoreCase("name")) {
			we = driver.findElement(By.name(locatorValue));

		} else if (locator.equalsIgnoreCase("id")) {
			we = driver.findElement(By.id(locatorValue));

		} else if (locator.equalsIgnoreCase("className")) {
			we = driver.findElement(By.className(locatorValue));

		} else if (locator.equalsIgnoreCase("linkText")) {
			we = driver.findElement(By.linkText(locatorValue));

		} else if (locator.equalsIgnoreCase("partialLinkText")) {
			we = driver.findElement(By.partialLinkText(locatorValue));

		} else if (locator.equalsIgnoreCase("tagName")) {
			we = driver.findElement(By.tagName(locatorValue));

		}

		return we;

	}

	public static void sendKeys(WebDriver driver, String locator, String locatorValue, String value) {
		WebElement we = FindElement(driver, locator, locatorValue);
		we.sendKeys(value);
	}

	public static void Click(WebDriver driver, String locator, String locatorValue) {
		WebElement we = FindElement(driver, locator, locatorValue);
		we.click();
	}

	public static void getText(WebDriver driver, String locator, String locatorValue) {
		WebElement we = FindElement(driver, locator, locatorValue);
		we.getText();
	}

	public static void selectDropDown(WebDriver driver, String locator, String locatorValue, String By, String value) {

		Select select = new Select(FindElement(driver, locator, locatorValue));
		if (By.equalsIgnoreCase("selectByIndex")) {
			select.selectByIndex(Integer.parseInt(value));
		} else if (By.equalsIgnoreCase("selectByValue")) {
			select.selectByValue(value);
		} else if (By.equalsIgnoreCase("selectByVisibleText")) {
			select.selectByVisibleText(value);
		}

	}

	public static void deselectDropDown(WebDriver driver, String locator, String locatorValue, String By,
			String value) {

		Select select = new Select(FindElement(driver, locator, locatorValue));
		if (By.equalsIgnoreCase("selectByIndex")) {
			select.deselectByIndex(Integer.parseInt(value));
		} else if (By.equalsIgnoreCase("selectByValue")) {
			select.deselectByValue(value);
		} else if (By.equalsIgnoreCase("selectByVisibleText")) {
			select.deselectByVisibleText(value);
		}

	}

	public static void deselectAll(WebDriver driver, String locator, String locatorValue) {

		Select select = new Select(FindElement(driver, locator, locatorValue));
		select.deselectAll();

	}
	
	
	
	
	

}
