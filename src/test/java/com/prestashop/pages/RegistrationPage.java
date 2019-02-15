package com.prestashop.pages;

import com.prestashop.utilities.BrowserUtilities;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.ExcelUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @FindBy(xpath="//a[@title='View my customer account']//span")
    public WebElement firstAndLastNameAfterReg;


    public void register(){
        firstName.sendKeys(firstNameToVerify=BrowserUtilities.fakerBase("fakeFirstName"));
        lastName.sendKeys(lastNameToVerify=BrowserUtilities.fakerBase("fakeLastName"));
        password.sendKeys(passwordToVerify=BrowserUtilities.fakerBase("fakePassword"));
        streetAddress.sendKeys(BrowserUtilities.fakerBase("fakeStreetAddress"));
        city.sendKeys(BrowserUtilities.fakerBase("tfakeCiy"));
        Select select= new Select(state);
        select.selectByIndex(Integer.parseInt(BrowserUtilities.fakerBase("fakeIndexNumber")));
        zipCode.sendKeys(BrowserUtilities.fakerBase("fakeZipCode"));
        phoneNumber.sendKeys(BrowserUtilities.fakerBase("fakeTelNumber"));
        register.click();
    }
    public void registerWithDD(int row){
        List<Map<String,String>> testData;
        ExcelUtil excelUtil= new ExcelUtil("./src/test/resources/sign_up_data.xlsx", 0);
        testData= excelUtil.getDataList();
        firstName.sendKeys(testData.get(row).get("first name"));
        lastName.sendKeys(testData.get(row).get("last name"));
        password.sendKeys(testData.get(row).get("password"));
        streetAddress.sendKeys(testData.get(row).get("street address"));
        city.sendKeys(testData.get(row).get("city"));
        Select select= new Select(state);
        select.selectByVisibleText(testData.get(row).get("state"));
        zipCode.sendKeys(testData.get(row).get("zipcode").replace(".0",""));
        phoneNumber.sendKeys(testData.get(row).get("tell number"));
        register.click();
    }
       public void putDataIntoAList(){
        List<Map<String,String>> ret= new ArrayList<>();

       }

    }

