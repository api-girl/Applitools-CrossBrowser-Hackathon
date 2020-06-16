package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Page{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "shoe_name")
    private WebElement productTitle;

    public boolean isProductTitleDisplayed(){
        String i = "";
        if(productTitle.isDisplayed()){
             i = productTitle.getText();
        }
        return i != null;
    }

    @FindBy(id = "shoe_img")
    private WebElement productImage;
    public boolean isProductImageDisplayed(){
        return productImage.isDisplayed();
    }

    @FindBy(id = "DIV__prodinfove__75")
    private WebElement reviewSection;

    public boolean isReviewSectionDisplayed(){
        return reviewSection.isDisplayed();
    }

    public boolean isThereMarginBetweenStarsAndSubTitle(){
        var i = driver.findElement(By.id("EM____82"));
        var e = i.getCssValue("margin-left");
        return !e.equals("0px");
    }

    @FindBy(id = "DIV__row__88")
    private WebElement size;
    public boolean isSizeDropdownClickable(){
        return false;
    }

    public boolean doesSizeDropdownHaveAtLeastOneOption(){
        return false;
    }

    @FindBy(id = "DIV__row__98")
    private WebElement quantity;
    public boolean canQuantityBeEnteredManually(){
        return false;
    }

    public boolean canQuantityBeIncreasedByClickingPlus(){
        return false;
    }

    @FindBy(id = "new_price")
    private WebElement newPrice;
    public boolean isNewPriceBlue(){
        return false;
    }

    public boolean isNewPriceDisplayedAsDouble(){
        return false;
    }

    @FindBy(id = "old_price")
    private WebElement oldPrice;
    public boolean isOldPriceGrayAndCrossed(){
        return false;
    }
    public boolean isOldPriceDisplayedAsDouble(){
        return false;
    }

    @FindBy(id = "discount")
    private WebElement discount;
    public void isDiscountDisplayed(){
        discount.isDisplayed();
    }

    @FindBy(id = "A__btn__114")
    private WebElement button;
    public boolean isThereSpaceBetweenButtonAndQuantityDropdown(){
        return false;
    }

}
