package pageObjects;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EyesPom {
    protected static WebDriver driver;
    protected static Eyes eyes;

    public EyesPom(WebDriver driver) {
        EyesPom.driver = driver;
        EyesPom.eyes = new Eyes();
        PageFactory.initElements(driver, this);
    }
}
