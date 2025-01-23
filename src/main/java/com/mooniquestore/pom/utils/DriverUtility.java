package com.mooniquestore.pom.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class DriverUtility {
    private WebDriver driver;

    public DriverUtility(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Checks if a given element is displayed using its By locator.
     *
     * @param by the By locator for the element
     * @return true if the element is displayed, false otherwise
     */
    public boolean isDisplayed(By by) {
        try {
            WebElement element = driver.findElement(by); // Find the element using the By locator
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false; // If the element is not found or is no longer attached, return false
        }
    }

    public String getText(By by) {
        try {
            WebElement element = driver.findElement(by); // Find the element using the By locator
            return element.getText();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return ""; // Return an empty string if the element is not found or if it becomes stale
        }
    }

    /**
     * Click on an element based on the By locator.
     *
     * @param by the By locator for the clickable element
     */
    public void select(By by) {
        try {
            WebElement clickableElement = driver.findElement(by); // Find the element
            clickableElement.click(); // Perform the click action
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            e.printStackTrace(); // Log the exception
            // Handle the error as needed
        }
    }
}
