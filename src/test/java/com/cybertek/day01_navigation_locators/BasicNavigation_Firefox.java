package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicNavigation_Firefox {
    public static void main(String[] args) {

        // 1. set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // 2. create WebDriver instance using FirefoxDriver object
        WebDriver driver = new FirefoxDriver();

        // 3. navigate to https://cybertekschool.com
        driver.get("https://cybertekschool.com");

        // 4. quit the browser
        System.out.println("Quit");
        driver.quit();

    }
}
