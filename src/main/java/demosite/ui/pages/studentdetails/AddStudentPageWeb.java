package demosite.ui.pages.studentdetails;

import com.vimalselvam.cucumber.listener.Reporter;
import demosite.ui.pages.base.BasePage;
import demosite.ui.utils.CommonUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddStudentPageWeb extends BasePage {

    CommonUtils commonUtils = new CommonUtils();

    private WebDriver driver;

    int timeout = 30;

    final static Logger logger = Logger.getLogger(AddStudentPageWeb.class);

    public AddStudentPageWeb(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//h1")
    private WebElement studentDetailsPageHeader;

    @FindBy(css = ".btn-primary")
    private WebElement addStudent;

    public void addStudent() {
        commonUtils.waitForVisible(driver, timeout, studentDetailsPageHeader);
        logger.debug("Add Student Page is displayed");
        Reporter.addStepLog("Add Student page is displayed");
        commonUtils.takeScreenshot(driver);
        commonUtils.waitForVisibleAndClick(driver, timeout, addStudent);
        commonUtils.takeScreenshot(driver);
    }

}
