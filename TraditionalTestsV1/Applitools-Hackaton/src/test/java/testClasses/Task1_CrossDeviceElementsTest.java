package testClasses;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.testng.Assert.*;

public class Task1_CrossDeviceElementsTest extends BaseTest{
    /**
     * The “AppliFashion” app is responsive, so when testing on various viewports, the elements of your application change.
     * Some are hidden, some are made visible, some are repositioned to accommodate the space available.
     * For example, in our app, the Search field is displayed on laptops and tablets but is hidden on mobile devices.
     * Your job is to visually find such changing elements (not all elements)
     * and ensure they are properly hidden or displayed in different viewports and on different browsers.
     *
     * Notes for Traditional Approach:
     * In cross-browser testing, it’s extremely hard to analyze test results because you are running the same tests
     * against numerous combinations of browsers and viewports.
     * To analyze them you need to print a formal report.
     * So once you test the application, print a report as shown below for each element or test that you test as part of the task.
     * Every line should show the result for one element or test.
     *
     * Task: <Task Number>, Test Name: <Test Name>, DOM Id:: <id>, Browser: <Browser>, Viewport: <Width x Height>,
     * Device<Device type>, Status: <Pass | Fail>
     *
     * Example:
     * Task: 1, Test Name: Search field is displayed, DOM Id: DIV__customsear__41, Browser: Chrome, Viewport: 1200 x 700,
     * Device: Laptop, Status: Pass
     *
     * Lastly, copy-paste the output of all your tests into a single file called
     * “Traditional-V1-TestResults.txt” for V1 of the app.
     * And after you run the tests for V2, make relevant maintenance, and copy the test results into “Traditional-V2-TestResults.txt”.
     */


    @Test
    public void testHomePageElements_isNavMenuDisplayed(ITestContext context){
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getNavMenuDomId());
        context.setAttribute("description", "Is Navigation Menu displayed in all three viewports");

        if(width >= 1200){
            var actualState = hp.isNavMenuDisplayed();
            assertTrue(hReporter(1, context, actualState), "Navigation Menu is not displayed in 1200px.");
        }
        else if(width>=768){
            var actualState = hp.isNavMenuDisplayed();
            assertFalse(hReporter(1, context,actualState), "Navigation Menu is not displayed in 768px.");
        }
        else if(width>=500){
            var actualState = hp.isNavMenuDisplayed();
            assertFalse(hReporter(1, context, actualState), "Some of the elements is not displayed in 500px.");
        }
        else{
            log.error("The viewport was not expected for this test case.");
        }
    }

    @Test(enabled = false)
    public void testHomePageElements_areElementsDisplayedInThreeDifferentViewports_expectFalse(){
        int width = hp.getScreenWidth();
        if(width >= 1200){
            log.info("IN - I am inside the if block for 1200px.");
            var actualState = hp.areElementsDisplayed(hp.notDisplayedIn1200ElementList());
            var expectedState = new ArrayList<Boolean>(Arrays.asList(new Boolean[actualState.size()]));
            Collections.fill(expectedState, Boolean.FALSE);

            assertEquals(actualState, expectedState, "Some of the elements are displayed in 1200px.");
            log.info("OUT - Getting outside of if block for 1200px.");
        }
        else if(width>=768){
            log.info("IN - Now I am inside the if block for 768px.");
            var actualState = hp.areElementsDisplayed(hp.notDisplayedIn768ElementList());
            var expectedState = new ArrayList<Boolean>(Arrays.asList(new Boolean[actualState.size()]));
            Collections.fill(expectedState, Boolean.FALSE);

            assertEquals(actualState, expectedState, "Some of the elements are displayed in 768px.");
            log.info("OUT - Getting outside of if block for 768px.");
        }
        else if(width>=500){
            log.info("IN - Now I am inside the if block for 500px.");
            var actualState = hp.areElementsDisplayed(hp.notDisplayedIn500ElementList());
            var expectedState = new ArrayList<Boolean>(Arrays.asList(new Boolean[actualState.size()]));
            Collections.fill(expectedState, Boolean.FALSE);

            assertEquals(actualState, expectedState, "Some of the elements are displayed in 500px.");
            log.info("OUT - Getting outside of if block for 500px.");
        }
        else{
            System.out.println("The viewport was not expected for this test case.");
        }
    }


}
