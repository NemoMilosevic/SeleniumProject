package com.cybertek.day04_common_elements_xpath_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatingDropDownList {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        // identify the year dropdown
        WebElement yearDropDown = driver.findElement(By.id("year"));

        // wrap it up by using Select class, so we can use easy methods
        Select yearSelectObject = new Select(yearDropDown);

        // select items in 3 different ways
        yearSelectObject.selectByIndex(2); // select 3rd item
        yearSelectObject.selectByValue("2019"); // select with value attribute 2019
        yearSelectObject.selectByVisibleText("1990"); // select by visible text "1990"

        // identify the month dropdown
        WebElement monthDropDown = driver.findElement(By.id("month"));

        // wrap it up by using Select class
        Select monthSelectObject = new Select(monthDropDown);

        // select items in 3 different ways
        monthSelectObject.selectByIndex(4);
        monthSelectObject.selectByValue("7");
        monthSelectObject.selectByVisibleText("December");


        driver.quit();

    }
}
