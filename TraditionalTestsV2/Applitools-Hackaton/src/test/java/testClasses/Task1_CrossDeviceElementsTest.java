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
            assertTrue(hReporter(1, context, hp.isNavMenuDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Navigation menu is hidden in tablet viewport");
            assertTrue(hReporter(1, context, !hp.isNavMenuDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Navigation menu is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isNavMenuDisplayed()), context.getAttribute("description").toString());
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testLogo_isLogoCorrectlyLocatedInHeaderAcrossThreeViewports(ITestContext context){
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getLogoDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Logo is located on the left top side of the screen in laptop viewport");
            assertTrue(hReporter(1, context, hp.isLogoCorrectlyLocated()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Logo is centered at the top of the page in tablet viewport.");
            assertTrue(hReporter(1, context, hp.isLogoCorrectlyLocated()), context.getAttribute("description").toString());
            System.out.println(context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Logo is centered at the top of the page in phone viewport");
            assertTrue(hReporter(1, context, hp.isLogoCorrectlyLocated()), context.getAttribute("description").toString());
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isSearchFieldDisplayedAcrossThreeViewports(ITestContext context){
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getSearchFieldDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Search Field is displayed in laptop viewport");
            assertTrue(hReporter(1, context, hp.isSearchFieldDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Search Field is hidden in tablet viewport");
            assertTrue(hReporter(1, context, hp.isSearchFieldDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Search Field is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isSearchFieldDisplayed()), context.getAttribute("description").toString());
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
            assertTrue(hReporter(1, context, hp.isWishlistIconDisplayed()), context.getAttribute("description").toString());
        }else if (width >= 768) {
            context.setAttribute("description", "Wishlist Icon is hidden in tablet viewport");
            assertTrue(hReporter(1, context, !hp.isWishlistIconDisplayed()), context.getAttribute("description").toString());
        }else if (width >= 500) {
            context.setAttribute("description", "Wishlist Icon is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isWishlistIconDisplayed()), context.getAttribute("description").toString());
        }else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isMagnifyingGlassIconDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getMagnifyingGlassDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Search Button - Magnifying Glass is hidden in laptop viewport");
            assertTrue(hReporter(1, context, !hp.isMagnifyingGlassDisplayed()), context.getAttribute("description").toString());
        }else if (width >= 768) {
            context.setAttribute("description", "Search Button - Magnifying Glass is hidden in tablet viewport");
            assertTrue(hReporter(1, context, !hp.isMagnifyingGlassDisplayed()), context.getAttribute("description").toString());
        }else if (width >= 500) {
            context.setAttribute("description", "Search Button - Magnifying Glass is displayed in phone viewport");
            assertTrue(hReporter(1, context, hp.isMagnifyingGlassDisplayed()), context.getAttribute("description").toString());
        }else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isMagnifyingGlassLocatedLeftAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getMagnifyingGlassDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Search Button - Magnifying Glass is hidden in laptop viewport");
            assertTrue(hReporter(1, context, hp.isMagnifyingGlassLocatedLeft()), context.getAttribute("description").toString());
        }else if (width >= 768) {
            context.setAttribute("description", "Search Button - Magnifying Glass is hidden in tablet viewport");
            assertTrue(hReporter(1, context, hp.isMagnifyingGlassLocatedLeft()), context.getAttribute("description").toString());
        }else if (width >= 500) {
            context.setAttribute("description", "Search Button - Magnifying Glass is displayed in phone viewport and located on the left side of the screen");
            assertTrue(hReporter(1, context, hp.isMagnifyingGlassLocatedLeft()), context.getAttribute("description").toString());
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
            assertTrue(hReporter(1, context, hp.isGridIconDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Grid Icon is hidden in tablet viewport");
            assertTrue(hReporter(1, context, !hp.isGridIconDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Grid Icon is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isGridIconDisplayed()), context.getAttribute("description").toString());
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
            assertTrue(hReporter(1, context, hp.isListIconDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "List Icon is hidden in tablet viewport");
            assertTrue(hReporter(1, context, !hp.isListIconDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "List Icon is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isListIconDisplayed()), context.getAttribute("description").toString());
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
            assertTrue(hReporter(1, context, hp.isTwoItemsInCartDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Two Items In Cart Icon is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isTwoItemsInCartDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Two Items In Cart Icon is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isTwoItemsInCartDisplayed()), context.getAttribute("description").toString());
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
            assertTrue(hReporter(1, context, hp.isFooterContactsMenuDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Footer - Contacts Menu is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isFooterContactsMenuDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Footer - Contacts Menu is collapsed in phone viewport");
            assertTrue(hReporter(1, context, !hp.isFooterContactsMenuDisplayed()), context.getAttribute("description").toString());
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
            assertTrue(hReporter(1, context, hp.isFooterQuickLinksMenuDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Footer - Quick Links Menu is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isFooterQuickLinksMenuDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Footer - Quick Links Menu is collapsed in phone viewport");
            assertTrue(hReporter(1, context, !hp.isFooterQuickLinksMenuDisplayed()), context.getAttribute("description").toString());
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
            assertTrue(hReporter(1, context, hp.isFooterKeepInTouchMenuDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Footer - Keep In Touch Menu is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isFooterKeepInTouchMenuDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Footer - Keep In Touch Menu is collapsed in phone viewport");
            assertTrue(hReporter(1, context, !hp.isFooterKeepInTouchMenuDisplayed()), context.getAttribute("description").toString());
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isFilterButtonTitleDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getFilterButtonTitleDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Filter Button Title is hidden in laptop viewport");
            assertTrue(hReporter(1, context, !hp.isFilterButtonTitleDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Filter Button Title is displayed only in laptop viewport");
            assertTrue(hReporter(1, context, hp.isFilterButtonTitleDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Filter Button Title is hidden in phone viewport");
            assertTrue(hReporter(1, context, !hp.isFilterButtonTitleDisplayed()), context.getAttribute("description").toString());
        } else {
            log.info("Unexpected viewport.");
        }
    }

    @Test
    public void testHomePageElements_isFunnelIconDisplayedAcrossThreeViewports(ITestContext context) {
        int width = hp.getScreenWidth();
        context.setAttribute("domId", hp.getFunnelIconDomId());
        if (width >= 1200) {
            context.setAttribute("description", "Funnel Icon is hidden in laptop viewport");
            assertTrue(hReporter(1, context, !hp.isFunnelIconDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Funnel Icon is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isFunnelIconDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Funnel Icon is displayed in phone viewport");
            assertTrue(hReporter(1, context, hp.isFunnelIconDisplayed()), context.getAttribute("description").toString());
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
            assertTrue(hReporter(1, context, !hp.isAddToFavouritesIconDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Add To Favourites Icon is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isAddToFavouritesIconDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Add To Favourites Icon is displayed in phone viewport");
            assertTrue(hReporter(1, context, hp.isAddToFavouritesIconDisplayed()), context.getAttribute("description").toString());
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
            assertTrue(hReporter(1, context, !hp.isAddToCartIconDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Add To Cart Icon is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isAddToCartIconDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Add To Cart Icon is displayed in phone viewport");
            assertTrue(hReporter(1, context, hp.isAddToCartIconDisplayed()), context.getAttribute("description").toString());
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
            assertTrue(hReporter(1, context, !hp.isCompareIconDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 768) {
            context.setAttribute("description", "Compare Icon is displayed in tablet viewport");
            assertTrue(hReporter(1, context, hp.isCompareIconDisplayed()), context.getAttribute("description").toString());
        } else if (width >= 500) {
            context.setAttribute("description", "Compare Icon is displayed in phone viewport");
            assertTrue(hReporter(1, context, hp.isCompareIconDisplayed()), context.getAttribute("description").toString());
        } else {
            log.info("Unexpected viewport.");
        }
    }
}
