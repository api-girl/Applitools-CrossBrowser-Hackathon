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
    public String getProductTitleDomId(){
        return getDomId(productTitle);
    }

    @FindBy(id = "shoe_img")
    private WebElement productImage;
    public String getProductImageDomId(){
        return getDomId(productImage);
    }

    @FindBy(id = "DIV__prodinfove__75")
    private WebElement reviewSection;
    public String getReviewSectionDomId(){
        return getDomId(reviewSection);
    }

    @FindBy(id = "DIV__customsele__92")
    private WebElement defaultSize;
    public String getDefaultSizeDomId(){
        return getDomId(defaultSize);
    }

    @FindBy(className = "new_price")
    private WebElement newPrice;
    public String getNewPriceDomId(){
        return getDomId(newPrice);
    }

    @FindBy(id = "DIV__btnaddtoca__113")
    private WebElement buttonWrapper;
    public String getButtonWrapperDomId(){
        return getDomId(buttonWrapper);
    }

    @FindBy(className = "old_price")
    private WebElement oldPrice;
    public String getOldPriceDomId(){
        return getDomId(oldPrice);
    }

    @FindBy(id = "EM____82")
    private WebElement reviewSubtitle;
    public String getReviewSubtitleDomId(){
        return getDomId(reviewSubtitle);
    }

    @FindBy(css = "#UL__toptools__46 li")
    private List<WebElement> icons;
    public List<String> getIconsDomId(){
        return icons.stream()
                .map(a->a.getAttribute("id"))
                .collect(Collectors.toList());
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

    public List<String> getPricesColoursFromProductPage(){
        List<String> rgbColours = List.of(oldPrice.getCssValue("color"), newPrice.getCssValue("color"));

        return rgbColours.
                stream().
                map(this::convertColourToHex).
                collect(Collectors.toList());
    }

    public boolean doBothPricesColoursMatchExpectedOnProductPage(List<String> expected){
        return expected.equals(getPricesColoursFromProductPage());
    }

    public boolean doPricesStyleMatchOnBothPages(List<String> actualHP){
        return actualHP.equals(getPricesStyleFromProductPage());
    }

    public String getTextDecorationFromPage(){
        return oldPrice.getCssValue("text-decoration");
    }

    public List<String> getPricesStyleFromProductPage(){
        List<String> styles = new ArrayList<String>(getPricesColoursFromProductPage());
        styles.add(getTextDecorationFromPage());
        return styles;
    }

    public boolean isThereExpectedSpaceBetweenNavIcons() {
        List<Boolean> results = new ArrayList<Boolean>();
        for(WebElement icon:icons){
            results.add(doesElementMarginEqualTo(icon, "left", 20));
        }
        return results.containsAll(List.of(true, true, true));

    }

    public boolean doProductTitlesMatch(String homePageTitle) {
        return homePageTitle.equals(getProductTitleFromProductPage());
    }

    public boolean areTheSamePricesDisplayedOnBothPages(List<String> actualHp) {
        return actualHp.equals(getPricesFromProductPage());
    }
}
