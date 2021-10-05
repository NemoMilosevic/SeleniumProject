package com.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebAppSecurity {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/");

        if (driver.getTitle().equals("Zero - Personal Banking - Loans - Credit Cards"))
            System.out.println("Title Correct");
        else
            System.out.println("Incorrect Title");

        WebElement signInButton = driver.findElement(By.id("signin_button"));
        signInButton.click();
        System.out.println("driver.getTitle() = " + driver.getTitle());

        WebElement userNameBox = driver.findElement(By.id("user_login"));
        userNameBox.sendKeys("username");

        WebElement passBox = driver.findElement(By.id("user_password"));
        passBox.sendKeys("password");

        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.submit();

        if (driver.getTitle().equals("Zero - Account Summary"))
            System.out.println("Title Correct");
        else
            System.out.println("Incorrect Title");

        driver.quit();

    }
}
