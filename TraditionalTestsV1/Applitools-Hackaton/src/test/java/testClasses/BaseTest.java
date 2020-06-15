package testClasses;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import classUtils.WindowManager;
import testUtils.BrowserFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class BaseTest {
    //private static EventFiringWebDriver driver;
    protected WebDriver driver;
    protected SoftAssert soft = new SoftAssert();
    protected static HomePage hp;

    public WebDriver getDriver() {
        return driver;
    }

    @Parameters({"url", "browser", "screenWidth", "screenHeight"})
    @BeforeMethod(alwaysRun = true)
    public HomePage initDriverAndGoToHomePage(String url, String browser, int screenWidth, int screenHeight) {
        try {
            BrowserFactory factory = new BrowserFactory();
            driver = factory.getDriver(browser);
        } catch (Exception e) {
            System.out.println("Error....." + Arrays.toString(e.getStackTrace()));
        }

        driver.get(url);
        driver.manage().window().setSize(getScreenDimension(screenWidth, screenHeight));
        hp = new HomePage(driver);
        return hp;
    }

    private Dimension getScreenDimension(int width, int height) {
        return new Dimension(width, height);
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//
//    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    public String getScreenshotPath(String testCaseName, String testClassName, WebDriver driver) {
        String screenshotFolderPath = "\\resources\\failedTestScreenshots\\" + LocalDate.now() + "\\" + testClassName + "\\";
        try {
            File file = new File(screenshotFolderPath);
            if (!file.exists())
                System.out.println("New folder for storing screenshots created " + file);
            file.mkdir();
        } catch (Exception e) {
            e.printStackTrace();
        }

        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") + screenshotFolderPath + testCaseName + ".png";
        File file = new File(screenshotPath);
        try {
            FileUtils.copyFile(screenshot, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }

    private ChromeOptions getChromeDriverOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--silent");
        return options;
    }

}