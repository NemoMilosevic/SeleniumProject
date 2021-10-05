package com.cybertek.tests.day11_property_driver_faker_pom;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class FakerPracticeTest {

    @Test
    public void testPrintFakeData(){

        Faker faker = new Faker(); // provides dummy data for various stuff

        // print fake full name
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        // print fake book info
        System.out.println("faker.book().title() = " + faker.book().title());

        // print fake phone number
        System.out.println("faker.phoneNumber().cellPhone() = " + faker.phoneNumber().cellPhone());

        // print Chuck Norris facts
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());

        // save and print fake address
        String streetAddress = faker.address().streetAddress();
        System.out.println("streetAddress = " + streetAddress);

        // print fake phone number in specific format
        System.out.println("Phone Number in Specific Format = " + faker.numerify("(###) ###-####"));

        // print fake credit card number
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());

    }

}
