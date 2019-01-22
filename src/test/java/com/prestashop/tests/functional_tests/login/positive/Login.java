package com.prestashop.tests.functional_tests.login.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {
     @Test
    public void loginPositive(){
         HomePage homePage= new HomePage();
         SignInPage signInPage= new SignInPage();
         homePage.openUrl();
         homePage.signInButton.click();
         signInPage.signIn("username","password");
       Assert.assertTrue(driver.getTitle().contains("My account"));
    }
}
