package testClasses;

import org.testng.annotations.Test;
import pageObjects.ProductPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Task3_ProductDetailsTest extends BaseTest {
    ProductPage pp;

    /**
     * Click on the first Black shoe to navigate to its details page. Check if everything looks good and accurate.
     *
     * Notes for Traditional Approach:
     * Report the test result just like you did for Task 1, and append the test results below “Task 1″’s results
     * into the same file.
     */

    @Test
    public void testReviewSection_isItDisplayedCorrectly_expectTrue(){
        pp = hp.clickOnAProduct();
        soft.assertTrue(pp.isReviewSectionDisplayed());
        soft.assertFalse(pp.isThereMarginBetweenStarsAndSubTitle());

        soft.assertAll();
    }

    @Test
    public void testProductTitle_isTitleDisplayed_expectTrue(){
        pp = hp.clickOnAProduct();
        assertTrue(pp.isProductTitleDisplayed());
    }

    @Test
    public void testProductImage_isImageDisplayed_expectTrue(){
        pp = hp.clickOnAProduct();
        assertTrue(pp.isProductImageDisplayed());
    }



}
