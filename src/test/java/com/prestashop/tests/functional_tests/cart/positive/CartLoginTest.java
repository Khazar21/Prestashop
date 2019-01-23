package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;
import com.prestashop.pages.SearchPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartLoginTest extends TestBase {
    @Test
    public void cartLoginTest(){
        homePage.openUrl();
        actions.moveToElement(searchPage.itemNumber(3)).perform();
        searchPage.addToCart().click();
        itemPage.continueShopping.click();
        actions.moveToElement(itemPage.viewCart).perform();
        String cartItemName= itemPage.cartItem.getAttribute("alt");
        homePage.signInButton.click();
        signInPage.signIn("username","password");
        actions.moveToElement(itemPage.viewCart).perform();
        Assert.assertEquals(itemPage.cartItem.getAttribute("alt"),cartItemName);
    }
}
