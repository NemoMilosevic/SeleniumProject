package com.cybertek.day04_common_elements_xpath_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectingFromFakeDropDown {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");

        // the only way that Select class works is if the element tag is selected

        // identify the fake dropdown menu (it's the actual link), and click on it
        WebElement fakeDropDown = driver.findElement(By.id("dropdownMenuLink"));
        fakeDropDown.click();

        // "Select" the options (it's the other link), identify "Google" and click on it
        driver.findElement(By.linkText("Google")).click();

        driver.quit();


    }
}
