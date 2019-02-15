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
    @Test
     public void loginPositiveWithDDT(){
         for (int i = 0; i < testDataSignIn.size() ; i++) {

              extentLogger = report.createTest("Login Test Positive");

              extentLogger.info("clicking on sign in");
              pages.homePage.signInButton.click();
              extentLogger.info("signing in using data from xlsx file");
              pages.signInPage.signInEmail.sendKeys(testDataSignIn.get(i).get("email"));
              pages.signInPage.password.sendKeys(testDataSignIn.get(i).get("password"));
              extentLogger.info("clicking on submit");
              pages.signInPage.submit.click();
              extentLogger.info("Verifying name with xlsx file");
              Assert.assertEquals(pages.registrationPage.firstAndLastNameAfterReg.getText(),
                      testDataSignUp.get(i).get("first name")+" "+ testDataSignUp.get(i).get("last name"));
              extentLogger.info("clicking on sign out");
              pages.myAccountPage.signOut.click();
         }
         extentLogger.info("PASSED- Login DDT Positive");
    }
}
