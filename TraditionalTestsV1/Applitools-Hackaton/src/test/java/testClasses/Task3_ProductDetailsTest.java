package testClasses;

import org.testng.annotations.Test;
import pageObjects.ProductPage;

import java.util.List;

import static org.testng.Assert.*;

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
    public void testReviewSection_isItDisplayedCorrectly_expectTrue() {
        pp = hp.clickOnAProduct();

        assertTrue(pp.isReviewSectionDisplayed(), "The review section is not displayed.");
        assertTrue(pp.isThereExpectedSpaceBetweenStarsAndSubtitle(), "Unexpected margin noticed next to the number of stars.");
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
        List<String> expectedStyles = List.of("#999999", "#004dda");

        var actualHpColours = hp.getPricesColourFromHomePage();
        var actualHpTextDecorationOldPrice = hp.getTextDecorationFromPage();
        pp = hp.clickOnAProduct();
        var actualPpColours = pp.getPricesColourFromProductPage();
        var actualPpTextDecorationOldPrice = pp.getTextDecorationFromPage();

        assertEquals(actualHpColours, expectedStyles, "Unexpected colour detected.");
        assertEquals(actualPpColours, expectedStyles,"Unexpected colour detected.");
        assertTrue(actualHpTextDecorationOldPrice.contains("line-through"), "The line's expected style on HP is line-though and it doesn't match the actual.");
        assertTrue(actualPpTextDecorationOldPrice.contains("line-through"), "The line's expected style on PP is line-though and it doesn't match the actual.");
    }

    @Test
    public void testPrices_verifyPricesStylesOnHomeAndProductPage_expectMatching() {
        var hpPricesStyles = hp.getPricesStyleFromHomePage();
        pp = hp.clickOnAProduct();
        var ppPricesStyles = pp.getPricesStyleFromProductPage();
        assertEquals(hpPricesStyles, ppPricesStyles, "There is no match between prices style on product and home pages.");
    }

    @Test
    public void testPrices_verifyIfPricesMatchOnHomeAndProductPages_expectMatching() {
        var hpActualPrices = hp.getPricesValuesFromHomePage();
        pp = hp.clickOnAProduct();
        var ppActualPrices = pp.getPricesFromProductPage();

        assertEquals(hpActualPrices, ppActualPrices, "Prices do not match.");
    }

    @Test
    public void testSizeDropdown_verifyFirstOption_expectSmallS() {
        var expectedOption = "Small (S)";
        pp = hp.clickOnAProduct();
        var actualOptions = pp.getDefaultSizeOption();

        assertEquals(actualOptions, expectedOption, "The default size option does not match expected.");
    }

    @Test
    public void testAddToCartButton_isThereSpaceBetweenButtonAndQuantityDropdown_expectTrue() {
        pp = hp.clickOnAProduct();

        assertTrue(pp.isThereExpectedSpaceBetweenButtonAndQuantityDropdown(), "Unexpected margin settings detected on \"Add to Cart\" button.");
    }

    @Test
    public void testNavigation_isThereExpectedSpaceBetweenNavIcons_expectTrue(){
        pp = hp.clickOnAProduct();

        assertTrue(pp.isThereExpectedSpaceBetweenNavIcons(), "The actual margin between icons is not 20px.");
    }

}
