package com.epam.automation.testing;

import com.epam.automation.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        // Optional: This ensures cleanup per method if needed
        DriverManager.quitDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        // Ensures final cleanup after all tests
        DriverManager.quitDriver();
    }
}
