package com.prestashop.tests.functional_tests.Positive;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {
     @Test
    public void loginPositive(){
       login();
       Assert.assertTrue(driver.getTitle().contains("My account"));
    }
}
