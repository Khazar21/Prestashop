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
        extentLogger= report.createTest("Cart Login Test");

        extentLogger.info("hovering over item");
        actions.moveToElement(pages.searchPage.itemNumber(3)).perform();
        extentLogger.info("clicking on add to cart");
        pages.searchPage.addToCart().click();
        extentLogger.info("clicking on continue shopping");
        pages.itemPage.continueShopping.click();
        extentLogger.info("clicking on view cart");
        actions.moveToElement(pages.itemPage.viewCart).perform();
        extentLogger.info("saving item name");
        String cartItemName= pages.itemPage.cartItem.getAttribute("alt");
        extentLogger.info("clicking on sign in");
        pages.homePage.signInButton.click();
        extentLogger.info("signing in with valid credentials");
        pages.signInPage.signIn("username","password");
        extentLogger.info("hovering over the cart icon");
        actions.moveToElement(pages.itemPage.viewCart).perform();
        extentLogger.info("verifying item name");
        Assert.assertEquals(pages.itemPage.cartItem.getAttribute("alt"),cartItemName);
        extentLogger.info("PASSED- Cart Login Test");
    }
}
