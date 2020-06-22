package testUtils;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class HReporter {

//    public boolean hackathonReporter(ITestResult result, ITestContext context, WebElement element){
//        try (var writer = new BufferedWriter(new FileWriter("Traditional-V1-TestResults.txt", true))) {
//            writer.write("Task: " + getTaskNumber(result) + ", Test Name: " + getTestMethodName(result) + ", DOM Id: " + getDomId(element) + ", Browser: " + getBrowser(context)
//                    + ", Viewport: " + getViewport(context) + ", Device: " + getDevice(context) + ", Status: " + (getTestStatus(result) ? "Pass" : "Fail"));
//            writer.newLine();
//        } catch (Exception e) {
//            System.out.println("Error writing to report file");
//            e.printStackTrace();
//        }
//        //returns the result so that it can be used for further Assertions in the test code.
//        return status;
//    }

    public int getTaskNumber(ITestResult result){
        String className = result.getTestClass().getRealClass().getSimpleName();
        var i = Integer.parseInt(String.valueOf(className.charAt(4)));
        return i;
    }

    public String getDomId(WebElement element){
        return element.getAttribute("id");
    }

    public String getBrowser(ITestContext context){
        return context.getCurrentXmlTest().getParameter("browser");
    }

    public String getViewport(ITestContext context){
        var w = context.getCurrentXmlTest().getParameter("screenWidth");
        var h = context.getCurrentXmlTest().getParameter("screenHeight");
        return String.format("%s x %s", w, h);
    }

    public String getDevice(ITestContext context){
        return context.getCurrentXmlTest().getParameter("device");
    }

    public int getTestStatus(ITestResult result){
        return result.getStatus();
    }
}
