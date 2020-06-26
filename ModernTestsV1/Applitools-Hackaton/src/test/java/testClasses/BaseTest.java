package testClasses;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    private static final String CHROME_DRIVER_PATH = System.getenv("chromedriver");
    private static final String EYES_API_KEY = System.getenv("EYES_API_KEY");
    protected WebDriver driver;
    private static VisualGridRunner runner;
	protected static EyesManager eyesManager;
    protected static Eyes eyes;

    @BeforeSuite
    public void nameBatch(){

    }

	@Parameters("url")
    @BeforeClass
    public void eyesSetUp(String url) {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(url);

        eyesManager = new EyesManager(driver, "AppliFashion V1");
        eyesManager.setBatchName("UFG Hackathon");

        gridSetUp();
    }

    public static void gridSetUp() {
        Configuration config = new Configuration();

        config.setIsVisualGrid(true);
        config.setViewportSize(new RectangleSize(800,600))
                .addBrowser(1200, 700, BrowserType.CHROME)
                .addBrowser(768, 700, BrowserType.CHROME)
                .addBrowser(1200, 700, BrowserType.FIREFOX)
                .addBrowser(768, 700, BrowserType.FIREFOX)
                .addBrowser(1200, 700, BrowserType.EDGE_CHROMIUM)
                .addBrowser(768, 700, BrowserType.EDGE_CHROMIUM)
                .addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);

        eyesManager.getEyes().setConfiguration(config);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        eyesManager.abort();
    }

    @AfterSuite
    public void summarizeTestResults(){
        TestResultsSummary allTestResults = eyesManager.getRunner().getAllTestResults(false);
        System.out.println(allTestResults);
    }

}