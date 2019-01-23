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
        homePage.openUrl();
        actions.moveToElement(searchPage.itemNumber(3)).perform();
        searchPage.addToCart().click();
        itemPage.continueShopping.click();
        actions.moveToElement(itemPage.viewCart).perform();
        itemPage.cartIconDeleteButton().click();
        WebDriverWait wait= new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.textToBePresentInElement(itemPage.cartIconProductCount,"(empty)"));
        Assert.assertEquals(itemPage.cartIconProductCount.getText(),"(empty)");
    }
}
