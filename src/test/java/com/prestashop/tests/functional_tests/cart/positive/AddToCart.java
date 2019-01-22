package com.prestashop.tests.functional_tests.cart.positive;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends TestBase {
    @Test
    public void addToCart(){
        HomePage homePage= new HomePage();
        SignInPage signInPage= new SignInPage();
        homePage.openUrl();
        homePage.signInButton.click();
        signInPage.signIn("username", "password");
        signInPage.search("searchItem1");
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='product_img_link']"))).perform();
        driver.findElement(By.xpath("//a[@title='Add to cart']")).click();
        driver.findElement(By.id("layer_cart_product_title")).click();
        Assert.assertEquals(driver.findElement(By.id("layer_cart_product_title")).getText(),"Blouse");
        Assert.assertEquals(driver.findElement(By.id("layer_cart_product_quantity")).getText(),"1");
        driver.findElement(By.xpath("//i[@class='icon-chevron-left left']/..")).click();
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='product_img_link']"))).perform();
        driver.findElement(By.xpath("//a[@title='Add to cart']")).click();
        driver.findElement(By.id("layer_cart_product_title")).click();
        Assert.assertEquals(driver.findElement(By.id("layer_cart_product_quantity")).getText(),"2");
    }
}
