package testClasses;

import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.HomePage;
import testUtils.BrowserFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

public class BaseTest {
    protected WebDriver driver;
    protected static HomePage hp;
    protected Logger log = LoggerFactory.getLogger("");

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

    public boolean hReporter(int taskNo, ITestContext context, boolean comparisonResult){
        try (var writer = new BufferedWriter(new FileWriter("Traditional-V2-TestResults.txt", true))) {
            writer.write(
                    "Task: " +  taskNo +
                    ", Test Name: " + context.getAttribute("description") +
                    ", DOM Id: " + context.getAttribute("domId") +
                     ", Browser: " + context.getCurrentXmlTest().getParameter("browser") +
                     ", Viewport: " + getViewport(context) +
                     ", Device: " + context.getCurrentXmlTest().getParameter("device") +
                     ", Status: " + (comparisonResult ? "Pass" : "Fail")
                    );
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Error writing to report file");
            e.printStackTrace();
        }
        return comparisonResult;
    }

    public String getViewport(ITestContext context){
        var w = Integer.parseInt(context.getCurrentXmlTest().getParameter("screenWidth"));
        var h = Integer.parseInt(context.getCurrentXmlTest().getParameter("screenHeight"));
        if(w>1200){
            w=1200;
        }else if(w>768){
            w=768;
        }else if(w>500){
            w=500;
        }

        if(h>700){
            h=700;
        }
        return String.format("%s x %s", w, h);
    }
}