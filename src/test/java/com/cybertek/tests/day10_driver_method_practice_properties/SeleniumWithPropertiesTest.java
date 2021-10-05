package com.cybertek.tests.day10_driver_method_practice_properties;

import com.cybertek.utility.*;
import org.junit.jupiter.api.Test;

public class SeleniumWithPropertiesTest extends TestBase {

    @Test
    public void testWebOrderLogin(){

        String url = ConfigReader.read("webOrder_url");
        String username = ConfigReader.read("webOrder_username");
        String password = ConfigReader.read("webOrder_password");

        Driver.getDriver().get(url);
        WebOrderUtility.login(username,password);


    }

}
