package testClasses;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    private static final String chromeDriverPath = System.getenv("chromedriver");
	private static final String EYES_API_KEY = System.getenv("EYES_API_KEY");
	private static VisualGridRunner runner;
	protected static Eyes eyes;

    @BeforeMethod
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();

        runner = new VisualGridRunner(1);

        eyes = new Eyes(runner);
        setUp(eyes);
    }

    public static void setUp(Eyes eyes) {
        Configuration config = new Configuration();
        config.setApiKey(EYES_API_KEY);

        config.setBatch(new BatchInfo("Ultrafast Batch"));

        config.addBrowser(1200, 700, BrowserType.CHROME);
        config.addBrowser(768, 700, BrowserType.CHROME);
        config.addBrowser(1200, 700, BrowserType.FIREFOX);
        config.addBrowser(768, 700, BrowserType.FIREFOX);
        config.addBrowser(1200, 700, BrowserType.EDGE_CHROMIUM);
        config.addBrowser(768, 700, BrowserType.EDGE_CHROMIUM);
        config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);

        eyes.setConfiguration(config);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        System.out.println(allTestResults);
    }

}