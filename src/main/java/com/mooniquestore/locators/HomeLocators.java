package com.mooniquestore.locators;

import org.json.JSONObject;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class HomeLocators extends AbstractLocator {
    public static final String HOME_JSON = "locators.json";
    private Map<String, JSONObject> locators;

    // Constructor to initialize the locators
    public HomeLocators(Path locatorRootDirectory) {
        super(locatorRootDirectory.toAbsolutePath().toString(), HOME_JSON);
        this.locators = loadLocators(locatorRootDirectory.resolve(HOME_JSON));
    }

    // Load locators from the JSON file
    private Map<String, JSONObject> loadLocators(Path jsonFilePath) {
        Map<String, JSONObject> locatorsMap = new HashMap<>();
        try {
            String content = new String(Files.readAllBytes(jsonFilePath)); // Read the whole file
            JSONObject jsonObject = new JSONObject(content);

            jsonObject.keys().forEachRemaining(key -> {
                locatorsMap.put(key, jsonObject.getJSONObject(key));
            });
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions appropriately
        }
        return locatorsMap;
    }

    // Get method to retrieve the By locator based on the enum key
    public By get(Key key) {
        JSONObject locator = locators.get(key.name()); // Use key.name()

        if (locator != null) {
            if (locator.has("xpath")) {
                return By.xpath(locator.getString("xpath"));
            } else if (locator.has("id")) {
                return By.id(locator.getString("id"));
            }
        }

        throw new IllegalArgumentException("Locator not found for key: " + key);
    }

    public enum Key {
        HOME_PAGE_ICON,
        SEARCH_ICON
    }
}