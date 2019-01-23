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
    @FindBy(xpath = "//span[@class='lighter']")
    public WebElement searchResultDisplayed;
    @FindBy(xpath = "//button[@name='processAddress']")
    public WebElement proceedToCheckoutInAddress;
    @FindBy(xpath = "//button[@name='processCarrier']")
    public WebElement proceedToCheckoutInShipping;
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    public WebElement proceedToCheckoutInSummary;
    @FindBy(xpath = "//*[@class='fancybox-error']")
    public WebElement error_YouMustAgree;
    @FindBy(xpath = "//a[@title='Close']")
    public WebElement closeErrorMessage;
    @FindBy(id = "cgv")
    public WebElement checkBox_IAgree;
    @FindBy(xpath = "//a[contains(text(),'by check')]")
    public WebElement payByCheck;
    @FindBy(xpath = "//*[.='I confirm my order']/..")
    public WebElement confirmOrder;
    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElement orderPlacedSuccessMessage;

    public WebElement itemNumber(int index) {
        this.index = index;
        return Driver.getDriver().findElement(By.xpath("(//div[@class='product-container'])[" + this.index + "]"));
    }
    public WebElement addToCart() {
        OrderPage.count++;
        return Driver.getDriver().findElement(By.xpath("(//span[.='Add to cart'])[" + this.index + "]"));
    }
    public WebElement moreButton(){
        return Driver.getDriver().findElement(By.xpath("(//span[.='More']/..)[" + this.index + "]"));
    }
    public WebElement productName(){
        return Driver.getDriver().findElement(By.xpath("(//a[@class='product-name'])[" + this.index + "]"));
    }
    public WebElement productHomePrice(){
        return Driver.getDriver().findElement(By.xpath("(//div[@class='content_price'])[" + (this.index +this.index-1)+ "]/span"));
    }
}