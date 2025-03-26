package com.epam.automation.testing;

import com.epam.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NegativeLoginTest extends BaseTest {

    @Test
    public void loginWithEmptyCredentials_ShouldShowUsernameRequired() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.clearUsername();
        loginPage.clearPassword();
        Thread.sleep(1000); // стабілізація
        loginPage.clickLogin();

        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, "Epic sadface: Username is required");
    }

    @Test
    public void loginWithOnlyUsername_ShouldShowPasswordRequired() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "");
        Thread.sleep(1000);
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, "Epic sadface: Password is required");
    }

    @Test
    public void loginWithOnlyPassword_ShouldShowInvalidCredentialsError() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.clearUsername();
        loginPage.enterPassword("secret_sauce");
        Thread.sleep(1000);
        loginPage.clickLogin();

        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, "Epic sadface: Username is required");
    }

    @Test
    public void loginWithInvalidCredentials_ShouldShowNoMatchError() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("invalid_user", "invalid_pass");
        Thread.sleep(1000);
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, "Epic sadface: Username and password do not match any user in this service");
    }
}
