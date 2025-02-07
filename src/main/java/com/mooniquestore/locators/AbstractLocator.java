package com.mooniquestore.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLocator {
    private WebDriver driver;
    private String locatorFilePath;
    private Map<String, JSONObject> locators;

    protected AbstractLocator(String locatorRootDirectory, Enum key, String jsonFileName) {
        this.locators = loadLocators(locatorRootDirectory, jsonFileName);
    }

    public AbstractLocator(String string) {
    }

    private Map<String, JSONObject> loadLocators(String rootDirectory, String jsonFileName) {
        Map<String, JSONObject> locatorsMap = new HashMap<>();
        try {
            Path path = Path.of(rootDirectory, jsonFileName);
            String content = Files.readString(path);
            JSONObject jsonObject = new JSONObject(content);
            jsonObject.keys().forEachRemaining(key -> locatorsMap.put(key, jsonObject.getJSONObject(key)));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception (log error or throw a custom exception)
        }
        return locatorsMap;
    }

    protected By getLocator(Enum<?> key) {
        JSONObject locator = locators.get(key.toString());
        if (locator != null) {
            String locatorType = locator.has("xpath") ? "xpath" : locator.has("id") ? "id" : locator.has("className") ? "className" : null;
            String locatorValue = locator.has("xpath") ? locator.getString("xpath") : locator.has("id") ? locator.getString("id") : locator.has("className") ? locator.getString("className") : null;

            if ("xpath".equals(locatorType)) {
                return By.xpath(locatorValue);
            } else if ("id".equals(locatorType)) {
                return By.id(locatorValue);
            } else if ("className".equals(locatorType)) {
                return By.className(locatorValue);
            }
        }
        throw new IllegalArgumentException("Locator not found for key: " + key);
    }

    protected WebElement findElement(Enum<?> key) {
        return driver.findElement(getLocator(key));
    }

    // Optionally allow setting the WebDriver
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
