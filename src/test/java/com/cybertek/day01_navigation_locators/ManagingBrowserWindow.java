package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManagingBrowserWindow {
    public static void main(String[] args) {

        // set up current driver
        WebDriverManager.chromedriver().setup();

        // create new Chrome Driver object
        WebDriver driver = new ChromeDriver();

        // maximize browser window
        driver.manage().window().maximize();

        // make browser window full screen
        driver.manage().window().fullscreen();

        // quit the browser
        driver.quit();


    }
}
