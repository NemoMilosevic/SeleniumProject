package com.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTask {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 1. Step:
        driver.get("https://www.facebook.com");

        // 2. Step:
        WebElement searchBox = driver.findElement(By.id("email"));
        searchBox.sendKeys("Nemo");

        // 3. Step:
        WebElement passBox = driver.findElement(By.id("pass"));
        passBox.sendKeys("Password123");

        // 4. Step:
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        // 5. Step:
        Thread.sleep(5000);
        driver.navigate().back();

        // 6. Step:
        WebElement forgotPassButton = driver.findElement(By.className("_6ltj"));
        forgotPassButton.click();

        // 7. Step:
        WebElement phoneNumber = driver.findElement(By.id("identify_email"));
        phoneNumber.sendKeys("+ (123) 456 7890");

        // 8. Step:
        WebElement searchButton = driver.findElement(By.id("did_submit"));
        searchButton.click();

        Thread.sleep(5000);

        // 9. Step:
        WebElement cancelButton = driver.findElement(By.linkText("Cancel"));
        cancelButton.click();

        Thread.sleep(5000);

        // 10. Step:
        driver.quit();

    }
}
