package com.prestashop.tests.functional_tests.login.negative;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration extends TestBase {
    @Test(groups = "regression")
    public void registration1(){
        extentLogger= report.createTest("Registration Test Negative1");

        extentLogger.info("clicking on sign in");
        pages.homePage.signInButton.click();
        extentLogger.info("entering invalid email address");
        pages.signInPage.signUpEmail.sendKeys("asdf");
        extentLogger.info("clicking on create account button");
        pages.signInPage.createAccountButton.click();
        extentLogger.info("verifying error message");
        Assert.assertTrue(driver.findElement(By.xpath("//li[.='Invalid email address.']")).isDisplayed());
        extentLogger.info("PASSED- Registration Test Negative1");
      }
    @Test(groups = "regression")
    public void registration2(){
        extentLogger= report.createTest("Registration Test Negative2");

        extentLogger.info("clicking on sign in");
        pages.homePage.signInButton.click();
        extentLogger.info("input valid email address but already registered one");
        pages.signInPage.signUpEmail.sendKeys("a111@gmail.com");
        extentLogger.info("clicking on create account button");
        pages.signInPage.createAccountButton.click();
        extentLogger.info("verifying error message");
        Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'has already been registered')]")).isDisplayed());
        extentLogger.info("PASSED- Registration Test Negative2");
    }
}
