package testClasses;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import eyesManager.EyesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    private static final String CHROME_DRIVER_PATH = System.getenv("chromedriver");
    protected WebDriver driver;
	protected static EyesManager eyesManager;


	@Parameters("url")
    @BeforeClass
    public void eyesSetUp(String url) {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(url);

        eyesManager = new EyesManager(driver, "AppliFashion V1");
        gridSetUp();
    }

    public void gridSetUp() {
        Configuration config = new Configuration();

        config.setBatch(new BatchInfo("UFG Hackaton"));

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