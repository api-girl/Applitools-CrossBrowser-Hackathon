package testClasses;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Task2_ShoppingExperienceTest extends BaseTest {
    /**
     * Filter for “Black” shoes. Ensure that there are 2 black shoes and everything works and looks good.
     *
     * Notes for Traditional Approach:
     * Report the test results just like you did for “Task 1”
     * and append the test results below the results from the previous test run results (in the same file).
     */

    @Test
    public void testFilterBlackShoesExpectTwoResults(){
        var actualResults = hp.countFilteredResults();

        assertEquals(actualResults, 2, "The number of filtered results does not match expected.");
    }
}
