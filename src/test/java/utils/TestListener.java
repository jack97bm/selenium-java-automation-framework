package utils;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess (ITestResult result) {
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        BaseTest instance = (BaseTest) testResult.getInstance();
        WebDriver driver = instance.getDriver();
        String path = ScreenshotUtil.capture(driver, testResult.getMethod().getMethodName());
        System.out.println("Screenshot: " + path);
        test.fail(testResult.getThrowable());
        if (path != null) {test.addScreenCaptureFromPath(path);}
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.getReportInstance().flush();
    }
}
