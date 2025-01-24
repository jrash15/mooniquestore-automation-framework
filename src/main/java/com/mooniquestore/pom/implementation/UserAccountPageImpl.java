package com.mooniquestore.pom.implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAccountPageImpl extends BasePageObject {
    private By myProfileTab = By.xpath("//span[contains(text(),'My profile')]");
    private By accountHolderName = By.xpath("//div[@class='frcp-nav__first-name']");

    public UserAccountPageImpl(WebDriver driver) {
        super(driver);
    }

    public void waitPageUntilLoading() {
        waitForPageLoading(myProfileTab);
        waitForPageLoading(accountHolderName, 10);
    }

    public String getAccountTitle() {
        return driver.findElement(accountHolderName).getText();
    }
}
