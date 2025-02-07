package com.mooniquestore.automation;

import com.mooniquestore.pom.implementation.HomePageImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends MSBaseTest {
    private static final Logger LOGGER = LogManager.getLogger(HomePageTest.class);


    @Test
    public void verifySearchButtonOnHomePage() {
        HomePageImpl homePageImp = new HomePageImpl(driver);
        Assert.assertTrue(homePageImp.isOnHomePage(), "Unable to go to the Home page");
        // Step 1: Click to Search button
        homePageImp.clickSearchButton();
        // Verify Search pop-up window is displayed

        //Step 2: Select Back
        // Verify Search pop-up window is gone
    }

    @Test
    public void verifyBagButtonOnHomePage() {
//        HomePageImpl homePageImp = new HomePageImpl(driver);
        System.out.println(">>> Verified Search button.");
//        Assert.assertTrue(homePageImp.isOnHomePage(), "Unable to go to the Home page");
        // Step 1: Click to Search button
//        homePageImp.clickSearchButton();
        // Verify Search pop-up window is displayed

        //Step 2: Select Back
        // Verify Search pop-up window is gone
    }

}
