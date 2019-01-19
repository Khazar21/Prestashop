package com.prestashop.tests.functional_tests.Positive;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOut extends TestBase {
    @Test
    public void checkOut() throws InterruptedException {
        addToCart();
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
        driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")).click();
        driver.findElement(By.xpath("//button[@name='processAddress']")).click();
        driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fancybox-error']")).getText().contains("You must agree"));
        driver.findElement(By.xpath("//a[@title='Close']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='cgv']")).click();
        driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'by check')]")).click();
        driver.findElement(By.xpath("//*[.='I confirm my order']/..")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText().contains("is complete"));

    }
}
