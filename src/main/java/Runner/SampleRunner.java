package Runner;

import java.util.Properties;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"C:\\Users\\boraajyo\\eclipse-workspace\\CucumberFramework\\src\\main\\java\\FeatureFile"},
		glue={"StepDefinition"},
		plugin={"html:target/cucumber-html-report","json:target/cucumber.json","pretty:target/pretty.text",
				"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"},
		dryRun=false,
		monochrome =true
		)
		
public class SampleRunner {
	static Properties properties;
	public static void CaptureExtentReport(Scenario scenario)
	{
		String filepath = getReportConfigPath();
		
	}
	public static String getReportConfigPath(){
		
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}
