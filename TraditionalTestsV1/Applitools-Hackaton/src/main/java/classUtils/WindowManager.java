package classUtils;


import org.openqa.selenium.WebDriver;
import pageObjects.Page;

import java.util.ArrayList;

public class WindowManager extends Page{

    public WindowManager(WebDriver driver) {
        super(driver);
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void goToUrl(String url) {
        driver.navigate().to(url);
    }

    public void switchToTabByTitle(String tabTitle) {
        var tabs = driver.getWindowHandles();

        for (String tab : tabs) {
            driver.switchTo().window(tab);
            if (tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }

    public void switchToTabByHandle(String handle) {
        var tabs = driver.getWindowHandles();

        for (String tab : tabs) {
            driver.switchTo().window(tab);
            if (handle.equals(getTabHandle())) {
                break;
            }
        }
    }

    public void switchToTabByIndex(int tab) {
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        waitForAllTabsToLoad();

        for (int i = 1; i < tabs.size(); i++) {
            driver.switchTo().window((tabs.get(i)).toString());
            if (i == tab) {
                break;
            }
        }
    }

    public void switchToTheFirstOpenedTab() {
        var tabs = driver.getWindowHandles();
        System.out.println(tabs);
        tabs.forEach(driver.switchTo()::window);
    }

    public int getNumberOfOpenTabs() {
        return driver.getWindowHandles().size();
    }

    public void openANewTab(){

    }


    public void closeAllAddedTabs() {
        ArrayList tabs = new ArrayList(driver.getWindowHandles());

        if (tabs.size() > 1) {
            for (int i = 1; i < tabs.size(); i++) {
                driver.switchTo().window(tabs.get(i).toString());
                driver.close();
            }
        }
    }


}
