package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
    public ItemPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h1")
    public WebElement itemName;
    @FindBy(xpath = "//span[@id='our_price_display']")
    public WebElement itemPrice;
    @FindBy(id = "quantity_wanted")
    public WebElement quantity;
    @FindBy(id = "group_1")
    public WebElement size;        //dropdown menu
    @FindBy(xpath = "//button[@class='exclusive']")
    public WebElement addToCardInItemPage;
    @FindBy(id = "layer_cart_product_attributes")
    public WebElement controlClick;
    @FindBy(id = "layer_cart_product_title")
    public WebElement itemNameTempWindow;
    @FindBy(id = "layer_cart_product_quantity")
    public WebElement itemQuantityTempWindow;
    @FindBy(xpath = "//i[@class='icon-chevron-left left']/..")
    public WebElement continueShopping;
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    public WebElement viewCart;
    @FindBy(xpath = "//a[@class='cart-images']//img")
    public WebElement cartItem;
    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    public WebElement cartIconProductCount;
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    public WebElement proceedToCheckout;
    @FindBy(xpath = "//i[@class='icon-ok']/..")
    public WebElement successMessage;
    @FindBy(id = "layer_cart_product_attributes")
    public WebElement itemSizeInTempWindow;


    public WebElement cartIconDeleteButton(){
        OrderPage.count--;
        return Driver.getDriver().findElement(By.xpath("//a[@class='ajax_cart_block_remove_link']"));
    }
}
