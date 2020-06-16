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

    public HomePage(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return getPageTitle();
    }

//    private By grabLocator(int pageWidth){
//        switch(pageWidth)
//        if(){
//
//        }
//        return locator;
//    }

//    private By grabLocator(){
//        if()
//    }

    public int filterBlackShoes() {
        clickOnElement(colourBlack);
        clickOnElement(filterButton);
        waitForElementVisibility(getWebElement(resultGrid));
        return driver.findElements(results).size();
    }



}
