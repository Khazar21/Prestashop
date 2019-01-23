package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SearchPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartLoginTest extends TestBase {
    @Test
    public void cartLoginTest(){
        HomePage homePage= new HomePage();
        SignInPage signInPage= new SignInPage();
        SearchPage searchPage= new SearchPage();
        homePage.openUrl();
        actions.moveToElement(searchPage.itemNumber(3)).perform();
        searchPage.addToCart().click();
        searchPage.continueShopping.click();
        actions.moveToElement(searchPage.viewCart).perform();
        String cartItemName= searchPage.cartItem.getAttribute("alt");
        homePage.signInButton.click();
        signInPage.signIn("username","password");
        actions.moveToElement(searchPage.viewCart).perform();
        Assert.assertEquals(searchPage.cartItem.getAttribute("alt"),cartItemName);
    }
}
