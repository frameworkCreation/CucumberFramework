package PlatformLayer;

import java.io.File;
import java.io.ObjectOutput;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.steadystate.css.util.Output;

import cucumber.api.Scenario;

public class Reporters {
	
	
	public static void CaptureScreenshot(WebDriver drv,Scenario logger)
	{
		final byte[] screenshot = ((TakesScreenshot)drv).getScreenshotAs(OutputType.BYTES);
		logger.embed(screenshot, "image/png");
	}
}
