package com.epam.automation.testing;

import com.epam.automation.pages.LoginPage;
import com.epam.automation.testing.BaseTest; // ✅ правильний імпорт
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.epam.automation.testing.listener.TestListener.class)
public class PositiveLoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials_ShouldSucceed() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(loginPage.getPageTitle(), "Swag Labs");
    }
}
