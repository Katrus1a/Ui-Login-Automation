package com.epam.automation.bdd.hooks;

import com.epam.automation.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setUp(Scenario scenario) {
        logger.info("Starting scenario: {}", scenario.getName());
        DriverManager.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();

        if (driver != null) {
            if (scenario.isFailed()) {
                logger.error("Scenario failed: {}", scenario.getName());
                try {
                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Failure Screenshot");
                    logger.info("Screenshot captured and attached.");
                } catch (Exception e) {
                    logger.error("Failed to capture screenshot", e);
                }
            }

            DriverManager.quitDriver();
            logger.info("WebDriver quit after scenario: {}", scenario.getName());
        } else {
            logger.error("WebDriver was null at scenario end: {}", scenario.getName());
        }
    }
}
