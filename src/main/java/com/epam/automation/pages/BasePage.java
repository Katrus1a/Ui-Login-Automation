package com.epam.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.epam.automation.driver.DriverManager.getDriver;

public abstract class BasePage {
    protected WebDriver driver;
    //protected WebDriverWait wait;

    public BasePage(WebDriver driver ) {
        this.driver = driver;
        //this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(getDriver(), this);
    }

    public String getPageTitle() {

        return getDriver().getTitle();
    }
}
