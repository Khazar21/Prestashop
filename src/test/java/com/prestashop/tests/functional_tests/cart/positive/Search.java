package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends TestBase {
    @Test(groups = "regression")
    public void search(){
        extentLogger= report.createTest("Search Test");

        extentLogger.info("clicking on sign in");
        pages.homePage.signInButton.click();
        extentLogger.info("signing in with valid credentials");
        pages.signInPage.signIn("username","password");
        extentLogger.info("serching item");
        pages.signInPage.search("searchItem1");
        extentLogger.info("verifying the search item name displayed correctly");
        Assert.assertEquals(pages.searchPage.searchResultDisplayed.
                getText().toLowerCase().replace("\"",""),ConfigurationReader.getProperty("searchItem1").toLowerCase());
        extentLogger.info("PASSED- Search Test");
    }
}
