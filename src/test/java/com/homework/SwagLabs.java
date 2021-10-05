package com.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SwagLabs {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://saucedemo.com/");

        driver.manage().window().maximize();

        System.out.println("Title = " + driver.getTitle());

        WebElement userNameBox = driver.findElement(By.id("user-name"));
        userNameBox.sendKeys("standard_user");
        WebElement passBox = driver.findElement(By.id("password"));
        passBox.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.submit();

        WebElement firstItemName = driver.findElement(By.className("inventory_item_name"));
        System.out.println("First Item = " + firstItemName.getText());
        WebElement firstItemPrice = driver.findElement(By.className("inventory_item_price"));
        System.out.println("First Item Price = " + firstItemPrice.getText());

        List<WebElement> allItems = driver.findElements(By.className("inventory_item_name"));
        System.out.println("Total Items = " + allItems.size());

        for (WebElement eachItem : allItems) {
            System.out.println("Product Item = " + eachItem.getText());
        }

        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        shoppingCart.click();

        WebElement continueShopping = driver.findElement(By.id("continue-shopping"));
        continueShopping.click();

        driver.quit();


    }
}
