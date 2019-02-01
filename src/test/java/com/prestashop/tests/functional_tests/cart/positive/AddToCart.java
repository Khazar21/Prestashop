package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;
import com.prestashop.pages.SearchPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends TestBase {
    @Test
    public void addToCart(){

        pages.homePage.signInButton.click();
        pages.signInPage.signIn("username", "password");
        pages.signInPage.search("searchItem1");
        actions.moveToElement(pages.searchPage.itemNumber(1)).perform();
        pages.searchPage.addToCart().click();
        pages.itemPage.controlClick.click();
        Assert.assertEquals(pages.itemPage.itemNameTempWindow.getText(), ConfigurationReader.getProperty("searchItem1"));
        Assert.assertEquals(pages.itemPage.itemQuantityTempWindow.getText(),"1");
        pages.itemPage.continueShopping.click();
        actions.moveToElement(pages.searchPage.itemNumber(1)).perform();
        pages.searchPage.addToCart().click();
        pages.itemPage.controlClick.click();
        Assert.assertEquals(pages.itemPage.itemQuantityTempWindow.getText(),"2");
    }
}
