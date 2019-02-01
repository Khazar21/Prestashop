package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;
import com.prestashop.pages.OrderPage;
import com.prestashop.pages.SearchPage;
import com.prestashop.utilities.BrowserUtilities;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartCheckoutDeleteTest extends TestBase {
    @Test(groups = "regression")
    public void cartCheckoutDeleteTest() throws InterruptedException {
        extentLogger=report.createTest("Cart Checkout Delete Test");

        extentLogger.info("hovering over the item");
        actions.moveToElement(pages.searchPage.itemNumber(2)).perform();
        extentLogger.info("clicking on to add to cart");
        pages.searchPage.addToCart().click();
        extentLogger.info("clicking on to continue shopping");
        pages.itemPage.continueShopping.click();
        extentLogger.info("hovering over the item");
        actions.moveToElement(pages.searchPage.itemNumber(4)).perform();
        extentLogger.info("clicking on to add to cart");
        pages.searchPage.addToCart().click();
        BrowserUtilities.waitForClickability(pages.itemPage.proceedToCheckout);
        extentLogger.info("clicking on to proceed to checkout");
        pages.itemPage.proceedToCheckout.click();
        extentLogger.info("verifying correct count of item");
        Assert.assertEquals(pages.orderPage.cartItemCountInformation.getText(),"Your shopping cart contains: 2 Products");

        extentLogger.info("clicking on to icon trash");
        pages.orderPage.iconTrash(1).click();
        Thread.sleep(1000);
        extentLogger.info("verifying correct count of item");
        Assert.assertEquals(pages.orderPage.cartItemCountInformation.getText(),"Your shopping cart contains: 1 Product");

        extentLogger.info("clicking on to icon trash");
        Thread.sleep(1000);
        extentLogger.info("clicking on to icon trash");
        pages.orderPage.iconTrash(1).click();
        Thread.sleep(1000);
        extentLogger.info("verifying correct count of item");
        Assert.assertEquals(pages.orderPage.alertMessage.getText(),"Your shopping cart is empty.");
        extentLogger.info("PASSED- Cart Checkout Delete Test");
    }
}
