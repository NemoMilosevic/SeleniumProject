package com.cybertek.day02_locators_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText_PartialLinkText {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        // identify the link with text "Disappearing Elements"
        // using partial link text then get the full text by using new method getText
        WebElement myLink = driver.findElement(By.partialLinkText("Disappearing"));
        System.out.println("Get Text: "+myLink.getText());

        // provide partial link as letter A
        WebElement aLink = driver.findElement(By.partialLinkText("A"));
        System.out.println("aLink.getText(): " + aLink.getText());


    }
}
