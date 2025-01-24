package com.mooniquestore.pom.implementation;

import org.openqa.selenium.WebDriver;

import java.nio.file.Path;

public abstract class MSBasePage {
    protected WebDriver driver; // Standard WebDriver instance
    protected Path locatorFile;

    public static final String HOME_PAGE = "homePage";
    public static final String CHROME_DRIVER = "chromeDriver"; // Constant for Chrome driver
    public static final String LOCATOR_PATH = "locatorPath";

    // Constructor
    protected MSBasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Common method to navigate to a URL
    protected void navigateTo(String url) {
        driver.get(url);
    }

    // Common method to return the title of the page
    protected String getPageTitle() {
        return driver.getTitle();
    }

    // Method to return the WebDriver instance
    protected WebDriver getDriver() {
        return this.driver;
    }
}