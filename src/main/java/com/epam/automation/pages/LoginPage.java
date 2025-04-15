package com.epam.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import static com.epam.automation.driver.DriverManager.getDriver;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        getDriver().get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        setInputValue(usernameInput, username);
        setInputValue(passwordInput, password);
        clickLogin();
    }




    public void enterUsername(String username) {
        setInputValue(usernameInput, username);
    }

    public void enterPassword(String password) {
        setInputValue(passwordInput, password);
    }

    public void clearUsername() {
        wait.until(ExpectedConditions.visibilityOf(usernameInput)).clear();
    }

    public void clearPassword() {
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).clear();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }

    private void setInputValue(WebElement input, String value) {
        wait.until(ExpectedConditions.visibilityOf(input)).clear();
        input.sendKeys(value);
    }
}
