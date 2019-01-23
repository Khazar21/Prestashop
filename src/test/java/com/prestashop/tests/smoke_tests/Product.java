package com.prestashop.tests.smoke_tests;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.ItemPage;
import com.prestashop.pages.SearchPage;
import com.prestashop.pages.SignInPage;
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
        HomePage homePage= new HomePage();
        SignInPage signInPage= new SignInPage();
        SearchPage searchPage= new SearchPage();
        ItemPage itemPage= new ItemPage();
        homePage.openUrl();
        actions.moveToElement(searchPage.itemNumber(2)).perform();
        String priceHomePageItem= searchPage.productHomePrice().getText();
        String nameHomePageItem= searchPage.productName().getText();
        searchPage.moreButton().click();
        Assert.assertEquals(itemPage.itemName.getText(),nameHomePageItem);
        Assert.assertEquals(itemPage.itemPrice.getText(),priceHomePageItem);
        Select dropBoxSize= new Select(itemPage.size);
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
         Assert.assertEquals(itemPage.quantity.getAttribute("value"), "1");
         Assert.assertEquals(defaultSize, "S");
         Assert.assertEquals(actualDropBoxList,expectedSizeDropBoxList);
         itemPage.addToCardInItemPage.click();
         itemPage.controlClick.click();
         Assert.assertEquals(itemPage.itemQuantityTempWindow.getText(),"1");
         Assert.assertEquals(itemPage.successMessage.getText(), "Product successfully added to your shopping cart");
         Assert.assertTrue(itemPage.itemSizeInTempWindow.getText().contains(" S"));
         Assert.assertEquals(itemPage.itemName.getText(),nameHomePageItem);
    }
}
