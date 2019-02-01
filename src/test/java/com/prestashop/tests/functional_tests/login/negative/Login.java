package com.prestashop.tests.functional_tests.login.negative;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test
    public void negativeLogin1(){
        pages.homePage.signInButton.click();
        pages.signInPage.submit.click();
        Assert.assertTrue(driver.findElement(By.xpath("//li[.='An email address required.']")).isDisplayed());
    }
    @Test
    public void negativeLogin2() throws InterruptedException {
        pages.homePage.signInButton.click();
        pages.signInPage.signIn("invalidUsername","invalidPassword");
        Assert.assertTrue(driver.findElement(By.xpath("//ol/li")).isDisplayed());
    }
}
