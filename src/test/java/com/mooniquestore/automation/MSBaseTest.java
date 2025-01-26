package com.mooniquestore.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class MSBaseTest {
    protected WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(MSBaseTest.class);

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(String browser) {
        LOGGER.info("*** Before Method ***");
        driver.get("https://mooniquestore.com/");
    }

    @AfterMethod
    public void afterMethod() {
        LOGGER.info("*** Quit from Browser! ***");
        driver.quit();
    }
}
