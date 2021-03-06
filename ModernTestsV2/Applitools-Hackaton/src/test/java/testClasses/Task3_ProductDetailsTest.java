package testClasses;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductPage;


public class Task3_ProductDetailsTest extends BaseTest {
    HomePage hp;
    ProductPage pp;

    @Test
    public void testProductPage_verifyVisibilityOfElementsAcross3Viewports(){
            hp = new HomePage(driver);
            pp = hp.clickOnAProduct();
            eyesManager.validateWindow("Task 3", "Product Details test");
    }

}
