package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract String getPageTitle();

    public void navigateTo(String url) {
        driver.get(url);
    }

    public String getElementText(By locator) {
         return driver.findElement(locator).getText();
    }
}
