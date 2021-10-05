package com.cybertek.day04_common_elements_xpath_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingCheckBoxes {
    public static void main(String[] args) {

        // check boxes can be checked or unchecked
        // we can use method called isSelected() to determine if the boxes are checked

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        // identify first checkbox
        WebElement checkbox1 = driver.findElement(By.id("box1"));
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());

        // identify second checkbox
        WebElement checkbox2 = driver.findElement(By.id("box2"));
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        // get the value of checked attribute
        System.out.println("checkbox1.getAttribute(\"checked\") = " + checkbox1.getAttribute("checked"));
        System.out.println("checkbox2.getAttribute(\"checked\") = " + checkbox2.getAttribute("checked"));

        checkbox1.click();
        checkbox2.click();

        // check if it's not already checked then click on it
        if (! checkbox1.isSelected()){
            checkbox1.click();
        }else{
            System.out.println("Already Checked");
        }

        if (! checkbox2.isSelected()){
            checkbox2.click();
        }else{
            System.out.println("Already Checked");
        }

        driver.quit();

    }
}
