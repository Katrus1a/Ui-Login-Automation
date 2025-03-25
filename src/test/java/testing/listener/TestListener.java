package com.epam.automation.testing.listener;

import com.epam.automation.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TestListener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);
    private static final String SCREENSHOTS_DIR = "target/screenshots/";

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("TEST FAILED: {}", result.getName());

        WebDriver driver = DriverManager.getDriver();
        if (driver == null) {
            logger.error("WebDriver is null — screenshot skipped");
            return;
        }

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(SCREENSHOTS_DIR + result.getName() + ".png");

        try {
            Files.createDirectories(destination.getParentFile().toPath());
            Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            logger.info(" Screenshot saved: {}", destination.getAbsolutePath());
        } catch (IOException e) {
            logger.error("Failed to save screenshot", e);
        }
    }

    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestSuccess(ITestResult result) {}
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
}
