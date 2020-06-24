package testUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import testClasses.BaseTest;

public class BrowserFactory extends BaseTest {
    private static final String chromeDriverPath = System.getenv("chromedriver");
    private static final String firefoxDriverPath = System.getenv("firefoxdriver");
    private static final String edgeDriverPath = System.getenv("edgedriver");


    public WebDriver getDriver (String browserType){
        switch (browserType) {
            case "Chrome" -> driver = initChromeDriver();
            case "Firefox" -> driver = initFirefoxDriver();
            case "Edge" -> driver = initEdgeDriver();
            default -> {
                log.info("browser : " + browserType + " is invalid, Launching Chrome as a browser of choice..");
                driver = initChromeDriver();
            }
        }
        return driver;
    }

    private WebDriver initEdgeDriver() {
        log.info("Launching a new instance of Edge Chromium...");
        System.setProperty("webdriver.edge.driver", edgeDriverPath);
        driver = new EdgeDriver();
        return driver;
    }

    private WebDriver initChromeDriver () {
        log.info("Launching a new instance of Google Chrome...");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver(getChromeDriverOptions());
        return driver;
    }

    private WebDriver initFirefoxDriver () {
        log.info("Launching a new instance of Firefox browser..");
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
        driver = new FirefoxDriver(getFirefoxDriverOptions());
        return driver;
    }

    private static ChromeOptions getChromeDriverOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        return options;
    }

    private static FirefoxOptions getFirefoxDriverOptions(){
        FirefoxOptions options = new FirefoxOptions();
        FirefoxBinary binary = new FirefoxBinary();
        binary.addCommandLineOptions("--headless");
        options.setBinary(binary);
        return options;
    }


}
