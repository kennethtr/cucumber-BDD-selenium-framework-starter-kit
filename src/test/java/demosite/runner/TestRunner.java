package demosite.runner;

import demosite.ui.config.ConfigFileReader;
import demosite.ui.config.WebDriverFactory;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "demosite.glue",
       plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:reports/ExecutionResults.html"},
        tags = {"@SampleTest"},
        monochrome = true,
        strict = true)



public class TestRunner {
    @BeforeClass
    public static void setup()
    {

        WebDriverFactory driverFactory = new WebDriverFactory();
    }


    @AfterClass
    public static void writeExtentReport()
    {
        WebDriverFactory driver = new WebDriverFactory();
        Reporter.loadXMLConfig(new File(ConfigFileReader.getExtentReportPath()));
        driver.closeWebDriver();

    }
}
