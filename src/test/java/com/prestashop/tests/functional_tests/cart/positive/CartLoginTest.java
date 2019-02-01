package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;
import com.prestashop.pages.SearchPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartLoginTest extends TestBase {
    @Test(groups = "regression")
    public void cartLoginTest(){
        actions.moveToElement(pages.searchPage.itemNumber(3)).perform();
        pages.searchPage.addToCart().click();
        pages.itemPage.continueShopping.click();
        actions.moveToElement(pages.itemPage.viewCart).perform();
        String cartItemName= pages.itemPage.cartItem.getAttribute("alt");
        pages.homePage.signInButton.click();
        pages.signInPage.signIn("username","password");
        actions.moveToElement(pages.itemPage.viewCart).perform();
        Assert.assertEquals(pages.itemPage.cartItem.getAttribute("alt"),cartItemName);
    }
}
