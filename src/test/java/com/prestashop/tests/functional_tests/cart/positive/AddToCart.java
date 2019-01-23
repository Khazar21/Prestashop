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
        homePage.openUrl();
        homePage.signInButton.click();
        signInPage.signIn("username", "password");
        signInPage.search("searchItem1");
        actions.moveToElement(searchPage.itemNumber(1)).perform();
        searchPage.addToCart().click();
        itemPage.controlClick.click();
        Assert.assertEquals(itemPage.itemNameTempWindow.getText(), ConfigurationReader.getProperty("searchItem1"));
        Assert.assertEquals(itemPage.itemQuantityTempWindow.getText(),"1");
        itemPage.continueShopping.click();
        actions.moveToElement(searchPage.itemNumber(1)).perform();
        searchPage.addToCart().click();
        itemPage.controlClick.click();
        Assert.assertEquals(itemPage.itemQuantityTempWindow.getText(),"2");
    }
}
