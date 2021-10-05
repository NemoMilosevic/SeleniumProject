package com.cybertek.tests.day09_explicit_wait_singleton_driver;

import com.cybertek.utility.Driver;
import org.junit.jupiter.api.Test;

public class SingletonPractice {

    @Test
    public void testOutDriverUtilityClass(){

        Driver.getDriver().get("https://www.google.com");

    }

    @Test
    public void testSingleton(){

        Singleton.getObj();
        Singleton.getObj();
        Singleton.getObj();
        Singleton.getObj();
        Singleton.getObj();

        /**
         * This is the output we got:
         *
         * Object has not been created yet, creating one now
         * You already have object , use that existing object
         * You already have object , use that existing object
         * You already have object , use that existing object
         * You already have object , use that existing object
         */

    }

}
