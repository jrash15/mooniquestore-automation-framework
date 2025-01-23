package com.mooniquestore.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MSDriver {
    private WebDriver webDriver;

    public MSDriver() {
        // Initialize the ChromeDriver or other drivers as needed
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        this.webDriver = new ChromeDriver();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void quit() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
