package demosite.ui.pages.base;

import demosite.ui.config.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    /**
     *
     * @param driver
     */
    protected BasePage(WebDriver driver)
    {
       this.driver = WebDriverFactory.webDriver;
        PageFactory.initElements(driver, this);
    }
}
