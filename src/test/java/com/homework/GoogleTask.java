package com.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleTask {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");
        searchBox.submit();

        WebElement results = driver.findElement(By.id("result-stats"));
        System.out.println("results = " + results.getText());

        List<WebElement> allLinks = driver.findElements(By.partialLinkText("Selenium"));
        System.out.println("textSelenium = " + allLinks.size());

        for (WebElement each : allLinks) {
            System.out.println("each = " + each.getText());
        }

        System.out.println("-----------------------------------------------------------------");

        System.out.println("First Text = " + allLinks.get(0).getText());
        System.out.println("Last Text = " + allLinks.get(allLinks.size() - 1).getText());

        driver.quit();


    }
}
