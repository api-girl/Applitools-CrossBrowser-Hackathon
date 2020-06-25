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
        try {
            eyes.open(driver, "Applifashion V1", "Task 3");
            hp = new HomePage(driver);
            pp = hp.clickOnAProduct();
            eyes.checkWindow("Product Details test");
            eyes.closeAsync();
        }finally {
            eyes.abortAsync();
        }
       // eyesManager.validateWindow("Task 3", "Product Details test");
    }

}
