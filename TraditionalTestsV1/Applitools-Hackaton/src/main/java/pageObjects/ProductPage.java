package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductPage extends Page{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    private WebElement productTitle;

    @FindBy(id = "shoe_img")
    private WebElement productImage;

    @FindBy(id = "DIV__prodinfove__75")
    private WebElement reviewSection;
    public String getReviewSectionDomId(){
        return getDomId(reviewSection);
    }

    @FindBy(css = "span.current")
    private WebElement defaultSize;

    @FindBy(className = "new_price")
    private WebElement newPrice;

    @FindBy(id = "discount")
    private WebElement discount;

    @FindBy(id = "DIV__btnaddtoca__113")
    private WebElement buttonWrapper;

    @FindBy(className = "old_price")
    private WebElement oldPrice;

    @FindBy(id = "EM____82")
    private WebElement reviewSubtitle;
    public String getReviewSubtitleDomId(){
        return getDomId(reviewSubtitle);
    }

    public void isDiscountDisplayed(){
        discount.isDisplayed();
    }

    public String getDefaultSizeOption() {
        scrollUntilElement(defaultSize);
        return defaultSize.getText();
    }

    public boolean isProductTitleDisplayed(){
        String i = "";
        if(productTitle.isDisplayed()){
            i = productTitle.getText();
        }
        return i != null;
    }

    public String getProductTitleFromProductPage(){
        waitForElementVisibility(productTitle);
        return productTitle.getText();
    }

    public boolean isProductImageDisplayed() {
        return productImage.isDisplayed() && productImage.getAttribute("style").contains("img");
    }

    public boolean isReviewSectionDisplayed(){
        return reviewSection.isDisplayed();
    }

    public boolean doesElementMarginEqualTo(WebElement element, String marginOrientation, int pixels){
        return element.getCssValue("margin-" + marginOrientation).equals(String.valueOf(pixels) + "px");
    }

    public boolean isThereExpectedSpaceBetweenStarsAndSubtitle(){
        scrollUntilElement(reviewSubtitle);
        return doesElementMarginEqualTo(reviewSubtitle, "left", 0);
    }

    public boolean isThereExpectedSpaceBetweenButtonAndQuantityDropdown(){
        scrollUntilElement(buttonWrapper);
        var a = doesElementMarginEqualTo(buttonWrapper, "top", 0);
        var b = doesElementMarginEqualTo(buttonWrapper, "bottom", 0);
        return a && b;
    }

    public List<String> getPricesFromProductPage(){
        return Arrays.asList(getPrice(oldPrice), getPrice(newPrice));
    }

    public List<String> getPricesColourFromProductPage(){
        List<String> rgbColours = List.of(oldPrice.getCssValue("color"), newPrice.getCssValue("color"));

        return rgbColours.
                stream().
                map(this::convertColourToHex).
                collect(Collectors.toList());
    }

    public String getTextDecorationFromPage(){
        return oldPrice.getCssValue("text-decoration");
    }

    public List<String> getPricesStyleFromProductPage(){
        List<String> styles = new ArrayList<String>(getPricesColourFromProductPage());
        styles.add(getTextDecorationFromPage());
        return styles;
    }

    @FindBy(css = "#UL__toptools__46 li")
    private List<WebElement> icons;
    public boolean isThereExpectedSpaceBetweenNavIcons() {
        List<Boolean> results = new ArrayList<Boolean>();
        for(WebElement icon:icons){
            results.add(doesElementMarginEqualTo(icon, "left", 20));
        }
        return results.containsAll(List.of(true, true, true));

    }
}
