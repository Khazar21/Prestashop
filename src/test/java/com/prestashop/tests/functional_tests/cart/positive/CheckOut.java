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
    @Test(groups = "regression")
    public void checkOut() throws InterruptedException {
        extentLogger= report.createTest("Checkout Test");

        extentLogger.info("clicking on sign in");
        pages.homePage.signInButton.click();
        extentLogger.info("signing in with valid credentials");
        pages.signInPage.signIn("username","password");
        extentLogger.info("serching item");
        pages.signInPage.search("searchItem1");
        extentLogger.info("hovering over item");
        actions.moveToElement(pages.searchPage.itemNumber(1)).perform();
        extentLogger.info("clicking on add to cart");
        pages.searchPage.addToCart().click();
        extentLogger.info("clicking on proceed to checkout");
        pages.itemPage.proceedToCheckout.click();
        extentLogger.info("clicking on proceed to checkout");
        pages.searchPage.proceedToCheckoutInSummary.click();
        extentLogger.info("clicking on proceed to checkout");
        pages.searchPage.proceedToCheckoutInAddress.click();
        extentLogger.info("clicking on proceed to checkout");
        pages.searchPage.proceedToCheckoutInShipping.click();
        extentLogger.info("verifying error message");
        Assert.assertTrue(pages.searchPage.error_YouMustAgree.getText().contains("You must agree"));
        extentLogger.info("clicking on error close button");
        pages.searchPage.closeErrorMessage.click();
        Thread.sleep(1000);
        extentLogger.info("checking the box I Agree");
        pages.searchPage.checkBox_IAgree.click();
        extentLogger.info("clicking on proceed to checkout");
        pages.searchPage.proceedToCheckoutInShipping.click();
        extentLogger.info("clicking on pay by check");
        pages.searchPage.payByCheck.click();
        extentLogger.info("clicking on confirm order");
        pages.searchPage.confirmOrder.click();
        extentLogger.info("verifying completion message");
        Assert.assertTrue(pages.searchPage.orderPlacedSuccessMessage.getText().contains("is complete"));
        extentLogger.info("PASSED- Checkout Test");
    }
}
