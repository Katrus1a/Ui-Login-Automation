package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By titleLabel = By.className("title");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return driver.findElement(titleLabel).getText();
    }

    public boolean isUserOnProductsPage() {
        return getTitleText().equalsIgnoreCase("Products");
    }
}
