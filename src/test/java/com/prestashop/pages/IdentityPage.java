package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdentityPage {
    public  IdentityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id ="firstname")
    public WebElement firstName;
    @FindBy(id="lastname")
    public WebElement lastName;
    @FindBy(xpath="//button[@name='submitIdentity']")
    public WebElement save;
    @FindBy(xpath=("//div[@id='center_column']/ul/li[1]//a"))
    public WebElement backToAccount;
    @FindBy(xpath=("//div[@id='center_column']/ul/li[2]//a"))
    public WebElement homeButton;
    @FindBy(xpath=("//div[@class='alert alert-danger']/ol/li"))
    public WebElement errorMessage;
}
