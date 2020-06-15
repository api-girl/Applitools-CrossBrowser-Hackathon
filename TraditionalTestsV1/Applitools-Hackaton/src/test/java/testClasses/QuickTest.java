package testClasses;

import org.testng.annotations.Test;
import pageObjects.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class QuickTest extends BaseTest{

    @Test (groups = "smoke", priority = 1)
    public void testIsTheWebSiteLoadingTheHomePage(){
        String pageTitle = hp.getTitle();

        assertEquals(pageTitle, "Applitools UltraFastGrid | Cross Browser Testing Demo App");
    }
}