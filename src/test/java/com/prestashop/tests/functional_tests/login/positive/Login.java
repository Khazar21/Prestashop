package com.prestashop.tests.functional_tests.login.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {
     @Test(groups = "regression")
    public void loginPositive(){
         extentLogger=report.createTest("Login Test Positive");

         extentLogger.info("clicking on sign in");
         pages.homePage.signInButton.click();
         extentLogger.info("signing in with valid credentials");
         pages.signInPage.signIn("username","password");
         extentLogger.info("verifying page title");
         Assert.assertTrue(driver.getTitle().contains("My account"));
         extentLogger.info("PASSED- Login Test Positive");
    }
}
