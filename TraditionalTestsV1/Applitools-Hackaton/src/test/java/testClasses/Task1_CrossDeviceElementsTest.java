package testClasses;

import org.testng.annotations.Test;

public class Task1_CrossDeviceElementsTest {
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
    public void testDetectHiddenElementsInResponsive(){

    }

    @Test
    public void testProductPage_Navigation_areNavIconsProperlyDisplayed(){
        //bug: tablet res, three nav icons loose space between themselves
        //li elements 2nd and 3rd, css attribute margin-left: -10px !important is a cause for bug
    }
}
