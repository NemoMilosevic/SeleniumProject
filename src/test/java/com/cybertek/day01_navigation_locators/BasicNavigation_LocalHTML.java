package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation_LocalHTML {
    public static void main(String[] args) {

        /*
            How to open Chrome browser with a local URL:
                        file:///Users/nemo/Desktop/HTML_Class/Day2.html
         */

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("file:///Users/nemo/Desktop/HTML_Class/Day2.html");


    }
}
