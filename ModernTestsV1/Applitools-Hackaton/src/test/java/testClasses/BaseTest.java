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
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    private static final String CHROME_DRIVER_PATH = System.getenv("chromedriver");
	private static final String EYES_API_KEY = System.getenv("EYES_API_KEY");
	private static VisualGridRunner runner;
	protected static Eyes eyes;

	@Parameters("url")
    @BeforeMethod
    public WebDriver initDriver(String url) {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(url);

        runner = new VisualGridRunner(10);

        eyes = new Eyes(runner);
        setUp();
        return driver;
    }

    public static void setUp() {
        Configuration config = new Configuration();
        config.setApiKey(EYES_API_KEY);

        config.setBatch(new BatchInfo("UFG Hackathon"));

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