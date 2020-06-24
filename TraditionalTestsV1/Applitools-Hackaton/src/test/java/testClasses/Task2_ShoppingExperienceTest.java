package testClasses;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Task2_ShoppingExperienceTest extends BaseTest {
    /**
     * Filter for “Black” shoes. Ensure that there are 2 black shoes and everything works and looks good.
     *
     * Notes for Traditional Approach:
     * Report the test results just like you did for “Task 1”
     * and append the test results below the results from the previous test run results (in the same file).
     */

    @Test
    public void testFilterBlackShoesExpectTwoResults(ITestContext context){
        var elements = hp.getFilteredResultsDomId();
        context.setAttribute("domId", elements);
        context.setAttribute("description", "Filter black shoes and verify 2 displayed results");

        assertTrue(hReporter(2, context, hp.countFilteredResults(elements.size())),
                "The expected number of filtered results: 2 results.\nActual: " + elements.size()+"\n");
    }
}
