package com.mooniquestore.automation;

import com.mooniquestore.CsvDataProvider;
import com.mooniquestore.pom.implementation.UserAccountPageImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mooniquestore.pom.implementation.LogInPageImpl;

import java.util.Map;

import static com.mooniquestore.Groups.LOGIN;

public class LoginTest extends MSBaseTest  {
    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class);

    @Test(dataProvider = "CsvDataProvider", dataProviderClass =  CsvDataProvider.class, groups = LOGIN)
    public void positiveLogInTest(Map<String, String> testData) {
        LogInPageImpl logInPageImpl = new LogInPageImpl(driver);
        UserAccountPageImpl userAccountPage = new UserAccountPageImpl(driver);

        //Step 1: Open Moonique Store Login page
        logInPageImpl.openLogInPage();
        //Step 2: Use email and password to log in
        logInPageImpl.fillUpEmailAndPassword("jafarzadehrashad@gmail.com", "Enver2018@!");
        //Step 3: Select Sign in Button and wait for page
        Assert.assertTrue(logInPageImpl.isSignInButtonDisplayed(), "SignIn button not displayed.");
        logInPageImpl.selectSignInButton();
        userAccountPage.waitPageUntilLoading();
        //Step 4: Verify Account page
        String accountName = userAccountPage.getAccountTitle();
        Assert.assertEquals(accountName, "Rashad" , "The account title doesn't match.");
    }


}
