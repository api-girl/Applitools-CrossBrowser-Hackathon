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

    @FindBy(id = "SPAN__oldprice__221")
    private WebElement oldPrice;

    @FindBy(id = "SPAN__newprice__220")
    private WebElement newPrice;

    @FindBy(css = "a h3")
    private List<WebElement> productTitles;

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

    public List<String> getPricesColourFromHomePage(){
        List<String> rgbColours = List.of(oldPrice.getCssValue("color"), newPrice.getCssValue("color"));

        return rgbColours.
                stream().
                map(this::convertColourToHex).
                collect(Collectors.toList());
    }

    public String getTextDecorationFromPage(){
        return oldPrice.getCssValue("text-decoration");
    }

    public List<String> getPricesStyleFromHomePage(){
        List<String> styles = new ArrayList<String>(getPricesColourFromHomePage());
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

    @FindBy(id = "A____201")
    private WebElement gridIcon;
    public boolean isGridIconDisplayed(){
        return gridIcon.isDisplayed();
    }

    @FindBy(id = "A____203")
    private WebElement listIcon;
    public boolean isListIconDisplayed(){
        return listIcon.isDisplayed();
    }

    //visible in 1200px and 768px
    @FindBy(id = "DIV__customsear__41")
    private WebElement searchField;
    public boolean isSearchFieldDisplayed(){
        return searchField.isDisplayed();
    }

    @FindBy(id = "STRONG____50")
    private WebElement twoItemsInCart;
    public boolean isTwoItemsInCartDisplayed(){
        return twoItemsInCart.isDisplayed();
    }

    @FindBy(id = "collapse_1")
    private WebElement footerQuickLinksMenu;
    public boolean isFooterQuickLinksMenuDisplayed(){
        return footerQuickLinksMenu.isDisplayed();
    }

    @FindBy(id = "collapse_3")
    private WebElement footerContactsMenu;
    public boolean isFooterContactsMenuDisplayed(){
        return footerContactsMenu.isDisplayed();
    }

    @FindBy(id = "collapse_4")
    private WebElement footerKeepInTouchMenu;
    public boolean isFooterKeepInTouchMenuDisplayed(){
        return footerKeepInTouchMenu.isDisplayed();
    }

    //visible only in 768px
    @FindBy(id = "SPAN____208")
    private WebElement filterButtonTitle;
    public boolean isFilterButtonTitleDisplayed(){
        return filterButtonTitle.isDisplayed();
    }

    //visible in 768px and 500px
    @FindBy(id = "ti-filter")
    private WebElement funnelIcon;
    public boolean isFunnelIconDisplayed(){
        return funnelIcon.isDisplayed();
    }

    @FindBy(id = "LI____223")
    private WebElement addToFavouritesIcon;
    public boolean isAddToFavouritesIconDisplayed(){
        return addToFavouritesIcon.isDisplayed();
    }

    @FindBy(id = "LI____227")
    private WebElement compareIcon;
    public boolean isCompareIconDisplayed(){
        return compareIcon.isDisplayed();
    }

    @FindBy(id = "LI____231")
    private WebElement addToCartIcon;
    public boolean isAddToCartIconDisplayed(){
        return addToCartIcon.isDisplayed();
    }

    public List<WebElement> create1200ElementList(){
        //visible in 1200px, some of them visible in 768
        return List.of(navMenu, wishlistIcon, gridIcon, listIcon,
                searchField, twoItemsInCart, footerQuickLinksMenu, footerContactsMenu, footerKeepInTouchMenu);
    }

    public List<WebElement> create768ElementList(){
        return List.of(searchField, twoItemsInCart, footerQuickLinksMenu, footerContactsMenu, footerKeepInTouchMenu,
                filterButtonTitle, funnelIcon, addToFavouritesIcon, compareIcon, addToCartIcon);
    }

    public List<WebElement> create500ElementList(){
        return List.of(funnelIcon, addToFavouritesIcon, compareIcon, addToCartIcon);
    }

    public List<WebElement> notDisplayedIn1200ElementList(){
        return List.of(filterButtonTitle, funnelIcon, addToFavouritesIcon, compareIcon, addToCartIcon);
    }

    public List<WebElement> notDisplayedIn768ElementList(){
        return List.of(navMenu, wishlistIcon, gridIcon, listIcon);
    }

    public List<WebElement> notDisplayedIn500ElementList(){
        return List.of(navMenu, wishlistIcon, gridIcon, listIcon,
                searchField, twoItemsInCart, footerQuickLinksMenu, footerContactsMenu, footerKeepInTouchMenu, filterButtonTitle);
    }

    public List<Boolean> areElementsDisplayed(List<WebElement> elements){

        return elements
                .stream()
                .map(WebElement::isDisplayed)
                .collect(Collectors.toList());
    }


}
