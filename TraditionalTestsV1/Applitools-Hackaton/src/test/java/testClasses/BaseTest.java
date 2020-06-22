package testClasses;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import testUtils.BrowserFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert soft = new SoftAssert();
    protected static HomePage hp;
    protected Logger log = LoggerFactory.getLogger("");

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
        driver.manage().window().setSize(new Dimension(screenWidth, screenHeight));
        hp = new HomePage(driver);
        return hp;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
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

    public void hReporter(int taskNo, String testName, String domId){
        try (var writer = new BufferedWriter(new FileWriter("Traditional-V1-TestResults.txt", true))) {
            writer.write("Task: " + taskNo +
                    ", Test Name: " + testName +
                    ", DOM Id: " + domId +
                    ", Browser: " + "chrome"
                    + ", Viewport: " + "500 x 700" +
                    ", Device: " + "mobile"
                    //+ ", " + "Status: " + (getTestStatus(result) ? "Pass" : "Fail")
                    );
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Error writing to report file");
            e.printStackTrace();
        }
    }


}