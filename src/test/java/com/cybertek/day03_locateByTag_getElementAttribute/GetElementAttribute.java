package com.cybertek.day03_locateByTag_getElementAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetElementAttribute {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        // get the first link on the page
        WebElement firstLink = driver.findElement(By.linkText("A/B Testing"));

        // get text
        System.out.println("firstLink.getText() = " + firstLink.getText());

        // get any attribute using href attribute
        System.out.println("firstLink.getAttribute(\"href\") = " + firstLink.getAttribute("href"));

        // navigate to google.com and identify the search box and get attributes value
        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");

        // get attributes by class, maxlength, title, autocapitalize, spellcheck, role
        System.out.println("searchBox.getAttribute(\"class\") = " + searchBox.getAttribute("class"));
        System.out.println("searchBox.getAttribute(\"maxlength\") = " + searchBox.getAttribute("maxlength"));
        System.out.println("searchBox.getAttribute(\"title\") = " + searchBox.getAttribute("title"));
        System.out.println("searchBox.getAttribute(\"autocapitalize\") = " + searchBox.getAttribute("autocapitalize"));
        System.out.println("searchBox.getAttribute(\"spellcheck\") = " + searchBox.getAttribute("spellcheck"));
        System.out.println("searchBox.getAttribute(\"role\") = " + searchBox.getAttribute("role"));

        // using value attribute of input text box to extract the text inside
        System.out.println("searchBox.getAttribute(\"value\") = " + searchBox.getAttribute("value"));


        driver.quit();

    }
}
