package com.prestashop.tests.functional_tests.login.negative;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test(groups = "regression")
    public void negativeLogin1(){
        extentLogger=report.createTest("Login Test Negative1");

        extentLogger.info("clicking on sign in");
        pages.homePage.signInButton.click();
        extentLogger.info("clicking on submit");
        pages.signInPage.submit.click();
        extentLogger.info("verifying error message");
        Assert.assertTrue(driver.findElement(By.xpath("//li[.='An email address required.']")).isDisplayed());
        extentLogger.info("PASSED- Login Test Negative1");
    }
    @Test(groups = "regression")
    public void negativeLogin2(){
        extentLogger=report.createTest("Login Test Negative2");

        extentLogger.info("clicking on sign in");
        pages.homePage.signInButton.click();
        extentLogger.info("signing in with invalid credentials");
        pages.signInPage.signIn("invalidUsername","invalidPassword");
        extentLogger.info("verifying error message");
        Assert.assertTrue(driver.findElement(By.xpath("//ol/li")).isDisplayed());
        extentLogger.info("PASSED- Login Test Negative2");
    }
}
