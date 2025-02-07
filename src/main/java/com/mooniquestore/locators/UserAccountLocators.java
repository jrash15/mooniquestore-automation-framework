package com.mooniquestore.locators;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class UserAccountLocators extends AbstractLocator {
    public static final String USER_PROFILE_JSON = "UserProfile.json";
    private static Map<String, JsonNode> locators;
    private Path locatorRootDirectory;

    public UserAccountLocators(Path locatorRootDirectory) {
        super(locatorRootDirectory.toAbsolutePath().toString());
        loadJson(locatorsDirectory());
    }

    private void loadJson(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            locators = mapper.readValue(new File(filePath), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load JSON file: " + filePath);
        }
    }

    private String locatorsDirectory() {
        return locatorRootDirectory + File.separator + USER_PROFILE_JSON;
    }

    public By get(Key key) {
        JsonNode node = locators.get(key.toString());
        return By.xpath(node.get("xpath").asText());
    }

    public enum Key {
        MY_PROFILE_TAB,
        ACCOUNT_OWNER_NAME
    }
}

