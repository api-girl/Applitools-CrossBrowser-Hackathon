package pageObjects;

import org.openqa.selenium.By;
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

    @FindBy(id = "A__openfilter__206")
    private WebElement funnel;

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
            clickOnElement(funnel);
        }
        clickOnElement(colourBlack);
        clickOnElement(filterButton);
        waitForElementVisibility(resultGrid);
        return results;
    }

    public int countFilteredResults(){
        return filterBlackShoes().size();
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

    @FindBy(id = "ASIDE__collg__67")
    private WebElement filterMenu;

    @FindBy(id = "A__wishlist__52")
    private WebElement wishlistIcon;

    @FindBy(id = "A____201")
    private WebElement gridIcon;

    @FindBy(id = "A____203")
    private WebElement listIcon;

    //visible in 1200px and 768px
    @FindBy(id = "DIV__customsear__41")
    private WebElement searchField;

    @FindBy(id = "STRONG____50")
    private WebElement twoItemsInCart;

    @FindBy(id = "collapse_1")
    private WebElement footerQuickLinksMenu;

    @FindBy(id = "collapse_3")
    private WebElement footerContactsMenu;

    @FindBy(id = "collapse_4")
    private WebElement footerKeepInTouchMenu;

    //visible only in 768px
    @FindBy(id = "SPAN____208")
    private WebElement filterButtonTitle;

    //visible in 768px and 500px
    @FindBy(id = "ti-filter")
    private WebElement funnelIcon;

    @FindBy(id = "LI____223")
    private WebElement addToFavouritesIcon;

    @FindBy(id = "LI____227")
    private WebElement compareIcon;

    @FindBy(id = "LI____231")
    private WebElement addToCartIcon;




}
