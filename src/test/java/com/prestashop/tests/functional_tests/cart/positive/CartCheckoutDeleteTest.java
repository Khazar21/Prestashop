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
        actions.moveToElement(pages.searchPage.itemNumber(2)).perform();
        pages.searchPage.addToCart().click();
        pages.itemPage.continueShopping.click();
        actions.moveToElement(pages.searchPage.itemNumber(4)).perform();
        pages.searchPage.addToCart().click();
        BrowserUtilities.waitForClickability(pages.itemPage.proceedToCheckout);
        pages.itemPage.proceedToCheckout.click();
        Assert.assertEquals(pages.orderPage.cartItemCountInformation.getText(),"Your shopping cart contains: 2 Products");
        pages.orderPage.iconTrash(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(pages.orderPage.cartItemCountInformation.getText(),"Your shopping cart contains: 1 Product");
        Thread.sleep(1000);
        pages.orderPage.iconTrash(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(pages.orderPage.alertMessage.getText(),"Your shopping cart is empty.");
    }
}
