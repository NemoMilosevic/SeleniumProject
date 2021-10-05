package com.cybertek.tests.day09_explicit_wait_singleton_driver;

import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ExplicitWait2Test extends TestBase {

    @Test
    public void waitUntilElementInteractive(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputField = driver.findElement(By.cssSelector("form#input-example>input"));
        System.out.println("inputField.isEnabled() = " + inputField.isEnabled());

        // elementToBeClickable(By locator) and elementToBeClickable(WebElement element)
        // click on Enable button and wait until input box is clickable again
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        WebDriverWait wait = new WebDriverWait(driver,6);
        // this will wait for 6 seconds max for input element (located by css selector)
        // enabled, interactive, visible
        wait.until(elementToBeClickable(inputField));
        // now enter something into the input field
        inputField.sendKeys("Hello World");

        BrowserUtility.waitFor(5);


    }

}

