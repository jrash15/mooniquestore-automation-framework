package com.mooniquestore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browser) {
        WebDriver driver;

        switch (browser) {
            case "safari":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/...");
                driver = new SafariDriver();
                break;

            case "fireFox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/...");
                driver = new ChromeDriver();
                break;

            default:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
