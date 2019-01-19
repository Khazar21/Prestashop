package com.prestashop.tests.smoke_tests;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Account extends TestBase {
    @Test
    public  void smokeTestAccount(){
        driver.get("http://automationpractice.com/index.php");
        WebElement signIn= driver.findElement(By.xpath("//a[@class='login']"));
        signIn.click();
        driver.findElement(By.id("email")).sendKeys("a111@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("12345");
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.getTitle().contains("My account"));
        Assert.assertTrue(driver.findElement(By.xpath("//span[.='John Smith']")).isDisplayed());
        driver.findElement(By.xpath("//span[.='My personal information']/..")).click();
        Assert.assertTrue(driver.getTitle().contains("Identity"));
        String firstName= driver.findElement(By.id("firstname")).getAttribute("value");
        String lastName= driver.findElement(By.id("lastname")).getAttribute("value");
        Assert.assertEquals(firstName+" "+lastName,driver.findElement(By.xpath("//span[.='John Smith']")).getText() );
        driver.findElement(By.xpath("//span[.='Save']/..")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//li[.='The password you entered is incorrect.']")).isDisplayed());
        driver.findElement(By.xpath("(//div[@id='center_column']//a)[1]")).click();
        Assert.assertTrue(driver.getTitle().contains("My account"));
        driver.findElement(By.xpath("//span[.='My addresses']/..")).click();
        driver.findElement(By.xpath("//span[.='Add a new address']/..")).click();
        firstName= driver.findElement(By.id("firstname")).getAttribute("value");
        lastName= driver.findElement(By.id("lastname")).getAttribute("value");
        Assert.assertEquals(firstName+" "+lastName,driver.findElement(By.xpath("//span[.='John Smith']")).getText() );
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.xpath("//span[contains(text(),'Save')]/..")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='firstname']")).isDisplayed());

    }
}
