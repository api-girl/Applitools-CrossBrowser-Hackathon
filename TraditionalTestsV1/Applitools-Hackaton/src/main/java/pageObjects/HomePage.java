package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

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

    public List<String> getPricesFromHomePage(){
        return Arrays.asList(getPrice(oldPrice), getPrice(newPrice));
    }

    public List<String> getPricesStyleFromHomePage(){
        return Arrays.asList(oldPrice.getCssValue("color"), oldPrice.getCssValue("text-decoration"),
                newPrice.getCssValue("color"), newPrice.getCssValue("text-decoration"));
    }

    public String getProductTitleFromHomePage(){
        return productTitles.get(0).getText();
    }



}
