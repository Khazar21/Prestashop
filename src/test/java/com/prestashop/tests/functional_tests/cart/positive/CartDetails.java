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
    @Test
    public void cartTest(){
        pages.homePage.signInButton.click();
        driver.manage().window().maximize();
        pages.signInPage.signIn("username","password");
        pages.signInPage.search("searchItem1");
        actions.moveToElement(pages.searchPage.itemNumber(1)).perform();
        pages.searchPage.moreButton().click();
        pages.itemPage.quantity.clear();
        pages.itemPage.quantity.sendKeys("3");
        Select select= new Select(pages.itemPage.size);
        select.selectByIndex(2);
        pages.itemPage.addToCardInItemPage.click();
        pages.itemPage.controlClick.click();
        Assert.assertTrue(pages.itemPage.successMessage.getText().contains("successfully added"));
        pages.itemPage.continueShopping.click();
        pages.signInPage.search("searchItem2");
        actions.moveToElement(pages.searchPage.itemNumber(4)).perform();
        pages.searchPage.moreButton().click();
        pages.itemPage.quantity.clear();
        pages.itemPage.quantity.sendKeys("3");
        select.selectByIndex(2);
        pages.itemPage.addToCardInItemPage.click();
        pages.itemPage.controlClick.click();
        Assert.assertTrue(pages.itemPage.successMessage.getText().contains("successfully added"));
        pages.itemPage.continueShopping.click();
        pages.itemPage.viewCart.click();
        double priceCheck= 27.0*3+16.40*3+2;
        Assert.assertEquals(Double.parseDouble(driver.findElement(By.id("total_price")).getText().replace("$",""))-priceCheck,0.0);
    }
}
