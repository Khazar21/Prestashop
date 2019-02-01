package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;
import com.prestashop.pages.SearchPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartIconDeleteTest extends TestBase {
    @Test(groups = "regression")
    public void cartIconDeleteTest(){
        extentLogger=report.createTest("Cart Icon Delete Test");

        extentLogger.info("hovering over item");
        actions.moveToElement(pages.searchPage.itemNumber(3)).perform();
        extentLogger.info("clicking on add to cart");
        pages.searchPage.addToCart().click();
        extentLogger.info("clicking on continue shopping");
        pages.itemPage.continueShopping.click();
        extentLogger.info("clicking on view cart");
        actions.moveToElement(pages.itemPage.viewCart).perform();
        extentLogger.info("clicking on icon delete button");
        pages.itemPage.cartIconDeleteButton().click();
        WebDriverWait wait= new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.textToBePresentInElement(pages.itemPage.cartIconProductCount,"(empty)"));
        extentLogger.info("verifying empty value of cart");
        Assert.assertEquals(pages.itemPage.cartIconProductCount.getText(),"(empty)");
        extentLogger.info("PASSED- Cart Icon Delete Test");
    }
}
