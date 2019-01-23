package com.prestashop.utilities;

import com.prestashop.pages.*;
import com.sun.java.swing.action.AboutAction;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected SoftAssert softAssert;

    protected HomePage homePage;
    protected IdentityPage identityPage;
    protected ItemPage itemPage;
    protected MyAccountPage myAccountPage;
    protected OrderPage orderPage;
    protected RegistrationPage registrationPage;
    protected SearchPage searchPage;
    protected SignInPage signInPage;


    @BeforeMethod
    public void setUpDriver(){
        driver = Driver.getDriver();
        softAssert= new SoftAssert();
        actions= new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        initializePageObjects();
    }

    @AfterMethod
    public void tearDown() {
        softAssert.assertAll();
        Driver.closeDriver();
    }
    public void initializePageObjects(){
        homePage= new HomePage();
        identityPage= new IdentityPage();
        itemPage= new ItemPage();
        myAccountPage= new MyAccountPage();
        orderPage= new OrderPage();
        registrationPage= new RegistrationPage();
        searchPage= new SearchPage();
        signInPage= new SignInPage();
    }

}