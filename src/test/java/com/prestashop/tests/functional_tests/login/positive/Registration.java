package com.prestashop.tests.functional_tests.login.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.RegistrationPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Registration extends TestBase {
    @Test(groups = "regression")
    public void registration1(){
        extentLogger=report.createTest("Registration Test Positive");

        extentLogger.info("clicking on sign in");
        pages.homePage.signInButton.click();
        extentLogger.info("entering valid fake email address");
        pages.signInPage.signUpEmail.sendKeys(RegistrationPage.emailToVerify=BrowserUtilities.fakerBase("fakeEmailAddress"));
        extentLogger.info("clicking on create account button");
        pages.signInPage.createAccountButton.click();
        extentLogger.info("filling mandatory fields and registering");
        pages.registrationPage.register();
        extentLogger.info("verifying the title of opened page");
        Assert.assertTrue(driver.getTitle().contains("My account"));
        Assert.assertEquals(pages.registrationPage.firstAndLastNameAfterReg.getText(),
                            RegistrationPage.firstNameToVerify+" "+RegistrationPage.lastNameToVerify);
        System.out.println("Sign in credentials:\n"+ RegistrationPage.firstNameToVerify+
                "\n"+RegistrationPage.lastNameToVerify+ "\n"+RegistrationPage.emailToVerify+
                "\n"+"Password: "+RegistrationPage.passwordToVerify);
        extentLogger.info("PASSED- Registration Test Positive");
    }
}
