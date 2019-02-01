package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@title='Orders']")
    public WebElement orderHistoryAndDetails;
    @FindBy(xpath = "//a[@title='Credit slips']")
    public WebElement myCreditSlips;
    @FindBy(xpath = "//a[@title='Addresses']")
    public WebElement myAddresses;
    @FindBy(xpath = "//a[@title='Information']")
    public WebElement information;
    @FindBy(xpath = "//a[@title='My wishlists']")
    public WebElement myWishList;
    @FindBy(xpath = "//a[@title='Home']")
    public WebElement returnHome;
    @FindBy(xpath = "//a[@class='account']/span")
    public WebElement signedInUser;
    @FindBy(xpath = "//a[@title='Log me out']")
    public WebElement signOut;
    @FindBy(xpath = "//span[.='Add a new address']/..")
    public WebElement addANewAddress;
    @FindBy(id = "submitAddress")
    public WebElement saveNewAddress;




}
