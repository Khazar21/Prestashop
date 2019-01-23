package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import com.prestashop.utilities.FakerBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
   @FindBy(id ="customer_firstname")
    public WebElement firstName;
    @FindBy(id="customer_lastname")
    public WebElement lastName;
    @FindBy(id="passwd")
    public WebElement password;
    @FindBy(id="address1")
    public WebElement streetAddress;
    @FindBy(id="city")
    public WebElement city;
    @FindBy(id="id_state")
    public WebElement state; // dropdown menu
    @FindBy(id="postcode")
    public WebElement zipCode;
    @FindBy(id="phone_mobile")
    public WebElement phoneNumber;
    @FindBy(id="submitAccount")
    public WebElement register;

    public void register(){
        firstName.sendKeys(FakerBase.fakeFirstName);
        lastName.sendKeys(FakerBase.fakeLastName);
        password.sendKeys(FakerBase.fakePassword);
        streetAddress.sendKeys(FakerBase.fakeStreetAddress);
        city.sendKeys(FakerBase.fakeCity);
        Select select= new Select(state);
        select.selectByIndex(FakerBase.fakeIndexNumber);
        zipCode.sendKeys(FakerBase.fakeZipCode);
        phoneNumber.sendKeys(FakerBase.fakeTelNumber);
        register.click();
    }
}

