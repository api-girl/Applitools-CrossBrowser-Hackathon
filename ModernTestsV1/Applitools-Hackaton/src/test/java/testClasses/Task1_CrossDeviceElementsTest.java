package testClasses;

import org.testng.annotations.Test;


public class Task1_CrossDeviceElementsTest extends BaseTest {

    @Test
    public void testHomePage_verifyVisibilityOfElementsAcross3Viewports(){
        eyesManager.validateWindow("Task 1", "Cross-Device Elements Test");
    }

}
