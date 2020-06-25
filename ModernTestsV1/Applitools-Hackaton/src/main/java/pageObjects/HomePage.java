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

    @FindBy(id = "ti-filter")
    private WebElement funnelIcon;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public WebElement getResultGridElement(){
        return resultGrid;
    }

    public void filterForBlackShoes() {
        if(!filterTable.isDisplayed()){
            clickOnElement(funnelIcon);
        }
        clickOnElement(colourBlack);
        clickOnElement(filterButton);
    }


    public ProductPage clickOnAProduct(){
        clickOnElement(results.get(0));
        return new ProductPage(driver);
    }

}
