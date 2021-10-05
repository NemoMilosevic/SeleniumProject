package com.cybertek.day01_navigation_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElements {
    public static void main(String[] args) throws InterruptedException {

        // Setting up WebDriver before starting each step:
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 1. open the browser with provided website:
        driver.get("https://www.yahoo.com/");

        // 2. find a search box (by name):
        WebElement searchBox = driver.findElement(By.name("p"));

        // 3. word "Selenium" is entered:
        searchBox.sendKeys("Selenium");

        // 4. find a search button (by id - since there is no name provided):
        WebElement searchButton = driver.findElement(By.id("ybar-search"));

        // 5. click the search button:
        searchButton.submit();

        // 6. wait 5 seconds before next command:
        Thread.sleep(5000);

        // 7. quit the browser:
        driver.quit();

    }
}
