package testClasses;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.fluent.Target;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductPage;


public class Task3_ProductDetailsTest extends BaseTest {
    HomePage hp;
    ProductPage pp;

    @Test
    public void testProductPage_verifyVisibilityOfElementsAcross3Viewports(){
        eyes.open(driver, "Applifashion V1", "Task 3", new RectangleSize(800,600));
        hp = new HomePage(driver);
        pp = hp.clickOnAProduct();
        eyes.check(Target.window().fully().withName("Product Details test"));
        eyes.closeAsync();
    }

}
