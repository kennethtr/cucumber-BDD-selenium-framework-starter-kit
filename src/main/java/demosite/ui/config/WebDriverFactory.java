package demosite.ui.config;

import demosite.ui.enums.DriverType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {
    public static Logger logger = Logger.getLogger(WebDriverFactory.class);
    public static WebDriver webDriver;
    static ConfigFileReader configFileReader = new ConfigFileReader();

    static {
        getWebDriver();
    }

    public static WebDriver getWebDriver() {

        try {
            DriverType driverType = configFileReader.getBrowserType();
            BasicConfigurator.configure();
            logger.debug("Fetching webdriver for " + driverType.toString());
            switch (driverType) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
                    webDriver = new ChromeDriver();
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "\\drivers\\geckodriver.exe");
                    webDriver = new FirefoxDriver();
                    break;
                case EDGE:
                    System.setProperty("webdriver.edge.driver", "\\drivers\\msedgedriver.exe");
                    webDriver = new EdgeDriver();
                    break;
                case MAC_CHROME:
                    System.setProperty("webdriver.edge.driver", "\\drivers\\chrome.exe");
                    webDriver = new ChromeDriver();
                default:
                    break;
            }
            logger.debug("Created webDriver for " + driverType.toString());


        } catch (Exception e) {
            logger.error("Unable to initialize browser..." + e.getMessage());
            e.printStackTrace();
        }
        return webDriver;
    }

    public void closeWebDriver() {
        logger.info("Closing webdriver");
        webDriver.close();
        webDriver.quit();
    }
}
