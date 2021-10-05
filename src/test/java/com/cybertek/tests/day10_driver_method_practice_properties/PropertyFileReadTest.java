package com.cybertek.tests.day10_driver_method_practice_properties;

import com.cybertek.utility.ConfigReader;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReadTest {

    @Test
    public void testInitialRead() throws Exception {

        // 1. Open a connection to the file by using FileInputStream object
        FileInputStream in = new FileInputStream("config.properties");

        // 2. Create empty Properties object
        Properties myProperty = new Properties();

        // 3. Load FileInputStream into the Properties object
        myProperty.load(in);

        // 4. Close the connection by calling close method of FileInputStream object
        in.close();

        // 5. Save and read from the properties file by using the key "hello"
        String helloValue = myProperty.getProperty("hello");
        System.out.println("Hello Value = " + helloValue);

        // 6. Read and print the value of key named "message"
        System.out.println("Message Value = " + myProperty.getProperty("message"));

        // 7. Read and print the values of the rest of the keys
        System.out.println("WebOrder URL = " + myProperty.getProperty("webOrder_url"));
        System.out.println("WebOrder username = " + myProperty.getProperty("webOrder_username"));
        System.out.println("WebOrder password = " + myProperty.getProperty("webOrder_password"));
        System.out.println("Browser Type = " + myProperty.getProperty("browser"));



    }

    @Test
    public void testReadWithTryCatch(){

        try {
            FileInputStream in = new FileInputStream("config.properties");
            Properties myProperty = new Properties();
            myProperty.load(in);
            in.close();
            System.out.println("Hello Value = " + myProperty.getProperty("hello"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testReadUsingUtilityClass(){

        System.out.println("ConfigReader.read(\"hello\") = " + ConfigReader.read("hello"));

    }

}
