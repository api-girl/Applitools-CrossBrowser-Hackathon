package testClasses;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.fluent.Target;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EyesManager {
    private static final String EYES_API_KEY = System.getenv("EYES_API_KEY");
    private Eyes eyes;
    private String appName;
    private WebDriver driver;
    private VisualGridRunner runner;

    public EyesManager(WebDriver driver, String appName, VisualGridRunner runner){
        this.driver = driver;
        this.appName = appName;
        this.runner = runner;

        eyes = new Eyes();
        eyes.setApiKey(EYES_API_KEY);
    }

    public void setBatchName(String batchName){
        eyes.setBatch(new BatchInfo(batchName));
    }

    /**
     *  issue 2: method check() throws
     *  java.lang.IllegalArgumentException: checkSettings is must be a interface com.applitools.eyes.selenium.fluent.ISeleniumCheckTarget
     *  when Target type parameter is passed to it
     */
    public void validateWindow(String testName, String testStep){
            eyes.open(driver, appName, testName);
            eyes.check(Target.window().fully().withName(testStep));
            eyes.closeAsync();
    }

    //issue 1: method region() not accepting WebElement type as a parameter
    public void validateRegion(String testName, WebElement element, String testStep){
        eyes.open(driver, appName, testName);
        eyes.check(Target.region(element).withName(testStep));
        eyes.closeAsync();
    }

    public void abort(){
        eyes.abortIfNotClosed();
    }

    public Eyes getEyes(){
        return eyes;
    }

}
