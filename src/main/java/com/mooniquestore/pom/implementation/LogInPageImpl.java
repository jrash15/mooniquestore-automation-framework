package com.mooniquestore.pom.implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.mooniquestore.pom.implementation.BasePageObject;

public class LogInPageImpl extends BasePageObject<LogInPageImpl> {
    private static final String URL = "https://mooniquestore.com/account/login?error=login_required";

    private By emailField = By.xpath("//input[@id='CustomerEmail']");
    private By passwordField = By.xpath("//input[@id='CustomerPassword']");
    private By signInButton = By.xpath("//button[normalize-space()='Sign in']");

    public LogInPageImpl(WebDriver driver) {
        super(driver);
    }

    public void openLogInPage() {
        getPage(URL);
    }

    public void fillUpEmailAndPassword(String email, String password) {
        type(email, emailField);
        type(email, passwordField);
    }


    public UserAccountPageImpl selectSignInButton() {
        select(signInButton);
        return new UserAccountPageImpl(driver);
    }



}
