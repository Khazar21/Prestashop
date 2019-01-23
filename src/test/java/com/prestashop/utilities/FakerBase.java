package com.prestashop.utilities;

import com.github.javafaker.Faker;

public class FakerBase{
    public static Faker faker= new Faker();
    public static String fakeEmailAddress= faker.internet().emailAddress(),
            fakeFirstName= faker.name().firstName(),
            fakeLastName= faker.name().lastName(),
            fakePassword= faker.internet().password(),
            fakeStreetAddress= faker.address().streetAddress(),
            fakeCity= faker.address().city(),
            fakeZipCode= faker.number().digits(5),
            fakeTelNumber= faker.phoneNumber().cellPhone();
    public static int fakeIndexNumber= faker.number().numberBetween(2,15);
}
