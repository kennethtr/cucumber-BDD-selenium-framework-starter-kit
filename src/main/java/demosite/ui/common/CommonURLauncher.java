package demosite.ui.common;

import demosite.ui.config.ConfigFileReader;
import demosite.ui.pages.base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CommonURLauncher extends BasePage {

    final static Logger logger = Logger.getLogger(CommonURLauncher.class);

    public CommonURLauncher(WebDriver driver)
    {
        super(driver);
        this.driver = driver;

    }

    public void launchURL()
    {
        logger.debug("Launching the web application URL...");
        driver.get(ConfigFileReader.getApplicationURL());
        driver.manage().window().maximize();

    }
}
