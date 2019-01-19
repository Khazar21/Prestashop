package com.prestashop.tests.functional_tests.Positive;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartDetails extends TestBase {
    @Test
    public void cartTest() throws InterruptedException {
        driver.manage().window().maximize();
        login();
        search("Blouse");
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='product_img_link']"))).perform();
        driver.findElement(By.xpath("//span[.='More']/..")).click();
        driver.findElement(By.id("quantity_wanted")).clear();
        driver.findElement(By.id("quantity_wanted")).sendKeys("3");
        Select select= new Select(driver.findElement(By.id("group_1")));
        select.selectByIndex(2);
        driver.findElement(By.xpath("//button[@class='exclusive']")).click();
        driver.findElement(By.xpath("//i[@class='icon-ok']/..")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='icon-ok']/..")).getText().contains("successfully added"));
        driver.findElement(By.xpath("//i[@class='icon-chevron-left left']/..")).click();
        search("dress");
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='product-image-container']//a[@title='Printed Chiffon Dress']"))).perform();
        driver.findElement(By.xpath("(//span[.='More'])[4]")).click();
        driver.findElement(By.id("quantity_wanted")).clear();
        driver.findElement(By.id("quantity_wanted")).sendKeys("3");
        select= new Select(driver.findElement(By.id("group_1")));
        select.selectByIndex(2);
        driver.findElement(By.xpath("//button[@class='exclusive']")).click();
        driver.findElement(By.xpath("//i[@class='icon-ok']/..")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='icon-ok']/..")).getText().contains("successfully added"));
        driver.findElement(By.xpath("//i[@class='icon-chevron-left left']/..")).click();
        driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
        double priceCheck= 27.0*3+16.40*3+2;
        Assert.assertEquals(Double.parseDouble(driver.findElement(By.id("total_price")).getText().replace("$",""))-priceCheck,0.0);
    }
}
