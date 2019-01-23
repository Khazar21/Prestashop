package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
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
    public void cartIconDeleteTest() throws InterruptedException {
        HomePage homePage= new HomePage();
        SearchPage searchPage= new SearchPage();
        homePage.openUrl();
        actions.moveToElement(searchPage.itemNumber(3)).perform();
        searchPage.addToCart().click();
        searchPage.continueShopping.click();
        actions.moveToElement(searchPage.viewCart).perform();
        searchPage.cartIconDeleteButton().click();
        WebDriverWait wait= new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.textToBePresentInElement(searchPage.cartIconProductCount,"(empty)"));
        Assert.assertEquals(searchPage.cartIconProductCount.getText(),"(empty)");

    }
}
