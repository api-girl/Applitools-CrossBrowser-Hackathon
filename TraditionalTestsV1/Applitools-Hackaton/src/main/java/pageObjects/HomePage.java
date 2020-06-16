package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage extends Page {
private By colourBlack = By.id("LI____103");
private By filterButton = By.id("filterBtn");
private By resultGrid = By.id("product_grid");
private By results = By.cssSelector("#product_grid figure");
private By filterTable = By.id("filter_col");
private By funnel = By.id("A__openfilter__206");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return getPageTitle();
    }


    private List<WebElement> filterBlackShoes() {
        if(!getWebElement(filterTable).isDisplayed()){
            clickOnElement(funnel);
        }
        clickOnElement(colourBlack);
        clickOnElement(filterButton);
        waitForElementVisibility(getWebElement(resultGrid));
        return driver.findElements(results);
    }

    public int countFilteredResults(){
        return filterBlackShoes().size();
    }

    public ProductPage clickOnAProduct(){
        var products = driver.findElements(results);
        clickOnElement(products.get(0));
        return new ProductPage(driver);
    }



}
