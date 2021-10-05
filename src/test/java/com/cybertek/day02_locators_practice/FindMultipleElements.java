package com.cybertek.day02_locators_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class FindMultipleElements {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        // get all the links that have partial text with 'A' in it
        List<WebElement> allLinks = driver.findElements(By.partialLinkText("A"));

        // get the size of List in order to know how many elements we have
        System.out.println("allLinks.size() = " + allLinks.size()); // 7 elements

        // get the first item/element and get the text (print)
        WebElement firstItem = allLinks.get(0);
        System.out.println("firstItem.getText() = " + firstItem.getText());

        // get the second item/element and get the text (print)
        WebElement secondItem = allLinks.get(1);
        System.out.println("secondItem.getText() = " + secondItem.getText());

        // iterate over the entire list using each loop and print out the text
        for (WebElement eachElement : allLinks) {
            System.out.println("eachElement = " + eachElement.getText());
        }

        driver.quit();

    }
}
