package testClasses;

import org.testng.annotations.Test;
import pageObjects.HomePage;


public class Task2_ShoppingExperienceTest extends BaseTest {
   HomePage hp;

    @Test
    public void testFilterBlackShoes_expectTwoResults(){
        try {
            hp = new HomePage(driver);
            hp.filterForBlackShoes();
            eyesManager.validateRegion("Task 2", hp.getResultGridElement(), "Filter Results");
        }finally{
            eyes.abortAsync();
        }

    }
}
