package com.cybertek.day04_common_elements_xpath_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatingAndSelectingMultiDropDown {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        // identify language multi select drop down
        WebElement langDropDown = driver.findElement(By.name("Languages"));

        // wrap it up by using Select class and print
        Select langSelectObject = new Select(langDropDown);
        System.out.println("langSelectObject is multiple? = " + langSelectObject.isMultiple());

        // select items in 3 different ways
        langSelectObject.selectByIndex(2);
        langSelectObject.selectByValue("c");
        langSelectObject.selectByVisibleText("Java");

        // de-select all the previous items in 3 different ways
        langSelectObject.deselectByIndex(2);
        langSelectObject.deselectByValue("c");
        langSelectObject.deselectByVisibleText("Java");


    }
}
