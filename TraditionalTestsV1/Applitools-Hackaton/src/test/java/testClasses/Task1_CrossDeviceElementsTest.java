package testClasses;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.testng.Assert.assertEquals;

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
//    ITestResult result;
//    ITestContext context;

    @Test
    public void testHomePageElements_areElementsDisplayedIn1200px(){
//        int viewport = Integer.parseInt(result.getTestContext().getCurrentXmlTest().getParameter("screenWidth"));
//        if(viewport == 1200){
        var width = hp.getScreenWidth();
        if(width == 1200){
            var actualState = hp.areElementsDisplayed(hp.create1200pxElementList());
            var expectedState = new ArrayList<Boolean>(Arrays.asList(new Boolean[actualState.size()]));
            Collections.fill(expectedState, Boolean.TRUE);

            assertEquals(actualState, expectedState, "Some of the elements is not displayed in 1200px.");

        }
    }

    public void testHomePageElements_areElementsDisplayedIn768px(){
        var actualState = hp.areElementsDisplayed(hp.create768ElementList());
    }

    public void testHomePageElements_areElementsDisplayedIn500px(){
        var actualState = hp.areElementsDisplayed(hp.create500ElementList());
    }

}
