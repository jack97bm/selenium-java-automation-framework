package tests;

import config.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        ConfigReader configReader = new ConfigReader();
        int timeout = Integer.parseInt(configReader.get("timeout"));
        baseUrl = configReader.get("base.url");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    @AfterMethod
    public void teardown() {
        if(driver !=null) driver.quit();
    }
}
