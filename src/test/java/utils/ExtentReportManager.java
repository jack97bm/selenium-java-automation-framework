package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extendReports;

    public static ExtentReports getReportInstance() {
        if (extendReports == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            extendReports = new ExtentReports();
            extendReports.attachReporter(reporter);
        }
        return extendReports;
    }

    public static ExtentTest createTest(String testName) {
        ExtentReports instance = getReportInstance();
        return instance.createTest(testName);
    }
}

