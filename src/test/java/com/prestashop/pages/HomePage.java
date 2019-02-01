package com.prestashop.pages;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;

    @FindBy(id = "search_query_top")
    public WebElement searchBox;


    public void search(String item) {
        String itemreturn= ConfigurationReader.getProperty(""+item);
        searchBox.clear();
        searchBox.sendKeys(itemreturn + Keys.ENTER);
    }

}
