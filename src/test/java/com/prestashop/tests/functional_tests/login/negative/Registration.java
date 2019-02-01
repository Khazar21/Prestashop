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
        pages.homePage.signInButton.click();
          //          //input invalid email type
        pages.signInPage.signUpEmail.sendKeys("asdf");
        pages.signInPage.createAccountButton.click();
          Assert.assertTrue(driver.findElement(By.xpath("//li[.='Invalid email address.']")).isDisplayed());
      }
    @Test(groups = "regression")
    public void registration2(){
        pages.homePage.signInButton.click();
        //input valid email address but already registered one.
        pages.signInPage.signUpEmail.sendKeys("a111@gmail.com");
        pages.signInPage.createAccountButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'has already been registered')]")).isDisplayed());
    }
}
