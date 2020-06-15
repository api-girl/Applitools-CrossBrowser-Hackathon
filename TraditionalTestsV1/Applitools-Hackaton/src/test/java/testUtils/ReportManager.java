package testUtils;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.time.LocalDate;

public class ReportManager {

        private static ExtentReports extent;
        private static String relativePathToReportFolder = "\\resources\\failedTestScreenshots\\" + LocalDate.now() +
                "\\";

        public static ExtentReports getInstance(){
            if(extent == null) {
                createInstance();
            }
            return extent;
        }

        public static ExtentReports createInstance() {
            String fileName = getReportName();
            String directory = System.getProperty("user.dir") + relativePathToReportFolder;

            new File(directory).mkdirs();
            String pathToReport = directory + fileName;
            ExtentSparkReporter reporter = new ExtentSparkReporter(pathToReport);
            reporter.config().setDocumentTitle("Test Report");
            reporter.config().setReportName("Cross-Browser Challenge");
            reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
            reporter.config().setEncoding("utf-8");
            reporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
            extent.setSystemInfo("Environment", "LAB");
            extent.setSystemInfo("Browser", "browser");

            return extent;
        }

        private static String getReportName() {
            LocalDate d = LocalDate.now();
            return "Test Report" + "_"
                    + d.toString()
                    .replace(" ", "_") + ".html";
        }

}
