package demosite.glue;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import org.junit.After;


public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        try {

            Reporter.addScenarioLog("Starting scenario execution : " + scenario.getName());
            System.setProperty("org.freemarker.loggerLibrary", "none");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        Reporter.addScenarioLog("Ending scenario execution : " + scenario.getName());
    }

}
