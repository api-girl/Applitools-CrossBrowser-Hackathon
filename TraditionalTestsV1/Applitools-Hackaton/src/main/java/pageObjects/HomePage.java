package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page {
// example for a page object that inherits from Page and its constructor

    public HomePage(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return getPageTitle();
    }

}
