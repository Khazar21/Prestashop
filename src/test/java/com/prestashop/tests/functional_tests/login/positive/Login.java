package com.prestashop.tests.functional_tests.login.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {
     @Test
    public void loginPositive(){
         pages.homePage.signInButton.click();
         pages.signInPage.signIn("username","password");
       Assert.assertTrue(driver.getTitle().contains("My account"));
    }
}
