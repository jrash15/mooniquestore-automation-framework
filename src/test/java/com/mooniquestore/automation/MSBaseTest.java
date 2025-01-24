package com.mooniquestore.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MSBaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://mooniquestore.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
