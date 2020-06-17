package pageObjects;

import classUtils.LoggerClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(id = "DIV__mainheader__3")
    protected WebElement header;

    @FindBy(id = "DIV__mainnavinn__36")
    protected WebElement navigation;

    @FindBy(id = "FOOTER____417")
    protected WebElement footer;

    public Page(WebDriver driver) {
        Page.driver = driver;
        Page.wait = new WebDriverWait(driver, fixedWait);
        PageFactory.initElements(driver, this);
    }

    protected String getPageTitle() {
        String pt = driver.getTitle();
        log.info("Page title is " + "\"" + pt + "\"");
        return pt;
    }

    protected void clickOnElement(WebElement element) {
        try {
            waitForElementClickability(element);
            highlightAnElement(element);
            element.click();
            log.info("Click on element");
        } catch (StaleElementReferenceException e) {
            log.error("Element cannot be located on the page.");
            element.click();
            e.getMessage();
        } catch (TimeoutException e) {
            element.click();
        }
    }

    protected void clearField(WebElement element) {
        waitForElementClickability(element);
        highlightAnElement(element);
        element.clear();
        log.info("Clear the field.");
    }

    protected void type(WebElement element, String text) {
        waitForElementVisibility(element);
        highlightAnElement(element);
        element.sendKeys(text);
        log.info("Send text " + "\"" + text + "\" to field.");
    }

    protected void waitUntil(ExpectedCondition<WebElement> condition, Integer timeoutInSeconds) {
        timeoutInSeconds = timeoutInSeconds != null ? timeoutInSeconds : fixedWait;
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(condition);
    }

    protected void waitForElementVisibility(WebElement element, Integer... timeOutInSeconds) {
        try {
            var timeout = timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : fixedWait;
            waitUntil(ExpectedConditions.visibilityOf(element), timeout);
        } catch (TimeoutException e) {
            log.error("Timeout - the wait time expired and the element is still not visible.");
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

    protected void scrollUntilElement(WebElement element) {
        String script = "arguments[0].scrollIntoView();";
        log.info("Scrolling to element..." );
        waitForElementVisibility(element);
        ((JavascriptExecutor) driver).executeScript(script, element);
        highlightAnElement(element);
    }

    private void highlightAnElement(WebElement element){
        String script = "arguments[0].style.border='5px solid orange'";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    protected String getPrice(WebElement element){
        return trimPrice(element);
    }

    protected String trimPrice(WebElement element){
       return element.getText()
                       .replace("$", "");
    }


}
