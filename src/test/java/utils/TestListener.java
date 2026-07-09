package utils;

import tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult testResult) {
        BaseTest instance = (BaseTest) testResult.getInstance();
        WebDriver driver = instance.getDriver();
        String path = ScreenshotUtil.capture(driver, testResult.getMethod().getMethodName());
        System.out.println("Screenshot: " + path);
    }

}
