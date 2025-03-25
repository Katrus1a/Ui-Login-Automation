package com.epam.automation.bdd.steps;

import com.epam.automation.driver.DriverManager;
import com.epam.automation.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginSteps {

    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
    private WebDriver driver = DriverManager.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        loginPage.open();
        logger.info("Opened SauceDemo login page");
    }

    @When("User enters {string} and {string} and clicks login")
    public void userEntersCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        logger.info("User attempted to log in with username='{}' and password='{}'",
                username, password.isEmpty() ? "[empty]" : "[provided]");
    }

    @Then("Error message should be {string}")
    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        logger.info("Checking error message: expected='{}', actual='{}'", expectedMessage, actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch");
    }

    @Then("User should be logged in and see {string}")
    public void verifyLoginSuccess(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        logger.info("Verifying page title after login: expected='{}', actual='{}'", expectedTitle, actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "User not logged in or wrong page");
    }
}
