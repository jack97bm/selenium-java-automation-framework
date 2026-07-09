package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static String capture(WebDriver driver, String testname) {
        try {
            if (driver == null) {
                System.out.println("Cannot capture screenshot — driver is null");
                return null;
            }
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            String dest = "screenshots/" + testname + "_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(src, new File(dest));
            return dest;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}