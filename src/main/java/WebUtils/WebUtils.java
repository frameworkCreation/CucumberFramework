package WebUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebUtils {

	public static void click(WebDriver driver, String locator, String locatorValue) {
		WebElement we = null;
		if (locator.equalsIgnoreCase("Xpath")) {
			we = driver.findElement(By.xpath(locatorValue));
			we.click();
		} else if (locator.equalsIgnoreCase("CSS")) {
			we = driver.findElement(By.cssSelector(locatorValue));
			we.click();
		} else if (locator.equalsIgnoreCase("name")) {
			we = driver.findElement(By.name(locatorValue));
			we.click();
		} else if (locator.equalsIgnoreCase("id")) {
			we = driver.findElement(By.id(locatorValue));
			we.click();
		} else if (locator.equalsIgnoreCase("className")) {
			we = driver.findElement(By.className(locatorValue));
			we.click();
		}else if (locator.equalsIgnoreCase("linkText")) {
			we = driver.findElement(By.linkText(locatorValue));
			we.click();
		}else if (locator.equalsIgnoreCase("partialLinkText")) {
			we = driver.findElement(By.partialLinkText(locatorValue));
			we.click();
		}else if (locator.equalsIgnoreCase("tagName")) {
			we = driver.findElement(By.tagName(locatorValue));
			we.click();
		}
		
		



	}

}
