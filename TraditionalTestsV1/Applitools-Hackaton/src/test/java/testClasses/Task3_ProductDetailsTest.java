package testClasses;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import pageObjects.ProductPage;

import java.util.ArrayList;
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
    public void testReviewSection_isItDisplayedCorrectly_expectTrue(ITestContext context) {
        pp = hp.clickOnAProduct();
        context.setAttribute("domId", pp.getReviewSectionDomId());
        context.setAttribute("description", "Review Section is displayed correctly");
        assertTrue(hReporter(3, context, pp.isReviewSectionDisplayed()),
                "The review section is not displayed.");

        context.setAttribute("domId", pp.getReviewSubtitleDomId());
        context.setAttribute("description", "The number of reviews does not overlap with stars.");
        assertTrue(hReporter(3, context, pp.isThereExpectedSpaceBetweenStarsAndSubtitle()),
                "The number of reviews is located on the right side of the stars.");
    }

    @Test
    public void testProductTitle_isTitleDisplayed_expectTrue(ITestContext context) {
        pp = hp.clickOnAProduct();
        context.setAttribute("domId", pp.getProductTitleDomId());
        context.setAttribute("description", "Product Title is displayed correctly");
        assertTrue(hReporter(3, context, pp.isProductTitleDisplayed()),
                "No content visible at the product title's position.");
    }

    @Test
    public void testProductTitle_verifyIfTitlesOnHomeAndProductPageMatch_expectMatching(ITestContext context) {
        var titleHomePage = hp.getProductTitleFromHomePage();
        List<String> titleDomIds = new ArrayList<String>();
        titleDomIds.add(hp.getProductTitleHpDomId());

        pp = hp.clickOnAProduct();
        context.setAttribute("description", "Product Titles displayed on Home and Product page must match.");
        titleDomIds.add(pp.getProductTitleDomId());
        context.setAttribute("domId", titleDomIds);

        assertTrue(hReporter(3, context, pp.doProductTitlesMatch(titleHomePage)), "The product titles do not match.");
    }

    @Test
    public void testProductImage_isImageDisplayed_expectTrue(ITestContext context) {
        pp = hp.clickOnAProduct();
        context.setAttribute("domId", pp.getProductImageDomId());
        context.setAttribute("description", "Product Image is displayed");
        assertTrue(hReporter(3, context, pp.isProductImageDisplayed()), "Product image is displayed");
    }

    @Test
    public void testPrices_verifyBothPricesStyle_expectBlueAndGrayColour(ITestContext context) {
        List<String> expectedStyles = List.of("#999999", "#004dda");
        var actualStyleHp = hp.doBothPricesColoursMatchExpectedOnHomePage(expectedStyles);
        var pricesDomIdsHp = List.of(hp.getOldPriceDomId(), hp.getNewPriceDomId());
        pp = hp.clickOnAProduct();

        var pricesDomIdsPp = List.of(pp.getOldPriceDomId(), pp.getNewPriceDomId());

        context.setAttribute("description", "On Home Page, old price is gray and new price is blue");
        context.setAttribute("domId", pricesDomIdsHp);
        assertTrue(hReporter(3, context, actualStyleHp),
                "Unexpected colour detected.");
        context.setAttribute("description", "On Product Page, old price is gray and new price is blue");
        context.setAttribute("domId", pricesDomIdsPp);
        assertTrue(hReporter(3, context, pp.doBothPricesColoursMatchExpectedOnProductPage(expectedStyles)),
                "On Product Page, old price is gray and new price is blue");
    }

    @Test
    public void testPrices_verifyOldPriceStyle_expectLineThroughOnAnyPage(ITestContext context){
        var actualHpTextDecorationOldPrice = hp.getTextDecorationFromPage();
        var priceDomIdsHp = hp.getOldPriceDomId();
        pp = hp.clickOnAProduct();
        var actualPpTextDecorationOldPrice = pp.getTextDecorationFromPage();
        var priceDomIdsPp = pp.getOldPriceDomId();

        context.setAttribute("description", "On Home Page, old price is always crossed");
        context.setAttribute("domId", priceDomIdsHp);
        assertTrue(hReporter(3, context, actualHpTextDecorationOldPrice.contains("line-through")),
                "The line's expected style on HP is line-though and it doesn't match the actual.");

        context.setAttribute("description", "On Product Page, old price is always crossed");
        context.setAttribute("domId", priceDomIdsPp);
        assertTrue(hReporter(3, context, actualPpTextDecorationOldPrice.contains("line-through")),
                "The old price is always crossed if there is a discount.");
    }

    @Test
    public void testPrices_verifyPricesStylesOnHomeAndProductPage_expectMatching(ITestContext context) {
        var hpPricesStyles = hp.getPricesStyleFromHomePage();
        var pricesDomIds = new ArrayList<String>(List.of(hp.getOldPriceDomId(), hp.getNewPriceDomId()));
        pp = hp.clickOnAProduct();
        pricesDomIds.addAll(List.of(pp.getOldPriceDomId(), pp.getNewPriceDomId()));

        context.setAttribute("description", "Prices styles are the same on Home and Product page");
        context.setAttribute("domId", pricesDomIds);
        assertTrue(hReporter(3, context, pp.doPricesStyleMatchOnBothPages(hpPricesStyles)),
                "Prices colours match on Product and Home Page.");
    }

    @Test
    public void testPrices_verifyIfPricesMatchOnHomeAndProductPages_expectMatching(ITestContext context) {
        var hpActualPrices = hp.getPricesValuesFromHomePage();
        var pricesDomIds = new ArrayList<>((List.of(hp.getOldPriceDomId(), hp.getNewPriceDomId())));
        pp = hp.clickOnAProduct();
        pricesDomIds.addAll(List.of(pp.getOldPriceDomId(), pp.getNewPriceDomId()));

        context.setAttribute("description", "Old and new prices displayed on the Home and Product pages are the same");
        context.setAttribute("domId", pricesDomIds);
        assertTrue(hReporter(3, context, pp.areTheSamePricesDisplayedOnBothPages(hpActualPrices)), "Prices and number of decimals match.");
    }

    @Test
    public void testSizeDropdown_verifyFirstOption_expectSmallS(ITestContext context) {
        var expectedOption = "Small (S)";
        pp = hp.clickOnAProduct();
        var actualOption = pp.getDefaultSizeOption();
        var optionDomId = pp.getDefaultSizeDomId();

        context.setAttribute("description", "Size dropdown's default value is Small(S)");
        context.setAttribute("domId", optionDomId);
        assertTrue(hReporter(3, context, actualOption.equals(expectedOption)), "The expected default size option is \"Small(S)\".\nActual: " + actualOption);
    }

    @Test
    public void testAddToCartButton_isThereSpaceBetweenButtonAndQuantityDropdown_expectTrue(ITestContext context) {
        pp = hp.clickOnAProduct();
        var buttonDomId = pp.getButtonWrapperDomId();

        context.setAttribute("description", "There is a space between button and quantity dropdown");
        context.setAttribute("domId", buttonDomId);
        assertTrue(hReporter(3, context, pp.isThereExpectedSpaceBetweenButtonAndQuantityDropdown()),
                "\"Add to Cart\" button is below Quantity dropdown. There is expected space between two elements.");
    }

    @Test
    public void testNavigation_isThereExpectedSpaceBetweenNavIcons_expectTrue(ITestContext context){
        pp = hp.clickOnAProduct();
        var iconsDomId = pp.getIconsDomId();

        context.setAttribute("description", "There is a space between each of the navigation icons");
        context.setAttribute("domId", iconsDomId);
        assertTrue(hReporter(3, context, pp.isThereExpectedSpaceBetweenNavIcons()), "The actual margin between Navigation Icons is 20px.");
    }

}
