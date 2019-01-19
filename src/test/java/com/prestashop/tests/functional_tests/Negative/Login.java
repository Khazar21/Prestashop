package com.prestashop.tests.functional_tests.Negative;

import com.prestashop.utilities.FakerBase;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test
    public void negativeLogin1(){
        driver.get("http://automationpractice.com");
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//li[.='An email address required.']")).isDisplayed());
    }
    @Test
    public void negativeLogin2(){
        driver.get("http://automationpractice.com");
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.id("email")).sendKeys("sda111@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("112345");
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//li[.='Authentication failed.']")).isDisplayed());
    }
}
