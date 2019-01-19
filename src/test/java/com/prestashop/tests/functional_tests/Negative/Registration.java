package com.prestashop.tests.functional_tests.Negative;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration extends TestBase {
      @Test
    public void registration1(){
          driver.get("http://automationpractice.com");
          driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
          //          //input invalid email type
          driver.findElement(By.id("email_create")).sendKeys("asdf");
          driver.findElement(By.id("SubmitCreate")).click();
          Assert.assertTrue(driver.findElement(By.xpath("//li[.='Invalid email address.']")).isDisplayed());
          driver.quit();
      }
    @Test
    public void registration2(){
        driver.get("http://automationpractice.com");
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        //input valid email address but already registered one.
        driver.findElement(By.id("email_create")).sendKeys("a111@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'has already been registered')]")).isDisplayed());
    }
}
