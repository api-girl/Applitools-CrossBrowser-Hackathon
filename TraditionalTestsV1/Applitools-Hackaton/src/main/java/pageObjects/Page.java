package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    int fixedWait = 15;

    public Page(WebDriver driver) {
        Page.driver = driver;
        Page.wait = new WebDriverWait(driver, fixedWait);
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
        timeoutInSeconds = timeoutInSeconds != null ? timeoutInSeconds : fixedWait;
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(condition);
    }

    protected void waitForElementVisibility(WebElement element, Integer... timeOutInSeconds) {
        try {
            var timeout = timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : fixedWait;
            waitUntil(ExpectedConditions.visibilityOf(element), timeout);
        } catch (TimeoutException e) {
           System.out.println("Timeout - the wait time expired and the element is still not visible.");
        }
    }

    protected void waitForElementClickability(WebElement element, Integer... timeoutInSeconds) {
        try {
            waitUntil(ExpectedConditions.elementToBeClickable(element), timeoutInSeconds.length > 0 ? timeoutInSeconds[0] : fixedWait);
        } catch (TimeoutException e) {
            System.out.println("Timeout - the wait time expired and the element is still not clickable.");
            e.getMessage();
        }
    }

    protected void scrollUntilElement(WebElement element) {
        String script = "arguments[0].scrollIntoView();";
        System.out.println("Scrolling to element..." );
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

    protected String convertColourToHex(String rgbColour){
        return Color.fromString(rgbColour).asHex();
    }

    public int getScreenWidth(){
        return driver.manage().window().getSize().getWidth();
    }

    public String getDomId(WebElement element){
        return element.getAttribute("id");
    }
}
