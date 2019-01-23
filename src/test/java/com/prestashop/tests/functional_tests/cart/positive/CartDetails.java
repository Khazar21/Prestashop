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
        homePage.openUrl();
        homePage.signInButton.click();
        driver.manage().window().maximize();
        signInPage.signIn("username","password");
        signInPage.search("searchItem1");
        actions.moveToElement(searchPage.itemNumber(1)).perform();
        searchPage.moreButton().click();
        itemPage.quantity.clear();
        itemPage.quantity.sendKeys("3");
        Select select= new Select(itemPage.size);
        select.selectByIndex(2);
        itemPage.addToCardInItemPage.click();
        itemPage.controlClick.click();
        Assert.assertTrue(itemPage.successMessage.getText().contains("successfully added"));
        itemPage.continueShopping.click();
        signInPage.search("searchItem2");
        actions.moveToElement(searchPage.itemNumber(4)).perform();
        searchPage.moreButton().click();
        itemPage.quantity.clear();
        itemPage.quantity.sendKeys("3");
        select.selectByIndex(2);
        itemPage.addToCardInItemPage.click();
        itemPage.controlClick.click();
        Assert.assertTrue(itemPage.successMessage.getText().contains("successfully added"));
        itemPage.continueShopping.click();
        itemPage.viewCart.click();
        double priceCheck= 27.0*3+16.40*3+2;
        Assert.assertEquals(Double.parseDouble(driver.findElement(By.id("total_price")).getText().replace("$",""))-priceCheck,0.0);
    }
}
