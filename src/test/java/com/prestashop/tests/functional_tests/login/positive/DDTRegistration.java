package com.prestashop.tests.functional_tests.login.positive;

import com.prestashop.pages.RegistrationPage;
import com.prestashop.utilities.BrowserUtilities;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DDTRegistration extends TestBase {
    @Test
    public void ddtSignUp() throws IOException {
        for (int i = 0; i < testDataSignUp.size() ; i++) {


            extentLogger = report.createTest("Registration Test Positive");

            extentLogger.info("clicking on sign in");
            pages.homePage.signInButton.click();
            extentLogger.info("entering valid fake email address");
            pages.signInPage.signUpEmail.sendKeys(RegistrationPage.emailToVerify = BrowserUtilities.fakerBase("fakeEmailAddress"));
            extentLogger.info("clicking on create account button");
            pages.signInPage.createAccountButton.click();
            extentLogger.info("filling mandatory fields and registering");
            pages.registrationPage.registerWithDD(i);
            Assert.assertTrue(driver.getTitle().contains("My account"));
            Assert.assertEquals(pages.registrationPage.firstAndLastNameAfterReg.getText(),
                    testDataSignUp.get(i).get("first name")+" "+ testDataSignUp.get(i).get("last name"));
            extentLogger.info("PASSED- Registration Test Positive");
            pages.myAccountPage.signOut.click();
            excelUtilOut.setCellData(RegistrationPage.emailToVerify,i+1,0);
            excelUtilOut.setCellData(testDataSignUp.get(i).get("password"),i+1,1);
            extentLogger.info("Created xlsx file with the valid credentials in it");
        }

    }
}
