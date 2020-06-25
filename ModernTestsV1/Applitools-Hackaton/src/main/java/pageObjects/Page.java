package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected static WebDriver driver;

    public Page(WebDriver driver) {
        Page.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickOnElement(WebElement element) {
        try {
            waitForElementClickability(element);
            highlightAnElement(element);
            element.click();
        } catch (StaleElementReferenceException e) {
            element.click();
            e.getMessage();
        } catch (TimeoutException e) {
            element.click();
        }
    }

    protected void waitUntil(ExpectedCondition<WebElement> condition, Integer timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(condition);
    }

    protected void waitForElementClickability(WebElement element, Integer... timeoutInSeconds) {
        try {
            waitUntil(ExpectedConditions.elementToBeClickable(element), timeoutInSeconds.length > 0 ? timeoutInSeconds[0] : 10);
        } catch (TimeoutException e) {
            System.out.println("Timeout - the wait time expired and the element is still not clickable.");
            e.getMessage();
        }
    }

    private void highlightAnElement(WebElement element){
        String script = "arguments[0].style.border='5px solid orange'";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public String getDomId(WebElement element){
        return element.getAttribute("id");
    }
}
