package testClasses;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.Region;
import com.applitools.eyes.fluent.Target;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Task2_ShoppingExperienceTest extends BaseTest {
   HomePage hp;

    @Test
    public void testFilterBlackShoes_expectTwoResults(){
        eyes.open(driver, "Applifashion V1", "Task 2", new RectangleSize(800,600));
        hp = new HomePage(driver);
        hp.filterForBlackShoes();
        eyes.checkRegion(By.id(hp.getProductGridDomId()), "Filter Results"); // confirm if it is checking the result grid TODO
//        eyes.check(Target.window().fully().withName("Filter Results”"));
        eyes.closeAsync();
    }
}
