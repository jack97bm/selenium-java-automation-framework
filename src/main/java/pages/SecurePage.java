package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends BasePage{

    @FindBy (id = "flash")
    private WebElement flashMessage;

    @FindBy (xpath = "//a[@href='/logout']")
    private WebElement logoutButton;

    public SecurePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isFlashMessageDisplayed() {
       return flashMessage.isDisplayed();
    }

    public String getFlashMessageText() {
        return flashMessage.getText();
    }

    public void clickLogout() {
        logoutButton.click();
    }
}
