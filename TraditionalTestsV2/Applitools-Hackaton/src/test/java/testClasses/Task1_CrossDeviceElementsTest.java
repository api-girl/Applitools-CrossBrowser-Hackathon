package testClasses;

import org.testng.ITestContext;
import org.testng.annotations.Test;
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
    public void testHomePageElements_isNavMenuDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getNavMenuDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Navigation menu is displayed only in laptop viewport");
            assertTrue(hReporter(1, context, hp.isNavMenuDisplayed()), "Navigation Menu is not displayed in 1200px.");
        } else if (width >= 768) {
            context.setAttribute("description", "Navigation menu is hidden in tablet viewport");
            assertTrue(hReporter(1, context, !hp.isNavMenuDisplayed()), "Navigation Menu is displayed in 768px.");
        } else if (width >= 500) {
            context.setAttribute("description", "Navigation menu is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isNavMenuDisplayed()), "Navigation Menu is displayed in 500px.");
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isWishlistIconDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getWishlistIconDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Wishlist Icon is displayed only in laptop viewport");
            assertTrue(hReporter(1, context, hp.isWishlistIconDisplayed()), "Wishlist Icon is not displayed in 1200px.");
        }else if (width >= 768) {
            context.setAttribute("description", "Wishlist Icon is hidden in tablet viewport");
            assertTrue(hReporter(1, context, !hp.isWishlistIconDisplayed()), "Wishlist Icon is displayed in 768px.");
        }else if (width >= 500) {
            context.setAttribute("description", "Wishlist Icon is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isWishlistIconDisplayed()), "Wishlist Icon is displayed in 500px.");
        }else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isGridIconDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getGridIconDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Grid Icon is displayed only in laptop viewport");
            assertTrue(hReporter(1, context, hp.isGridIconDisplayed()), "Grid Icon is not displayed in 1200px.");
        } else if (width >= 768) {
            context.setAttribute("description", "Grid Icon is hidden in tablet viewport");
            assertTrue(hReporter(1, context, !hp.isGridIconDisplayed()), "Grid Icon is displayed in 768px.");
        } else if (width >= 500) {
            context.setAttribute("description", "Grid Icon is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isGridIconDisplayed()), "Grid Icon is displayed in 500px.");
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isListIconDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getListIconDomId());
        if (width >= 1200) {
            context.setAttribute("description", "List Icon is only displayed in laptop viewport");
            assertTrue(hReporter(1, context, hp.isListIconDisplayed()), "List Icon is not displayed in 1200px.");
        } else if (width >= 768) {
            context.setAttribute("description", "List Icon is hidden in tablet viewport");
            assertTrue(hReporter(1, context, !hp.isListIconDisplayed()), "List Icon is displayed in 768px.");
        } else if (width >= 500) {
            context.setAttribute("description", "List Icon is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isListIconDisplayed()), "List Icon is displayed in 500px.");
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_areTwoItemsInCartDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getTwoItemsDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Two Items In Cart Icon is displayed in laptop viewport");
            assertTrue(hReporter(1, context, hp.isTwoItemsInCartDisplayed()), "Two Items In Cart Icon is not displayed in 1200px.");
        } else if (width >= 768) {
            context.setAttribute("description", "Two Items In Cart Icon is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isTwoItemsInCartDisplayed()), "Two Items In Cart Icon is not displayed in 768px.");
        } else if (width >= 500) {
            context.setAttribute("description", "Two Items In Cart Icon is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isTwoItemsInCartDisplayed()), "Two Items In Cart Icon is displayed in 500px.");
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isFooterContactsDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getFooterContactsMenuDomId());

        if (width >= 1200) {
            context.setAttribute("description", "Footer - Contacts Menu is displayed in laptop viewport");
            assertTrue(hReporter(1, context, hp.isFooterContactsMenuDisplayed()), "Footer: Contacts Menu is not displayed in 1200px.");
        } else if (width >= 768) {
            context.setAttribute("description", "Footer - Contacts Menu is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isFooterContactsMenuDisplayed()), "Footer: Contacts Menu is not displayed in 768px.");
        } else if (width >= 500) {
            context.setAttribute("description", "Footer - Contacts Menu is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isFooterContactsMenuDisplayed()), "Footer: Contacts Menu is displayed in 500px.");
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isFooterQuickLinksDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getFooterQuickLinksMenuDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Footer - Quick Links Menu is displayed in laptop viewport");
            assertTrue(hReporter(1, context, hp.isFooterQuickLinksMenuDisplayed()), "Footer: Quick Links Menu is not displayed in 1200px.");
        } else if (width >= 768) {
            context.setAttribute("description", "Footer - Quick Links Menu is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isFooterQuickLinksMenuDisplayed()), "Footer: Quick Links Menu is not displayed in 768px.");
        } else if (width >= 500) {
            context.setAttribute("description", "Footer - Quick Links Menu is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isFooterQuickLinksMenuDisplayed()), "Footer: Quick Links Menu is displayed in 500px.");
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isFooterKeepInTouchDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getFooterKeepInTouchDomId());

        if (width >= 1200) {
            context.setAttribute("description", "Footer - Keep In Touch Menu is displayed in laptop viewport");
            assertTrue(hReporter(1, context, hp.isFooterKeepInTouchMenuDisplayed()), "Footer: Keep In Touch Menu is not displayed in 1200px");
        } else if (width >= 768) {
            context.setAttribute("description", "Footer - Keep In Touch Menu is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isFooterKeepInTouchMenuDisplayed()), "Footer: Keep In Touch Menu is not displayed in 768px");
        } else if (width >= 500) {
            context.setAttribute("description", "Footer - Keep In Touch Menu is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isFooterKeepInTouchMenuDisplayed()), "Footer: Keep In Touch Menu is displayed in 500px.");
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isFilterButtonTitleDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getFooterKeepInTouchDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Filter Button Title is hidden in laptop viewport");
            assertTrue(hReporter(1, context, !hp.isFilterButtonTitleDisplayed()), "Filter Button Title is displayed in 1200px.");
        } else if (width >= 768) {
            context.setAttribute("description", "Filter Button Title is displayed only in laptop viewport");
            assertTrue(hReporter(1, context, hp.isFilterButtonTitleDisplayed()), "Filter Button Title is not displayed in 768px.");
        } else if (width >= 500) {
            context.setAttribute("description", "Filter Button Title is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isFilterButtonTitleDisplayed()), "Filter Button Title is displayed in 500px.");
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isFunnelIconDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getFooterKeepInTouchDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Funnel Icon is hidden in laptop viewport");
            assertTrue(hReporter(1, context, !hp.isFunnelIconDisplayed()), "Funnel Icon is displayed in 1200px.");
        } else if (width >= 768) {
            context.setAttribute("description", "Funnel Icon is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isFunnelIconDisplayed()), "Funnel Icon is not displayed in 768px.");
        } else if (width >= 500) {
            context.setAttribute("description", "Funnel Icon is displayed in phone viewport");
            assertTrue(hReporter(1, context, hp.isFunnelIconDisplayed()), "Funnel Icon is not displayed in 500px.");
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isFavouritesIconDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getAddToFavouritesIconDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Add To Favourites Icon is hidden in laptop viewport");
            assertTrue(hReporter(1, context, !hp.isAddToFavouritesIconDisplayed()), "Add To Favourites Icon is displayed in 1200px.");
        } else if (width >= 768) {
            context.setAttribute("description", "Add To Favourites Icon is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isAddToFavouritesIconDisplayed()), "Add To Favourites Icon is not displayed in 768px.");
        } else if (width >= 500) {
            context.setAttribute("description", "Add To Favourites Icon is displayed in phone viewport");
            assertTrue(hReporter(1, context, hp.isAddToFavouritesIconDisplayed()), "Add To Favourites Icon is not displayed in 500px.");
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isCartIconDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getAddToCartIconDomId());

        if (width >= 1200) {
            context.setAttribute("description", "Add To Cart Icon is hidden in 1200 viewport");
            assertTrue(hReporter(1, context, !hp.isAddToCartIconDisplayed()), "Add To Cart Icon is displayed in 1200px.");
        } else if (width >= 768) {
            context.setAttribute("description", "Add To Cart Icon is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isAddToCartIconDisplayed()), "Add To Cart Icon is not displayed in 768px.");
        } else if (width >= 500) {
            context.setAttribute("description", "Add To Cart Icon is displayed in phone viewport");
            assertTrue(hReporter(1, context, hp.isAddToCartIconDisplayed()), "Add To Cart Icon is not displayed in 500px.");
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isCompareIconDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getCompareIconDomId());

        if (width >= 1200) {
            context.setAttribute("description", "Compare Icon is hidden in laptop viewport");
            assertTrue(hReporter(1, context, !hp.isCompareIconDisplayed()), "Compare Icon is displayed in 1200px.");
        } else if (width >= 768) {
            context.setAttribute("description", "Compare Icon is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isCompareIconDisplayed()), "Compare Icon is not displayed in 768px");
        } else if (width >= 500) {
            context.setAttribute("description", "Compare Icon is displayed in phone viewport");
            assertTrue(hReporter(1, context, hp.isCompareIconDisplayed()), "Compare Icon is not displayed in500px.");
        } else {
            log.info("Unexpected viewport.");
        }
    }
}
