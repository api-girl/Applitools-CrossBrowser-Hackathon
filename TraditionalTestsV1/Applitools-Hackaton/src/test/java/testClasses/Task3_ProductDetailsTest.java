package testClasses;

import org.testng.annotations.Test;
import pageObjects.ProductPage;

import java.util.List;

import static org.testng.Assert.*;

public class Task3_ProductDetailsTest extends BaseTest {
    ProductPage pp;

    /**
     * Click on the first Black shoe to navigate to its details page. Check if everything looks good and accurate.
     * <p>
     * Notes for Traditional Approach:
     * Report the test result just like you did for Task 1, and append the test results below “Task 1″’s results
     * into the same file.
     */

    @Test
    public void testReviewSection_isItDisplayedCorrectly_expectTrue() {
        pp = hp.clickOnAProduct();
        soft.assertTrue(pp.isReviewSectionDisplayed());
        soft.assertFalse(pp.isThereAMarginBetweenStarsAndSubtitle(), "Unexpected margin noticed next to the number of stars.");

        soft.assertAll();
    }

    @Test
    public void testProductTitle_isTitleDisplayed_expectTrue() {
        pp = hp.clickOnAProduct();
        assertTrue(pp.isProductTitleDisplayed());
    }

    @Test
    public void testProductTitle_verifyIfTitlesOnHomeAndProductPageMatch_expectMatching() {
        var titleHomePage = hp.getProductTitleFromHomePage();
        pp = hp.clickOnAProduct();
        var titleProductPage = pp.getProductTitleFromProductPage();

        assertEquals(titleHomePage, titleProductPage, "The product titles do not match.");
    }

    @Test
    public void testProductImage_isImageDisplayed_expectTrue() {
        pp = hp.clickOnAProduct();
        assertTrue(pp.isProductImageDisplayed());
    }

    @Test
    public void testPrices_verifyBothPricesStyle_expectBlueAndGrayLineThrough() {
        List<String> expectedStyles = List.of("rgba(153, 153, 153, 1)", "line-through solid rgb(153, 153, 153)",
                "rgba(0, 77, 218, 1)", "none solid rgb(0, 77, 218)");

        var actualHpStyles = hp.getPricesStyleFromHomePage();
        pp = hp.clickOnAProduct();
        var actualPpStyles = pp.getPricesStyleFromProductPage();

        soft.assertEquals(actualHpStyles, expectedStyles);
        soft.assertEquals(actualPpStyles, expectedStyles);
        soft.assertAll();
    }

    @Test
    public void testPrices_verifyPricesStylesOnHomeAndProductPage_expectMatching() {
        var hpPricesStyles = hp.getPricesStyleFromHomePage();
        pp = hp.clickOnAProduct();
        var ppPricesStyles = pp.getPricesStyleFromProductPage();
        assertEquals(hpPricesStyles, ppPricesStyles);
    }

    @Test
    public void testPrices_verifyIfPricesMatchOnHomeAndProductPages_expectMatching() {
        var hpActualPrices = hp.getPricesFromHomePage();
        pp = hp.clickOnAProduct();
        var ppActualPrices = pp.getPricesFromProductPage();

        assertEquals(hpActualPrices, ppActualPrices, "Prices do not match.");
    }

    @Test(enabled = false)
    public void testSizeDropdown_verifyOptionsContent_expectSToXl() {
        var expectedOptions = List.of("Small (S)", "M", "L", "XL");
        pp = hp.clickOnAProduct();
        var actualOptions = pp.getSizeDropdownOptions();

        assertEquals(actualOptions, expectedOptions, "Some of the dropdown options does not match expected.");
    }

    @Test
    public void testAddToCartButton_isThereSpaceBetweenButtonAndQuantityDropdown_expectTrue() {
        pp = hp.clickOnAProduct();
        var margin = pp.isThereASpaceBetweenButtonAndQuantityDropdown();

        assertTrue(margin);
    }


}
