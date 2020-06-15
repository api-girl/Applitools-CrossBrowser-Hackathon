package testUtils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import testClasses.BaseTest;

public class BrowserFactory extends BaseTest {
    private static final String chromeDriverPath = "resources/chromedriver.exe";
    private static final String firefoxDriverPath = "resources/geckodriver.exe";
    private static final String edgeDriverPath = "resources/msedgedriver.exe";


    public WebDriver getDriver (String browserType){
        switch (browserType) {
            case "chrome" -> driver = initChromeDriver();
            case "firefox" -> driver = initFirefoxDriver();
            case "edge" -> driver = initEdgeDriver();
            default -> {
                System.out.println("browser : " + browserType + " is invalid, Launching Chrome as a browser of choice..");
                driver = initChromeDriver();
            }
        }
        return driver;
    }

    private WebDriver initEdgeDriver() {
        System.out.println("Launching a new instance of Edge Chromium...");
        System.setProperty("webdriver.edge.driver", edgeDriverPath);

        driver = new EdgeDriver();
        return driver;
    }

    private WebDriver initChromeDriver () {
        System.out.println("Launching a new instance of Google Chrome...");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver(getChromeDriverOptions());
        return driver;
    }

    private WebDriver initFirefoxDriver () {
        System.out.println("Launching a new instance of Firefox browser..");
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);

        driver = new FirefoxDriver(getFirefoxDriverOptions());
        return driver;
    }

    private static ChromeOptions getChromeDriverOptions() {
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return options;
    }

    private static FirefoxOptions getFirefoxDriverOptions(){
        FirefoxOptions options = new FirefoxOptions();
        FirefoxBinary binary = new FirefoxBinary();
        // binary.addCommandLineOptions("--headless");
        options.setBinary(binary);
        return options;
    }

}
