package PlatformLayer;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutput;
//import java.nio.file.Files;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.steadystate.css.util.Output;

import cucumber.api.Scenario;
import gherkin.formatter.Reporter;

public class Reporters {
	
	
	public static void CaptureScreenshot(WebDriver drv,Scenario scenario)
	{
		
		
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot)drv).getScreenshotAs(OutputType.FILE);
				
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				
				//Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath); 
				// Take the Screen shot and embed in Cucumber Reports
				final byte[] screenshot = ((TakesScreenshot)drv).getScreenshotAs(OutputType.BYTES);
				
				scenario.embed(screenshot, "image/png");

				//This attach the specified screenshot to the test
				
			} catch (IOException e) {
			} 
		
	}
	
}
