package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation_Chrome {
    public static void main(String[] args) {

        // set up current driver
        WebDriverManager.chromedriver().setup();

        // create new Chrome Driver object
        WebDriver driver = new ChromeDriver();

        // navigate to https://amazon.com using get("url")
        driver.get("https://amazon.com");

        // navigate to https://google.com using navigate.to("url")
        driver.navigate().to("https://google.com");

        // navigate back, forward and refresh
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        // closing browser: close() will close current tab (if any), or quit the browser (if only 1 tab)
        // driver.close();

        // quiting browser: quit() will close all the tabs and quit the browser
        driver.quit();




    }
}
