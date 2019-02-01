package com.prestashop.pages;

import com.prestashop.utilities.BrowserUtilities;
import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    public static String firstNameToVerify;
    public static String lastNameToVerify;
    public static String passwordToVerify;
    public static String emailToVerify;

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
        firstName.sendKeys(firstNameToVerify=BrowserUtilities.fakerBase("fakeFirstName"));
        lastName.sendKeys(lastNameToVerify=BrowserUtilities.fakerBase("fakeLastName"));
        password.sendKeys(passwordToVerify=BrowserUtilities.fakerBase("fakePassword"));
        streetAddress.sendKeys(BrowserUtilities.fakerBase("fakeStreetAddress"));
        city.sendKeys(BrowserUtilities.fakerBase("fakeCity"));
        Select select= new Select(state);
        select.selectByIndex(Integer.parseInt(BrowserUtilities.fakerBase("fakeIndexNumber")));
        zipCode.sendKeys(BrowserUtilities.fakerBase("fakeZipCode"));
        phoneNumber.sendKeys(BrowserUtilities.fakerBase("fakeTelNumber"));
        register.click();
    }
}

