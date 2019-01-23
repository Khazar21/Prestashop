package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    public static int count;
    public OrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='heading-counter']")
    public WebElement cartItemCountInformation;
    @FindBy(xpath = "//p[@class='alert alert-warning']")
    public WebElement alertMessage;





    public WebElement iconTrash(int index){
        OrderPage.count--;
        return Driver.getDriver().findElement(By.xpath("(//i[@class='icon-trash'])["+index+"]"));
    }
}

