package demosite.ui.pages.studentdetails;

import com.vimalselvam.cucumber.listener.Reporter;
import demosite.ui.pages.base.BasePage;
import demosite.ui.utils.CommonUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterStudentDetailsPageWeb extends BasePage {

    CommonUtils commonUtils = new CommonUtils();
    final static Logger logger = Logger.getLogger(EnterStudentDetailsPageWeb.class);

    private WebDriver driver;

    int timeout = 30;

    @FindBy(xpath = "//h1")
    private WebElement enterStudentDetailsPageHeader;

    @FindBy(xpath = "//*[@value='submit']")
    private  WebElement submit;

    public EnterStudentDetailsPageWeb(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public void verifyEnterStudentDetailsPage()
    {
    commonUtils.waitForVisible(driver, timeout, enterStudentDetailsPageHeader);
    logger.debug("Enter Student Details Page header displayed");
    Reporter.addStepLog("Enter student details page is displayed");
    commonUtils.waitForVisible(driver, timeout, submit);
    commonUtils.takeScreenshot(driver);
    }

}
