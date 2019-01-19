package com.prestashop.tests.functional_tests.Positive;

import com.github.javafaker.Faker;
import com.prestashop.utilities.FakerBase;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration extends FakerBase {
    @Test
    public void registration1(){
        driver.get("http://automationpractice.com");
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        //input random valid type email address using faker
        driver.findElement(By.id("email_create")).sendKeys(fakeEmailAddress);
        driver.findElement(By.id("SubmitCreate")).click();
        WebElement stateDB= driver.findElement(By.id("id_state"));
        Select select= new Select(stateDB);
        driver.findElement(By.id("customer_firstname")).sendKeys(fakeFirstName);
        driver.findElement(By.id("customer_lastname")).sendKeys(fakeLastName);
        driver.findElement(By.id("passwd")).sendKeys(fakePassword);
        driver.findElement(By.id("address1")).sendKeys(fakeStreetAddress);
        driver.findElement(By.id("city")).sendKeys(fakeCity);
        select.selectByIndex(fakeIndexNumber);
        driver.findElement(By.id("postcode")).sendKeys(fakeZipCode);
        driver.findElement(By.id("phone_mobile")).sendKeys(fakeTelNumber);
        driver.findElement(By.id("submitAccount")).click();
        Assert.assertTrue(driver.getTitle().contains("My account"));
        Assert.assertEquals(driver.findElement(By.xpath("//a[@title='View my customer account']//span")).getText(),
                            fakeFirstName+" "+fakeLastName);
        System.out.println("Sign in credentials:\n "+ fakeFirstName+"\n"+fakeLastName+ "\n"+fakeEmailAddress+"\n"+"Password: "+fakePassword);
    }
}
