package com.prestashop.step_definitions;

import com.prestashop.pages.HomePage;
import com.prestashop.pages.SignInPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SignInPageStepDefinitions {
    HomePage homePage= new HomePage();
    SignInPage signInPage= new SignInPage();

    @Given("User is in sign in page")
    public void user_is_in_sign_in_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        homePage.signInButton.click();
    }

    @When("User puts valid credentials")
    public void user_puts_valid_credentials() {
        signInPage.signIn("username","password");
    }

    @Then("System should display page title contains- {string}")
    public void system_should_display_page_title_contains(String title) {
     Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }

    @When("User puts invalid username and valid password")
    public void user_puts_invalid_username_and_valid_password() {
     signInPage.signIn("invalidUsername","password");
    }

    @Then("System should display error message")
    public void system_should_display_error_message() {
Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//ol/li")).isDisplayed());
    }
    @When("User puts valid username and invalid password")
    public void user_puts_valid_username_and_invalid_password() {
        signInPage.signIn("username","invalidPassword");
    }
    @When("User puts invalid username and invalid password")
    public void user_puts_invalid_username_and_invalid_password() {
      signInPage.signIn("invalidUsername","invalidPassword");
    }

}
