package com.cybertek.day03_locateByTag_getElementAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocateElementsByClassName {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        // identify element using class attribute
        WebElement element1 = driver.findElement(By.className("h1y"));
        System.out.println("element1.getText() = " + element1.getText());

        // identify first li element from the class name list-group-item
        WebElement firstLiElement = driver.findElement(By.className("list-group-item"));
        System.out.println("firstLiElement.getText() = " + firstLiElement.getText());

        // get list of all elements from class name list-group-items and print size
        List<WebElement> allLiTagElements = driver.findElements(By.className("list-group-item"));
        System.out.println("allTagElements.size() = " + allLiTagElements.size());

        // iterate this list and get text of the link and get attribute (print)
        for (WebElement eachLiElement : allLiTagElements) { // allLiTagElement.iter and hit enter
            System.out.println("eachElement.getText() = " + eachLiElement.getText());
        }


        driver.quit();

    }
}
