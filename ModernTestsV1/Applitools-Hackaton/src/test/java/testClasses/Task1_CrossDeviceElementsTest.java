package testClasses;

import com.applitools.eyes.fluent.Target;
import org.testng.annotations.Test;


public class Task1_CrossDeviceElementsTest extends BaseTest {

    @Test
    public void testHomePage_verifyVisibilityOfElementsAcross3Viewports(){
        eyesManager.validateWindow("Task 1", "Cross-Device Elements Test");
    }

    @Test(enabled = false)
    public void ultraFastTest() {
        try {
            // Call Open on eyes to initialize a test session
//			eyes.open(driver, "Demo App", "Ultrafast grid demo", new RectangleSize(800, 600));
            // check the login page with fluent api, see more info here
            // https://applitools.com/docs/topics/sdk/the-eyes-sdk-check-fluent-api.html
            eyes.check(Target.window().fully().withName("Login page"));
//			driver.findElement(By.id("log-in")).click();
            // Check the app page
            eyes.check(Target.window().fully().withName("App page"));
            // Call Close on eyes to let the server know it should display the results
            eyes.closeAsync();
        } finally {
            eyes.abortAsync();
        }

    }


}
