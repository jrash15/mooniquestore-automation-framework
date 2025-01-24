package com.mooniquestore.automation;

import com.mooniquestore.CsvDataProvider;
import com.mooniquestore.pom.implementation.UserAccountPageImpl;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mooniquestore.pom.implementation.LogInPageImpl;

public class LoginTest extends MSBaseTest  {

    @Test(dataProvider = "CsvDataProvider", dataProviderClass =  CsvDataProvider.class)
    public void positiveLogInTest() {
        LogInPageImpl logInPageImpl = new LogInPageImpl(driver);
        UserAccountPageImpl userAccountPage = new UserAccountPageImpl(driver);

        //Step 1: Open Moonique Store Login page
        logInPageImpl.openLogInPage();
        //Step 2: Use email and password to log in
        logInPageImpl.fillUpEmailAndPassword("jafarzadehrashad@gmail.com", "Enver2018@!");
        //Step 3: Select Sign in Button and wait for page
        logInPageImpl.selectSignInButton();
        userAccountPage.waitPageUntilLoading();
        //Step 4: Verify Account page
        String accountName = userAccountPage.getAccountTitle();
        Assert.assertEquals(accountName, "Rashad" , "The account title doesn't match.");
    }


}
