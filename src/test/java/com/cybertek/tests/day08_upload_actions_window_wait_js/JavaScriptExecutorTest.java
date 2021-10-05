package com.cybertek.tests.day08_upload_actions_window_wait_js;

import com.cybertek.utility.BrowserUtility;
import com.cybertek.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorTest extends TestBase {

    @Test
    public void testScrollWholeWindow(){

        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        BrowserUtility.waitFor(3);

        // get JavascriptExecutor from driver variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)");

        // scroll the page 10 times using the for loop
        for (int i = 1; i <= 10; i++) {
            jse.executeScript("window.scrollBy(0,1000)");
            BrowserUtility.waitFor(1);
        }

    }

    @Test
    public void testScrollElementIntoView(){

        driver.get("http://practice.cybertekschool.com/large");

        // locate cybertekSchoolLink and home link
        // then run Javascript to scroll the element into view

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        int myScrollNumber = 1000;
        jse.executeScript("window.scrollBy(0,arguments[0])",myScrollNumber);
        WebElement cybertekSchoolLink = driver.findElement(By.linkText("Cybertek School"));
        jse.executeScript("arguments[0].scrollIntoView(true)",cybertekSchoolLink);

        BrowserUtility.waitFor(5);

    }

}
