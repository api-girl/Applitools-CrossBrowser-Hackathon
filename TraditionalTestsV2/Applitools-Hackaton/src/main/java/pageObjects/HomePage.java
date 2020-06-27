package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends Page {

    public HomePage(WebDriver driver){
        super(driver);
    }

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
    public String getOldPriceDomId() {
        return getDomId(oldPrice);
    }

    @FindBy(id = "SPAN__newprice__221")
    private WebElement newPrice;
    public String getNewPriceDomId() {
        return getDomId(newPrice);
    }

    @FindBy(css = "a h3")
    private List<WebElement> productTitles;
    public String getProductTitleHpDomId() {
        return getDomId(productTitles.get(0));
    }

    @FindBy(id="A____8")
    private WebElement logo;
    public String getLogoDomId(){
        return getDomId(logo);
    }

    @FindBy(id = "UL____21")
    private WebElement navMenu;
    public String getNavMenuDomId(){
        return navMenu.getAttribute("id");
    }

    @FindBy(id = "A__wishlist__52")
    private WebElement wishlistIcon;
    public String getWishlistIconDomId(){return getDomId(wishlistIcon);}

    @FindBy(id = "A____202")
    private WebElement gridIcon;
    public String getGridIconDomId() {return getDomId(gridIcon);}

    @FindBy(id = "A____204")
    private WebElement listIcon;
    public String getListIconDomId() {return getDomId(listIcon);}

    @FindBy(id = "DIV__customsear__41")
    private WebElement searchField;
    public String getSearchFieldDomId(){
        return getDomId(searchField);
    }

    @FindBy(id = "STRONG____50")
    private WebElement twoItemsInCart;
    public String getTwoItemsDomId(){
        return getDomId(twoItemsInCart);
    }

    @FindBy(id = "collapse_1")
    private WebElement footerQuickLinksMenu;
    public String getFooterQuickLinksMenuDomId(){
        return getDomId(footerQuickLinksMenu);
    }

    @FindBy(id = "collapse_3")
    private WebElement footerContactsMenu;
    public String getFooterContactsMenuDomId(){
        return getDomId(footerContactsMenu);
    }

    @FindBy(id = "collapse_4")
    private WebElement footerKeepInTouchMenu;
    public String getFooterKeepInTouchDomId(){
        return getDomId(footerKeepInTouchMenu);
    }

    @FindBy(id = "SPAN____209")
    private WebElement filterButtonTitle;
    public String getFilterButtonTitleDomId(){
        return getDomId(filterButtonTitle);
    }

    @FindBy(id = "ti-filter")
    private WebElement funnelIcon;
    public String getFunnelIconDomId(){
        return getDomId(funnelIcon);
    }

    @FindBy(id = "LI____224")
    private WebElement addToFavouritesIcon;
    public String getAddToFavouritesIconDomId(){
        return getDomId(addToFavouritesIcon);
    }

    @FindBy(id = "LI____228")
    private WebElement compareIcon;
    public String getCompareIconDomId(){
        return getDomId(compareIcon);
    }

    @FindBy(id = "LI____232")
    private WebElement addToCartIcon;
    public String getAddToCartIconDomId(){
        return getDomId(addToCartIcon);
    }

    @FindBy(id = "LI____58")
    private WebElement magnifyingGlass;
    public String getMagnifyingGlassDomId(){
        return getDomId(magnifyingGlass);
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

    public String getOldPriceValue(){
        return getPrice(oldPrice);
    }

    public String getNewPriceValue(){
        return getPrice(newPrice);
    }

    public String getOldPriceColour(){
        return convertColourToHex(oldPrice.getCssValue("color"));
    }

    public String getNewPriceColour(){
        return convertColourToHex(newPrice.getCssValue("color"));
    }

    public String getOldPriceTextDecoration(){
        return oldPrice.getCssValue("text-decoration");
    }

    public String getProductTitle(){
        return productTitles.get(0).getText();
    }

    public boolean isLogoCorrectlyLocated() {
        if (getScreenWidth() >= 1200) {
            return logo.getRect().getX() == 15;
        } else if (getScreenWidth() >= 768) {
            var i = logo.getRect().getX();
            return i >= 279 && i < 288;
        } else if (getScreenWidth() >= 500) {
            return logo.getRect().getX() == 153;
        }
        System.out.println("Unexpected viewport");
        return false;
    }

    public boolean isNavMenuDisplayed(){
        return navMenu.isDisplayed();
    }

    public boolean isWishlistIconDisplayed(){
        return wishlistIcon.isDisplayed();
    }

    public boolean isGridIconDisplayed(){
        return gridIcon.isDisplayed();
    }

    public boolean isListIconDisplayed(){
        return listIcon.isDisplayed();
    }

    public boolean isTwoItemsInCartDisplayed(){
        return twoItemsInCart.isDisplayed();
    }

    public boolean isSearchFieldDisplayed(){
        return searchField.isDisplayed();
    }

    public boolean isFooterQuickLinksMenuDisplayed(){
        return footerQuickLinksMenu.isDisplayed();
    }

    public boolean isFooterContactsMenuDisplayed(){
        return footerContactsMenu.isDisplayed();
    }

    public boolean isFooterKeepInTouchMenuDisplayed(){
        return footerKeepInTouchMenu.isDisplayed();
    }

    public boolean isFilterButtonTitleDisplayed(){
        return filterButtonTitle.isDisplayed();
    }

    public boolean isFunnelIconDisplayed(){
        return funnelIcon.isDisplayed();
    }

    public boolean isAddToFavouritesIconDisplayed(){
        return addToFavouritesIcon.isDisplayed();
    }

    public boolean isCompareIconDisplayed(){
        return compareIcon.isDisplayed();
    }

    public boolean isAddToCartIconDisplayed(){
        return addToCartIcon.isDisplayed();
    }

    public boolean isMagnifyingGlassCorrectlyDisplayed() {
        return magnifyingGlass.isDisplayed() && magnifyingGlass.getRect().getX() <= 15;
    }

}
