package com.cybertek.day05_css_xpath_junit5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CssSelectorPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // locate 2 elements using css locator
        WebElement emailBox = driver.findElement(By.cssSelector("input[name='email']"));
        emailBox.sendKeys("someone@somewhere.com");

        /**
         * Can use any of them below:
         * #form_submit
         * button#form_submit
         * button#form_submit.radius
         * button[id='form_submit'][class='radius']
         */
        WebElement retrievePassButton = driver.findElement(By.cssSelector("#form_submit"));
        retrievePassButton.submit();

        // identify the success message and print out the text -> #content > h4
        WebElement confirmationMsg = driver.findElement(By.cssSelector("#content > h4"));
        System.out.println("confirmationMsg.getText() = " + confirmationMsg.getText());


        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.quit();

    }
}
