package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.OrderPage;
import com.prestashop.pages.SearchPage;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartCheckoutDeleteTest extends TestBase {
    @Test
    public void cartCheckoutDeleteTest() throws InterruptedException {
        HomePage homePage= new HomePage();
        SearchPage searchPage= new SearchPage();
        OrderPage orderPage= new OrderPage();
        homePage.openUrl();
        actions.moveToElement(searchPage.itemNumber(2)).perform();
        searchPage.addToCart().click();
        searchPage.continueShopping.click();
        actions.moveToElement(searchPage.itemNumber(4)).perform();
        searchPage.addToCart().click();
        searchPage.proceedToCheckout.click();
        Assert.assertEquals(orderPage.cartItemCountInformation.getText(),"Your shopping cart contains: "+OrderPage.count+" Products");
        orderPage.iconTrash(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(orderPage.cartItemCountInformation.getText(),"Your shopping cart contains: "+OrderPage.count+" Product");
        orderPage.iconTrash(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(orderPage.alertMessage.getText(),"Your shopping cart is empty.");
    }
}
