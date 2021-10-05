package com.cybertek.day04_common_elements_xpath_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingByXpathIntro {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        // Xpath can be used to navigate through elements and attributes in the html document
        // copy 'full xpath' is known as absolute xpath
        // '//h1/span' (partial) this is known as relative xpath, and it starts with double forward slash //

        // full xpath (absolute xpath) to identify an element and get the text
        WebElement headerElement1 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/h1/span"));
        System.out.println("headerElement1.getText() = " + headerElement1.getText());

        // relative xpath to identify an element and get the text (starts with //)
        WebElement headerElement2 = driver.findElement(By.xpath("//h1/span"));
        System.out.println("headerElement2.getText() = " + headerElement2.getText());

        // providing attributes in xpath
        // elementTag[@attributeName='attribute value']
        // add 'and' if you have multiple element tags

        // //*[@id="box1"]

        driver.quit();

    }
}
