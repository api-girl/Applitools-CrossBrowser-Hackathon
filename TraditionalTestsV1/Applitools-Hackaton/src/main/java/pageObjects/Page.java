package pageObjects;

import classUtils.LoggerClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

public class Page {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static LoggerClass log = new LoggerClass();
    int fixedWait = 15;

    public Page(WebDriver driver) {
        Page.driver = driver;
        Page.wait = new WebDriverWait(driver, fixedWait);
    }

    protected WebElement getWebElement(By locator, String elementName) {
        WebElement element = null;
        try {
            waitForThePresenceOfElementInDom(locator);
            element = driver.findElement(locator);
            if (driver instanceof JavascriptExecutor) {
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].style.border='5px solid orange'", element);
            }
        } catch (StaleElementReferenceException e) {
            log.error("Element " + elementName + "cannot be located on the page.");
            e.printStackTrace();
        }
        return element;
    }

    private String[] parseUrlToStrings() {
        return driver.getCurrentUrl().split("/");
    }

    public String getPageFromUrlEndpoint() {
        int lastIndex = parseUrlToStrings().length - 1;
        String page = parseUrlToStrings()[lastIndex];
        if (page.startsWith("?")) {
            page = parseUrlToStrings()[lastIndex - 1];
        }
        return page;
    }

    public String getQueryStringFromEndpoint() {
        for (String urlString : parseUrlToStrings()) {
            if (urlString.contains("?")) {
                return urlString;
            }
        }
        return null;
    }

    protected String getWebElementText(By locator, String elementName) {
        waitForThePresenceOfElementInDom(locator);
        String e = getWebElement(locator, elementName).getText();
        log.info("Get text for WebElement " + elementName);
        log.info("Element's text: " + "\"" + e + "\"");
        return e;
    }

    protected String getPageTitle() {
        String pt = driver.getTitle();
        log.info("Page title is " + "\"" + pt + "\"");
        return pt;
    }

    protected void clickOnElement(By locator, String elementName, Integer... timeoutInSeconds) {
        waitForElementClickability(locator, timeoutInSeconds);
        getWebElement(locator, elementName).click();
        log.info("Click on " + "\"" + elementName + "\"");
    }

    protected void clickOnElement(WebElement element, String elementName) {
        try {
            waitForElementClickability(element);
            element.click();
            log.info("Click on " + "\"" + elementName + "\"");
        } catch (StaleElementReferenceException e) {
            log.error("Element " + elementName + "cannot be located on the page.");
            element.click();
            e.getMessage();
        } catch (TimeoutException e) {
            element.click();
        }
    }

    protected void clearField(By locator, String elementName) {
        waitForElementClickability(locator);
        getWebElement(locator, elementName).clear();
        log.info("Clear the field " + elementName);
    }

    protected void type(By locator, String text, String elementName) {
        waitForElementVisibility(driver.findElement(locator));
        getWebElement(locator, elementName).sendKeys(text);
        log.info("Send text " + "\"" + text + "\"" + " to " + elementName);
    }

    protected boolean isElementDisplayed(By locator, String elementName, Integer... timeoutInSeconds) {
        boolean displayed = getWebElement(locator, elementName).isDisplayed();
        waitForElementVisibility(driver.findElement(locator), timeoutInSeconds);
        String text = displayed ? " is displayed." : " is not displayed.";
        log.info(elementName + text);
        return displayed;
    }

    protected Select createSelectElement(By locator) {
        return new Select(driver.findElement(locator));
    }

    protected void selectByText(By locator, String text, String elementName) {
        waitForElementClickability(locator);
        createSelectElement(locator).selectByVisibleText(text);
        log.info("Select " + text + " from " + elementName + " dropdown");
    }


    protected void waitUntil(ExpectedCondition<WebElement> condition, Integer timeoutInSeconds) {
        timeoutInSeconds = timeoutInSeconds != null ? timeoutInSeconds : fixedWait;
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(condition);
    }

    protected void waitForAllTabsToLoad() {
        int complete = driver.getWindowHandles().size();
        wait.until(ExpectedConditions.numberOfWindowsToBe(complete));
    }

    protected void waitForElementVisibility(WebElement element, Integer... timeOutInSeconds) {
        try {
            var timeout = timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : fixedWait;
            waitUntil(ExpectedConditions.visibilityOf(element), timeout);
        } catch (TimeoutException e) {
            log.error("Timeout - the wait time expired and the element is still not visible.");
        }
    }

    protected void waitForElementClickability(By locator, Integer... timeoutInSeconds) {
        try {
            waitUntil(ExpectedConditions.elementToBeClickable(locator), timeoutInSeconds.length > 0 ? timeoutInSeconds[0] : fixedWait);
        } catch (TimeoutException e) {
            log.error("Timeout - the wait time expired and the element is still not clickable.");
            e.getMessage();
        } catch (ElementClickInterceptedException e) {
            log.error("Element cannot be clicked at the moment." + Arrays.toString(e.getStackTrace()));
        }
    }

    protected void waitForElementClickability(WebElement element, Integer... timeoutInSeconds) {
        try {
            waitUntil(ExpectedConditions.elementToBeClickable(element), timeoutInSeconds.length > 0 ? timeoutInSeconds[0] : fixedWait);
        } catch (TimeoutException e) {
            log.error("Timeout - the wait time expired and the element is still not clickable.");
            e.getMessage();
        }

    }

    protected void waitForThePresenceOfElementInDom(By locator, Integer... timeoutInSeconds) {
        try {
            waitUntil(ExpectedConditions.presenceOfElementLocated(locator), timeoutInSeconds.length > 0 ? timeoutInSeconds[0] : fixedWait);
        } catch (TimeoutException e) {
            log.error("Timeout - the wait time expired and the element is still not present in DOM.");
            e.getMessage();
        }
    }


    protected void scrollUntilElement(WebElement element) {
        String script = "arguments[0].scrollIntoView();";
        log.info("Scrolling to element..." );
        waitForElementVisibility(element);
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    protected String getTabHandle() {
        return driver.getWindowHandle();
    }

}
