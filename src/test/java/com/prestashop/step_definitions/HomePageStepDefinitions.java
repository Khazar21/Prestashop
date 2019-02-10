package com.prestashop.step_definitions;

import com.prestashop.pages.HomePage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HomePageStepDefinitions {
    @Given("user is in home page")
    public void user_is_in_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user inputs search term and clicks enter")
    public void user_inputs_search_term_and_clicks_enter() {
        HomePage homePage= new HomePage();
        homePage.search("searchItem1");
    }
}
