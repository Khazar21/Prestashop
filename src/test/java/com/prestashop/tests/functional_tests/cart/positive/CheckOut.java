package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;
import com.prestashop.pages.SearchPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOut extends TestBase {
    @Test
    public void checkOut() throws InterruptedException {
        pages.homePage.signInButton.click();
        pages.signInPage.signIn("username","password");
        pages.signInPage.search("searchItem1");
        actions.moveToElement(pages.searchPage.itemNumber(1)).perform();
        pages.searchPage.addToCart().click();
        pages.itemPage.proceedToCheckout.click();
        pages.searchPage.proceedToCheckoutInSummary.click();
        pages.searchPage.proceedToCheckoutInAddress.click();
        pages.searchPage.proceedToCheckoutInShipping.click();
        Assert.assertTrue(pages.searchPage.error_YouMustAgree.getText().contains("You must agree"));
        pages.searchPage.closeErrorMessage.click();
        Thread.sleep(1000);
        pages.searchPage.checkBox_IAgree.click();
        pages.searchPage.proceedToCheckoutInShipping.click();
        pages.searchPage.payByCheck.click();
        pages.searchPage.confirmOrder.click();
        Assert.assertTrue(pages.searchPage.orderPlacedSuccessMessage.getText().contains("is complete"));
    }
}
