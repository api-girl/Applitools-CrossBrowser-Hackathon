package eyesManager;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EyesManager {
    private static final String EYES_API_KEY = System.getenv("EYES_API_KEY");
    private Eyes eyes;
    private String appName;
    private WebDriver driver;
    private VisualGridRunner runner;

    public EyesManager(WebDriver driver, String appName){
        this.driver = driver;
        this.appName = appName;

        runner = new VisualGridRunner(10);
        eyes = new Eyes(runner);
        eyes.setApiKey(EYES_API_KEY);
    }

    public void validateWindow(String testName, String testStep){
            eyes.open(driver, appName, testName);
            eyes.check(Target.window().fully().withName(testStep));
            eyes.closeAsync();
    }

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

    public VisualGridRunner getRunner(){
        return runner;
    }

}
