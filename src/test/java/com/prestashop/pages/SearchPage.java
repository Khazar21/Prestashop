package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    int index = 1;

    public SearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "layer_cart_product_attributes")
    public WebElement controlClick;
    @FindBy(id = "layer_cart_product_title")
    public WebElement itemName;
    @FindBy(id = "layer_cart_product_quantity")
    public WebElement itemQuantity;
    @FindBy(xpath = "//i[@class='icon-chevron-left left']/..")
    public WebElement continueShopping;
    @FindBy(xpath = "//a[@title='View my shopping cart']")
    public WebElement viewCart;
    @FindBy(xpath = "//a[@class='cart-images']//img")
    public WebElement cartItem;
//    @FindBy(xpath = "//a[@class='ajax_cart_block_remove_link']")
//    public WebElement cartIconDeleteButton;
    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    public WebElement cartIconProductCount;
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    public WebElement proceedToCheckout;



    public WebElement itemNumber(int index) {
        this.index = index;
        return Driver.getDriver().findElement(By.xpath("(//div[@class='product-container'])[" + this.index + "]"));
    }

    public WebElement addToCart() {
        OrderPage.count++;
        return Driver.getDriver().findElement(By.xpath("(//span[.='Add to cart'])[" + this.index + "]"));
    }
    public WebElement cartIconDeleteButton(){
        OrderPage.count--;
        return Driver.getDriver().findElement(By.xpath("//a[@class='ajax_cart_block_remove_link']"));
    }
}
