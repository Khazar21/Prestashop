package com.prestashop.pages;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // registration
    @FindBy(id = "email_create")
    public WebElement signUpEmail;
    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton;
    // sign in
    @FindBy(id = "email")
    public WebElement signInEmail;
    @FindBy(id = "passwd")
    public WebElement password;
    @FindBy(id = "SubmitLogin")
    public WebElement submit;
    // search
    @FindBy(id = "search_query_top")
    public WebElement searchBox;

    public void signIn(String username, String password) {
        String usernameRet= ConfigurationReader.getProperty(username);
        String passwordRet= ConfigurationReader.getProperty(password);
        signInEmail.sendKeys(usernameRet);
        this.password.sendKeys(passwordRet);
        submit.click();
    }
    public void search(String item) {
        String itemreturn= ConfigurationReader.getProperty(item);
        searchBox.clear();
        searchBox.sendKeys(itemreturn + Keys.ENTER);
    }


}
