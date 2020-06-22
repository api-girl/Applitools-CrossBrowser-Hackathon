package testUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testClasses.BaseTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestListener extends BaseTest implements ITestListener {
    private static ExtentReports extent = ReportManager.createInstance();
    public static ThreadLocal<ExtentTest> extentParallel = new ThreadLocal<ExtentTest>();
    public static boolean hReporter;


    private static String getTestMethodNameForScreenShot(ITestResult iTestResult) {
        String invocationCount = String.valueOf(iTestResult.getMethod().getCurrentInvocationCount());
        return iTestResult.getMethod().getConstructorOrMethod().getName() + "_" + invocationCount;
    }

    private static String getTestClassName(ITestResult iTestResult) {
        return iTestResult.getTestClass().getRealClass().getSimpleName();
    }

    private String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

    public static String getTestName(ITestResult result) {
        return result.getTestContext().getCurrentXmlTest().getName();
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("*** EXECUTION STARTED:" + context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(("*** RUNNING TEST METHOD: " + result.getMethod().getMethodName()));
        ExtentTest test = extent.createTest(getTestClassName(result)
                + " | "
                + getTestMethodName(result));
        extentParallel.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String logText = "PASSED";
        System.out.println(logText + " - " + result.getMethod().getMethodName());
        Markup stylizedStatus = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        
        extentParallel.get().info(getTestName(result));
        extentParallel.get().log(Status.PASS, stylizedStatus);
    }


    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        String screenshotPath = getScreenshotPath(getTestMethodNameForScreenShot(result),
                getTestClassName(result), driver);
        extentParallel.get().info(getTestName(result));
        try {
            extentParallel.get().fail("Screenshot taken: ",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            extentParallel.get().fail("Cannot attach screenshot.");
        }
        extentParallel.get().error(result.getThrowable());
        System.out.println("FAILED - " + result.getMethod().getMethodName());
        Markup stylizedStatus = MarkupHelper.createLabel("FAILED", ExtentColor.RED);
        extentParallel.get().log(Status.FAIL, stylizedStatus);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String logText = "SKIPPED";
        System.out.println(logText + " - " + result.getMethod().getMethodName());
        Markup stylizedStatus = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
        extentParallel.get().info(getTestName(result));
        extentParallel.get().log(Status.SKIP, stylizedStatus);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


}
