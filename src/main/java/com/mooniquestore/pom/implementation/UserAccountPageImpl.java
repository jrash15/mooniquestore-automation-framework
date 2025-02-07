package com.mooniquestore.pom.implementation;

import com.mooniquestore.locators.UserAccountLocators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.file.Path;

public class UserAccountPageImpl extends BasePageObject {
    private static final Logger LOGGER = LogManager.getLogger(UserAccountPageImpl.class);
    protected UserAccountLocators userAccountLocators;

    public UserAccountPageImpl(WebDriver driver) {
        super(driver);
        userAccountLocators = new UserAccountLocators(Path.of("src/main/resources/locators/UserProfile.json"));
    }

    public void waitPageUntilLoading() {
        LOGGER.info("*** Wait User Account Page is loaded ***");
        waitForPageLoading(userAccountLocators.get(UserAccountLocators.Key.MY_PROFILE_TAB));
        waitForPageLoading(userAccountLocators.get(UserAccountLocators.Key.ACCOUNT_OWNER_NAME), 10);
    }

    public String getAccountTitle() {
        return driver.findElement(userAccountLocators.get(UserAccountLocators.Key.ACCOUNT_OWNER_NAME)).getText();
    }
}
