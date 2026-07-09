package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecurePage;
import utils.RetryAnalyzer;

import java.time.Duration;

public class LoginTest extends BaseTest{

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                { "tomsmith", "SuperSecretPassword!", true},
                { "wronguser", "wrongpass", false }
        };
    }

    @Test (dataProvider = "loginData", description = "Login check", groups = "smoke", priority = 1)
     public void validLogin(String username, String password, boolean shouldPass) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo(baseUrl+"/login");
        loginPage.loginAs(username, password);
        if(shouldPass) {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("secure"));
            Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
        }
        else {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
            Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
        }
    }

    @Test(groups = {"smoke","regression"})
    public void loginAndVerifySecurePage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo(baseUrl+"/login");
        loginPage.loginAs("tomsmith", "SuperSecretPassword!");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("secure"));
        Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
        SecurePage securePage = new SecurePage(driver);
        Assert.assertTrue(securePage.isFlashMessageDisplayed());
    }

//    @Test(groups = "regression", priority = 2)
//    public void invalidLogin() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.navigateTo("https://the-internet.herokuapp.com/login");
//        loginPage.loginAs("tomsmith", "wrongPassword");
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
//        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
//    }

    @Test(groups = {"smoke","regression"}, priority = 3)
    public void verifyTitle() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo(baseUrl+"/login");
        Assert.assertEquals(driver.getTitle(),"The Internet");
    }


    @Test(groups = {"smoke","regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void flakyTest() {
        int random = (int)(Math.random() * 2);
        Assert.assertEquals(random,1, "Simulated flaky failure");
    }

}
