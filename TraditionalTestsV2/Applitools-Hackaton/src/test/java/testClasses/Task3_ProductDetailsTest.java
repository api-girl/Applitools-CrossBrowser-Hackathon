package testClasses;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import pageObjects.ProductPage;

import java.util.ArrayList;
import java.util.Arrays;
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
        assertTrue(hReporter(3, context, pp.isReviewSectionDisplayed()),context.getAttribute("description").toString());

        context.setAttribute("domId", pp.getReviewSubtitleDomId());
        context.setAttribute("description", "The number of reviews does not overlap with stars.");
        assertTrue(hReporter(3, context, pp.isThereExpectedSpaceBetweenStarsAndSubtitle()), context.getAttribute("description").toString());
    }

    @Test
    public void testProductTitle_isTitleDisplayed_expectTrue(ITestContext context) {
        pp = hp.clickOnAProduct();
        context.setAttribute("domId", pp.getProductTitleDomId());
        context.setAttribute("description", "Product Title is displayed correctly");
        assertTrue(hReporter(3, context, pp.isProductTitleDisplayed()),
                context.getAttribute("description").toString());
    }

    @Test
    public void testProductTitle_verifyIfTitlesOnHomeAndProductPageMatch_expectMatching(ITestContext context) {
        var titleHomePage = hp.getProductTitle();
        List<String> titleDomIds = new ArrayList<String>();
        titleDomIds.add(hp.getProductTitleHpDomId());

        pp = hp.clickOnAProduct();
        context.setAttribute("description", "Product Titles displayed on Home and Product page must match.");
        titleDomIds.add(pp.getProductTitleDomId());
        context.setAttribute("domId", titleDomIds);

        assertTrue(hReporter(3, context, pp.doProductTitlesMatch(titleHomePage)), context.getAttribute("description").toString());
    }

    @Test
    public void testProductImage_isImageDisplayed_expectTrue(ITestContext context) {
        pp = hp.clickOnAProduct();
        context.setAttribute("domId", pp.getProductImageDomId());
        context.setAttribute("description", "Product Image is displayed");
        assertTrue(hReporter(3, context, pp.isProductImageDisplayed()), context.getAttribute("description").toString());
    }

    @Test
    public void testPrices_isTheOldPriceStyleCorrect(ITestContext context){
        context.setAttribute("domId", hp.getOldPriceDomId());
        context.setAttribute("description", "Old price font is gray on Home Page.");
        var actualStyleH = List.of(hp.getOldPriceColour(), hp.getOldPriceTextDecoration());
        assertTrue(hReporter(3, context, actualStyleH.get(0).equals("#999999")), context.getAttribute("description").toString());

        context.setAttribute("description", "Old price font decoration has value \"line-through\" on Home Page");
        assertTrue(hReporter(3, context, actualStyleH.get(1).contains("line-through")), context.getAttribute("description").toString());

        pp = hp.clickOnAProduct();
        context.setAttribute("domId", pp.getOldPriceDomId());
        context.setAttribute("description", "Old price font is gray on Product Page.");
        var actualStyleP = List.of(pp.getOldPriceColour(), pp.getOldPriceTextDecoration());
        assertTrue(hReporter(3, context, actualStyleP.get(0).equals("#999999")), context.getAttribute("description").toString());

        context.setAttribute("description", "Old price font decoration has value \"line-through\" on Product Page");
        assertTrue(hReporter(3, context, actualStyleP.get(1).contains("line-through")), context.getAttribute("description").toString());
    }

    @Test
    public void testPrices_isTheNewPriceFontColourCorrect(ITestContext context){
        context.setAttribute("domId", hp.getNewPriceDomId());
        context.setAttribute("description", "New price font is blue on Home Page.");
        var actualColour = hp.getNewPriceColour();
        assertTrue(hReporter(3, context, actualColour.equals("#004dda")), context.getAttribute("description").toString());

        pp = hp.clickOnAProduct();
        context.setAttribute("domId", pp.getNewPriceDomId());
        context.setAttribute("description", "New price font is blue on Product Page.");
        var actualColourP = pp.getNewPriceColour();
        assertTrue(hReporter(3, context, actualColour.equals("#004dda")), context.getAttribute("description").toString());
    }

    @Test
    public void testPrices_areTheSameValuesShownOnHomeAndProductPage(ITestContext context){
        var oldHpId = hp.getOldPriceDomId();
        var newHpId = hp.getNewPriceDomId();
        var priceValuesHp = List.of(hp.getOldPriceValue(), hp.getNewPriceValue());
        pp = hp.clickOnAProduct();
        var priceValuesPp = List.of(pp.getOldPriceValue(), pp.getNewPriceValue());

        context.setAttribute("domId", List.of(oldHpId, pp.getOldPriceDomId())); //TODO
        context.setAttribute("description", "Old price value is the same on Home and Product Page.");
        assertTrue(hReporter(3, context, priceValuesHp.get(0).equals(priceValuesPp.get(0))), context.getAttribute("description").toString());

        context.setAttribute("domId", List.of(newHpId, pp.getNewPriceDomId()));
        context.setAttribute("description", "New price value is the same on Home and Product Page.");
        assertTrue(hReporter(3, context, priceValuesHp.get(1).equals(priceValuesPp.get(1))), context.getAttribute("description").toString());
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

        context.setAttribute("description", "\"Add to Cart\" button is below Quantity dropdown. There is no additional margin between two elements.");
        context.setAttribute("domId", buttonDomId);
        assertTrue(hReporter(3, context, pp.isThereExpectedSpaceBetweenButtonAndQuantityDropdown()), context.getAttribute("description").toString());
    }

    @Test
    public void testNavigation_isThereExpectedSpaceBetweenNavIcons_expectTrue(ITestContext context){
        pp = hp.clickOnAProduct();
        var iconsDomId = pp.getIconsDomId();

        context.setAttribute("description", "The actual margin between Navigation Icons is 20px");
        context.setAttribute("domId", iconsDomId);
        assertTrue(hReporter(3, context, pp.isThereExpectedSpaceBetweenNavIcons()), context.getAttribute("description").toString());
    }

}
