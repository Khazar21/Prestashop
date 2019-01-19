package com.prestashop.tests.smoke_tests;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Product extends TestBase {
    @Test
    public void verifyPriceAndName(){
        driver.get("http://automationpractice.com/index.php");
        String priceHomePageItem= driver.findElement(By.xpath("(/html[1]/body/div/div[2]/div/div[2]/div/div/ul/li[2]/div/div[2]/div/span)[1]")).getText();
        String nameHomePageItem= driver.findElement(By.xpath("(//a[contains(text(),'Blouse')])[2]")).getText();
        WebElement itemBlouse=driver.findElement(By.xpath("(//a[contains(text(),'Blouse')])[2]"));
        itemBlouse.click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1[.='Blouse']")).getText(),nameHomePageItem);
        Assert.assertEquals(driver.findElement(By.xpath("//span[.='$27.00']")).getText(),priceHomePageItem);

        WebElement quantity= driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
         String defaultQuantity= quantity.getAttribute("value");
         WebElement sizeDropBox= driver.findElement(By.xpath("//select[@id='group_1']"));
         Select dropBoxSize= new Select(sizeDropBox);
         String defaultSize= dropBoxSize.getFirstSelectedOption().getText();
         List<WebElement> sizeDropBoxList= dropBoxSize.getOptions();
         List<String> actualDropBoxList= new ArrayList<String>();
         for(int i=0;i<sizeDropBoxList.size(); i++){
             actualDropBoxList.add(sizeDropBoxList.get(i).getText());
         }
         List<String> expectedSizeDropBoxList= new ArrayList<String>();
         expectedSizeDropBoxList.add("S");
         expectedSizeDropBoxList.add("M");
         expectedSizeDropBoxList.add("L");
         Assert.assertEquals(defaultQuantity, "1");
         Assert.assertEquals(defaultSize, "S");
         Assert.assertEquals(actualDropBoxList,expectedSizeDropBoxList);
         driver.findElement(By.xpath("//span[.='Add to cart']/..")).click();
         WebElement actualQuantityAfterAddingToCard= driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']"));
         actualQuantityAfterAddingToCard.click();
         String actualQuantityAfterAddingToCardText= driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']")).getText();

         String actualTextAfterAddingToCard= driver.findElement(By.xpath("//i[@class='icon-ok']/..")).getText();
         Assert.assertEquals(actualQuantityAfterAddingToCardText,"1");
         Assert.assertEquals(actualTextAfterAddingToCard, "Product successfully added to your shopping cart");
         Assert.assertTrue(driver.findElement(By.id("layer_cart_product_attributes")).getText().contains(" S"));

         Assert.assertEquals(driver.findElement(By.id("layer_cart_product_title")).getText(),nameHomePageItem);


    }
}
