package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
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
        HomePage homePage= new HomePage();
        SignInPage signInPage= new SignInPage();
        SearchPage searchPage= new SearchPage();
        homePage.openUrl();
        homePage.signInButton.click();
        signInPage.signIn("username", "password");
        signInPage.search("searchItem1");
        actions.moveToElement(searchPage.itemNumber(1)).perform();
        searchPage.addToCart().click();
        searchPage.controlClick.click();
        Assert.assertEquals(searchPage.itemName.getText(), ConfigurationReader.getProperty("searchItem1"));
        Assert.assertEquals(searchPage.itemQuantity.getText(),"1");
        searchPage.continueShopping.click();
        actions.moveToElement(searchPage.itemNumber(1)).perform();
        searchPage.addToCart().click();
        searchPage.controlClick.click();
        Assert.assertEquals(searchPage.itemQuantity.getText(),"2");
    }
}
