package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();

    }
    @AfterMethod
    public void teardown() {
        if(driver !=null) driver.quit();
    }
}
