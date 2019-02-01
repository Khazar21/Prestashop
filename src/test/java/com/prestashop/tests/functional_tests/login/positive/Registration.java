package com.prestashop.tests.functional_tests.login.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.RegistrationPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Registration extends TestBase {
    @Test
    public void registration1(){
        homePage.openUrl();
        homePage.signInButton.click();
        signInPage.signUpEmail.sendKeys(RegistrationPage.emailToVerify=BrowserUtilities.fakerBase("fakeEmailAddress"));
        signInPage.createAccountButton.click();
        registrationPage.register();
        Assert.assertTrue(driver.getTitle().contains("My account"));
        Assert.assertEquals(driver.findElement(By.xpath("//a[@title='View my customer account']//span")).getText(),
                            RegistrationPage.firstNameToVerify+" "+RegistrationPage.lastNameToVerify);
        System.out.println("Sign in credentials:\n"+ RegistrationPage.firstNameToVerify+
                "\n"+RegistrationPage.lastNameToVerify+ "\n"+RegistrationPage.emailToVerify+
                "\n"+"Password: "+RegistrationPage.passwordToVerify);
    }
}
