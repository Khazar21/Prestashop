package com.prestashop.tests.smoke_tests;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.IdentityPage;
import com.prestashop.pages.MyAccountPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Account extends TestBase {
    @Test(groups = "smoke")
    public  void smokeTestAccount(){
        extentLogger= report.createTest("Smoke Test- Account");

        extentLogger.info("clicking on sign in button");
        pages.homePage.signInButton.click();
        extentLogger.info("signing in with valid credentials");
        pages.signInPage.signIn("username", "password");
        extentLogger.info("verifying page title and displayed user name");
        Assert.assertTrue(driver.getTitle().contains("My account"));
        Assert.assertTrue(pages.myAccountPage.signedInUser.isDisplayed());

        extentLogger.info("clicking on information");
        pages.myAccountPage.information.click();
        extentLogger.info("verifying page title and  user's first and last name ");
        Assert.assertTrue(driver.getTitle().contains("Identity"));
        Assert.assertEquals(pages.identityPage.firstName.getAttribute("value")+" "+pages.identityPage.lastName.getAttribute("value"),
                pages.myAccountPage.signedInUser.getText());

        extentLogger.info("clicking on save");
        pages.identityPage.save.click();
        extentLogger.info("verifying error message");
        Assert.assertTrue(pages.identityPage.errorMessage.isDisplayed());

        extentLogger.info("clicking on back to account");
        pages.identityPage.backToAccount.click();
        extentLogger.info("verifying page title");
        Assert.assertTrue(driver.getTitle().contains("My account"));

        extentLogger.info("clicking on my adresses");
        pages.myAccountPage.myAddresses.click();
        extentLogger.info("clicking on add a new address");
        pages.myAccountPage.addANewAddress.click();
        extentLogger.info("verifying first and last name");
        Assert.assertEquals(pages.identityPage.firstName.getAttribute("value")+" "+pages.identityPage.lastName.getAttribute("value"),
                pages.myAccountPage.signedInUser.getText());

        extentLogger.info("clearing first name box");
        pages.identityPage.firstName.clear();
        extentLogger.info("clicking on save");
        pages.myAccountPage.saveNewAddress.click();
        extentLogger.info("verifying error message");
        Assert.assertTrue(pages.identityPage.errorMessage.isDisplayed());
        extentLogger.info("PASS- Smoke Test- Account");


    }
}
