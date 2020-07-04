package demosite.ui.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Set;

public class CommonUtils {

    public void waitForVisible (WebDriver driver, int timeout, WebElement webElement)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForVisibleAndClick(WebDriver driver, int timeout, WebElement webElement)
    {
        waitForVisible(driver, timeout, webElement);
        webElement.click();
    }

    public void waitForEnable(WebDriver driver, int timeout, WebElement webElement )
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForEnableAndClick(WebDriver driver, int timeout, WebElement webElement)

    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void moveToElement(WebElement webElement, WebDriver driver)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
    }

//    public void switchToContext(String context, WebDriver appiumDriver)
//    {
//        RemoteExecuteMethod executeMethod = new RemoteExecuteMethod((AppiumDriver) appiumDriver);
//        Map<String, Object> params = new HashMap<>();
//        params.put("name", context);
//        executeMethod.execute(DriverCommand.SWITCH_TO_CONTEXT, params);
//    }

//    public WebElement getVisibleElement(By webElement, WebDriver driver)
//    {
//        moveToElement(driver.findElement(webElement), driver);
//        List<WebElement> elementList = driver.findElements(webElement);
//        WebElement visibleWebELement = elementList.stream().filter(l2 -> l2.isDisplayed()).findFirst().get();
//        return visibleWebELement;
//
//    }


    public void scrollToWebElement (WebDriver driver, WebElement element)
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", driver);
    }

    public void clickUsingJsExecutor(WebElement webElement, WebDriver driver) {
        waitForVisible(driver,15, webElement);
        scrollToWebElement(driver, webElement);
        moveToElement(webElement, driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", webElement);
    }

//    public void swipeDownToViewNotifications(WebDriver driver)
//    {
//        Map<String, Object> params = new HashMap<>();
//        params.put("start", "100.0%");
//        params.put("end", "0%,100%");
//        params.put("duration", "3");
//        ((AppiumDriver) driver).executeScript( "mobile:touch:swipe", params);
//    }
//
//    public boolean validatePushNotificationMessage(String message, WebDriver driver)
//    {
//        Map<String, String> map = new HashMap<>();
//        map.put("content", message);
//        String s = (String) ((AppiumDriver) driver).executeScript("mobile:checkpoint:text", map);
//        return Boolean.parseBoolean(s);
//    }

    public void clickUsingActions(WebElement element, WebDriver driver)
    {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        action.moveToElement(element).click().perform();
    }

    public void doubleClickUsingActions(WebElement webElement, WebDriver driver)
    {
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();
        action.moveToElement(webElement).doubleClick().perform();
    }

    public void openNewTabAndSwitch (WebDriver driver)
    {
        try
        {
            Thread.sleep(3000);
            driver.switchTo().defaultContent();
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL  + "t");
            String parentWindow = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            for(String windowHandle : handles)
            {
                if(!windowHandle.equals(parentWindow))
                {
                    driver.switchTo().window(windowHandle);
                }
            }
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean retryWaitForElementPresent(WebElement webElement, WebDriver driver)
    {
        boolean result = false;
        int noOfAttemps = 0;

        while(noOfAttemps<4)
        {
            try
            {
                waitForVisible(driver, 40, webElement);
                result = true;
                break;
            }
            catch(StaleElementReferenceException e)
            {
                e.printStackTrace();
            }
            noOfAttemps++;
        }
        return result;
    }

    public void selectDropDownOption(WebElement dropdownElement, WebDriver driver, String optionToSelect)
    {
        waitForVisibleAndClick(driver, 60, dropdownElement);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionToSelect);
    }
//    public void switchToNewTabAndCloseToReturn(WebDriver webDriver) {
//        try {
//            Thread.sleep(3000);
//            String oldTab = webDriver.getWindowHandle();
//            ArrayList<String> newTab = new ArrayList< > (webDriver.getWindowHandles());
//            newTab.remove(oldTab);
//            webDriver.switchTo().window(newTab.get(0));
//            webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
//            webDriver.switchTo().window(oldTab);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
    public void clearInputTextField(WebElement webElement, WebDriver webdriver)
    {
        waitForVisibleAndClick(webdriver, 60, webElement);
        Actions builder = new Actions(webdriver);
        builder.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
        builder.sendKeys(Keys.DELETE).keyUp(Keys.CONTROL).build().perform();
    }

    public String getTextOfWebElement(WebElement webElement, WebDriver driver)
    {
        waitForVisible(driver, 60, webElement);
       return webElement.getText().trim();
    }

    public synchronized void takeScreenshot(WebDriver driver)
    {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotLocation = System.getProperty("user.dir") + "//screenshots";
            FileUtils.copyFileToDirectory(srcFile, new File(screenshotLocation));
//            MediaEntityModelProvider mediaEntityModelProvider = MediaEntityBuilder.createScreenCaptureFromPath(new File(screenshotLocation).getPath()).build();
//            ThreadLocal<ExtentTest> stepTestThreadLocal = new InheritableThreadLocal<>();
//            stepTestThreadLocal.get().info("", mediaEntityModelProvider);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
