package com.mooniquestore.pom.implementation;

import com.mooniquestore.locators.HomeLocators;
import com.mooniquestore.pom.HomePage;
import com.mooniquestore.pom.utils.DriverUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageImpl extends MSBasePage implements HomePage {
    private static final Logger LOGGER = LogManager.getLogger(HomePageImpl.class);
    private HomeLocators homeLocators;
    private DriverUtility driver;


    public HomePageImpl(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOnHomePage() {
//        LOGGER.info("Verifying if on home page icon...");
        return driver.isDisplayed(By.xpath("//*[@class='header__icon header__icon--account link focus-inset small-hide']"));
//        return driver.isDisplayed(homeLocators.get(HomeLocators.Key.HOME_PAGE_ICON));
    }

    @Override
    public void clickSearchButton() {
//        LOGGER.info("Clicking to search icon...");
        driver.select(homeLocators.get(HomeLocators.Key.SEARCH_ICON));
    }
}