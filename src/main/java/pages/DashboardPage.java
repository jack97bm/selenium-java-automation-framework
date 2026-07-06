package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isWelcomeMessageDisplayed() {
        return driver.findElement(By.id("flash")).isDisplayed();
    }
}

