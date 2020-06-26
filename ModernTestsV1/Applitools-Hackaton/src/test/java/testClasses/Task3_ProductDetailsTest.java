package testClasses;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.fluent.Target;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductPage;

import java.lang.reflect.InvocationTargetException;


public class Task3_ProductDetailsTest extends BaseTest {
    HomePage hp;
    ProductPage pp;

    @Test
    public void testProductPage_verifyVisibilityOfElementsAcross3Viewports() throws InvocationTargetException {
//            eyes.open(driver, "Applifashion V1", "Task 3");
            hp = new HomePage(driver);
            pp = hp.clickOnAProduct();
            eyesManager.validateWindow("Task 3", "Product Details test");
//            eyes.checkWindow("Product Details test");
//            eyes.closeAsync();

//            eyesManager.getEyes().abortAsync();

    }

}
