package com.prestashop.tests.smoke_tests;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.IdentityPage;
import com.prestashop.pages.MyAccountPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Account extends TestBase {
    @Test
    public  void smokeTestAccount(){
        pages.homePage.signInButton.click();
        pages.signInPage.signIn("username", "password");
        Assert.assertTrue(driver.getTitle().contains("My account"));
        Assert.assertTrue(pages.myAccountPage.signedInUser.isDisplayed());
        pages.myAccountPage.information.click();

        Assert.assertTrue(driver.getTitle().contains("Identity"));
        Assert.assertEquals(pages.identityPage.firstName.getAttribute("value")+" "+pages.identityPage.lastName.getAttribute("value"),
                pages.myAccountPage.signedInUser.getText());
        pages.identityPage.save.click();

        Assert.assertTrue(pages.identityPage.errorMessage.isDisplayed());

        pages.identityPage.backToAccount.click();

        Assert.assertTrue(driver.getTitle().contains("My account"));

        pages.myAccountPage.myAddresses.click();

        driver.findElement(By.xpath("//span[.='Add a new address']/..")).click();
        Assert.assertEquals(pages.identityPage.firstName.getAttribute("value")+" "+pages.identityPage.lastName.getAttribute("value"),
                pages.myAccountPage.signedInUser.getText());
        pages.identityPage.firstName.clear();
        driver.findElement(By.id("submitAddress")).click();
    Assert.assertTrue(pages.identityPage.errorMessage.isDisplayed());

    }
}
