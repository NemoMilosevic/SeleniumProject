package com.cybertek.day04_common_elements_xpath_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingByCSSSelector {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://search.yahoo.com/");

        // identify search box by using css selector (by id, by name, by value, etc.)
        WebElement searchBox = driver.findElement(By.cssSelector("#yschsp")); // by id
        // WebElement searchBox = driver.findElement(By.cssSelector("input[name='p']"));
        // WebElement searchBox = driver.findElement(By.cssSelector("input[id='#yschsp']"));
        // WebElement searchBox = driver.findElement(By.cssSelector("input[name='p'] [type='text']"));
        searchBox.sendKeys("CSS Selector");
        //searchBox.submit();
        Thread.sleep(3000);

        WebElement clearIcon = driver.findElement(By.cssSelector("button#sbq-clear>span"));
        clearIcon.click();

        searchBox.sendKeys("Xpath");

        WebElement searchIcon = driver.findElement(By.cssSelector("span[title='Search']"));
        searchIcon.click();

        Thread.sleep(3000);

        driver.quit();

    }
}
