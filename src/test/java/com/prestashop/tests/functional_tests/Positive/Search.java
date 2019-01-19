package com.prestashop.tests.functional_tests.Positive;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends TestBase {
    @Test
    public void search(){
        driver.get("http://automationpractice.com");
        String searchData= "Blouse";
        driver.findElement(By.id("search_query_top")).sendKeys(searchData+ Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Blouse')]")).
                getText().contains(searchData),"actual search data: "+driver.
                findElement(By.xpath("//span[contains(text(),'Blouse')]")).getText() );
    }
}
