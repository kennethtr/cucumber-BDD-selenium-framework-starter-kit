package demosite.ui.pages.studentdetails;

import demosite.ui.pages.base.BasePage;
import demosite.ui.utils.CommonUtils;
import com.vimalselvam.cucumber.listener.Reporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteLoginPageWeb extends BasePage {

    CommonUtils commonUtils = new CommonUtils();

    private WebDriver driver;

    int timeout = 30;

    final static Logger logger = Logger.getLogger(DemoSiteLoginPageWeb.class);


    @FindBy(css = ".primary")
    private WebElement homePageLogo;

    @FindBy(xpath = "//*[@id='userName']")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordField;

    @FindBy(css = ".btn-info")
    private WebElement login;

    public DemoSiteLoginPageWeb(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /**
     * @param username
     * @param password
     */

    /**
     *
     * @param username
     * @param password
     */
    public void login(String username, String password) {
        logger.debug("Opening demo site...");
        commonUtils.waitForVisible(driver, timeout, homePageLogo);
        commonUtils.takeScreenshot(driver);
        logger.debug("Demo login page logo is displayed");
        Reporter.addStepLog("Demo login page logo is displayed");
        commonUtils.waitForVisible(driver, timeout, usernameField);
        commonUtils.waitForVisible(driver, timeout, passwordField);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        commonUtils.waitForVisibleAndClick(driver, timeout, login);
        logger.debug("Logging in with valid credentials...");
        commonUtils.takeScreenshot(driver);

    }


}
