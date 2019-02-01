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
    @Test
    public void cartIconDeleteTest(){
        actions.moveToElement(pages.searchPage.itemNumber(3)).perform();
        pages.searchPage.addToCart().click();
        pages.itemPage.continueShopping.click();
        actions.moveToElement(pages.itemPage.viewCart).perform();
        pages.itemPage.cartIconDeleteButton().click();
        WebDriverWait wait= new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.textToBePresentInElement(pages.itemPage.cartIconProductCount,"(empty)"));
        Assert.assertEquals(pages.itemPage.cartIconProductCount.getText(),"(empty)");
    }
}
