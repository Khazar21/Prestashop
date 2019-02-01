package com.prestashop.utilities;

import com.github.javafaker.Faker;

public class BrowserUtilities {
    public static String fakerBase(String fake){
                final Faker faker= new Faker();
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

}
