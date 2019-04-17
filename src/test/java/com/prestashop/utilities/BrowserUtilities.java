package com.prestashop.utilities;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BrowserUtilities {
    public static String fakerBase(String fake){
                 Faker faker= new Faker();
                switch(fake) {
                    case "fakeEmailAddress" :
                        return faker.internet().emailAddress();
                    case "fakeFirstName"  :
                        return faker.name().firstName();
                    case "fakeLastName" :
                        return faker.name().lastName();
                    case "fakePassword" :
                        return faker.internet().password();
                    case "fakeStreetAddress" :
                        return faker.address().streetAddress();
                    case "fakeCity" :
                        return faker.address().city();
                    case "fakeZipCode" :
                        return faker.number().digits(5);
                    case "fakeTelNumber" :
                        return faker.phoneNumber().cellPhone();
                    case "fakeIndexNumber" :
                        return String.valueOf(faker.number().numberBetween(2, 15));
                    default:
                        return null;
                }
    }
    public static void waitForClickability(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static String getScreenshot(String name) {
        // name the screenshot with current date-time to avoid duplicate naming
        String time = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakeScreenshot -> interface from selenium which takes screenshots
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots" + name + time + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException io) {
        }
        return target;

    }

}
