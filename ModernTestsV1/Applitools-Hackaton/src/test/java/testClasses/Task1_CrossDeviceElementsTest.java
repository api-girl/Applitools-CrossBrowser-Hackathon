package testClasses;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.fluent.Target;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Task1_CrossDeviceElementsTest extends BaseTest{
    /**
     * The “AppliFashion” app is responsive, so when testing on various viewports, the elements of your application change.
     * Some are hidden, some are made visible, some are repositioned to accommodate the space available.
     * For example, in our app, the Search field is displayed on laptops and tablets but is hidden on mobile devices.
     * Your job is to visually find such changing elements (not all elements)
     * and ensure they are properly hidden or displayed in different viewports and on different browsers.
     *
     * Notes for Modern Approach:
     *
     */

     @Test
     public static void ultraFastTest(WebDriver webDriver, Eyes eyes) {

		try {
			// Call Open on eyes to initialize a test session
			eyes.open(webDriver, "Demo App", "Ultrafast grid demo", new RectangleSize(800, 600));

			// check the login page with fluent api, see more info here
			// https://applitools.com/docs/topics/sdk/the-eyes-sdk-check-fluent-api.html
			eyes.check(Target.window().fully().withName("Login page"));

			webDriver.findElement(By.id("log-in")).click();

			// Check the app page
			eyes.check(Target.window().fully().withName("App page"));

			// Call Close on eyes to let the server know it should display the results
			eyes.closeAsync();

		} finally  {
			eyes.abortAsync();
		}

	}

	@Test
    public void testHomePage_verifyVisibilityOfElementsAcross3Viewports(){}


}
