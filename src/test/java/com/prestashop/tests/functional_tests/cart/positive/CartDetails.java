package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;
import com.prestashop.pages.SearchPage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartDetails extends TestBase {
    @Test(groups = "regression")
    public void cartTest(){
        extentLogger= report.createTest("Cart Details Test");

        extentLogger.info("clicking on sign in");
        pages.homePage.signInButton.click();
        extentLogger.info("maximizing window");
        driver.manage().window().maximize();
        extentLogger.info("signing in with valid credentials");
        pages.signInPage.signIn("username","password");
        extentLogger.info("serching item");
        pages.signInPage.search("searchItem1");
        extentLogger.info("hovering over item");
        actions.moveToElement(pages.searchPage.itemNumber(1)).perform();
        extentLogger.info("clicking on 'MORE' button");
        pages.searchPage.moreButton().click();
        extentLogger.info("clearing quantity box");
        pages.itemPage.quantity.clear();
        extentLogger.info("inputting value 3");
        pages.itemPage.quantity.sendKeys("3");
        extentLogger.info("selecting 3nd option on dropdown");
        Select select= new Select(pages.itemPage.size);
        select.selectByIndex(2);
        extentLogger.info("clicking on add to cart");
        pages.itemPage.addToCardInItemPage.click();
        pages.itemPage.controlClick.click();
        extentLogger.info("verifying success message");
        Assert.assertTrue(pages.itemPage.successMessage.getText().contains("successfully added"));

        extentLogger.info("clicking on continue shopping");
        pages.itemPage.continueShopping.click();
        extentLogger.info("searching another item");
        pages.signInPage.search("searchItem2");
        extentLogger.info("hovering over item");
        actions.moveToElement(pages.searchPage.itemNumber(4)).perform();
        extentLogger.info("clicking on 'MORE' button");
        pages.searchPage.moreButton().click();
        extentLogger.info("clearing quantity box");
        pages.itemPage.quantity.clear();
        extentLogger.info("inputting value 3");
        pages.itemPage.quantity.sendKeys("3");
        extentLogger.info("selecting 3nd option on dropdown");
        select.selectByIndex(2);
        extentLogger.info("clicking on add to cart");
        pages.itemPage.addToCardInItemPage.click();
        pages.itemPage.controlClick.click();
        extentLogger.info("verifying success message");
        Assert.assertTrue(pages.itemPage.successMessage.getText().contains("successfully added"));

        extentLogger.info("clicking on continue shopping");
        pages.itemPage.continueShopping.click();
        extentLogger.info("clicking on view cart");
        pages.itemPage.viewCart.click();
        double priceCheck= 27.0*3+16.40*3+2;
        extentLogger.info("verifying calculation operation");
        Assert.assertEquals(Double.parseDouble(driver.findElement(By.id("total_price")).getText().replace("$",""))-priceCheck,0.0);
        extentLogger.info("PASSED- Cart Details Test");
    }
}
