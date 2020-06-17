package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(css = "span.current")
    private WebElement defaultSize;

    public String getDefaultSizeOption() {
        scrollUntilElement(defaultSize);
        return defaultSize.getText();
    }

    @FindBy(id = "DIV__row__98")
    private WebElement quantity;

    @FindBy(className = "new_price")
    private WebElement newPrice;
    public boolean isNewPriceBlue(){
        return false;
    }

    @FindBy(id = "discount")
    private WebElement discount;
    public void isDiscountDisplayed(){
        discount.isDisplayed();
    }

    @FindBy(id = "DIV__colxlcollg__112")
    private WebElement buttonWrapper;
    public boolean isThereASpaceBetweenButtonAndQuantityDropdown(){
        var s = buttonWrapper.getCssValue("margin-top");
              return  s.equals("10px");
    }

    @FindBy(className = "old_price")
    private WebElement oldPrice;
    public boolean isOldPriceGrayAndCrossed(){
        return false;
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

    @FindBy(id = "EM____82")
    private WebElement reviewSubtitle;

    public boolean isThereAMarginBetweenStarsAndSubtitle(){
        return !reviewSubtitle.getCssValue("margin-left").equals("0px");
    }

    public List<String> getPricesFromProductPage(){
        return Arrays.asList(getPrice(oldPrice), getPrice(newPrice));
    }

    public List<String> getPricesStyleFromProductPage(){
        return Arrays.asList(oldPrice.getCssValue("color"), oldPrice.getCssValue("text-decoration"),
                            newPrice.getCssValue("color"), newPrice.getCssValue("text-decoration"));
    }
}
