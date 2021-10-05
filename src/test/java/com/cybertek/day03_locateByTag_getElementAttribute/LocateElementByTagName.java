package com.cybertek.day03_locateByTag_getElementAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocateElementByTagName {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        // identify the first element by tagName and print getText
        WebElement firstLink = driver.findElement(By.tagName("a"));
        System.out.println("firstLink.getText() = " + firstLink.getText());

        // find and store all elements with <a> tag
        List<WebElement> allTagElements = driver.findElements(By.tagName("a"));
        System.out.println("allTagElements.size() = " + allTagElements.size());

        // iterate this list and get text of the link and get attribute (print)
        for (WebElement eachElement : allTagElements) { // allTagElement.iter and hit enter
            System.out.println("eachElement.getText() = " + eachElement.getText());
            System.out.println("eachElement.getAttribute(\"href\") = " + eachElement.getAttribute("href"));
        }

        // get first element with <h1> tag and get text out of it
        WebElement firstH1TagElement = driver.findElement(By.tagName("h1"));
        System.out.println("firstH1TagElement.getText() = " + firstH1TagElement.getText());


        driver.quit();

    }
}
