package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;
import com.prestashop.pages.SearchPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.BrowserUtilities;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends TestBase {
    @Test(groups = "regression")
    public void addToCart(){
        extentLogger= report.createTest("addToCart");

        extentLogger.info("click on sign in");
        pages.homePage.signInButton.click();
        extentLogger.info("signing in with valid credentias");
        pages.signInPage.signIn("username", "password");
        extentLogger.info("searching item");
        pages.signInPage.search("searchItem1");
        extentLogger.info("hovering over item");
        actions.moveToElement(pages.searchPage.itemNumber(1)).perform();
        extentLogger.info("clicking on add to cart");
        pages.searchPage.addToCart().click();
        pages.itemPage.controlClick.click();
        extentLogger.info("verifying item name and quantity");
        Assert.assertEquals(pages.itemPage.itemNameTempWindow.getText(), ConfigurationReader.getProperty("searchItem1"));
        Assert.assertEquals(pages.itemPage.itemQuantityTempWindow.getText(),"1");

        extentLogger.info("clicking on continue shopping");
        pages.itemPage.continueShopping.click();
        extentLogger.info("hovering over item");
        actions.moveToElement(pages.searchPage.itemNumber(1)).perform();
        extentLogger.info("clicking on add to cart");
        pages.searchPage.addToCart().click();
        pages.itemPage.controlClick.click();
        extentLogger.info("verifying item quantity");
        Assert.assertEquals(pages.itemPage.itemQuantityTempWindow.getText(),"2");
    }
}
