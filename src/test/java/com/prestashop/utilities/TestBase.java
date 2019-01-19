package com.prestashop.utilities;

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

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;

    @BeforeClass
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpDriver() throws InterruptedException {
        driver = new ChromeDriver();
        actions= new Actions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        // driver.quit();
    }

    public void login() {
        driver.get("http://automationpractice.com");
        driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        driver.findElement(By.id("email")).sendKeys("a111@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("12345");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    public void search(String item) {
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys(item + Keys.ENTER);
    }
    public void addToCart(){
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='product_img_link']"))).perform();
        driver.findElement(By.xpath("//a[@title='Add to cart']")).click();
    }
}