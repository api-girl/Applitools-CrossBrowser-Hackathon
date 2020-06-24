package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends Page {
    @FindBy(id = "LI____103")
    private WebElement colourBlack;

    @FindBy(id = "filterBtn")
    private WebElement filterButton;

    @FindBy(id = "product_grid")
    private WebElement resultGrid;

    @FindBy(css = "#product_grid figure")
    private List<WebElement> results;

    @FindBy(id = "filter_col")
    private WebElement filterTable;

    @FindBy(id = "SPAN__oldprice__222")
    private WebElement oldPrice;

    @FindBy(id = "SPAN__newprice__221")
    private WebElement newPrice;

    @FindBy(css = "a h3")
    private List<WebElement> productTitles;
    public String getProductTitleHpDomId() {
        return getDomId(productTitles.get(0));
    }

    public HomePage(WebDriver driver){
        super(driver);
    }

    private List<WebElement> filterBlackShoes() {
        if(!filterTable.isDisplayed()){
            clickOnElement(funnelIcon);
        }
        clickOnElement(colourBlack);
        clickOnElement(filterButton);
        waitForElementVisibility(resultGrid);
        return results;
    }

    public List<String> getFilteredResultsDomId(){
        return filterBlackShoes()
                .stream()
                .map(a->a.getAttribute("id"))
                .collect(Collectors.toList());
    }

    public boolean countFilteredResults(int size){
        return size == 2;
    }

    public ProductPage clickOnAProduct(){
        clickOnElement(results.get(0));
        return new ProductPage(driver);
    }

    public List<String> getPricesValuesFromHomePage(){
        return Arrays.asList(getPrice(oldPrice), getPrice(newPrice));
    }

    public List<String> getPricesColoursFromHomePage(){
        List<String> rgbColours = List.of(oldPrice.getCssValue("color"), newPrice.getCssValue("color"));

        return rgbColours.
                stream().
                map(this::convertColourToHex).
                collect(Collectors.toList());
    }

    public boolean doBothPricesColoursMatchExpectedOnHomePage(List<String> expected){
        return expected.equals(getPricesColoursFromHomePage());
    }

    public String getTextDecorationFromPage(){
        return oldPrice.getCssValue("text-decoration");
    }

    public List<String> getPricesStyleFromHomePage(){
        List<String> styles = new ArrayList<String>(getPricesColoursFromHomePage());
        styles.add(getTextDecorationFromPage());
        return styles;
    }

    public String getProductTitleFromHomePage(){
        return productTitles.get(0).getText();
    }

    //only displayed in 1200px
    @FindBy(id = "UL____21")
    private WebElement navMenu;
    public boolean isNavMenuDisplayed(){
        return navMenu.isDisplayed();
    }

    public String getNavMenuDomId(){
        return navMenu.getAttribute("id");
    }

    @FindBy(id = "A__wishlist__52")
    private WebElement wishlistIcon;
    public boolean isWishlistIconDisplayed(){
        return wishlistIcon.isDisplayed();
    }

    public String getWishlistIconDomId(){return getDomId(wishlistIcon);}

    @FindBy(id = "A____202")
    private WebElement gridIcon;
    public boolean isGridIconDisplayed(){
        return gridIcon.isDisplayed();
    }

    public String getGridIconDomId() {return getDomId(gridIcon);}

    @FindBy(id = "A____204")
    private WebElement listIcon;
    public boolean isListIconDisplayed(){
        return listIcon.isDisplayed();
    }

    public String getListIconDomId() {return getDomId(listIcon);}

    //visible in 1200px and 768px
    @FindBy(id = "DIV__customsear__41")
    private WebElement searchField;
    public boolean isSearchFieldDisplayed(){
        return searchField.isDisplayed();
    }

    public String getSearchFieldDomId(){
        return getDomId(searchField);
    }

    @FindBy(id = "STRONG____50")
    private WebElement twoItemsInCart;
    public boolean isTwoItemsInCartDisplayed(){
        return twoItemsInCart.isDisplayed();
    }

    public String getTwoItemsDomId(){
        return getDomId(twoItemsInCart);
    }

    @FindBy(id = "collapse_1")
    private WebElement footerQuickLinksMenu;
    public boolean isFooterQuickLinksMenuDisplayed(){
        return footerQuickLinksMenu.isDisplayed();
    }

    public String getFooterQuickLinksMenuDomId(){
        return getDomId(footerQuickLinksMenu);
    }

    @FindBy(id = "collapse_3")
    private WebElement footerContactsMenu;
    public boolean isFooterContactsMenuDisplayed(){
        return footerContactsMenu.isDisplayed();
    }

    public String getFooterContactsMenuDomId(){
        return getDomId(footerContactsMenu);
    }

    @FindBy(id = "collapse_4")
    private WebElement footerKeepInTouchMenu;
    public boolean isFooterKeepInTouchMenuDisplayed(){
        return footerKeepInTouchMenu.isDisplayed();
    }

    public String getFooterKeepInTouchDomId(){
        return getDomId(footerKeepInTouchMenu);
    }

    //visible only in 768px
    @FindBy(id = "SPAN____209")
    private WebElement filterButtonTitle;
    public boolean isFilterButtonTitleDisplayed(){
        return filterButtonTitle.isDisplayed();
    }

    public String getFilterButtonTitleDomId(){
        return getDomId(filterButtonTitle);
    }

    //visible in 768px and 500px
    @FindBy(id = "ti-filter")
    private WebElement funnelIcon;
    public boolean isFunnelIconDisplayed(){
        return funnelIcon.isDisplayed();
    }

    public String getFunnelIconDomId(){
        return getDomId(funnelIcon);
    }

    @FindBy(id = "LI____224")
    private WebElement addToFavouritesIcon;
    public boolean isAddToFavouritesIconDisplayed(){
        return addToFavouritesIcon.isDisplayed();
    }

    public String getAddToFavouritesIconDomId(){
        return getDomId(addToFavouritesIcon);
    }

    @FindBy(id = "LI____228")
    private WebElement compareIcon;
    public boolean isCompareIconDisplayed(){
        return compareIcon.isDisplayed();
    }

    public String getCompareIconDomId(){
        return getDomId(compareIcon);
    }

    @FindBy(id = "LI____232")
    private WebElement addToCartIcon;
    public boolean isAddToCartIconDisplayed(){
        return addToCartIcon.isDisplayed();
    }

    public String getAddToCartIconDomId(){
        return getDomId(addToCartIcon);
    }

    //visible only in 500px
    @FindBy(id = "LI____58")
    private WebElement magnifyingGlass;
    public boolean isMagnifyingGlassDisplayed(){
        return magnifyingGlass.isDisplayed();
    }

    public String getMagnifyingGlassDomId(){
        return getDomId(magnifyingGlass);
    }

    public String getOldPriceDomId() {
        return getDomId(oldPrice);
    }

    public String getNewPriceDomId() {
        return getDomId(newPrice);
    }

    public boolean isMagnifyingGlassLocatedLeft() {
        return magnifyingGlass.getRect().getX() <= 15;
    }
}
